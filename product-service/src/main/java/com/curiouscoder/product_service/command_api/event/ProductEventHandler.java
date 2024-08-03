package com.curiouscoder.product_service.command_api.event;


import com.curiouscoder.product_service.base_entity.Product;
import com.curiouscoder.product_service.base_entity.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductEventHandler {

    private final ProductRepository productRepository;

    //Once the event is created we need to handle it ex. store in db
    @EventHandler
    public void on(ProductCreatedEvent event) {

        Product product = new Product();
        BeanUtils.copyProperties(event , product);
        productRepository.save(product);

    }
}
