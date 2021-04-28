package com.ricardomaricato.productservice.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardomaricato.productservice.event.ProductPersistEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Order(2)
public class ProductPersistQueueListener implements ApplicationListener<ProductPersistEvent> {

    private static final Logger logger = Logger.getLogger(ProductPersistQueueListener.class.getName());

    private final ObjectMapper objectMapper;
    private final JmsTemplate jmsTemplate;

    public ProductPersistQueueListener(ObjectMapper objectMapper, JmsTemplate jmsTemplate) {
        this.objectMapper = objectMapper;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void onApplicationEvent(ProductPersistEvent productPersistEvent) {
        try {
            var product  = productPersistEvent.getProduct();
            var json = objectMapper.writeValueAsString(product);
            jmsTemplate.convertAndSend("product.persist.queue", json);
        } catch (JsonProcessingException e) {
            logger.finer(e.getMessage());
        }
    }
}
