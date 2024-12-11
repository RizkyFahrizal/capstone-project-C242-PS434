import handlers from '../server/handler.js';

const routes = [
  // {
  //   path: '/predict',
  //   method: 'POST',
  //   handler: handlers.postPredict,
  //   options: {
  //     payload: {
  //       allow: 'multipart/form-data',
  //       multipart: true,
  //     },
  //   },
  // },
  {
    path: '/product',
    method: 'GET',
    handler: handlers.getProducts,
  },
];

export default routes;