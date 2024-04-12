import React, {useEffect} from "react";

function Image() {


  function createFunc() {
    console.log("이미지가 생성 됨");
    return destroyFunc;
  }

  function destroyFunc() {
    console.log("이미지가 소멸 됨");

  }

  useEffect(createFunc, []);

  return (
    <img src = "/다운로드.jpg" alt = "img" />
  );
}

export default Image;