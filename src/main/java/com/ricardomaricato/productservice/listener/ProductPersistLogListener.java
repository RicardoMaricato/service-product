package com.ricardomaricato.productservice.listener;

import com.ricardomaricato.productservice.event.ProductPersistEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ProductPersistLogListener implements ApplicationListener<ProductPersistEvent> {

    @Override
    public void onApplicationEvent(ProductPersistEvent productPersistEvent) {
        var product = productPersistEvent.getProduct();
        System.out.println(product.getDescription());
    }
}
