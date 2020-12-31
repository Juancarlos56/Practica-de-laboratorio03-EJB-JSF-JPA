package ec.edu.ups.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

//Activates CDI build-in beans
@FacesConfig(version = FacesConfig.Version.JSF_2_3)

@Named("HolaDesdeJSF")
@RequestScoped
public class HolaJSF  implements Serializable {
	private static final long serialVersionUID = 1L;
    private String saludo = "Hola desde JSF 2.3";       
    
    public String getSaludo() {
	return saludo;
    }
}
