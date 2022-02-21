package com.crm.app.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

import com.crm.app.entity.Company;
import com.crm.app.entity.Permission;
import com.crm.app.entity.Role;
import com.crm.app.entity.Utilisateur;
import com.google.common.io.Files;

public class StaticUtils {
	public static String FILE_BASE_LOCATION;
	 
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
	public static final String LOGO_BASE_LOCATION = "default.jpg";

	
	public static String saveFile(MultipartFile file, String prefix, String companyName) {
		if(file.isEmpty())
			return "";
		
		String ext = Files.getFileExtension(file.getOriginalFilename());
		ext = ext.isEmpty() ? "" : "." + ext;
		String fileName = prefix + "_" + companyName + "_" + (new Date()).getTime() + ext;
		
		try {
			File fileToSave = new File(FILE_BASE_LOCATION + fileName.trim().replace(" ", ""));
			file.transferTo(fileToSave);
			
			return fileName.trim().replace(" ", "");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return "";
	}
	
	public static String saveFile(Part file, String prefix, String companyName) {
		String ext = Files.getFileExtension(file.getSubmittedFileName());
		ext = ext.isEmpty() ? "" : "." + ext;
		String fileName = prefix + "_" + companyName + "_" + (new Date()).getTime() + ext;
		fileName = fileName.trim().replace(" ", "");
		
		try {
			File aFile = new File(FILE_BASE_LOCATION + fileName);
			InputStream is = file.getInputStream();
			java.nio.file.Files.copy(is, aFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
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
	
	public static boolean isOperationalManager(Utilisateur user) {
		for(Role role : user.getRoles()) {
			for(Permission perm : role.getPermissions()) {
				if(perm.getName().equalsIgnoreCase("edt_stage_4"))
					return true;
			}
		}
		
		return false;
	}
	
	public static boolean isSuperAdmin(Utilisateur user) {
		for(Role role : user.getRoles()) {
			String roleName = role.getGuardName();
			if(roleName != null && roleName.equals("super_admin"))
				return true;
			
			for(Permission perm : role.getPermissions()) {
				String permName = perm.getGuardName();
				if(permName != null && permName.equals("super_admin"))
					return true;
			}
		}
		
		return false;
	}
	
	public static boolean isUserAllowedForCompany(Utilisateur user, Company company) {
		Set<Utilisateur> users = company.getUsers();
		if(users == null || users.size() == 0)
			return false;
		
		List<Long> userIds = users.stream()
				.map(u -> u.getId())
				.collect(Collectors.toList());
		
		return userIds.contains(user.getId());
	}
	
	public static List<Part> getFiles(HttpServletRequest request) {
		try {
			Collection<Part> parts = request.getParts();
			return parts.stream()
					.collect(Collectors.toList());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
