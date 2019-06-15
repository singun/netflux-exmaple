package singun.springframework.netfluxexample.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import singun.springframework.netfluxexample.domain.Movie;
import singun.springframework.netfluxexample.domain.MovieEvent;

public class MovieServiceImpl implements MovieService {
	@Override
	public Flux<MovieEvent> events(String movieId) {
		return null;
	}

	@Override
	public Mono<Movie> getMovieById(String id) {
		return null;
	}

	@Override
	public Flux<Movie> getAllMovies() {
		return null;
	}
}
