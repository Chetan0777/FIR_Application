package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.masai.model.UserLogin;
@Repository
public interface UserLoginRepo extends JpaRepository<UserLogin, Integer> {
	public UserLogin findByKey(String key);
}
