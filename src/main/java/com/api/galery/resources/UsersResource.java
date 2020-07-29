package com.api.galery.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.galery.model.Users;
import com.api.galery.repository.UsersRepository;


@RestController
@RequestMapping(value = "galery")


public class UsersResource {

	@Autowired
	UsersRepository usersRepository;
	@GetMapping("/users")
	public List<Users> listaDeUsuarios(){
		
		return usersRepository.findAll();
	}
}
