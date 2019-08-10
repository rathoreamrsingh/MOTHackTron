var myMap = new Map();
var usersService = require("../services/usersServices");
 getUsers = function(req,res){
   let queueName=req.params.queueName;
   console.log(queueName);
  let users=usersService.getUsers(queueName);
  if (!users.error) {
    res.json(users);
  } else {
    res.status(400).json(users);
  }

}
addUser = function(req,res){
let queueName=req.params.queueName;
let user=req.body.user;
 let users=usersService.addUser(queueName, user);
 if (!users.error) {
   res.json(users);
 } else {
   res.status(400).json(users);
 }

}

module.exports.getUsers = getUsers;
module.exports.addUser = addUser;
