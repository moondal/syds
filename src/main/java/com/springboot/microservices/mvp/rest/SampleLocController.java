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

import com.springboot.microservices.mvp.dao.SampleFileDao;
import com.springboot.microservices.mvp.dao.SampleLocDao;
import com.springboot.microservices.mvp.dao.SampleUserDao;
import com.springboot.microservices.mvp.model.SampleLoc;
import com.springboot.microservices.mvp.model.SampleUser;
import com.springboot.microservices.mvp.rabbitmq.BroadcastMessageProducer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(value="Hello Service API")
@RequestMapping(value="/Loc")
@RestController
public class SampleLocController {
	
	private String msgTemplate = "%s님  반갑습니다.";
	private final AtomicLong  vistorConouter = new AtomicLong();
	
	@Autowired
	private SampleLocDao sampleLocDao;
	
	@Autowired
	private BroadcastMessageProducer broadcastMessageProducer;
	
	
	@ApiOperation(value="로케이션 정보 가져오기 ")
	@RequestMapping(value="/locs", method=RequestMethod.GET)
	public ResponseEntity <List<SampleLoc>> getLocList() { 
		
		List<SampleLoc> list = null;
		try {
			log.info("Start db select");
			list = sampleLocDao.selectLoc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("user counts :"+list.size());
		
		return new ResponseEntity<List<SampleLoc>> (list, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="로케이션 정보 등록하기 ")
	@RequestMapping(value="/locs", method=RequestMethod.POST)
	public ResponseEntity <String > setLocInsert(
			@RequestBody SampleLoc sampleLoc
		) throws Exception { 
		
		List<SampleLoc> list = null;
		log.info("Start db insert");
		int re  = sampleLocDao.insertLoc(sampleLoc);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
}
