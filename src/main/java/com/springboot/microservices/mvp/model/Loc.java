package com.springboot.microservices.mvp.model;

import lombok.Data;

@Data
public class Loc {
	 private String  locCd;	 
	 private String  locNm; 
	 private int 	 onhandQty;  
	 private int  	 capaQty;  
	 private String  useYn;
}
