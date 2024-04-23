const express = require('express')
const app = express()
const port = 3001

app.get('/', (req, res) => {
  res.send('request get message')
});

app.get('/name', (req, res) => {
  res.send('name')
});

app.post('/', (req, res) => {
  res.send('response post message')
});


app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
});


// const {createServer} = require('node:http');
//
// const hostname = '127.0.0.1';
// const port = 3000;
//
// const server = createServer((req, res) => {
//   res.statusCode = 200;
//   res.setHeader('Content-Type', 'text/html');
//   res.end('<h1>Hello World</h1>');
//   console.log("hello world");
// });
//
// server.listen(port, hostname, () => {
//   console.log(`Server running at http://${hostname}:${port}/`);
// });