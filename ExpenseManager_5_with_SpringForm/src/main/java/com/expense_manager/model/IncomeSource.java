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
@Table(name = "income_sources")
public class IncomeSource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="income_source_id")
	private Integer incomeSourceID; 
	
	@Basic
	@Column(name ="income_source_name", nullable=false)
	@NotBlank(message = "Category name is required")
	private String incomeSourceName;
	
	@Basic
	@Column(name="income_source_description", nullable=true)
	private String incomeSourceDescription;
	
	// Foreign Key: None
	
	// Constructors
	public IncomeSource() {}
	
	public IncomeSource( String incomeSourceName,
			String incomeSourceDescription) {
		this.incomeSourceName = incomeSourceName;
		this.incomeSourceDescription = incomeSourceDescription;
	}

	public IncomeSource(Integer incomeSourceID,
		String incomeSourceName, String incomeSourceDescription) {
		this.incomeSourceID = incomeSourceID;
		this.incomeSourceName = incomeSourceName;
		this.incomeSourceDescription = incomeSourceDescription;
	}

	// Getters/Setters
	public Integer getIncomeSourceID() {
		return incomeSourceID;
	}

	public void setIncomeSourceID(Integer incomeSourceID) {
		this.incomeSourceID = incomeSourceID;
	}

	public String getIncomeSourceName() {
		return incomeSourceName;
	}

	public void setIncomeSourceName(String incomeSourceName) {
		this.incomeSourceName = incomeSourceName;
	}

	public String getIncomeSourceDescription() {
		return incomeSourceDescription;
	}

	public void setIncomeSourceDescription(String incomeSourceDescription) {
		this.incomeSourceDescription = incomeSourceDescription;
	}
	

	//Methods
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("[IncomeSource] {IncomeSourceName : ").append(this.getIncomeSourceName())
		.append(" IncomeSourceDescription: ").append(this.getIncomeSourceDescription())
		 .append("}");
		return b.toString();
	}

}
