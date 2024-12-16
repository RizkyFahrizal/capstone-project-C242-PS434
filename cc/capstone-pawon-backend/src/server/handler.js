import predictClassification from '../services/inferenceService.js';
import crypto from 'crypto';
import { storeDataUser, productsCollection, usersCollection, restaurantsCollection,pedasCollection,asamCollection, pahitCollection,gurihCollection,asinCollection,manisCollection} from '../services/dataService.js';
import { get } from 'https';

async function postUser(request, h) {
  // const { image } = request.payload;
  // const { model } = request.server.app;

  // const { resultScore, result, suggestion } = await predictClassification(
  //   model,
  //   image
  // );
  const {username, email, password } = request.payload;
  const user_id = crypto.randomUUID();

  const dataUser = {
    user_id,
    username,
    email,
    password,
  };

  // // Hash password sebelum menyimpan
  // dataUser.password = hashedPassword;

  await storeDataUser(user_id, dataUser);
  return h
    .response({
      status: 'success',
      message: 'user is successfully added.',
      dataUser,
    })
    .code(201);
    // return response // tidak memiliki fungsi ?
}

const postLogin = async (request, h) => {
  try {
    const { email, password } = request.payload;

    // Validasi input
    if (!email || !password) {
      return h.response({
        status: 'fail',
        message: 'Email and password are required',
      }).code(400);
    }

    console.log('Attempting to log in user with email:', email);

    // Ambil data pengguna berdasarkan email
    const querySnapshot = await usersCollection.where('email', '==', email).get();

    // Periksa apakah data ditemukan
    if (querySnapshot.empty) {
      return h.response({
        status: 'fail',
        message: 'User not found',
      }).code(404);
    }

    // Ambil data pengguna pertama
    const userDoc = querySnapshot.docs[0];
    const user = userDoc.data();

    console.log('User data retrieved:', user);

    // Cocokkan password (tanpa bcrypt)
    if (user.password !== password) {
      return h.response({
        status: 'fail',
        message: 'Invalid password',
      }).code(401);
    }

    // Jika email dan password cocok
    return h.response({
      status: 'success',
      message: 'Login successful',
      data: {
        user_id: user.user_id,
        email: user.email,
        username: user.username,
      },
    }).code(200);

  } catch (error) {
    console.error('Error during login:', error);
    return h.response({
      status: 'error',
      message: 'Internal server error',
      details: error.message,
    }).code(500);
  }
};



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

async function getManis(request, h) {
  const products = (await manisCollection.get()).docs.map((doc) =>
    doc.data()
  );
  const data = products.map((item) => ({
    product_id: item.product_id,
    history: item,
  }));
  return h.response({ status: 'success', data }).code(200);
}

async function getAsin(request, h) {
  const products = (await asinCollection.get()).docs.map((doc) =>
    doc.data()
  );
  const data = products.map((item) => ({
    product_id: item.product_id,
    history: item,
  }));
  return h.response({ status: 'success', data }).code(200);
}

async function getGurih(request, h) {
  const products = (await gurihCollection.get()).docs.map((doc) =>
    doc.data()
  );
  const data = products.map((item) => ({
    product_id: item.product_id,
    history: item,
  }));
  return h.response({ status: 'success', data }).code(200);
}
async function getPahit(request, h) {
  const products = (await pahitCollection.get()).docs.map((doc) =>
    doc.data()
  );
  const data = products.map((item) => ({
    product_id: item.product_id,
    history: item,
  }));
  return h.response({ status: 'success', data }).code(200);
}

async function getAsam(request, h) {
  const products = (await asamCollection.get()).docs.map((doc) =>
    doc.data()
  );
  const data = products.map((item) => ({
    product_id: item.product_id,
    history: item,
  }));
  return h.response({ status: 'success', data }).code(200);
}

async function getPedas(request, h) {
  const products = (await pedasCollection.get()).docs.map((doc) =>
    doc.data()
  );
  const data = products.map((item) => ({
    product_id: item.product_id,
    history: item,
  }));
  return h.response({ status: 'success', data }).code(200);
}

// Handler untuk mendapatkan data users
async function getUsers(request, h) {
  try {
    const users = (await usersCollection.get()).docs.map((doc) => doc.data());
    const data = users.map((user) => ({
      user_id: user.user_id,
      email: user.email,
      username: user.username,
    }));
    return h.response({ status: 'success', data }).code(200);
  } catch (error) {
    console.error(error);
    return h.response({ status: 'fail', message: 'Failed to fetch users' }).code(500);
  }
}

// Handler untuk mendapatkan data restoran
async function getRestaurants(request, h) {
  try {
    const restaurants = (await restaurantsCollection.get()).docs.map((doc) => doc.data());
    const data = restaurants.map((restaurant) => ({
      restaurant_id: restaurant.restaurant_id,
      restaurant_name: restaurant.restaurant_name,
      city: restaurant.kota,
    }));
    return h.response({ status: 'success', data }).code(200);
  } catch (error) {
    console.error(error);
    return h.response({ status: 'fail', message: 'Failed to fetch restaurants' }).code(500);
  }
}


export default {getPahit,getGurih,getAsin, getManis, postUser,getAsam,getPedas,postLogin, getProducts, getRestaurants, getUsers,};