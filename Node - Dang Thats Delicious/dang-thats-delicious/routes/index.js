const express = require('express');
const router = express.Router();
const storeController = require('../controllers/storeController');
//Object destructuring, allows us to import a single method rather than the whole file:
const { catchErrors } = require('../handlers/errorHandlers'); 


router.get('/', storeController.homePage);
router.get('/add', storeController.addStore);
router.post('/add', catchErrors(storeController.createStore));

module.exports = router;