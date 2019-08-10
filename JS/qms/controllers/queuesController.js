var myMap = new Map();
var queuesService = require("../services/queuesService");
getAllQueues = function(req, res) {
  let queueSize = queuesService.getQueueSize();
  res.json({ size: queueSize });
};
createQueue = function(req, res) {
  let queueName = req.body.name;
  let message = queuesService.createQueue(queueName);
  if (!message.error) {
    res.json({ message: "Branch " + queueName + " created successfully" });
  } else {
    res.status(400).json(message);
  }
};
module.exports.getAllQueues = getAllQueues;
module.exports.createQueue = createQueue;
