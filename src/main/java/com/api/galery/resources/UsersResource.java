package com.api.galery.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import javax.validation.Valid;

import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import com.api.galery.model.Users;
import com.api.galery.repository.UsersRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/galery")

public class UsersResource {

	@Autowired
	UsersRepository usersRepository;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@GetMapping("/users")
	public Page<Users> listaDeUsuarios(Pageable pageable) {
		return usersRepository.findAll(pageable);
	}

	@GetMapping("/users/{name}")
	public Page<Users> buscarUsuario(@PathVariable(value = "name") String name, Pageable pageable) {
		return usersRepository.findByNameContaining(name, pageable);
	}

	@PostMapping("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public Users cadastrarUsuario(@RequestBody @Valid Users users) {
		users.setPass(bCryptPasswordEncoder().encode(users.getPass()));
		return usersRepository.save(users);
	}

	@PutMapping("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public Users editarUsuario(@RequestBody @Valid Users users) {
		return usersRepository.save(users);
	}

	@DeleteMapping("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Users deletarUsuario(@PathVariable(value = "id") long id) {
		return usersRepository.deleteById(id);
	}

	@GetMapping("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Users loginAutenticar(@RequestBody Users users) {

		return usersRepository.findByName(users.getName());
	}

}
