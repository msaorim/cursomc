package br.com.msaorim.cursomc.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msaorim.cursomc.entities.Estado;
import br.com.msaorim.cursomc.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public ResponseEntity<List<Estado>> findAll(){
		List<Estado> lista = estadoService.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Estado>> findById(@PathVariable long id){
		Optional<Estado> obj = estadoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
