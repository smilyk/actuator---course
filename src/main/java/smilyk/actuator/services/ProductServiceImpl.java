package smilyk.actuator.services;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
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
    private CounterService counterService;
    private GaugeService gaugeService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, JmsTextMessageService jmsTextMessageService,
                              CounterService counterService, GaugeService gaugeService) {
        this.productRepository = productRepository;
        this.jmsTextMessageService = jmsTextMessageService;
        this.counterService = counterService;
        this.gaugeService = gaugeService;
    }

    @Override
    public Product getProduct(Integer id) {
        jmsTextMessageService.sendTextMessage("Fetching Product ID: " + id );
        counterService.increment("guru.springframework.services.ProductService.getproduct");
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> listProducts() {
        jmsTextMessageService.sendTextMessage("Listing Products");

        counterService.increment("guru.springframework.services.ProductService.listProducts");
        gaugeService.submit("guru.springframework.services.listProducts.ProductService.pageViewsPerMin", 6);

        return IteratorUtils.toList(productRepository.findAll().iterator());
    }

}
