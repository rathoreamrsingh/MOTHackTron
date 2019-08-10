var myMap = new Map();
myMap.set("test", "value associated with 'a string'");
getAllQueues = function(req,res){
  res.json({"size":myMap.size})

}
createQueue = function(req,res){
  console.log(req.body);
  let queueName = req.body.name;
  myMap.set(queueName,[])
  res.json({"req":queueName})
}
module.exports.getAllQueues=getAllQueues;
module.exports.createQueue=createQueue;
