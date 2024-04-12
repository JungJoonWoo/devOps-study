const {readFile, readFileSync} = require("fs");
console.log("1");
readFile(__dirname + "/passwd.txt", (err, data)=>{
  if (err) throw err;
  console.log(data);
});
console.log("2");

let sync = readFileSync(__dirname + "/passwd.txt");
console.log(`sync: ${sync.toString()}`)