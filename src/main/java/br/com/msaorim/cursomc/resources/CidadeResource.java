package br.com.msaorim.cursomc.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msaorim.cursomc.entities.Cidade;
import br.com.msaorim.cursomc.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public ResponseEntity<List<Cidade>> findAll(){
		List<Cidade> lista = cidadeService.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Cidade>> findById(@PathVariable long id){
		Optional<Cidade> obj = cidadeService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
