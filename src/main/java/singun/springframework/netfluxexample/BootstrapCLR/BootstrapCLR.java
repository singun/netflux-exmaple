package singun.springframework.netfluxexample.BootstrapCLR;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import singun.springframework.netfluxexample.domain.Movie;
import singun.springframework.netfluxexample.repositories.MovieRepository;

import java.util.UUID;

@Component
public class BootstrapCLR implements CommandLineRunner {

	private final MovieRepository movieRepository;

	public BootstrapCLR(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		movieRepository.deleteAll().thenMany(
			Flux.just("Aladin", "Frozen", "Toy Story 4", "Avengers - End Game",
				"Iron Man", "Thor", "Captain America")
				.map(title -> new Movie(title, UUID.randomUUID().toString()))
				.flatMap(movieRepository::save))
				.subscribe(null, null, () -> {
					movieRepository.findAll().subscribe(System.out::println);
				});
	}
}
