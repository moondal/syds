package com.springboot.microservices.mvp.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.springboot.microservices.mvp.model.Stock;

import lombok.extern.slf4j.Slf4j;





@Component
@Slf4j
public class BroadcastMessageProducer {

	  @Value("${prop.rabbit.direct.input}")
	  private String EXCHANGE;
	  
	  @Value("${prop.rabbit.route.input}")
	  private String ROUTING_KEY;
	  
	  @Autowired
	  private RabbitTemplate rabbitTemplate;

	  public void produceWmsItemInput(Stock stock){
			log.debug("EXCHANGE : "+EXCHANGE);
			log.debug("ROUTING_KEY : "+ROUTING_KEY);
		    log.debug("Send Message to Rabbitmq :" + stock.toString());
		    rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, stock);
	  }
}