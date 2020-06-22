package smilyk.actuator.repositories;

import org.springframework.data.repository.CrudRepository;
import smilyk.actuator.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
