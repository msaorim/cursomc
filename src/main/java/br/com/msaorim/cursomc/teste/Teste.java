package br.com.msaorim.cursomc.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.msaorim.cursomc.entities.Categoria;
import br.com.msaorim.cursomc.repositories.CategoriaRepository;

@Configuration
public class Teste implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		var cat1 = new Categoria(null, "Escritório");
		var cat2 = new Categoria(null, "Informática");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
