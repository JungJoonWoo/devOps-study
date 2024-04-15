import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";

function Detail() {
  let { id } = useParams();
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function getMovie() {
      const response = await fetch(`https://yts.mx/api/v2/movie_details.json?movie_id=${id}`);
      let json = await response.json();
      setData(json.data.movie);
      setLoading(false);
    }

    getMovie();
  }, [id, loading]);

  console.log(data);

  return (
    <div>
      {loading ? (
        "loading..."
      ) : (
        data ? (
          <div>
            <h1>{data.title_long} Detail</h1>
            <h3>{data.slug}</h3>
            <hr />
            <img src = {data.medium_cover_image} alt = {`${data.title} Cover`} />
            <br />
            <br />
            <span>평점: </span>
            <span>{data.rating} </span>
            <span> 런타임: </span>
            <span>{data.runtime} </span>
            <h1>장르</h1>
            {data.genres && data.genres.map((genre, index) => <span key = {index}>{genre} </span>)}
            <h3>설명</h3>
            <span>{data.description_full} </span>

          </div>
        ) : (
          <p>영화 정보를 불러올 수 없습니다.</p>
        )
      )}
    </div>
  );
}

export default Detail;