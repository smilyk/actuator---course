package smilyk.actuator.services;

import smilyk.actuator.domain.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(Integer id);

    List<Product> listProducts();
}
