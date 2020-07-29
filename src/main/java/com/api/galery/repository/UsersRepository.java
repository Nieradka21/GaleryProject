package com.api.galery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.galery.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	
	Users findById(long id);

}
