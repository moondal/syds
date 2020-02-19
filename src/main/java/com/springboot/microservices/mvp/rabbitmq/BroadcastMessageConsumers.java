package com.springboot.microservices.mvp.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.microservices.mvp.model.Stock;
import com.springboot.microservices.mvp.dao.StockDao;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BroadcastMessageConsumers {

	/*
	@Autowired
	private StockDao stockDao;
	
	@RabbitListener(queues = "${prop.rabbit.queue.input}" )
	public void receiveMessageFromDirectInputWithQueue(Stock stock) {
		log.debug("WMS_ITEM_INPUT Receive : "+ stock.toString());
		
		
		// 실패하면 재고증가 취소
		if(stock.getQty() == 0)
		{
			try
			{
				int re  = stockDao.updateStockDelete(stock);
			}
			catch(Exception ex)
			{
				log.debug("Fail");
			}
		}
	}
	*/
}
