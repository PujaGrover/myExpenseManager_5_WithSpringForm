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

import com.expense_manager.model.Expense;
import com.expense_manager.model.ExpenseCategory;
import com.expense_manager.service.ExpenseCategoryService;
import com.expense_manager.service.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private ExpenseCategoryService expenseCategoryService;

	// EXPENSE PAGE
	@GetMapping("/expense")
	public String showExpenseForm(Model model) {
		List<ExpenseCategory> expenseCategories = expenseCategoryService.listAll();
		model.addAttribute("expenseCategories", expenseCategories);
		model.addAttribute("newExpense", new Expense());

		// Return Expense.jsp Page
		return "Expense";
	}

	// SAVE EXPENSE
	@PostMapping("/saveExpense")
	public String saveExpenseForm(@Valid @ModelAttribute("newExpense") Expense newExpense, BindingResult bindingResult,
			Model model) {

		// Printing on console to test if newExpense got the values
		// from the form and see if data binding works
		System.out.println("Inside saveExpenseForm() method");
		System.out.println(newExpense.toString());

		// Test for errors if data binding has errors
		if (bindingResult.hasErrors()) {
			return "redirect:/expense";
		}

		// save expense to the database
		expenseService.save(newExpense);

		// Printing on console to test the newExpense got saved
		System.out.println("Saving the Expense detail");
		System.out.println(newExpense.toString());

		// Sending message to the view that the Expense detail got saved
		model.addAttribute("message",
				"Expense detail saved. Add more expenses or click on Home->Report to generate report");

		// Return back to the expense form page i.e. Expense.jsp
		return "redirect:/expense";
	}

	// SHOW EXPENSE REPORT PAGE
	@GetMapping("/expenseReport")
	public String showExpenseReport(Model model) {

		// return ExpenseReport.jsp Page
		return "ExpenseReport";
	}

	// SHOW ALL EXPENSES IN GIVEN MONTH AND YEAR
	@GetMapping("/showExpenseReport")
	public String getExpenseByYearAndMonth(@Valid @RequestParam("month") String month,
			@RequestParam("year") String year, Model model) {

		System.out.println("Inside getExpenseByYearAndMonth method in ExpenseController");

		int selectedMonth = Integer.parseInt(month);
		System.out.println("selectedMonth = " + selectedMonth);
		int selectedYear = Integer.parseInt(year);
		System.out.println("selectedYear = " + selectedYear);
		List<Expense> allExpensesByYearAndMonth = expenseService.getByYearAndMonth(selectedYear, selectedMonth);
		System.out.println(allExpensesByYearAndMonth.toString());
		model.addAttribute("allExpensesByYearAndMonth", allExpensesByYearAndMonth);

		//To get the sum of values we can use DoubleStream in java 8
		Double totalExpense = allExpensesByYearAndMonth.stream().map(Expense::getExpenseAmount).mapToDouble(Double::doubleValue).sum();
		System.out.println("totalExpense = " + totalExpense);
		model.addAttribute("totalExpense", totalExpense);
		return "ExpenseReport";
	}

	// GETTING ALL EXPENSES FROM DATABASE
	@GetMapping("/allExpenses")
	public String allExpenses(Model model) {
		List<Expense> allExpenses = expenseService.listAll();
		model.addAttribute("allExpenses", allExpenses);

		// return allExpenses to ExpenseReport.jsp
		return "redirect:/expenseReport";
	}

}
