package com.springboot.microservices.mvp.model;

import lombok.Data;

@Data
public class Stock {
	 private String  locCd;
	 private String  locNm; 
	 private String  useYn;
	 private String  barcode;
	 private String  itemCd; 
	 private String  itemNm;
	 private int 	 qty;  
	 private String  makeDt;  
	 private String  efftDt;
}