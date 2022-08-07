import React, { useEffect } from 'react';
import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button} from 'reactstrap';
import './App.css';
import MovieList from './components/MovieList';
import SearchBox from './components/SearchBox';
import MovieListHeading from './components/MovieListHeading';

function App() {
  const[movies,setMovies]=useState([]);
  const[searchValue,setSearchValue]=useState('');


  const getMovieReuest=async(searchValue)=>{
    //search
    ////http://localhost:8080/api/v1/movies/search?title=

    //http://localhost:8080/api/v1/movies/popular?page=1
    //https://api.themoviedb.org/3/movie/popular?api_key=a97243d7813d31446f6c43284e6854d5&page=1
    const url='http://localhost:8080/api/v1/movies/search?title='+searchValue;
    //const urlSearch='http://localhost:8080/api/v1/movies/search?title='+searchValue;
    const response=await fetch(url);

    const responseJson=await response.json();
    console.log(responseJson)
      
    if(responseJson.results){
    setMovies(responseJson.results)
    }
  };


  useEffect(()=>{
    getMovieReuest(searchValue);
  },[searchValue])
      

  return (
    <div>
        <div>
          <MovieListHeading heading="Movies"/>
          
          <SearchBox searchValue={searchValue} setSearchValue={setSearchValue}/>
          <br></br>
        </div>
      <div className="row row-cols-2 row-cols-lg-5 g-2 g-lg-3">
      <MovieList movies={movies}/>
      </div>
      
    </div>
  );
};

export default App;
