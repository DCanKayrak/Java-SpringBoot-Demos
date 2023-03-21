package com.dcankayrak.nortwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcankayrak.nortwind.core.entities.User;

public interface UserDao extends JpaRepository<User,Integer>{
	
	User findByEmail(String email);
}
