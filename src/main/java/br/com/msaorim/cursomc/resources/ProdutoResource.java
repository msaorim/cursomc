package br.com.msaorim.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msaorim.cursomc.entities.Produto;
import br.com.msaorim.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> lista = produtoService.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable long id){
		Produto obj = produtoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//@GetMapping(value = "/{id}")
	//public ResponseEntity<Optional<Produto>> findById(@PathVariable long id){
	//	Optional<Produto> obj = produtoService.findById(id);
	//	return ResponseEntity.ok().body(obj);
	//}
}
