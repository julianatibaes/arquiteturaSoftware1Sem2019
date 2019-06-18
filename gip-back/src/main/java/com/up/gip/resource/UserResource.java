package com.up.gip.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.up.gip.entity.User;
import com.up.gip.repository.IUserRepository;

@RestController
@RequestMapping("login")
public class UserResource {
	
	@Autowired
	private IUserRepository repository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<User> listAll() {
		Iterable<User> list = repository.findAll();
		return list;
	}
	
	@PostMapping()
	public User add(@RequestBody @Valid User user) {
		return repository.save(user);
	}

	@DeleteMapping("/{id}")
	public User delete(@PathVariable Integer id) {
		User user = repository.getOne(id);
		repository.delete(user);
		return user;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody User getById(@PathVariable Integer id) {
		User user = repository.getOne(id);
		return user;
	}
}
