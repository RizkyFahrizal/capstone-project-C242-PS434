import "dotenv/config.js";

import Hapi from '@hapi/hapi';
import routes from './routes.js';
import { loadModel } from '../services/loadModel.js';
import { InputError } from '../exceptions/InputError.js';

(async () => {
  const server = Hapi.server({
    port: 8080,
    host: '0.0.0.0',
    routes: {
      cors: {
        origin: ['*'],
      },
      payload: {
        maxBytes: 1000000,
      },
    },
  });

  const model = await loadModel();
  server.app.model = model;

  server.route(routes);

  server.ext('onPreResponse', function (request, h) {
    const response = request.response;

    if (response instanceof InputError) {
      const newResponse = h.response({
        status: 'fail',
        message: `Terjadi kesalahan dalam mengakses API`,
      });
      newResponse.code(response.statusCode);
      return newResponse;
    }

    if (response.isBoom) {
      const newResponse = h.response({
        status: 'fail',
        message: response.message,
      });
      newResponse.code(response.output.statusCode);
      return newResponse;
    }

    if (response.statusCode === 400) {
      const newResponse = h.response({
        status: 'fail',
        message: 'Terjadi kesalahan saat mengakses API',
      });
      newResponse.code(400);
      return newResponse;
    }

    return h.continue;
  });

  await server.start();
  console.log(`Server start at: ${server.info.uri}`);
})();