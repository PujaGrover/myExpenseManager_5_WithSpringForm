package com.expense_manager.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name ="user_details")
public class UserDetail {
	// Attributes/Fields
	// Primary Key - userDetailID, auto_increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_detail_id")
	private int userDetailID;
	
	@Basic
	@Column(name = "first_name", nullable = false, length = 50)
	@Size(min=2, max=25,  message="Name must be between 2 and 16 characters long.")
	@NotBlank(message="First Name is required.")
	private String firstName;
	
	@Basic
	@Column(name = "last_name", nullable = false, length = 50)
	@Size(min=2, max=25,  message="Name must be between 2 and 16 characters long.")
	@NotBlank(message="Last Name is required.")
	private String lastName;
	
	@Basic
	@Column(name = "user_name", nullable = false, length = 50)
	@Size(min=2, max=25,  message="Name must be between 2 and 25 characters long.")
	@NotBlank(message="User Name is required.")
	private String userName;
	
	@Basic
	@Column(name = "user_password", nullable = true, length = 50)
	@Size(min=8, max=16,  message="Password must be between 8 and 16 characters long.")
	@NotBlank(message="Password is required.")
	private String userPassword;
	
	@Basic
	@Column(name = "user_email", nullable = true, unique = true)
	@Email(message = "Please enter a valid email")
	@NotBlank(message="Email is required.")
	private String userEmail;
	
	// Foreign Key
	@OneToOne
	@JoinColumn(name="role_roleid")
	private Role role;
	
//	//Bi-directional relationship mapped by userDetail property in Expense Class
//	@OneToMany(mappedBy="userDetail",
//			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//					CascadeType.DETACH, CascadeType.REFRESH})
//	
	//Convenience method for bi-directional relationship
//	public void add(Expense theExpense) {
//		if(expenseList == null) {
//			expenseList = new ArrayList<Expense>();
//		}
//		expenseList.add(theExpense);
//		expenseList.setUserDetail(this);
//	}

	//Constructors
	//First constructor takes no parameters and it initializes every member to an initial value
	public UserDetail() {
		Role role = new Role();
		role.setRoleID(2);
		role.setRoleName("user");
		role.setAccessLevel("basic");
	}
	//Second constructor initializes every private member with parameter provided in the constructor
	public UserDetail(String firstName, String lastName, String userName, String userPassword,
			String userEmail, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		role.setRoleID(2);
		role.setRoleName("user");
		role.setAccessLevel("basic");
		this.role = role;
	}



	public int getUserDetailID() {
		return userDetailID;
	}
	public void setUserDetailID(int userDetailID) {
		this.userDetailID = userDetailID;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}


	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("[UserDetail] {FirstName: ").append(this.getFirstName())
		.append(" LastName: ").append(this.getLastName())
		.append(" UserName: ").append(this.getUserName())
		.append(" Email: ").append(this.getUserEmail())
		.append(" Password: ").append(this.getUserPassword())
		.append(" RoleName: ").append(this.getRole().getRoleName())
		.append(" RoleAccess: ").append(this.getRole().getAccessLevel())
		.append("}");
		return b.toString();
	}

}

	

