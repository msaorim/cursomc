package br.com.msaorim.cursomc.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.msaorim.cursomc.entities.Categoria;
import br.com.msaorim.cursomc.entities.Cidade;
import br.com.msaorim.cursomc.entities.Estado;
import br.com.msaorim.cursomc.entities.Produto;
import br.com.msaorim.cursomc.repositories.CategoriaRepository;
import br.com.msaorim.cursomc.repositories.CidadeRepository;
import br.com.msaorim.cursomc.repositories.EstadoRepository;
import br.com.msaorim.cursomc.repositories.ProdutoRepository;

@Configuration
public class Teste implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		var cat1 = new Categoria(null, "Informática");
		var cat2 = new Categoria(null, "Escritório");
		
		var pd1 = new Produto(null, "Computador", 2000.0);
		var pd2 = new Produto(null, "Impressora", 800.0);
		var pd3 = new Produto(null, "Mouse", 80.0);
		
		var est1 = new Estado(null, "MG");
		var est2 = new Estado(null, "SP");
		
		var cid1 = new Cidade(null, "Uberlândia", est1);
		var cid2 = new Cidade(null, "São Paulo", est2);
		var cid3 = new Cidade(null, "Campinas", est2);
		
		cat1.setProdutos(Arrays.asList(pd1, pd2, pd3));
		cat2.setProdutos(Arrays.asList(pd2));
		
		pd1.setCategorias(Arrays.asList(cat1));
		pd2.setCategorias(Arrays.asList(cat1, cat2));
		pd3.setCategorias(Arrays.asList(cat1));
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(pd1, pd2, pd3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
	}

}
