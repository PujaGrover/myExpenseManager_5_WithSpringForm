package com.expense_manager;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.expense_manager.filters.AuthenticationFilter;

/**
 * The first step in producing a deployable war file is to provide a 
 * 	SpringBootServletInitializer subclass and override its configure method.
 *  Doing so makes use of Spring Framework’s Servlet 3.0 support and lets 
 *  you configure your application when it is launched by the servlet container. 
 *
 */
@ComponentScan
@SpringBootApplication
public class ExpenseManager3Application extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ExpenseManager3Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManager3Application.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<AuthenticationFilter> authFilter(){
		FilterRegistrationBean<AuthenticationFilter> registrationBean = 
				new FilterRegistrationBean<>();
		registrationBean.setFilter(new AuthenticationFilter());
		registrationBean.setUrlPatterns(Arrays.asList(new String[] {"/homePage",
				"/about", "/configure", "/saveExpense", "/expense", "/expenseReport", "/showExpenseReport"
				, "/allExpenses", "/income", "/saveIncome", "/incomeReport", "/showIncomeReport"
				, "/allIncomes" ,"/incomeSource", "/saveIncomeSource","/expenseCategory"
				, "/saveExpenseCategory", "/adminReport", "/userRoles"}));
		
		return registrationBean;
	}

}
