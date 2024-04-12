import './App.css';
import {useState} from "react";

function App() {

  const [todo, setTodo] = useState("");
  const onChange = (event) =>{
    setTodo(event.target.value);
  };
  const [todolist, setTodolist] = useState([]);
  const addTodo = (event) => {
    event.preventDefault();
    setTodo("");
    setTodolist(cur => [todo, ...cur,]);
  };

  return (
    <div className = "App">
      <header className = "App-header">
      <h1>Todolist-App</h1>
      </header>
      <form onSubmit={addTodo}>
        <input type={"text"} value={todo} onChange={onChange} placeholder={"할 일"}/>
        <button type={"submit"}>Add</button>
        <hr/>
      </form>
      <ul>
        {todolist.map((todo, index) => <li key={index}>{todo}</li>)}
      </ul>
    </div>
  );
}
export default App;