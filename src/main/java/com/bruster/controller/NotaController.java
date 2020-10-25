package com.bruster.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruster.ApiRestNotasApplication;
import com.bruster.model.Nota;
import com.bruster.repository.INotaRepo;


@RestController
@RequestMapping("/notas")
public class NotaController {
private static Logger LOG = LoggerFactory.getLogger(ApiRestNotasApplication.class); 
	
	@Autowired
	private INotaRepo repo;
	
	@GetMapping()
	public List<Nota> listarNotas() {
		return repo.findAll();
	}
    @GetMapping(value = "/{id}")
    public Optional<Nota> buscarNota(@PathVariable("id") Integer id) {
    	LOG.info("id mandado: " + id);
		return repo.findById(id);
	}
	@PostMapping()
	public void insertar(@RequestBody Nota nota) {
		repo.save(nota);
	}
	
	@PutMapping()
	public void actualizar(@RequestBody Nota nota) {
		repo.save(nota);
	}
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}

}
