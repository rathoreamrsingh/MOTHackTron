var express = require('express');
var router = express.Router();
var queuesController = require('../controllers/queuesController');

/* GET home page. */
router.get('/', function(req, res, next) {
  queuesController.getAllQueues(req,res);
});
router.post('/', function(req, res, next) {
  queuesController.createQueue(req,res);
});

module.exports = router;
