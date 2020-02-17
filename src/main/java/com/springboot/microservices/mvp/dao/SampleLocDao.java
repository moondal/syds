package com.springboot.microservices.mvp.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.microservices.mvp.model.SampleLoc;


@Mapper
public interface SampleLocDao {

	/**
	 * 사용자 전체 정보 가져오기 
	 * @return
	 * @throws Exception
	 */
	List<SampleLoc> selectLoc() throws Exception;	
	
	/**
	 * 사용자 정보 변경하
	 * @param sampleUser
	 * @return
	 * @throws Exception
	 */
	int insertLoc(SampleLoc sampleLoc) throws Exception;
	
}
