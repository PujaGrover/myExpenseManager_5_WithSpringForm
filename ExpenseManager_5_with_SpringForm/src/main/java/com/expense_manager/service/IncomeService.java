package com.expense_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.expense_manager.model.Income;
import com.expense_manager.repository.IncomeRepository;

@Service
public class IncomeService {

	@Autowired
	private IncomeRepository incomeRepository;

	// Get the list of all Income objects from expense table in Database
	public List<Income> listAll() {
			List<Income> allIncomes = incomeRepository.findAll();
			return allIncomes;
		}

	// save income object in the database
	public void save(Income income) {
		incomeRepository.save(income);
	}

	// To take care of exception incase we didn't find the income object
	// : UDEMY: Spring Boot: Creating Spring Data Jpa Repository
	public Income get(int id) {
		Optional<Income> result = incomeRepository.findById(id);
		Income income = null;

		if (result.isPresent()) {
			income = result.get();
		} else {
			// if we didn't find income with the given id
			throw new RuntimeException("Did not find income with id: " + id);
		}
		return income;
	}

	// delete income object with given id from the database
	public void delete(int id) {
		incomeRepository.deleteById(id);
	}
	
	//Get List o all incomes in given year and a month
	public List<Income> getByYearAndMonth( int year, int month){
		List<Income> allIncomesByYearAndMonth = incomeRepository.getByYearAndMonth(year, month);
		return allIncomesByYearAndMonth;
	}

}
