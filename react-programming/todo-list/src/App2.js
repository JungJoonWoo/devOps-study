import "./App.css"
import {useReducer, useState} from "react";

function App2() {

  const [todo, setTodo] = useState("");

  const actionType = {
    ADD: "ADD",
    DELETE: "DELETE",
    UPDATE: "UPDATE"
  }

  function reducer(state, action) {
    switch (action.type) {
      case actionType.ADD:
        if (!state.includes(action.payload) && action.payload) {
          return [...state, {text: action.payload, isComplete: false}];
        }
        return state;
      case actionType.DELETE:
        return state.filter(todo => todo !== action.payload);
      case actionType.UPDATE:
        return state.map((item) =>
          item.text === action.payload
            ? {...item, isCompleted: !item.isCompleted}
            : item
        );
    }
  }

  const initialState = [];
  const [todoList, dispatch] = useReducer(reducer, initialState);
  const onChange = event => {
    setTodo(event.target.value);
  }
  const addEvent = event => {
    event.preventDefault();
    dispatch({type: actionType.ADD, payload: todo})
    setTodo("");
  }
  const deleteEvent = todo => dispatch({type: actionType.DELETE, payload: todo})
  const updateEvent = todo => {
    dispatch({type: actionType.UPDATE, payload: todo})
  }

  return (
    <div className = {"App"}>
      <header>
        <h1>Todo-List</h1>
      </header>
      <form onSubmit = {addEvent}>
        <input type = {"text"} value = {todo} onChange = {onChange} placeholder = {"할 일"} />
        <button type = {"submit"}>add</button>
      </form>
      <ul>
        {todoList.map((item, index) => (
          <li key = {index} className = {item.isCompleted ? "completed" : ""}>
            {item.text}
            <button onClick = {() => updateEvent(item.text)}>Complete</button>
            <button onClick = {() => deleteEvent(item)}>Delete</button>
          </li>
        ))}

      </ul>
    </div>
  );
}

export default App2;