package com.expense_manager.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.expense_manager.model.Role;
import com.expense_manager.model.UserDetail;
import com.expense_manager.service.RoleService;
import com.expense_manager.service.UserDetailService;

@Controller
public class HomeController {
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private RoleService roleService;
	
	//LOGIN
	@GetMapping("/")
	public String showLoginPage() {
		//return Login.html page
		return "Login";
	}
	
	//VALIDATE LOGIN
	@PostMapping("/validateLogin")
	public String validateLoginForm(@RequestParam("userName") String userName,
									@RequestParam("userPassword") String userPassword,
									Model model, HttpSession session) {
		
		UserDetail userDetailFromDb = userDetailService.searchUserName(userName);
		
		if(userDetailFromDb != null) {
			System.out.println(userDetailFromDb.toString());
			//Validating userDetailFromDb userPassword with userPassword passed by user in login
			if(userPassword.equals(userDetailFromDb.getUserPassword())){
				
				//USING TO ASSIGN FIRST ADMIN (HARDCODED FOR TESTING)
//				if(userName.equals("sanjay") && userPassword.equals("sanjaygrover")) {
//					
//					//SAVE & SET ROLE ONLY WHEN THE PROGRAM RUNS FIRST TIME
//					Role roleAdmin = new Role(1, "admin", "complete");
//					userDetailFromDb.setRole(roleAdmin);
//					userDetailService.save(userDetailFromDb);
//					
//					//Set the session object with currentUser
//					session.setAttribute("currentUser", userDetailFromDb);
//					
//					//Printing Result for testing
//					System.out.println(userDetailFromDb.toString());
//					System.out.println("Credentials Match with Admin");
//					//Return Congigure.jsp after successful Login as Admin
//					return "redirect:/configure";
//				}
				//Set the session object with currentUser
				session.setAttribute("currentUser", userDetailFromDb);
			
				//Printing Result for testing
				System.out.println("Passwords Match");
				
				//Return HomePage.jsp after successful Login
				return "redirect:/homePage";
			}
			//Printing Result for testing
			System.out.println("Passwords do not match");
			
			//add error to the model object and display it in the view
			model.addAttribute("errorMessage", "Invalid Credentials");
			
			//return login.jsp page
			return "Login";	
			
		}else {
			//add error to the model object and display it in the view
			model.addAttribute("errorMessage", "Username does not exist! Please SignUp as new user.");
			
			//return login.jsp page
			return "Login";	
			
		}
		
	}	
	
	//HOMEPAGE
	@GetMapping("/homePage")
	public String showHomePage() {
		//return HomePage.html page
		return "HomePage";
	}
	
	//SIGNUP OR REGISTER
	@GetMapping("/signUp")
	public String showSignUpForm(Model model) {
		
		model.addAttribute("newUserDetail", new UserDetail());
		//return SignUp.html page
		return "SignUp";
	}
	
	//VALIDATE AND SAVE USER FILLING SIGNUP FORM TO DATABASE
	@PostMapping("/saveSignUp")
	public String saveSignUpForm(@Valid @ModelAttribute("newUserDetail") UserDetail newUserDetail
								, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "SignUp";
		}
		
		//If the username and email already exist then request user to login
		System.out.println("Checking if the user already is registered");
		List<UserDetail> userDetailList = userDetailService.listAll();
		boolean userExists = false;
		for(UserDetail u : userDetailList) {
			if(u.getUserName().equals(newUserDetail.getUserName()) && u.getUserEmail().equals(newUserDetail.getUserEmail())) {
				userExists = true;
				System.out.println("Username and email already exist.");
				model.addAttribute("errorMessage", "Username and email is already registered. Please go to Login");
				return "SignUp";
			}else if(u.getUserName().equals(newUserDetail.getUserName()) || u.getUserEmail().equals(newUserDetail.getUserEmail())){
				userExists = true;
				System.out.println("Username or email already exist.");
				model.addAttribute("errorMessage", "Username or email is already registered. Please sign up with different credentials or go to Login");
				return "SignUp";
			}	
		}
		
		//If the username and email do not exist then save the user and return login page(login.jsp)
		if(!userExists) {
			Role roleUser = new Role();
			Role roleAdmin = new Role();
			
			roleUser.setRoleID(2);
			roleUser.setRoleName("user");
			roleUser.setAccessLevel("basic");
			newUserDetail.setRole(roleUser);
			roleService.save(roleUser);
			
			roleAdmin.setRoleID(1);
			roleAdmin.setRoleName("admin");
			roleAdmin.setAccessLevel("complete");
			roleService.save(roleAdmin);
			
			
			userDetailService.save(newUserDetail);
			System.out.println("User Created and saved to the database");
			System.out.println(newUserDetail.toString());
		}	
		//return Login.html page mapping is done by ("/") in HomeController i.e.this controller
		return "redirect:/";
	}
	
	
	//DESIGNED FOR ADMIN USAGE ONLY
	@GetMapping("/configure")
	public String showConfigurePage() {
		//return Configure.html page
		return "Configure";
	}
	
	//LOGOUT: USER SESSION ENDS
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:/";

	}	
	//ABOUT
	@GetMapping("/about")
	public String showAboutPage() {
		//return About.jsp
		return "About";
	}

}
