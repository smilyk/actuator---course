package smilyk.actuator.services;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smilyk.actuator.domain.Product;
import smilyk.actuator.repositories.ProductRepository;
import smilyk.actuator.services.ProductService;
import smilyk.actuator.services.jms.JmsTextMessageService;

import java.util.List;

/**
 * отслеживаем сколько раз продукты полуяались через этот сервис
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private JmsTextMessageService jmsTextMessageService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, JmsTextMessageService jmsTextMessageService) {
        this.productRepository = productRepository;
        this.jmsTextMessageService = jmsTextMessageService;
    }

    @Override
    public Product getProduct(Integer id) {
        jmsTextMessageService.sendTextMessage("Fetching Product ID: " + id );
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> listProducts() {
        jmsTextMessageService.sendTextMessage("Listing Products");
        return IteratorUtils.toList(productRepository.findAll().iterator());
    }

}
