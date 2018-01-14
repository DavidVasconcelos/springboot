package br.com.alura.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.listavip.models.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	
	@Autowired
	private ConvidadoRepository repository;
	
	public Iterable<Convidado> obterTodos() {		
		return repository.findAll();		
	}
	
	public Iterable<Convidado> obterPorNome(String nome) {
		return repository.findByNome(nome);
	}
	
	public void salvar(Convidado convidado) {		
		repository.save(convidado);		
	}
	
	

}
