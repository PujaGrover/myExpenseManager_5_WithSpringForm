package com.expense_manager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.expense_manager.model.Income;
import com.expense_manager.model.IncomeSource;
import com.expense_manager.service.IncomeService;
import com.expense_manager.service.IncomeSourceService;

@Controller
public class IncomeController {

	@Autowired
	private IncomeService incomeService;

	@Autowired
	private IncomeSourceService incomeSourceService;

	// INCOME PAGE
	@GetMapping("/income")
	public String showIncomeForm(Model model) {
		List<IncomeSource> incomeSources = incomeSourceService.listAll();
		model.addAttribute("incomeSources", incomeSources);
		model.addAttribute("newIncome", new Income());

		// Return Income.jsp Page
		return "Income";
	}

	// SAVE INCOME
	@PostMapping("/saveIncome")
	public String saveIncomeForm(@Valid @ModelAttribute("newIncome") Income newIncome, BindingResult bindingResult,
			Model model) {

		// Testing: Printing on console to test if newIncome got the values
		// from the form and see if data binding works
		System.out.println("Inside saveIncomeForm() method");
		System.out.println(newIncome.toString());

		// Test for errors if data binding has errors
		if (bindingResult.hasErrors()) {
			return "redirect:/income";
		}

		// Save newIncome to the database
		incomeService.save(newIncome);

		// Testing: Printing on console to test the newIncome got saved
		System.out.println("Saving the Income detail");
		System.out.println(newIncome.toString());

		// Sending message to the view that the Income detail got saved
		model.addAttribute("message",
				"Income detail saved. Add more Income or click on Home->Report to generate report");

		// Return back to the Income form page i.e. Income.jsp
		return "redirect:/income";
	}

	// SHOW INCOME REPORT
	@GetMapping("/incomeReport")
	public String showIncomeReport(Model model) {

		// Return IncomeReport.jsp Page
		return "IncomeReport";
	}
	
	// SHOW ALL EXPENSES IN GIVEN MONTH AND YEAR
	@GetMapping("/showIncomeReport")
	public String getIncomeByYearAndMonth(@Valid @RequestParam("month") String month,
			@RequestParam("year") String year, Model model) {

		System.out.println("Inside getIncomeByYearAndMonth method in IncomeController");

		int selectedMonth = Integer.parseInt(month);
		System.out.println("selectedMonth = " + selectedMonth);
		int selectedYear = Integer.parseInt(year);
		System.out.println("selectedYear = " + selectedYear);
		
		List<Income> allIncomesByYearAndMonth  = incomeService.getByYearAndMonth(selectedYear, selectedMonth);
		System.out.println(allIncomesByYearAndMonth.toString());
		model.addAttribute("allIncomesByYearAndMonth", allIncomesByYearAndMonth);
		
		//To get the sum of values we can use DoubleStream in java 8
		Double totalIncome = allIncomesByYearAndMonth.stream().map(Income::getIncomeAmount).mapToDouble(Double::doubleValue).sum();
		System.out.println("totalIncome = " + totalIncome);
		model.addAttribute("totalIncome", totalIncome);
		
		return "IncomeReport";
}
	
	// GETTING ALL INCOMES FROM DATABASE
	@GetMapping("/allIncomes")
	public String allIncomes(Model model) {
		List<Income> allIncomes = incomeService.listAll();
		model.addAttribute("allIncomes", allIncomes);

		// return //return allIncomes to IncomeReport.jsp
		return "redirect:/incomeReport";
	}



}
