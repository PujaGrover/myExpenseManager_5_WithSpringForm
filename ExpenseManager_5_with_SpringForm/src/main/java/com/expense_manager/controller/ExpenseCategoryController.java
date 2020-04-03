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
import com.expense_manager.model.ExpenseCategory;
import com.expense_manager.service.ExpenseCategoryService;

@Controller
public class ExpenseCategoryController {

	@Autowired
	private ExpenseCategoryService expenseCategoryService;

	// EXPENSECATEGORY FORM & LIST OF EXISTING CATEGORIES
	@GetMapping("/expenseCategory")
	public String showExpenseCategoryForm(Model model) {
		model.addAttribute("newExpenseCategory", new ExpenseCategory());
		
		List<ExpenseCategory> expenseCategoryList = expenseCategoryService.listAll();
		if (expenseCategoryList != null) {
			System.out.println("expenseCategoryList is not null. Printing the List.");
			for (ExpenseCategory ec : expenseCategoryList) {
				System.out.println(ec.toString());
			}
		} else {
			System.out.println("ExpenseCategory List is empty");
		}
		model.addAttribute("expenseCategoryList", expenseCategoryList);
		// Return ExpenseCategory.jsp page
		return "ExpenseCategory";
	}

	// SAVE EXPENSECATEGORY FORM
	@PostMapping("/saveExpenseCategory")
	public String saveExpenseCategoryForm(
			@Valid @ModelAttribute("newExpenseCategory") ExpenseCategory newExpenseCategory
			, Model model, BindingResult bindingResult) {
		System.out.println("Inside saveExpenseCategory Controller");
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Result has errors!!");
			return "ExpenseCategory";
		}

		// save expenseCategory to the database
		expenseCategoryService.save(newExpenseCategory);
		System.out.println(newExpenseCategory.toString());

		//model.addAttribute("message", "New Expense Category is added to the existing list.");
		System.out.println("New Expense Category is added to the existing list.");
		// return back ExpenseCategory.jsp
		return "redirect:/expenseCategory";
		
	}

	// ABOVE METHOD IS SAME AS THIS ONE(INSTEAD OF MODELANDVIEW, MODEL OBJECT IS
	// USED)
	// VALIDATE/SAVE/GET ALL CATEGORIES: EXPENSECATEGORY FORM
//	@PostMapping("/saveExpenseCategory")
//	public ModelAndView saveExpenseCategoryForm(
//			@Valid @ModelAttribute("newExpenseCategory") ExpenseCategory newExpenseCategory,
//			BindingResult bindingResult) {
//		System.out.println("Inside saveExpenseCategoryController");
//		ModelAndView mav = new ModelAndView("ExpenseCategory");
//		if (bindingResult.hasErrors()) {
//			System.out.println("Binding Result has errors!!");
//			return mav;
//		}
//
//		// save expenseCategory to the database
//		expenseCategoryService.save(newExpenseCategory);
//		System.out.println(newExpenseCategory.toString());
//
//		// Getting List of all entries from database from ExpenseCategory Class and
//		// passing it to the view
//
//		List<ExpenseCategory> expenseCategoryList = expenseCategoryService.listAll();
//		if (expenseCategoryList != null) {
//			System.out.println("expCategoryList is not null. Printing the List.");
//			for (ExpenseCategory ec : expenseCategoryList) {
//				System.out.println(ec.toString());
//			}
//		} else {
//			System.out.println("expenseCategoryList is empty");
//		}
//		mav.addObject("expenseCategoryList", expenseCategoryList);
//
//		mav.addObject("Added expenseCategoryList to the ModelAndView Object");
//
//		// return back ModelAndViewObject
//		return mav;
//	}


}
