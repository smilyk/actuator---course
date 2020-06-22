package smilyk.actuator.repositories;

import org.springframework.data.repository.CrudRepository;
import smilyk.actuator.domain.Author;

/**
 * Created by jt on 5/6/16.
 */
public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
