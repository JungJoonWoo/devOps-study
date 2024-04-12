import './App.css';
import React, {createContext, useContext, useEffect} from "react";

let ThemeContext = createContext("red");

//section start

function App() {
  const theme = useContext(ThemeContext);
  console.log(theme);
  useEffect(() => {
  }, [])
  return (
    <div className = "App">
      <h1>Function component</h1>
      <ThemeContext.Provider value = {theme}>
        <Form />
      </ThemeContext.Provider>

    </div>);
}

function Form() {
  const theme = useContext(ThemeContext);
  console.log(theme);
  return <form>
    <Button></Button>
    <Button></Button>
  </form>
}

function Button() {
  const theme = useContext(ThemeContext);
  console.log(theme);

  return <button
    style = {{backgroundColor: theme}}>
    Show</button>
}

export default App;