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


import com.springboot.microservices.mvp.dao.LocDao;
import com.springboot.microservices.mvp.model.Loc;
import com.springboot.microservices.mvp.model.SampleUser;
import com.springboot.microservices.mvp.rabbitmq.BroadcastMessageProducer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value="Hello Service API")
@RequestMapping(value="/loc")
@RestController
public class LocController {
	
	@Autowired
	private LocDao locDao;
	
		
	@ApiOperation(value="가용 위치 조회")
	@RequestMapping(value="/getloclist/{barcode}", method=RequestMethod.GET)
	public ResponseEntity <List<Loc>> getLocList(
			@PathVariable (name="barcode", required = true) String barcode
			) { 
		
		List<Loc> list = null;
		try {
			log.info("Start db select");
			list = locDao.selectLocList(barcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("user counts :"+list.size());
		
		return new ResponseEntity<List<Loc>> (list, HttpStatus.OK);
	}
	
	@ApiOperation(value="가용 상태 업데이트(param:locCd,useYn)")
	@RequestMapping(value="/setlocupdate", method=RequestMethod.POST)
	public ResponseEntity <String> setLocUpdate(
			@RequestBody Loc loc
		) throws Exception { 
		
		log.info("Start db update");
		int re  = locDao.updateLoc(loc);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
}
