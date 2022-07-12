package br.com.msaorim.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msaorim.cursomc.entities.Categoria;
import br.com.msaorim.cursomc.repositories.CategoriaRepository;
import br.com.msaorim.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria findById(long id){
		Optional<Categoria> obj = categoriaRepository.findById(id);
		//return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!!! Id: " + id + ", tipo: " + Categoria.class.getName()));
	}
	
}
