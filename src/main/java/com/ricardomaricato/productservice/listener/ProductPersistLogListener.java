package com.ricardomaricato.productservice.listener;

import com.ricardomaricato.productservice.event.ProductPersistEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ProductPersistLogListener implements ApplicationListener<ProductPersistEvent> {

    private final Logger logger = LoggerFactory.getLogger(ProductPersistLogListener.class);

    @Override
    public void onApplicationEvent(ProductPersistEvent productPersistEvent) {
        var product = productPersistEvent.getProduct();
        logger.info("Inserting the product {} ", product);
    }
}
