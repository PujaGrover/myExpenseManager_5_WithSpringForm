package com.expense_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense_manager.model.Expense;
import com.expense_manager.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	// Get the list of all Expense objects from expense table in Database
	public List<Expense> listAll() {
		return expenseRepository.findAll();
	}
	
	//save expense object in the database
	public void save(Expense expense) {
		expenseRepository.save(expense);
	}

	// To take care of exception incase we didn't find the expense object
	// : UDEMY: Spring Boot: Creating Spring Data Jpa Repository
	public Expense get(int id) {
		Optional<Expense> result = expenseRepository.findById(id);
		Expense expense = null;

		if (result.isPresent()) {
			expense = result.get();
		} else {
			// if we didn't find expense with the given id
			throw new RuntimeException("Did not find expense with id: " + id);
		}
		return expense;
	}

	// delete expense object with given id from the database
	public void delete(int id) {
		expenseRepository.deleteById(id);
	}
	
	public List<Expense> getByYearAndMonth( int year, int month){
		List<Expense> allExpensesByYearAndMonth = expenseRepository.getByYearAndMonth( year, month);
		return allExpensesByYearAndMonth;
	}

}
