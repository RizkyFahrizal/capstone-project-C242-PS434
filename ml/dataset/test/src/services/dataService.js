import { Firestore } from '@google-cloud/firestore';

const db = new Firestore();
const productsCollection = db.collection('products');

async function storeData(id, data) {
  try {
    const productCollection = db.collection('products');
    await productCollection.doc(id).set(data);
    return { success: true };
  } catch (error) {
    console.error('Error in storeData:', error);
    return { success: false, error: 'Failed to store data' };
  }
}

export { productsCollection, storeData };