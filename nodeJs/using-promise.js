const {readFile} = require("fs");

function successCallback(data) {
  console.log(`success: ${data}`);
}

function failureCallback(reason) {
  console.log(`failureReason: ${reason}`);
}

function read() {
  return new Promise((resolve, reject) => {
    readFile(__dirname + "/passwd.txt", "utf-8", (err, data) => {
      if (err) reject(err);
      else resolve(data);
    });
  });
}

console.log(read().then(successCallback, failureCallback));