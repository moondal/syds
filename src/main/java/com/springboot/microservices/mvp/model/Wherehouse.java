package com.springboot.microservices.mvp.model;

import lombok.Data;

@Data
public class Wherehouse {
	private String barcode;
	private String itemCd;
	private String itemNm;
	private int qty;
	private int capaQty;
	private String useYn;
	private String locNm;
	private int sort;
}