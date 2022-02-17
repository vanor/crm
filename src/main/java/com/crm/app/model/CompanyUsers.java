package com.crm.app.model;

import java.util.Arrays;

public class CompanyUsers {

	
	private Long companyId;
	
	private Long[] userIds ;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long[] getUserIds() {
		return userIds;
	}

	public void setUserIds(Long[] userIds) {
		this.userIds = userIds;
	}

	@Override
	public String toString() {
		return "CompanyUsers [companyId=" + companyId + ", userIds=" + Arrays.toString(userIds) + "]";
	}
	
	
}
