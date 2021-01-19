package ec.edu.ups.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ec.edu.ups.EJB.UserFacade;
import ec.edu.ups.entities.User;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class UserBean implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -5713304986716465231L;
	@EJB
	private UserFacade ejbUserFacade;

	private String email;
	private String password;
	private String name;
	private String role;
	private String state;
	
	
    public UserBean() {
    
    }
    
 
    
    public String createUser() {
    	//System.out.println("nombre"+ name);
		try {
			User user = new User(email, password, name, role, state);
			ejbUserFacade.create(user);
			addMessage("Usuario creado!!");
			return "Success";
		} catch (Exception e) {
			return "Error";
		}
	}
    
    
    public List<User> getUserList() {
		return ejbUserFacade.findAll();
	}
    
    public String updateUser(User user) {
		try {
			user.setEmail(email);
			user.setUserName(name);
			user.setPassword(password);
			user.setRole(role);
			user.setState(state);
			ejbUserFacade.edit(user);
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
    
    
    public String deleteUser(User user) {
		try {
			user.setState("Inactivo");
			ejbUserFacade.edit(user);
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    

	public UserFacade getEjbUserFacade() {
		return ejbUserFacade;
	}

	public void setEjbUserFacade(UserFacade ejbUserFacade) {
		this.ejbUserFacade = ejbUserFacade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
}
