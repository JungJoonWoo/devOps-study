import {useEffect, useState} from "react";
import Movie from "../components/Movie";

function Home() {
  const [results, setResults] = useState([]);
  const [loading, setLoading] = useState(true);
  const getMovie = async () => {
    let response = await fetch("https://yts.mx/api/v2/list_movies.json?minimum_rating=8.5&sort_by=year");
    let json = await response.json();
    setResults(json.data.movies);
    setLoading(false);
  };
  useEffect(() => {
    getMovie();
  }, []);

  return (
    <div className = "App">
      <header className = "App-header">
        <h1>Movie APP!!</h1>
        <hr />
      </header>
      {loading ? <h3>loading...</h3> : null}
      <ul>
        {loading ? null : results.map((movie) =>
          <Movie
            key = {movie.id}
            coverImage = {movie.medium_cover_image}
            title = {movie.title}
            id = {movie.id}
            genres = {movie.genres}
          />
        )}
      </ul>
    </div>
  );
}

export default Home;