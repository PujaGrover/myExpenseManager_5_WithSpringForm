package com.expense_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense_manager.model.UserDetail;
import com.expense_manager.repository.UserDetailRepository;

@Service
public class UserDetailService {
	
	@Autowired
	private UserDetailRepository repo;
	
	public List<UserDetail> listAll(){
		return repo.findAll();
	}
	
	public void save(UserDetail userDetail) {
		repo.save(userDetail);
	}
	
//	public UserDetail get(int id) {
//		return repo.findById(id).get();
//	}
	
	//To take care of exception incase we didn't find the user: UDEMY: Spring Boot: Creating Spring Data Jpa Repository
	public UserDetail get(int id) {
		Optional<UserDetail> result = repo.findById(id);
		UserDetail user = null;
		
		if(result.isPresent()) {
			user = result.get();
		}else {
			//if we didn't find user with the given id
			throw new RuntimeException("Did not find iser id: " + id);
		}
		return user;
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public UserDetail searchUserName(String userName) {
		//To take care of exception incase we didn't find the user
		UserDetail user = repo.searchUserName(userName);
//		if(user != null) {
//			return user;
//		}else {
//			//if we didn't find user with the given userName
//			throw new RuntimeException("Did not find username: " + userName);
//		}
		return user;
	}
	
//	public UserDetail searchUserPassword(String userPassword) {
//		return repo.searchUserPassword(userPassword);
//	}

}
