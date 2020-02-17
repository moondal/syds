package com.springboot.microservices.mvp.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.microservices.mvp.model.Barcode;


@Mapper
public interface BarcodeDao {

	/**
	 * 바코드 정보 가져오기 
	 * @return
	 * @throws Exception
	 */
	Barcode selectBarcode() throws Exception;	
}
