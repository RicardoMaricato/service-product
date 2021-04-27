package com.ricardomaricato.productservice.listener;

import com.ricardomaricato.productservice.event.ProductPersistEvent;
import com.ricardomaricato.productservice.model.Product;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProductPersistLogListener implements ApplicationListener<ProductPersistEvent> {

    @Override
    public void onApplicationEvent(ProductPersistEvent productPersistEvent) {
        Product product = productPersistEvent.getProduct();
        System.out.println(product.getDescription());
    }
}
