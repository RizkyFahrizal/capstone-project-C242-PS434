import handlers from '../server/handler.js';

const routes = [
  {
    path: '/user',
    method: 'POST',
    handler: handlers.postUser,
    options: {
      payload: {
        allow: 'multipart/form-data',
        multipart: true,
      },
    },
  },
  {
    path: '/product',
    method: 'GET',
    handler: handlers.getProducts,
  },
];

export default routes;