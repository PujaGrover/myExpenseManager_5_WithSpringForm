package com.expense_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense_manager.model.Role;
import com.expense_manager.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repo;
	
	public List<Role> listAll(){
		return repo.findAll();
	}
	
	public void save(Role role) {
		repo.save(role);
	}
	
	
	public Role get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}

}
