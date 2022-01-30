package com.crm.app.dto;

import org.springframework.web.multipart.MultipartFile;

public class AccountDto {
	private Long id;
    private String name;
	private String aboutUs;
	
	private MultipartFile logo;
	private String line1;
	private String line2;
	private String line3;
	private String city;
	private String postalCode;
	private String localAuthority;
	private String contactName;
	private String contactEmail;
	private String contactPhoneNumber;
	private String website;
 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAboutUs() {
		return aboutUs;
	}
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	public MultipartFile getLogo() {
		return logo;
	}
	public void setLogo(MultipartFile logo) {
		this.logo = logo;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getLine3() {
		return line3;
	}
	public void setLine3(String line3) {
		this.line3 = line3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getLocalAuthority() {
		return localAuthority;
	}
	public void setLocalAuthority(String localAuthority) {
		this.localAuthority = localAuthority;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", name=" + name + ", aboutUs=" + aboutUs + ", logo=" + logo + ", line1=" + line1 + ", line2="
				+ line2 + ", line3=" + line3 + ", city=" + city + ", postalCode=" + postalCode + ", localAuthority="
				+ localAuthority + ", contactName=" + contactName + ", contactEmail=" + contactEmail
				+ ", contactPhoneNumber=" + contactPhoneNumber + ", website=" + website + "]";
	}
	
	public String checkRequired() {
		if(name == null || name.isEmpty() )
			return "name or email required";
		
		if(logo == null || logo.isEmpty())
			return "phoneNumber or logo required";
		
		if(line1 == null || line1.isEmpty() || city == null || city.isEmpty())
			return "line1 or city required";
		
		if(postalCode == null || postalCode.isEmpty() || localAuthority == null || localAuthority.isEmpty())
			return "postalCode or localAutority required";
		
		if(contactName == null || contactName.isEmpty() || contactEmail == null || contactEmail.isEmpty())
			return "contactName or contactEmail required";
		
		if(contactPhoneNumber == null || contactPhoneNumber.isEmpty())
			return "contactPhoneNumber required";
		
		return "ok";
	}
}
