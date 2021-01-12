package ec.edu.ups.beans;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;


@Named
@RequestScoped
public class Navegador {
	
	public Navegador() {
		
	}
	
	public String redireccionar(String page) {
		
		if(page.equals("Bodega1")) {
			return "Bodega1";
		} else if(page.equals("Bodega2")) {
			return "Bodega2";
		}else if(page.equals("Bodega3")) {
			return "Bodega3";
		}else if(page.equals("usuarioEmpleado")) {
			return "usuarioEmpleado";
		}
		
		
		return page;
		
	}

}
