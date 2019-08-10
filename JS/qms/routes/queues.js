var express = require('express');
var router = express.Router();
var qController = require('../controllers/queuesController');

/* GET home page. */
router.get('/', function(req, res, next) {
  qController.getAllQueues(req,res);
});
router.post('/', function(req, res, next) {
  qController.createQueue(req,res);
});

module.exports = router;
