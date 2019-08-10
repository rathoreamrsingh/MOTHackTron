var myMap = new Map();
 getUsers = function(req,res){
  res.json({"size":myMap.size})

}
createQueue = function(queueName){
  myMap.set(queueName,[])
  res.json({"message":"Branch "+queueName+" created successfully"})
}
module.exports.addUser=getAllQueues;
module.exports.createQueue=createQueue;
