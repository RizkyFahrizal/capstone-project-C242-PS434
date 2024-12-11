import { Firestore } from '@google-cloud/firestore';

const db = new Firestore();
const productsCollection = db.collection('products');

async function storeDataUser(id, dataUser) {
  try {
    const userCollection = db.collection('users');
    await userCollection.doc(id).set(dataUser);
    return { success: true };
  } catch (error) {
    console.error('Error in storeData User:', error);
    return { success: false, error: 'Failed to store data' };
  }
}

export { productsCollection, storeDataUser };