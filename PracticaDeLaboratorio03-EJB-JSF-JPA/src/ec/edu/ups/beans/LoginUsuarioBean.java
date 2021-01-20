package ec.edu.ups.beans;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.EJB.PersonaFacade;
import ec.edu.ups.EJB.UserFacade;
import ec.edu.ups.controller.LoguinBean;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entities.User;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class LoginUsuarioBean {

	private String username;
    private String contrasena;
    @EJB
	private PersonaFacade ejbPersona;
    
    public LoginUsuarioBean() {
        // TODO Auto-generated constructor stub
    }
    
	public String iniciarSecion() {
		
		System.out.println("Username: " + username+" Password: " + contrasena );
		
		Persona sta = ejbPersona.inicioSesion(username, contrasena);
		LoguinBean loguinBean=new LoguinBean();
		
		if (sta != null && sta.getRol() == 'A') {
			loguinBean.login();
			return "inicioAdmin";
		}else if (sta != null) {
			loguinBean.login();
			return "inicioUsuario";
		}
		
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
