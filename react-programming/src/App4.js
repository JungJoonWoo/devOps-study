import './App.css';
import React, {useEffect, useState} from "react";
import Image from "./Images";
import Button from "./button";

function App() {
  let [toggle, setToggle] = useState(false);
  let onChange = () => setToggle(cur => !cur);

  return (
    <div className = "App">
      <h1>Function component</h1>
      {toggle?<Image />:null}
      <br />
      <Button text = {toggle ? "show" : "hide"} onClick = {onChange}></Button>

    </div>);
}

export default App;