package com.api.galery.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

import com.api.galery.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findById(long id);

	Users deleteById(long id);

	Page<Users> findByNameContaining(String infix, Pageable pageable);

	@Query(value = "SELECT u.name,u.pass FROM Users u WHERE u.name = :name and u.pass = :pass")
	List<?> findByNameAndPassUsers(@Param("name") String name, @Param("pass") String pass);

	@Query(value = "SELECT u FROM Users u WHERE u.email = :email")
	Users findByEmail(@Param("email") String email);

	@Transactional
	@Modifying
	@Query(value = "update Users u set u.token = :token where u.email = :email")
	Integer gerarCodigo(@Param("token") String temp, @Param("email") String email);

	@Transactional
	@Modifying
	@Query(value = "update Users u set u.pass = :pass where u.email = :email")
	Integer resetPassword(@Param("pass") String pass, @Param("email") String email);

}
