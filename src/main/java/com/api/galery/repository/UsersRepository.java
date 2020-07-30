package com.api.galery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.galery.model.Users;

public interface UsersRepository  extends  JpaRepository<Users, Long>{
	
	Users findById(long id);
	
	@Query(value = "SELECT u FROM Users u WHERE u.name IN :names")
	Users findByName(@Param("names")String name); 

}


