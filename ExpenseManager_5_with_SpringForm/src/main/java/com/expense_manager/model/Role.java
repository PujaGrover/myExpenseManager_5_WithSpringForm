package com.expense_manager.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
public class Role {
	// Attributes/Fields
	@Id
	@Column(name = "roleid")
	private int roleID;

	@Basic
	@Column(name = "role_name", nullable = false, length = 50)
	@NotBlank(message="Role name is required.")
	private String roleName;

	@Basic
	@Column(name = "access_level", nullable = false, length = 50)
	@NotBlank(message="Access level is required.")
	private String accessLevel;

	// Constructors
	// First constructor takes no parameters and it initializes every member to an
	// initial value
	public Role() {
		//this.addAdminRoleInDB();
		
	}

	// Second constructor initializes every private member with parameter provided
	// in the constructor
	public Role(int roleID, String roleName, String accessLevel) {
		this.roleID = roleID;
		this.roleName = roleName;
		this.accessLevel = accessLevel;
		//this.addAdminRoleInDB();
	}

	// Getters/Setters
	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	// Methods

//	public void addAdminRoleInDB() {
//		Role role = new Role();
//		role.setRoleID(1);
//		role.setRoleName("admin");
//		role.setAccessLevel("complete");
//	}


	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("[Role] {RoleID : ").append(this.getRoleID()).append(" Role Name: ").append(this.getRoleName())
				.append(" Access Level: ").append(this.getAccessLevel()).append("}");
		return b.toString();
	}

//	//Methods
//	public List<Role> getRolesFromDB(){
//		return null;
//	}
//	
//	public void addRoleInDB(Role r) {}

}
