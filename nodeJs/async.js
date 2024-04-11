function funcTest(syncFunc) {
  syncFunc();
}

function funcTest2(asyncFunc) {
  setTimeout(() => {
    asyncFunc();
  }, 1000);
}

function syncFunc() {
  console.log("바로 실행")
}

function asyncFunc() {
  console.log("1초 후 실행")
}

funcTest(syncFunc);
funcTest2(asyncFunc);

console.log("요리하기");
console.log("청소하기");
console.log("운동하기");