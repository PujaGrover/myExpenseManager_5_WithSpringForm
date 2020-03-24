package com.expense_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expense_manager.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	
	@Query("select e from Expense e where year(e.expenseDate) = :selectedYear and month(e.expenseDate) = :selectedMonth")
	List<Expense> getByYearAndMonth(@Param("selectedYear") int selectedYear,@Param("selectedMonth") int selectedMonth);

}
