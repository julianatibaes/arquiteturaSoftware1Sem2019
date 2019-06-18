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

import com.up.gip.entity.StrategicObjective;
import com.up.gip.repository.IStrategicObjectiveRepository;

@RestController
@RequestMapping("objective")
public class StrategicObjectiveResource {
	
	@Autowired
	private IStrategicObjectiveRepository repository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<StrategicObjective> listAll() {
		Iterable<StrategicObjective> list = repository.findAll();
		return list;
	}
	
	@PostMapping()
	public StrategicObjective add(@RequestBody @Valid StrategicObjective objective) {
		return repository.save(objective);
	}

	@DeleteMapping("/{id}")
	public StrategicObjective delete(@PathVariable String id) {
		StrategicObjective objective = repository.getOne(id);
		repository.delete(objective);
		return objective;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody StrategicObjective getById(@PathVariable String id) {
		StrategicObjective objective = repository.getOne(id);
		return objective;
	}

}
