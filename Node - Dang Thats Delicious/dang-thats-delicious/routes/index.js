const express = require('express');
const router = express.Router();

// Do work here
router.get('/', (req, res) => {
  const wes = { name: 'Wes', age: 100, cool: true };
  //res.json(wes) //Only send once, more times will give an error
  res.send(req.query.name); //For URL data submission localhost:7777/?name=Don

});

router.get('/reverse/:name', (req, res) => {
	const reverse = [...req.params.name].reverse().join(''); // reverses the string req.params.name
	res.send(reverse);
});

module.exports = router;