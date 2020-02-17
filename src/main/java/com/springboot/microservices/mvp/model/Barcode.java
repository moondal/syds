package com.springboot.microservices.mvp.model;

import lombok.Data;

@Data
public class Barcode {
	 private String  barcode;	 
	 private String  itemCd; 
	 private String  itemNm;
	 private int 	 qty;  
	 private String  makeDt;  
	 private String  efftDt;
	 private String  scanYn;
}
