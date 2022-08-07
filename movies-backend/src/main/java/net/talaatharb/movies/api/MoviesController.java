package net.talaatharb.movies.api;

import net.talaatharb.movies.services.MovieDBService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import net.talaatharb.movies.facades.MovieFacade;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/movies")
public class MoviesController {
	
	private final MovieFacade movieFacade;
	private final MovieDBService movieDB;

	//http://localhost:8080/api/v1/movies/popular?page=1
	@GetMapping(path = "/popular")
	public ResponseEntity<Object> getPopularMovies(@RequestParam Integer page){
		
		return new ResponseEntity<>(movieFacade.getPopularMovies(page), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> getMovieDetails(@PathVariable Integer id){
		return new ResponseEntity<>(movieDB.getMovieDetails(id), HttpStatus.OK);
	}

	//http://localhost:8080/api/v1/movies/search?title=Thor:%20Love%20and%20Thunder

	@GetMapping(path = "/search")
	public ResponseEntity<Object> searchMovie(@RequestParam String title) {
		return new ResponseEntity<>(movieDB.searchForMovie(title), HttpStatus.OK);
	}
}
