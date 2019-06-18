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

import com.up.gip.entity.Program;
import com.up.gip.repository.IProgramRepository;



@RestController
@RequestMapping("program")
public class ProgramResource {
	
	@Autowired
	private IProgramRepository repository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Program> listAll() {
		Iterable<Program> list = repository.findAll();
		return list;
	}
	
	@PostMapping()
	public Program add(@RequestBody @Valid Program program) {
		return repository.save(program);
	}

	@DeleteMapping()
	public Program delete(@PathVariable Integer id) {
		Program program = repository.getOne(id);
		repository.delete(program);
		return program;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Program getById(@PathVariable Integer id) {
		Program program = repository.getOne(id);
		return program;
	}

}
