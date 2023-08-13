package br.com.medicamento.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.medicamento.model.Medicamento;
import br.com.medicamento.service.MedicamentoService;
import br.com.medicamento.utility.Message;
import br.com.medicamento.utility.NegocioException;

@Named
@SessionScoped
public class MedicamentoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Medicamento medicamento;

	@Inject
	private MedicamentoService service;

	private List<Medicamento> medicamentos;

	// acionado assim que a classe é criada 
	@PostConstruct
	public void carregar() {
		medicamentos = service.todosOsMedicamentos();

	}

	// adicionar/ salvar 
	public void adicionar() {
		try {
			service.salvar(medicamento);
			medicamento = new Medicamento();
			carregar();

			Message.info("Salvo com sucesso");
		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}
	

	public void excluir() {
		try {
			service.remover(medicamento);
			carregar();
			medicamento = new Medicamento();
			Message.info(medicamento.getNome() + " foi removido");

		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}
	

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

}
