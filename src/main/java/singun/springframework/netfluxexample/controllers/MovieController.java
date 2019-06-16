package singun.springframework.netfluxexample.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import singun.springframework.netfluxexample.domain.Movie;
import singun.springframework.netfluxexample.domain.MovieEvent;
import singun.springframework.netfluxexample.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}


	@GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<MovieEvent> streamMovieEvents(@PathVariable String id) {
		return movieService.events(id);
	}

	@GetMapping(value = "/{id}")
	Mono<Movie> getMovieById(@PathVariable String id) {
		return movieService.getMovieById(id);
	}

	@GetMapping
	Flux<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
}
