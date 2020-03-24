package com.expense_manager.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expense_manager.model.UserDetail;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

	// hql query to query database table user_detail of UserDetail class binding 
	// with searchUserName method
	@Query(value = "SELECT u FROM UserDetail u where u.userName = :userName")
	public UserDetail searchUserName(@Param("userName") String userName);
	
//	@Query(value = "SELECT u FROM UserDetail u where u.userPassword = :userPassword")
//	public UserDetail searchUserPassword(@Param("userPassword") String userPassword);
}

	
