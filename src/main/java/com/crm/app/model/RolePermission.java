package com.crm.app.model;

import java.io.Serializable;
import java.util.Arrays;

public class RolePermission implements Serializable{
	
	private Long roleId;
	
	private Long[] permissionIds ;

	public Long getRoleId() {
		return roleId;
	}
  
	public void setRoleId(Long roleid) {
		this.roleId = roleid;
	}

	public Long[] getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(Long[] permissionIds) {
		this.permissionIds = permissionIds;
	}

	@Override
	public String toString() {
		return "RolePermission [roleId=" + roleId + ", permissionIds=" + Arrays.toString(permissionIds) + "]";
	}
	
	

}
