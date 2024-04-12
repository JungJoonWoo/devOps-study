let todolist = "";
console.log(`1. ${todolist}`);
setTimeout(function (todos) {
  todolist = todos;
  console.log(`2. ${todolist}`);
  setTimeout(function (todos) {
    todolist += todos;
    console.log(`2-1. ${todolist}`);

    setTimeout(function (todos) {
      todolist += todos;
      console.log(`2-2. ${todolist}`);

    },1000, "운동하기");
  }, 1000, "청소하기")
}, 1000, "요리하기");

console.log(`3. ${todolist}`);