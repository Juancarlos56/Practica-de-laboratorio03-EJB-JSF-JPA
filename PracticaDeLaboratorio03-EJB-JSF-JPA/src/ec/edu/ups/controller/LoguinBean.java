package ec.edu.ups.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class LoguinBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	public void login() {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contador", 1);
	}
	
	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contador", null);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
