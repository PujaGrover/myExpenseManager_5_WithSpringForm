package com.expense_manager.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "expense_categories")
public class ExpenseCategory {

	// Attributes/Fields
	// Primary Key - expenseCategoryID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="expense_category_id")
	private int expenseCategoryID;
	
	@Basic
	@Column(name ="expense_category_name", nullable=false)
	@NotBlank(message = "Category name is required")
	private String expenseCategoryName;
	
	@Basic
	@Column(name="expense_category_description", nullable=true)
	private String expenseCategoryDescription;
	
	// Foreign Key: None

	// Constructors
	public ExpenseCategory() {
	}

	public ExpenseCategory(String expenseCategoryName, String expenseCategoryDescription) {
		this.expenseCategoryName = expenseCategoryName;
		this.expenseCategoryDescription = expenseCategoryDescription;
	}
	
	public ExpenseCategory(int expenseCategoryID, String expenseCategoryName, String expenseCategoryDescription) {
		this.expenseCategoryID = expenseCategoryID;
		this.expenseCategoryName = expenseCategoryName;
		this.expenseCategoryDescription = expenseCategoryDescription;
	}

	// Getters/Setters
	public int getExpenseCategoryID() {
		return expenseCategoryID;
	}

	public void setExpenseCategoryID(int expenseCategoryID) {
		this.expenseCategoryID = expenseCategoryID;
	}

	public String getExpenseCategoryName() {
		return expenseCategoryName;
	}

	public void setExpenseCategoryName(String expenseCategoryName) {
		this.expenseCategoryName = expenseCategoryName;
	}

	public String getExpenseCategoryDescription() {
		return expenseCategoryDescription;
	}

	public void setExpenseCategoryDescription(String expenseCategoryDescription) {
		this.expenseCategoryDescription = expenseCategoryDescription;
	}
	
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("[ExpenseCategory] {ExpenseCategoryName : ").append(this.getExpenseCategoryName())
				.append(" ExpenseCategoryDescription: ").append(this.getExpenseCategoryDescription()).append("}");
		return b.toString();
	}
	
}
