package ec.edu.ups.controller;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ec.edu.ups.EJB.CategoriaFacade;
import ec.edu.ups.EJB.PersonaFacade;
import ec.edu.ups.EJB.ProductoFacade;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class CategoriaBean implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String[] list;
    private String categoria;
    
    private String text = "";
    
    
    private String usuario;
    
    private String contrasena;
    
    private ArrayList<Producto> listaArr ;
    
    private String lista = "nada aqui";

    private List<Producto> productos;
	
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	private List<Categoria> categorias;
	
	@EJB
	private CategoriaFacade ejbCategoria;
	
	@EJB
	private ProductoFacade ejbProducto;
	
	@EJB
	private PersonaFacade ejbPersona;
	
	public CategoriaBean() {
		
	}
	
	@PostConstruct
	public void init(){
		productos=ejbProducto.findAll();
		categorias=ejbCategoria.findAll();
		getTodos();
	}
	

	private String[] generateList(String pre, int size) {
    	list = new String[size];
	list[0] = "Todas";

	for (int i = 1; i < size; i++)
	    list[i] = pre +  categorias.get(i).getNombre();

	return list;
    }

    
    
    public String[] getcategoriaList() {
	return this.generateList("",  categorias.size());
    }

	public String getCategoria() {
		System.out.println(categoria);
		return categoria;
		
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;

		//Aqui se carga la categoria 
		
		
		//this.bntBusc = this.categoria.equals("Categorias");
	
	}
	public String getlista() {
		return lista;
	}
	public void setlista(String productosT) {
		this.lista = productosT;
	}
	public void listener() {
		System.out.println("Texto de busqueda: " + text);
        System.out.println("Seleccionada : " + categoria);
        ArrayList<Producto> stosTemp = new ArrayList<Producto>();        
        if(categoria.equals("Todas")) {
    		for (Producto producto : listaArr) {
    			if (producto.getNombre().toLowerCase().contains(text.toLowerCase())) {
    				stosTemp.add(producto);
    			}
    		}
    	}else {
	        for (int i = 0; i < listaArr.size()-1; i++) {
	        	if (listaArr.get(i).getCategoria().getNombre().equals(categoria) && listaArr.get(i).getNombre().toLowerCase().contains(text.toLowerCase())) {

		       		System.out.println("Prod Actual: "+listaArr.get(i).getNombre());
		       		stosTemp.add(listaArr.get(i));
		       		
		       	 }
			}
    	}
        
        setListaArr(stosTemp);

    }
	
	
	
	
	public void getTodos() {
		ArrayList<Producto> sumados = new ArrayList<Producto>();
		Boolean f = true;
		List<Producto> stos =productos;
		for (Producto producto : stos) {
				if (sumados.isEmpty() && producto.getEstado() == 'S') {					
					sumados.add(producto);					
				}else {				
					for (Producto producto2 : sumados) {						
						if (producto2.getNombre().equals(producto.getNombre()) && f ) {
							producto2.setStock(producto2.getStock() + producto.getStock());													
							f = false;					
						}	
					}
					if (f && producto.getEstado() == 'S') {
						sumados.add(producto);
						f = true;
					}
				}
			}
				System.out.println("Todos "+sumados);
				setListaArr(sumados);
	}
	

	public String getText() {
		return text;
	    }

	    public void setText(String text) {
		this.text = text;
	    }
	
	    
	    
	    
	public void buscarTexto() {
		
		listener();
		//System.out.println("Texto de busqueda: " + text);

		//ArrayList<Producto> tempBusc = new ArrayList<Producto>();
		
		//tempBusc = getListaArr();
		
		//for (Producto producto : tempBusc) {
			
			//if (producto.getNombre().contains(text)) {
				
			//}
		
		//}
		
		
		
	}

	
	
	
	
	public ArrayList<Producto> getListaArr() {
		
		return this.listaArr;
	}

	public void setListaArr(ArrayList<Producto> listaArr) {
		this.listaArr = listaArr;
	}
	

	public String iniciarSecion() {
		
		System.out.println("Usuario: " + usuario );
		
		System.out.println("Contrase�a: " + contrasena );
		
		
		Persona sta = ejbPersona.inicioSesion(usuario, contrasena);
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	
	
	
	
	
}
