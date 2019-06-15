package singun.springframework.netfluxexample.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import singun.springframework.netfluxexample.domain.Movie;

public interface  MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
