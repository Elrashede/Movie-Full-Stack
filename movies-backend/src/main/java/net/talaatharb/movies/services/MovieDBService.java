package net.talaatharb.movies.services;

import net.talaatharb.movies.Repository.MovieRepository;
import net.talaatharb.movies.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import net.talaatharb.movies.dtos.MoviePage;

@Service
@RequiredArgsConstructor
public class MovieDBService {

	private final RestTemplate restTemplate;

	private String apiKey = "a97243d7813d31446f6c43284e6854d5";

	private String apiUrl = "https://api.themoviedb.org/3";

	private static final String URL_SEGEMENT_FOR_POPULAR = "/movie/popular";

	//http://localhost:8080/api/v1/movies/popular?page=1
	//https://api.themoviedb.org/3/movie/popular?api_key=a97243d7813d31446f6c43284e6854d5&page=1
	public MoviePage getPopularMovies(Integer page) {
		String urlForPopularMovies = apiUrl + URL_SEGEMENT_FOR_POPULAR + "?api_key=" + apiKey + "&page="
				+ page.intValue();
		System.out.println(urlForPopularMovies);
		return restTemplate.getForEntity(urlForPopularMovies, MoviePage.class).getBody();
	}
	MovieRepository movieRepository ;
	// https://api.themoviedb.org/3/movie/616037?api_key=a97243d7813d31446f6c43284e6854d5

	public Movie getMovieDetails(Integer id) {
		String urlForMovieDetails = apiUrl + "/movie/" + id + "?api_key=" + apiKey;
		boolean isMovieInDB =movieRepository.existsById(id);
		if (isMovieInDB) {
			return movieRepository.findById(id).get();
		} else {
			Movie movie = restTemplate.getForEntity(urlForMovieDetails, Movie.class).getBody();
			System.out.println(movie);
			movieRepository.save(movie);
			return movie;
		}

	}
	public Object searchForMovie(String title) {
		//https://api.themoviedb.org/3/search/?api_key=a97243d7813d31446f6c43284e6854d5&query=
		String urlForMovie = apiUrl + "/search/movie?api_key=" + apiKey + "&query=" + title;
		System.out.println(urlForMovie);
		return restTemplate.getForEntity(urlForMovie, Object.class).getBody();
	}


}
