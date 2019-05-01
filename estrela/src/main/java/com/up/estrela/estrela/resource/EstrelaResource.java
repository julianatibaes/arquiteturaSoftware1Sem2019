package com.up.estrela.estrela.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.up.estrela.estrela.entity.Estrela;
import com.up.estrela.estrela.repository.EstrelaRepository;


@RestController
@RequestMapping("/estrela")
public class EstrelaResource {

	@Autowired
	private EstrelaRepository repository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Estrela> listaAmigos() {
		Iterable<Estrela> listaAmigos = repository.findAll();
		return listaAmigos;
	}
	
	@PostMapping()
	public Estrela cadastraEstrela(@RequestBody @Valid Estrela estrela) {
		return repository.save(estrela);
	}
	
	@DeleteMapping()
	public Estrela deletaAmigo(@RequestBody Estrela estrela) {
		repository.delete(estrela);
		return estrela;
	}
	
}
