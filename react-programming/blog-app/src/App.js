import './App.css';
import {useState} from "react";

function App() {
  const [data, setData] = useState(["강남 고기 맛집", true]);

  const [count, setCount] = useState(0);

  return (
    <div className = "App">
      <div className = "black-nav">
        <div>개발 Blog</div>
      </div>
      <div className = "list">
        <h3>{data}
          <button type = {"button"} onClick = {() => {
            data[1] ? setData(["용인 고기 맛집", !data[1]]) : setData(["강남 고기 맛집", !data[1]]);
          }}> 변경 버튼
          </button>
          <span onClick = {() => setCount(count + 1)}> ❤️</span> {count}
        </h3>
        <p>2월 18일 발행</p>
        <hr />
      </div>
    </div>
  );
}

export default App;