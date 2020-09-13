package com.api.galery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.galery.model.Users;

/*@NamedQueries({
		@NamedQuery(name = "UsersRepository.findByNameAndPass", 
				query = "SELECT name,pass FROM Users WHERE name = :name and pass = :pass") })*/

public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findById(long id);

	Users deleteById(long id);

	Page<Users> findByNameContaining(String infix, Pageable pageable);

	@Query(value = "SELECT u.name,u.pass FROM Users u WHERE u.name = :name and u.pass = :pass")
	List<?> findByNameAndPassUsers(@Param("name") String name, @Param("pass") String pass);

	@Query(value = "SELECT u FROM Users u WHERE u.email = :email")
	Users findByName(@Param("email") String email);

}
