import {useEffect, useState} from "react";
import Movie from "./components/Movie";

function MovieApp2() {
  const [results, setResults] = useState([]);
  const [loading, setLoading] = useState(true);
  const getMovie = async () => {
    setLoading(false);
    let response = await fetch("https://yts.mx/api/v2/list_movies.json?minimum_rating=8.5&sort_by=year");
    let json = await response.json();
    setResults(json.data.movies);
    setLoading(false);
  };
  useEffect(() => {
    getMovie();
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <h1>Movie APP!!</h1>
        <hr />
      </header>
      {loading ? <h3>loading...</h3> : null}
      <ul>
        {loading ? null : results.map((movie) =>

          <div key={movie.id}>
            <img src={movie.medium_cover_image} alt="img" />
            <p>{movie.title}</p>
            <p>{movie.summary}</p>
            <ul>
              {movie.genres.map((genre, index) => <li key={index}>{genre}</li>)}
            </ul>
          </div>
        )}
      </ul>
    </div>
  );
}

export default MovieApp2;