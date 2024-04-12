import {useEffect, useState} from "react";

function MovieApp() {
  const [results, setResults] = useState([]);
  useEffect(() => {
    return () => {
      fetch("https://yts.mx/api/v2/list_movies.json?minimum_rating=8.5&sort_by=year")
        .then((response) => response.json())
        .then((json) => {
          setResults(json.data.movies)
          setLoading(true);
        });
    };
  }, []);
  const [loading, setLoading] = useState(false);
  console.log(results);
  return (
    <div className = {"App"}>
      <header className = {"App-header"}>
        <h1>Movie APP!!</h1>
        <hr />
      </header>
        {loading ? null : <h3>loading...</h3>}
      <ul>
        {loading? <select>
          {results.map((movie, index) => <option key = {index}>{movie.title}</option>)}
        </select>:null}
      </ul>
    </div>
  );
}

export default MovieApp;