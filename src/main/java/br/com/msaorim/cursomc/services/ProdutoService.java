package br.com.msaorim.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msaorim.cursomc.entities.Categoria;
import br.com.msaorim.cursomc.entities.Produto;
import br.com.msaorim.cursomc.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	public Produto findById(Long id){
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElse(null);
	}
	
	//public Categoria findById(long id){
	//	Optional<Categoria> obj = categoriaRepository.findById(id);
	//	return obj.orElse(null);
	
	
	//public Optional<Produto> findById(long id){
	//	return produtoRepository.findById(id);
	//}
}
