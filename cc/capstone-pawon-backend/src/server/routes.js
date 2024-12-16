import handlers from '../server/handler.js';

const routes = [
  {
    path: '/user',
    method: 'POST',
    handler: handlers.postUser,
    options: {
      payload: {
        allow: 'application/json',
        multipart: true,
      },
    },
  },
  {
    path:'/login',
    method: 'POST',
    handler: handlers.postLogin,
    options: {
      payload: {
        allow: 'application/json',
        multipart: true,
      },
    },
  },
  {
    path: '/manis',
    method: 'GET',
    handler: handlers.getManis,
  },
  {
    path: '/asin',
    method: 'GET',
    handler: handlers.getAsin,
  },
  {
    path: '/gurih',
    method: 'GET',
    handler: handlers.getGurih,
  },
  {
    path: '/pahit',
    method: 'GET',
    handler: handlers.getPahit,
  },
  {
    path: '/asam',
    method: 'GET',
    handler: handlers.getAsam,
  },
  {
    path: '/pedas',
    method: 'GET',
    handler: handlers.getPedas,
  },
  {
    path: '/product',
    method: 'GET',
    handler: handlers.getProducts,
  },
  {
    path: '/users',
    method: 'GET',
    handler: handlers.getUsers,
  },
  {
    path: '/restaurants',
    method: 'GET',
    handler: handlers.getRestaurants,
  },
];

export default routes;
