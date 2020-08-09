package com.api.galery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.galery.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findById(long id);

	Users deleteById(long id);

	@Query(value = "SELECT u.name,u.pass FROM Users u WHERE u.name = :names and u.pass = :passw")
	Users findByNameAndPass(@Param("names") String name, @Param("passw") String pass);

	@Query(value = "SELECT u.pass FROM Users u WHERE u.pass = :passw")
	Users findByPass(@Param("passw") String pass);

}
