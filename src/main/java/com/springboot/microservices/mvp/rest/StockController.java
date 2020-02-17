package com.springboot.microservices.mvp.rest;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


import com.springboot.microservices.mvp.dao.StockDao;
import com.springboot.microservices.mvp.model.Stock;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value="Hello Service API")
@RequestMapping(value="/stock")
@RestController
public class StockController {
	
	@Autowired
	private StockDao stockDao;
	
		
	@ApiOperation(value="위치별 재고 조회")
	@RequestMapping(value="/getstocklist/{itemCd}", method=RequestMethod.GET)
	public ResponseEntity <List<Stock>> getStockList(
			@PathVariable (name="itemCd", required = true) String itemCd
			) { 
		
		List<Stock> list = null;
		try {
			log.info("Start db select");
			list = stockDao.selectStockList(itemCd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("stock counts :"+list.size());
		
		return new ResponseEntity<List<Stock>> (list, HttpStatus.OK);
	}
	
	@ApiOperation(value="재고 증가(입고 확정)(param:locCd,barcode)")
	@RequestMapping(value="/setstockinsert", method=RequestMethod.POST)
	public ResponseEntity <String> setStockInsert(
			@RequestBody Stock stock
		) throws Exception { 
		
		log.info("Start db update");
		int re  = stockDao.updateStockInsert(stock);
		
		if( re == 1)
		{
			re  = stockDao.updateBarcode(stock);
		}
		
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
	@ApiOperation(value="재고 감소(param:locCd,barcode)")
	@RequestMapping(value="/setstockdelete", method=RequestMethod.POST)
	public ResponseEntity <String> setStockDelete(
			@RequestBody Stock stock
		) throws Exception { 
		
		log.info("Start db update");
		int re  = stockDao.updateStockDelete(stock);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
}
