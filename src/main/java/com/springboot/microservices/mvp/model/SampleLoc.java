package com.springboot.microservices.mvp.model;

import lombok.Data;

@Data
public class SampleLoc {

	 private String  locCd 		; 
	 private String  locNm 		; 
	 private int 	 onhandQty 	;  
	 private int  	 capaQty 	    ;  
	 private String  uom    ;  
	 private String  useYn 	    ;
	 private String  barcode 	    ;
}