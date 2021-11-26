package net.filmcity.app.repositories;

import net.filmcity.app.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}

@Repository

    public class MovieRepository {

        private List<Movie> movies;

        public MovieRepository() {
            this.coders = new ArrayList<>();
        }

        public Coder save(Coder coder) {
            coders.add(coder);
            return coder;
        }

        public void deleteAll() {
            coders.clear();
        }

        public List<Coder> findAll() {
            return coders;
        }

        public Optional<Coder> findByIndex(int index) {
            if (isValidIndex(index)) {
                return Optional.of(coders.get(index));
            }
            return Optional.empty();
        }
}

