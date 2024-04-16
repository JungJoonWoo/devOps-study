import "./App.css"
import Container from "./Container";
import "./Container.css"
import {useState} from "react";

function App3() {
  return Parent();
}

function Parent() {

  const [color, setColor] = useState("white");
  const style = {
    backgroundColor: color,

  }
  return (<div>
    <Container style = {style} setColor = {setColor} text = {"red"}></Container>
    <Container text = {"green"} style = {style} setColor = {setColor}></Container>
    <Container text = {"yellow"} setColor = {setColor} style = {style}></Container>
  </div>);
}

export default App3;