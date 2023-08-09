package br.com.medicamento.utility;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("")
@ViewScoped
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static void info(String text) {
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, text, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	

	public static void erro(String text) {
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, text, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

public static void warn(String text) {
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, text, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
