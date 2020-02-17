package com.springboot.microservices.mvp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.microservices.mvp.model.Loc;


@Mapper
public interface LocDao {

	/**
	 * 가용위치 가져오기 
	 * @return
	 * @throws Exception
	 */
	List<Loc> selectLocList(String barcode) throws Exception;	
	
	/**
	 * 가용상태 업데이트
	 * @param Loc
	 * @return
	 * @throws Exception
	 */
	int updateLoc(Loc loc) throws Exception;
}


