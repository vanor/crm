package com.crm.app.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;

public class StaticUtils {
	
	public static final String FILE_BASE_LOCATION = "/home/vanor/eclipse-workplace/uploads/";
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
	
	public static String saveFile(MultipartFile file, String prefix, String companyName) {
		if(file.isEmpty())
			return "";
		
		String ext = Files.getFileExtension(file.getOriginalFilename());
		ext = ext.isEmpty() ? "" : "." + ext;
		String fileName = prefix + "_" + companyName + SIMPLE_DATE_FORMAT.format(new Date()) + ext;
		
		try {
			File fileToSave = new File(FILE_BASE_LOCATION + fileName);
			file.transferTo(fileToSave);
			
			return fileName;
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return "";
	}
	
	public static Resource getFileByName(String name) {
		String filePath = "file:" + FILE_BASE_LOCATION + name;
		DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
		
		return resourceLoader.getResource(filePath);
	}
}