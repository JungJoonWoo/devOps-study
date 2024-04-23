//
// fetch("https://jsonplaceholder.typicode.com/comments/")
//   .then((response) => {
//     console.log(response);
//     return response.json();
//   })
//   .then((data) => console.log(data))
//   .catch((err) => console.log(err));

async function dataFetch() {

  console.log("Start");
  let response = await fetch("https://jsonplaceholder.typicode.com/users/10");
  let json = await response.json();
  console.log(json);
  console.log("end");

}

dataFetch();