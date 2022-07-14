package br.com.msaorim.cursomc.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.msaorim.cursomc.entities.Categoria;
import br.com.msaorim.cursomc.entities.Cidade;
import br.com.msaorim.cursomc.entities.Cliente;
import br.com.msaorim.cursomc.entities.Endereco;
import br.com.msaorim.cursomc.entities.Estado;
import br.com.msaorim.cursomc.entities.Produto;
import br.com.msaorim.cursomc.entities.enums.ClienteEnum;
import br.com.msaorim.cursomc.repositories.CategoriaRepository;
import br.com.msaorim.cursomc.repositories.CidadeRepository;
import br.com.msaorim.cursomc.repositories.ClienteRepository;
import br.com.msaorim.cursomc.repositories.EnderecoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
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
		
		var cl1 = new Cliente(null, "Maria Silva", "maria@email.com", "111.222.333-44", ClienteEnum.PESSOAFISICA);
		cl1.getTelefones().addAll(Arrays.asList("1234566", "789000"));
		//var cl2 = new Cliente(null, "Lojas Americanas", "americanas@email.com", "111.222.333/0001-44", ClienteEnum.PESSOAJURIDICA);
		//var cl3 = new Cliente(null, "Ramalho dos Santos", "ra_san@email.com", "111.222.333-45", ClienteEnum.PESSOAFISICA);
		//var cl4 = new Cliente(null, "Fernanda Souza", "fe_so@email.com", "111.222.333-46", ClienteEnum.PESSOAFISICA);
		
		var e1 = new Endereco(null, "Rua das Flores", "300", "Apto 203", "Jardim", "10222000", cid1, cl1);
		var e2 = new Endereco(null, "Av Matos", "105", "Sala 800", "Centro", "38777012", cid2, cl1);
		
		cl1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		cat1.getProdutos().addAll(Arrays.asList(pd1, pd2, pd3));
		cat2.getProdutos().addAll(Arrays.asList(pd2));
		
		pd1.getCategorias().addAll(Arrays.asList(cat1));
		pd2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		pd3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(pd1, pd2, pd3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		clienteRepository.saveAll(Arrays.asList(cl1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
