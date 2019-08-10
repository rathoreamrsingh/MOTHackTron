queues = new Map();
getQueueSize = function() {
  return queues.size;
};
getQueue = function(queueName){
  console.log(queues,queueName);
  return queues.get(queueName);
}
createQueue = function(queueName) {
  if (queues.get(queueName) == undefined) {
    queues.set(queueName, []);
    return { message: "Branch " + queueName + " created successfully" };
  }
  else{
    return { error:{message:"Branch "+queueName+" already exists"} };
  }
};
module.exports.getQueueSize = getQueueSize;
module.exports.createQueue = createQueue;
module.exports.getQueue = getQueue;
