package smilyk.actuator.repositories;

import org.springframework.data.repository.CrudRepository;
import smilyk.actuator.domain.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
}
