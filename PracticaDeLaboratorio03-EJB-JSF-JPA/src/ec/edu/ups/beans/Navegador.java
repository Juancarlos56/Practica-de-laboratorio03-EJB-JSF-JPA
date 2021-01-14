package ec.edu.ups.beans;
import java.io.Serializable;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class Navegador implements Serializable{
	
	
	
	
	public Navegador() {
		
	}
	
	public String redireccionar(String page) {
		
		if(page.equals("bodega1")) {
			return "bodega1jj";
		} else if(page.equals("bodega2")) {
			return "bodega2";
		}else if(page.equals("bodega3")) {
			return "bodega3";
		}else if(page.equals("usuarioEmpleado")) {
			return "usuarioEmpleado";
			
		}else if(page.equals("usuarioAdministrador")) {
			return "usuarioAdmin";
			
		}else if(page.equals("paginaPrincipal")) {
			return "paginaPrincipal";
			
		}else if(page.equals("CreacionFactura")) {
			return "creacionFactura";
			
		}else if(page.equals("ListarFactura")) {
			return "listarFactura";
			
		}else if(page.equals("CrearCliente")) {
			return "crearCliente";
			
		}else if(page.equals("ListarClientes")) {
			return "listarCliente";
		}
		
		
		return page;
		
	}
	
	public String pruebaNavegador() {
		return  "ingresa al Navegador";
	}

}
