import React from "react"

class AppPokemon extends React.Component {
  constructor() {
    super();
    this.state = {
      result: [],
      loading: false,

    }
  }

  componentDidMount() {
    let url = "https://pokeapi.co/api/v2/pokemon?limit=10000";
    console.log(this.state.loading)

    fetch(url).then((result) => result.json()).then((jsonData) => {
      this.setState({result: jsonData.results});
      this.setState({loading: true});
    });
  }

  render() {
    console.log(this.state.result)
    return (
      <div className = {"App"}>
        <header className = {"appheader"}>
          <h1>Pokemon</h1>
          <hr />
        </header>
        {this.state.loading ? null : <h2>Loading...</h2>}
        <ul>
          {this.state.loading ? <select>
            {this.state.result.map((result, index) => <option key = {index}>{result.name}</option>)}
          </select> : null}
        </ul>
      </div>
    );
  }
}

export default AppPokemon;