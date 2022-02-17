package com.crm.app.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;

public class StaticUtils {
	//public static final String FILE_BASE_LOCATION = "/home/vanor/eclipse-workplace/uploads/";
	//public static final String FILE_BASE_LOCATION = "C:/Users/pc-wv/eclipse-workspace/upload/";
	public static final String FILE_BASE_LOCATION = "/home/centos/media/";
	 
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
	public static final String LOGO_BASE_LOCATION = "default.jpg";

	
	public static String saveFile(MultipartFile file, String prefix, String companyName) {
		if(file.isEmpty())
			return "";
		
		String ext = Files.getFileExtension(file.getOriginalFilename());
		ext = ext.isEmpty() ? "" : "." + ext;
		String fileName = prefix + "_" + companyName + (new Date()).getTime() + ext;
		
		try {
			File fileToSave = new File(FILE_BASE_LOCATION + fileName.trim().replace(" ", ""));
			file.transferTo(fileToSave);
			
			return fileName.trim().replace(" ", "");
			
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
	
	public static Long parseLong(String aString) {
		if(aString == null || aString.isEmpty())
			return null;
		
		try {
			return Long.parseLong(aString);
			
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Map<String, String> getParams(HttpServletRequest request) {
		Map<String, String> params = new LinkedHashMap<>();
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			List<String> values = Arrays.asList(paramValues);
			
			params.put(paramName, String.join("; ", values));
		}
		
		return params;
	}
	
	public static String getConnectedUserLogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken))
			return auth.getName();
		
		return null;
	}
}
