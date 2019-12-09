package com.liuft.springbootseed;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.FileInputStream;
import java.io.FileOutputStream;

@SpringBootApplication
@RestController
public class SpringBootSeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSeedApplication.class, args);
	}

	@Value("${file.out.path}")
	private String basePath;

	/**
	 *
	 * @param file 将要处理的ppt
	 * @return
	 */
	@PostMapping("test")
	public String test(@RequestParam("file") MultipartFile file) {
		try{
			String baseFileName = file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf("."));
			PPTUtil.split(file.getInputStream(),basePath,baseFileName);
			return "success";
		}catch (Exception e){
			e.printStackTrace();
			return "fail";
		}

	}


}
