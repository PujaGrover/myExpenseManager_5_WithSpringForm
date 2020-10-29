package com.expense_manager.model;

import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "expenses")
public class Expense {
	//Attributes/Fields
	//Primary Key - expenseID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="expense_id")
	private Integer expenseID;

	@Basic
	@Column(name = "expense_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expenseDate;
	
	@Basic
	@Column(name = "expense_amount", nullable = false)
	private Double expenseAmount;
	
	@Basic
	@Column(name = "expense_description", nullable = true)
	private String expenseDescription;
	
	
	//Foreign Key - mapped by expenseCategoryID
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="expense_category_id")
	private ExpenseCategory expenseCategory;

	 
//	//Foreign Key - mapped by useID
//    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//					CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name="exp_user_detail_id")
//	private UserDetail userDetail;
	
	//Constructors
	public Expense() {}
	
	public Expense(LocalDate expenseDate, Double expenseAmount, 
			ExpenseCategory expenseCategory,String expenseDescription) {
	this.expenseDate = expenseDate;
	this.expenseAmount = expenseAmount;
	this.expenseCategory = expenseCategory;
	this.expenseDescription = expenseDescription;
	}
	
	public Expense(Integer expenseID, LocalDate expenseDate,
			Double expenseAmount, String expenseDescription,
			ExpenseCategory expenseCategory) {
		super();
		this.expenseID = expenseID;
		this.expenseDate = expenseDate;
		this.expenseAmount = expenseAmount;
		this.expenseDescription = expenseDescription;
		this.expenseCategory = expenseCategory;
	}
	
	//Getters/Setters
	public Integer getExpenseID() {
		return expenseID;
	}
	public void setExpenseID(Integer expenseID) {
		this.expenseID = expenseID;
	}
	public LocalDate getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}
	
	public Double getExpenseAmount() {
		return expenseAmount;
	}
	public void setExpenseAmount(Double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
	public String getExpenseDescription() {
		return expenseDescription;
	}
	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}
	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}
	public void setExpenseCategory(ExpenseCategory expenseCategory) {
		this.expenseCategory = expenseCategory;
	}
	
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("[Expense] {ExpenseDate : ").append(this.getExpenseDate())
		.append("  ExpenseAmount: ").append(this.getExpenseAmount())
		.append(" ExpenseDescription: ").append(this.getExpenseDescription())
		.append(" ExpenseCategory: ").append(this.getExpenseCategory().getExpenseCategoryName())
		.append("}");
		return b.toString();
	}
	
//	public UserDetail getUserDetail() {
//		return userDetail;
//	}
//	public void setUserID(UserDetail userDetail) {
//		this.userDetail = userDetail;
//	}
	
//	public String toString() {
//		StringBuffer b = new StringBuffer();
//		b.append("[Expense] {ExpenseDate : ").append(this.getExpenseDate())
//		.append("  ExpenseAmount: ").append(this.getExpenseAmount())
//		.append(" ExpenseDescription: ").append(this.getExpenseDescripton())
//		.append(" ExpenseCategory: ").append(this.getExpenseCategory().getExpenseCategoryName())
//		.append(" UserDetail Name: ").append(this.getUserDetail().getUserName())
//		.append("}");
//		return b.toString();
//	}
	
	
	
//	//Methods
//	/**
//	 * This method will insert the validated <b><i>Expense</i></b> in the Database.
//	 * @param u
//	 */
//	public void createExpenseInDB(Expense e) {}   
//	
//	
//	/**
//	 * @param u
//	 * @return
//	 */
//	public boolean validateExpense(Expense e) {
//		return true;
//	}
//	
//	/**
//	 * @param 
//	 * @return
//	 */
//	public Expense getExpenseFromDB(int expenseID, String month, int Year) {
//		return null;
//	}
	

	

}
