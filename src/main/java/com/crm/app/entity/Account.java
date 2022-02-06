package com.crm.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
    private Long id;
 
	@Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
	
	@Column(name = "about_us")
	private String aboutUs;
	
	@Column(name = "logo_link", nullable = false, columnDefinition = "TEXT")
	private String logoLink;
	
	@Column(name = "line_1", nullable = false)
	private String line1;
	
	@Column(name = "line2")
	private String line2;
	
	@Column(name = "line3")
	private String line3;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "postal_code", nullable = false)
	private String postalCode;
	
	@Column(name = "local_authority", nullable = false)
	private String localAuthority;
	
	@Column(name = "contact_name", nullable = false)
	private String contactName;
	
	@Column(name = "contact_email", nullable = false)
	private String contactEmail;
	
	@Column(name = "contact_phone_number", nullable = false)
	private String contactPhoneNumber;
	
	@Column(name = "website")
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

	public String getLogoLink() {
		return logoLink;
	}

	public void setLogoLink(String logoLink) {
		this.logoLink = logoLink;
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
		return "Company [id=" + id + ", name=" + name + ", aboutUs=" + aboutUs + ", logoLink=" + logoLink + ", line1=" + line1
				+ ", line2=" + line2 + ", line3=" + line3 + ", city=" + city + ", postalCode=" + postalCode
				+ ", localAuthority=" + localAuthority + ", contactName=" + contactName + ", contactEmail="
				+ contactEmail + ", contactPhoneNumber=" + contactPhoneNumber + ", website=" + website
				+ "]";
	}

	
}
