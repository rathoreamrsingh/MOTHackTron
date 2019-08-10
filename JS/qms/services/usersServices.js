var queuesService = require("./queuesService");
addUser = function(queueName, user) {
  let queue = queuesService.getQueue(queueName);
  if (queue != undefined) {
    user.createdDate = new Date();

    let token = Math.trunc(Math.random() * 10000);
    user.token = token;
    queue.push(user);
    return { token: token };
  } else {
    return { error: { message: "Branch does not exists" } };
  }
};

getUsers = function(queueName) {
  let queue = queuesService.getQueue(queueName);
  console.log(queue);
  if (queue != undefined) {
    return { data: queue };
  } else {
    return { error: { message: "Branch does not exists" } };
  }
};

module.exports.getUsers = getUsers;
module.exports.addUser = addUser;
