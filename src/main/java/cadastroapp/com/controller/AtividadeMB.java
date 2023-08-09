package cadastroapp.com.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cadastroapp.com.model.Atividade;
import cadastroapp.com.model.TipoAtividade;

@Named("atividadeMB")
@SessionScoped
public class AtividadeMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Atividade atividade;
	
	public TipoAtividade[] getAtividades() {
		return TipoAtividade.values();
	}
	
	public Atividade getAtividade() {
		return atividade;
	}
	
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
}
