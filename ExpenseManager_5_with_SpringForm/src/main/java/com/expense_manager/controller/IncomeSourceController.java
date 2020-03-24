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
import com.expense_manager.model.IncomeSource;
import com.expense_manager.service.IncomeSourceService;

@Controller
public class IncomeSourceController {
	
	@Autowired
	private IncomeSourceService incomeSourceService;
	
	//INCOMESOURCE FORM
	@GetMapping("/incomeSource")
	public String showIncomeSourceForm(Model model) {
		model.addAttribute("newIncomeSource", new IncomeSource());
		List<IncomeSource> incomeSourceList = incomeSourceService.listAll();
		if(incomeSourceList != null) {
			System.out.println("incomeSourceList is not null. Printing the List.");
			for (IncomeSource is : incomeSourceList) {
				System.out.println(is.toString());
			}
		} else {
			System.out.println("IncomeSource List is empty");
		}
		model.addAttribute("incomeSourceList", incomeSourceList);
		//Return IncomeSource.jsp Page
		return "IncomeSource";
	}
	
	//VALIDATE?SAVE?GET ALL SOURCES: INCOMESOURCE FORM
	@PostMapping("/saveIncomeSource")
	public String saveIncomeSourceForm(
			@Valid @ModelAttribute("newIncomeSource") IncomeSource newIncomeSource
			, Model model, BindingResult bindingResult) {
		System.out.println("Inside saveIncomeSourceForm Controller");
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Result has errors!!");
			return "IncomeSource";
		}
		
		//save incomeSource to the database
		incomeSourceService.save(newIncomeSource);
		System.out.println(newIncomeSource.toString());
		
		//Getting List of all entries from database from IncomeSource
		//and passing it to the view
//		List<IncomeSource> incomeSourceList = incomeSourceService.listAll();
//		if(incomeSourceList != null) {
//			System.out.println("incomeSourceList is not null. Printing the List.");
//			for (IncomeSource is : incomeSourceList) {
//				System.out.println(is.toString());
//			}
//		} else {
//			System.out.println("IncomeSource List is empty");
//		}
//		model.addAttribute("incomeSourceList", incomeSourceList);
		model.addAttribute("message", "New Income Source is added to the existing list.");
		
		System.out.println("New Income Source is added to the existing list.");
		//Return IncomeSource.jsp
		return "redirect:/incomeSource";
		
	}
	

}
