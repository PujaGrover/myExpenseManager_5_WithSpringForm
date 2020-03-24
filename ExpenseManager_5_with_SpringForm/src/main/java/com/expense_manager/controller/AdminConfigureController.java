package com.expense_manager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.expense_manager.model.UserDetail;
import com.expense_manager.service.UserDetailService;

@Controller
public class AdminConfigureController {
	
	@Autowired
	private UserDetailService userDetailService;
	
	//USER ROLES PAGE
	@GetMapping("/userRoles")
	public String showUserRolesPage(Model model) {
		List<UserDetail> userDetailList = userDetailService.listAll();
		model.addAttribute("userDetailList", userDetailList);
		//return UserRoles.jsp
		return "UserRoles";
	}
	
//	//ASSIGN USER ROLES
//	@PostMapping("/assignUserRoles")

	//ADMIN REPORT PAGE
	@GetMapping("/adminReport")
	public String showAdminReportPage(Model model) {
		//return AdminReport.jsp
		return "AdminReport";
	}
	
//	//REPORT: USER EXPENSE ON EACH CATEGORY
//	@GetMapping("/showAdminReport")
//	public String getUserExpenseByYearAndMonth(@Valid @RequestParam("month") String month,
//			@RequestParam("year") String year, Model model) {
//
//		System.out.println("Inside getUserExpenseByYearAndMonth method in AdminConfigureController");
//
//		int selectedMonth = Integer.parseInt(month);
//		System.out.println("selectedMonth = " + selectedMonth);
//		int selectedYear = Integer.parseInt(year);
//		System.out.println("selectedYear = " + selectedYear);
//		
//		return null;
//		
//	}

	
	
}
