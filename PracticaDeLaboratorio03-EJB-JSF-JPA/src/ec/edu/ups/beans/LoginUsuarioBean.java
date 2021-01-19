package ec.edu.ups.beans;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.EJB.UserFacade;
import ec.edu.ups.controller.LoguinBean;
import ec.edu.ups.entities.User;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class LoginUsuarioBean {

	private String username;
    private String contrasena;
    
    @EJB
    private UserFacade ejbUser;
    
    public LoginUsuarioBean() {
        // TODO Auto-generated constructor stub
    }
    
	public String iniciarSecion() {
		
		System.out.println("Username: " + username+" Password: " + contrasena );
		User usuario = ejbUser.buscarUsuario(username, contrasena);
		LoguinBean loguinBean=new LoguinBean();
		
		if (usuario != null && usuario.getState().equals("Activo")) {
			if (usuario != null && usuario.getRole().equals("Admin")) {
				loguinBean.login();
				return "inicioAdmin";
			}else if (usuario != null) {
				loguinBean.login();
				return "inicioUsuario";
			}
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

	public UserFacade getEjbUser() {
		return ejbUser;
	}

	public void setEjbUser(UserFacade ejbUser) {
		this.ejbUser = ejbUser;
	}
    

}
