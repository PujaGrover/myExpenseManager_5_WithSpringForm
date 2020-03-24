package com.expense_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense_manager.model.ExpenseCategory;
import com.expense_manager.repository.ExpenseCategoryRepository;

@Service
public class ExpenseCategoryService {
	
	@Autowired
	private ExpenseCategoryRepository expenseCategoryRepository;
	
	//Get list of all expenseCategory Objects
	public List<ExpenseCategory> listAll(){
		List<ExpenseCategory> allCategories = expenseCategoryRepository.findAll();
		return allCategories;
	}
	
	//save expenseCategory object in the database
	public void save(ExpenseCategory expenseCategory) {
		expenseCategoryRepository.save(expenseCategory);
	}
	
	// To take care of exception incase we didn't find the expenseCategory 
    // object: UDEMY: Spring Boot: Creating Spring Data Jpa Repository
	public ExpenseCategory get(int id) {
		Optional<ExpenseCategory> result = expenseCategoryRepository.findById(id);
		ExpenseCategory expCategory =null;
		
		if(result.isPresent()) {
			expCategory = result.get();
		}else {
			// if we didn't find expenseCategory with the given id
			throw new RuntimeException("Did not find expenseCategory with id: " + id);	
		}
		return expCategory;
	}
	
	//delete expenseCategory object with given id
	public void delete(int id) {
		expenseCategoryRepository.deleteById(id);
	}

}
