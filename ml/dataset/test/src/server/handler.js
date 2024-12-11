import predictClassification from '../services/inferenceService.js';
import crypto from 'crypto';
import { storeData, productsCollection } from '../services/dataService.js';

async function postPredict(request, h) {
  const { image } = request.payload;
  const { model } = request.server.app;

  const { resultScore, result, suggestion } = await predictClassification(
    model,
    image
  );
  const id = crypto.randomUUID();
  const createdAt = new Date().toISOString();

  const dataUser = {
    user_id,
    username,
    fullname,
    email,
    password,
  };

  await storeDataUser(id, dataUser);
  return h
    .response({
      status: 'success',
      message: 'user is successfully added.',
      dataUser,
    })
    .code(201);
    return response
}

async function getProducts(request, h) {
  const products = (await productsCollection.get()).docs.map((doc) =>
    doc.data()
  );
  const data = products.map((item) => ({
    product_id: item.product_id,
    history: item,
  }));
  return h.response({ status: 'success', data }).code(200);
}

export default { postPredict, getProducts };