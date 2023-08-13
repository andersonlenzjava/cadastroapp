package cadastroapp.com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cadastroapp.com.model.Pessoa;

// equivalente a uma controller 
// o acionamento dos métodos é feito na view
// arquitetura orientada a eventos
// escopos estabelecem limites relacionados ao transporte das informaçoes (statefull)
@Named("bean")
@ApplicationScoped
public class PessoaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoa pessoa;
	
	private List<Pessoa> pessoas = new ArrayList<Pessoa>(); 
	
	public String adicionar() {
		
		pessoas.add(pessoa);
		
		// limpar os campos que recebem dados após uma operação
		limpar();
		
		// naavegação por método (não estava funcionando por causa do erro de digitação 
		return "paginas/Sucesso";
	}
	
	private void limpar() {
		
		pessoa = new Pessoa();
		
	}
	
	public String editarPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		
		return "paginas/Sucesso";
	}
	
	public String editar() {
		return "paginas/sucesso";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
}
