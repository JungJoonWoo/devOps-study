import {useState, useEffect} from "react";

function MovieApp2() {
  const [results, setResults] = useState([]);
  const [loading, setLoading] = useState(false);
  useEffect(() => {
    const getMovie = async () => {
      setLoading(false);
      let response = await fetch("https://yts.mx/api/v2/list_movies.json?minimum_rating=8.5&sort_by=year");
      let json = await response.json();
      setResults(json.data.movies);
      setLoading(true);
      // console.log(json);
    };
    getMovie();

  }, []);
  console.log(results);
  return (
    <div className = {"App"}>
      <header className = {"App-header"}>
        <h1>Movie APP!!</h1>
        <hr />
      </header>
      {loading ? null : <h3>loading...</h3>}
      <ul>
        {loading ? <select>
          {results.map((movie, index) => <option key = {index}>{movie.title}</option>)}
        </select> : null}
      </ul>
    </div>
  );
}

export default MovieApp2;