package com.springboot.microservices.mvp.common.file.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

@Data
public class FileUpdateRequestVO {
	String path;
	private long attachSeq;
	List<MultipartFile> uploadList = new ArrayList<>();
	
	List<FileDownloadRequestVO> deleteList = new ArrayList<>();
	
}
