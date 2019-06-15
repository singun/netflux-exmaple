package singun.springframework.netfluxexample.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import singun.springframework.netfluxexample.domain.Movie;
import singun.springframework.netfluxexample.domain.MovieEvent;
import singun.springframework.netfluxexample.repositories.MovieRepository;

import java.time.Duration;
import java.util.Date;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;

	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public Flux<MovieEvent> events(String movieId) {
		return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
			movieEventSynchronousSink.next(new MovieEvent(movieId, new Date()));
		}).delayElements(Duration.ofSeconds(1));
	}

	@Override
	public Mono<Movie> getMovieById(String id) {
		return this.movieRepository.findById(id);
	}

	@Override
	public Flux<Movie> getAllMovies() {
		return this.movieRepository.findAll();
	}
}
