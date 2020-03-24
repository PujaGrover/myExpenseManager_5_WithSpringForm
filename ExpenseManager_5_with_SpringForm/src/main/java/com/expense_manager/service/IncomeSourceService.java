package com.expense_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense_manager.model.IncomeSource;
import com.expense_manager.repository.IncomeSourceRepository;

@Service
public class IncomeSourceService {
	
	@Autowired
	private IncomeSourceRepository incomeSourceRepository;
	
	//Get list of all incomeSource Objects
	public List<IncomeSource> listAll(){
		List<IncomeSource> allSources = incomeSourceRepository.findAll();
		return allSources;
	}
	
	//Save incomeSource object in the database
	public void save(IncomeSource incomeSource) {
		incomeSourceRepository.save(incomeSource);
	}
	
	// To take care of exception in-case we didn't find the incomeSource 
    // object: UDEMY: Spring Boot: Creating Spring Data Jpa Repository
	public IncomeSource get(int id) {
		Optional<IncomeSource> result = incomeSourceRepository.findById(id);
		IncomeSource incomeSource = null;
		
		if(result.isPresent()) {
			incomeSource = result.get();
		}else {
			// if we didn't find incomeSource with the given id
			throw new RuntimeException("Did not find incomeSource with id: " + id);
		}
		return incomeSource;
	}
	
	//Delete incomeSource object with given id
		public void delete(int id) {
			incomeSourceRepository.deleteById(id);
		}

}
