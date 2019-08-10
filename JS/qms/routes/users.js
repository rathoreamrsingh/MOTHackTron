var express = require('express');
var router = express.Router();
var usersController = require('../controllers/usersController');

/* GET users listing. */
router.get('/:queueName', function(req, res, next) {
  usersController.getUsers(req,res);
});
router.post('/:queueName', function(req, res, next) {
  usersController.addUser(req,res);
});


module.exports = router;
