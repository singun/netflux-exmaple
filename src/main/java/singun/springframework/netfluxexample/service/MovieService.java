package singun.springframework.netfluxexample.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import singun.springframework.netfluxexample.domain.Movie;
import singun.springframework.netfluxexample.domain.MovieEvent;

public interface MovieService {
	Flux<MovieEvent> events(String movieId);

	Mono<Movie> getMovieById(String id);

	Flux<Movie> getAllMovies();
}
