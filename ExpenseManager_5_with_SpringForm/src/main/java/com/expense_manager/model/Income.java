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
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "incomes")
public class Income {
	
	//Attributes/Fields
		//Primary Key - expenseID
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="income_id")
		private Integer incomeID;
		
		@Basic
		@Column(name = "income_date", nullable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate incomeDate;
		
		@Basic
		@Column(name = "income_amount", nullable = false)
		private Double incomeAmount;

		@Basic
		@Column(name = "income_description", nullable = true)
		private String incomeDescription;
		
		//Foreign Key - mapped by incomeSourceID
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="income_source_id")
		private IncomeSource incomeSource;
		
		//Constructors
		public Income() {}
		
		public Income(LocalDate incomeDate, Double incomeAmount, String incomeDescription, IncomeSource incomeSource) {
			super();
			this.incomeDate = incomeDate;
			this.incomeAmount = incomeAmount;
			this.incomeDescription = incomeDescription;
			this.incomeSource = incomeSource;
		}

		public Income(Integer incomeID, LocalDate incomeDate, Double incomeAmount, String incomeDescription,
				IncomeSource incomeSource) {
			super();
			this.incomeID = incomeID;
			this.incomeDate = incomeDate;
			this.incomeAmount = incomeAmount;
			this.incomeDescription = incomeDescription;
			this.incomeSource = incomeSource;
		}

		//Getters/Setters
		public Integer getIncomeID() {
			return incomeID;
		}

		public void setIncomeID(Integer incomeID) {
			this.incomeID = incomeID;
		}

		public LocalDate getIncomeDate() {
			return incomeDate;
		}

		public void setIncomeDate(LocalDate incomeDate) {
			this.incomeDate = incomeDate;
		}

		public Double getIncomeAmount() {
			return incomeAmount;
		}

		public void setIncomeAmount(Double incomeAmount) {
			this.incomeAmount = incomeAmount;
		}

		public String getIncomeDescription() {
			return incomeDescription;
		}

		public void setIncomeDescription(String incomeDescription) {
			this.incomeDescription = incomeDescription;
		}

		public IncomeSource getIncomeSource() {
			return incomeSource;
		}

		public void setIncomeSource(IncomeSource incomeSource) {
			this.incomeSource = incomeSource;
		}

		//Methods
		public String toString() {
			StringBuffer b = new StringBuffer();
			b.append("[Income] {IncomeDate : ").append(this.getIncomeDate())
			.append("  IncomeAmount: ").append(this.getIncomeAmount())
			.append("  IncomeDescription: ").append(this.getIncomeDescription())
			.append(" IncomeSource: ").append(this.getIncomeSource().getIncomeSourceName())
			.append("}");
			return b.toString();
		}

		
}
