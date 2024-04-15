import {useEffect, useState} from "react";

function Movie({coverImage, title, summary, genres}) {
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
    <div>
      <img src = {coverImage} alt = "img"></img>
      <p>{title}</p>
      <p>{summary}</p>
      <ul>
        {genres.map((genre, index) => <li key = {index}>{genre}</li>)}
      < /ul>
    </div>
  )
}

export default Movie;