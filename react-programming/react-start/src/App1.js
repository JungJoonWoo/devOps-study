import './App.css';
import React from "react";


class App extends React.Component {

  constructor() {
    super();
    this.state = {
      counter: 0
    }
  }

  componentDidMount() {
    console.log("화면이 렌더링 되었습니다");
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log("props 값이 변경되었습니다");
  }

  componentWillUnmount() {
    console.log("컴포넌트가 사라질 예정입니다");
  }

  onChange = () => {
    this.setState(() => ({counter: ++this.state.counter}));
  }

  render() {
    return (
      <div className = "App">
        <h1>class component</h1>
        <p>{this.state.counter} times clicked!</p>
        <button onClick = {this.onChange}>click</button>

      </div>
    );
  }
}

export default App;