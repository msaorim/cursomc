package br.com.msaorim.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msaorim.cursomc.entities.Estado;
import br.com.msaorim.cursomc.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> findAll(){
		return estadoRepository.findAll();
	}
	
	public Optional<Estado> findById(long id){
		return estadoRepository.findById(id);
	}
}
