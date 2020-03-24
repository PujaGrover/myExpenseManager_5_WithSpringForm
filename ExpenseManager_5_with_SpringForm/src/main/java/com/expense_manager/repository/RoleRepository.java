package com.expense_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.expense_manager.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
