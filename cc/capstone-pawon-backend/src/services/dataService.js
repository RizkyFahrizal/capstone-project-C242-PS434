import { Firestore } from '@google-cloud/firestore';

const db = new Firestore(
  {databaseId: 'pawondb'}
);
const productsCollection = db.collection('products');
const usersCollection = db.collection('users');
const restaurantsCollection = db.collection('restaurants');
const manisCollection = db.collection('manis');
const asinCollection = db.collection('asin');
const gurihCollection = db.collection('gurih');
const pahitCollection = db.collection('pahit');
const asamCollection = db.collection('asam');
const pedasCollection = db.collection('pedas');

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


export { pahitCollection,gurihCollection,asinCollection,asamCollection,pedasCollection,manisCollection,productsCollection,usersCollection,restaurantsCollection, storeDataUser};