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

import com.springboot.microservices.mvp.dao.BarcodeDao;
import com.springboot.microservices.mvp.model.Barcode;
import com.springboot.microservices.mvp.rabbitmq.BroadcastMessageProducer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value="Hello Service API")
@RequestMapping(value="/barcode")
@RestController
public class BarcodeController {
	
	@Autowired
	private BarcodeDao barcodeDao;
	
	
	@ApiOperation(value="바코드 정보 조회 ")
	@RequestMapping(value="/getbarcode", method=RequestMethod.GET)
	public ResponseEntity <Barcode> getBarcode() { 
		Barcode re = null;
		try {
			log.info("Start db select");
			re = barcodeDao.selectBarcode();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Barcode> (re, HttpStatus.OK);
	}
}

