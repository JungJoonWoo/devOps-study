import './App.css';
import {useEffect, useState} from "react";

function AppPokemon() {
  const [results, setResults] = useState([]);
  useEffect(() => {
    return () => {
      fetch("https://pokeapi.co/api/v2/pokemon?limit=10000")
        .then((response) => response.json())
        .then((data) => {
          setResults(data.results)
          setLoading(true);
        });
    };
  }, []);
  const [loading, setLoading] = useState(false);
  // console.log(results);
  return (
    <div className = {"App"}>
      <header className = {"App-header"}>
        <h1>Pokemon!!</h1>
      </header>
        {loading ? null : <h3>loading...</h3>}
        <hr />
      <ul>
        {loading? <select>
          {results.map((pokemon, index) => <option key = {index}>{pokemon.name}</option>)}
          {/*<option value = ""></option>*/}
        </select>:null}
      </ul>
    </div>
  );
}

export default AppPokemon;