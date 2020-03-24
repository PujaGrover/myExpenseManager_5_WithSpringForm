package com.expense_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.expense_manager.model.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {

	@Query("select i from Income i where year(i.incomeDate) = :selectedYear and month(i.incomeDate) = :selectedMonth")
	List<Income> getByYearAndMonth(@Param("selectedYear") int selectedYear, @Param("selectedMonth") int selectedMonth);
			
}
