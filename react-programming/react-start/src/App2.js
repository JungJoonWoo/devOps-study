import './App.css';
import React, {useEffect, useState} from "react";
import Button from './button';


function App() {

  let [counter, setCounter] = useState(0);
  const onClick = () => setCounter(cur => cur + 1);
  useEffect(() => console.log("화면이 렌더링 되었습니다"), []);
  // useEffect(()=>console.log("state 값이 변경되었습니다"), [counter]);
  const [input, setInput] = useState();
  const onChange = (event) => setInput(event.target.value);
  useEffect(() => console.log("state 값이 변경되었습니다"), [counter, input]);

  return (
    <div className = "App">
      <h1>Function component</h1>
      <p>{counter} times clicked!</p>
      <Button text = {"click"} onClick = {onClick}></Button>
      <br />
      <input placeholder = "이름을 입력하세요." onChange = {onChange} value = {input} />
    </div>);
}

export default App;