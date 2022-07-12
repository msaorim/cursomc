package br.com.msaorim.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msaorim.cursomc.entities.Cidade;
import br.com.msaorim.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> findAll(){
		return cidadeRepository.findAll();
	}
	
	public Optional<Cidade> findById(long id){
		return cidadeRepository.findById(id);
	}
}
