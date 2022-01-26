package com.crm.app.model;

import java.util.Arrays;

public class UserRoles {
	
private Long userId;
	
	private Long[] roleIds ;

	public Long getUserId() {
		return userId;
	}
  
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	@Override
	public String toString() {
		return "UserRoles [userId=" + userId + ", roleIds=" + Arrays.toString(roleIds) + "]";
	}
	
	

}
