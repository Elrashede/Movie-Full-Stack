import { render } from "@testing-library/react";
import React from "react";

const MovieList=(props)=>{

   
        const imageClick = () => {
          console.log('Click');
        } 
    
    return(
        <>
        {props.movies.map((movie,index,)=>(
         <div className="d-flex justify-content-start m-3">
            <img src={"https://www.themoviedb.org/t/p/original"+movie.poster_path} 
            alt="movie" height={400} onClick={() => imageClick()} 
            ></img>
        </div>
        ))}
        </>
    )
    
 
}
export default MovieList;