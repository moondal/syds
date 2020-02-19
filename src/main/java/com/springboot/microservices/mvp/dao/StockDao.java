package com.springboot.microservices.mvp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.microservices.mvp.model.Stock;
import com.springboot.microservices.mvp.model.Wherehouse;;


@Mapper
public interface StockDao {

	/**
	 * 위치별 재고조회
	 * @return
	 * @throws Exception
	 */
	List<Stock> selectStockList(String prodCd) throws Exception;	
	
	/**
	 * 재고 증가
	 * @param Stock
	 * @return
	 * @throws Exception
	 */
	int updateStockInsert(Stock stock) throws Exception;
	
	/**
	 * 재고 감소
	 * @param Stock
	 * @return
	 * @throws Exception
	 */
	int updateStockDelete(Stock stock) throws Exception;
	
	/**
	 * 바코드상태 업데이트
	 * @param Stock
	 * @return
	 * @throws Exception
	 */
	int updateBarcode(Stock stock) throws Exception;
	
	/**
	 * 창고  재고조회
	 * @return
	 * @throws Exception
	 */
	List<Wherehouse> selectWherehouseList() throws Exception;	
	
}
