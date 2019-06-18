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

import com.up.gip.entity.Project;
import com.up.gip.repository.IProjectRepository;

@RestController
@RequestMapping("project")
public class ProjectResource {
	
	@Autowired
	private IProjectRepository repository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Project> listAll() {
		Iterable<Project> list = repository.findAll();
		return list;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Project getById(@PathVariable Integer id) {
		Project project = repository.getOne(id);
		return project;
	}
	
	@PostMapping()
	public Project add(@RequestBody @Valid Project project) {
		return repository.save(project);
	}

	@DeleteMapping("/{id}")
	public Project delete(@PathVariable Integer id) {
		Project project = repository.getOne(id);
		repository.delete(project);
		return project;
	}
	
	

}
