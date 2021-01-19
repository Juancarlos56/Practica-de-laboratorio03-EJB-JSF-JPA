package ec.edu.ups.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.EJB.BodegaFacade;
import ec.edu.ups.EJB.CategoriaFacade;
import ec.edu.ups.EJB.PersonaFacade;
import ec.edu.ups.EJB.ProductoFacade;
import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped

public class BodegaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static boolean b;
	@EJB
	private CategoriaFacade ejbCategoria;
	
	@EJB
	private ProductoFacade ejbProducto;
	
	@EJB
	private BodegaFacade ejbBodega;
	@EJB
	private PersonaFacade ejbPersona;
	
	public BodegaBean() {
		
	}
	
	private static int bodega = 0;
	
	private List<Producto> productos;
	
	private List<Categoria> categorias;
	
	private List<Bodega> bodegas;
	 
	@PostConstruct
	public void init(){
		productos=ejbProducto.findAll();
		categorias=ejbCategoria.findAll();
		bodegas=ejbBodega.findAll();
		b = true;
		//System.out.println("Cargan Bodegas: " + bodegas);
		//System.out.println("Cargan lista: " + bodegas.get(0).getProductos().get(0).getNombre());
		
		
	}
	
	

	String[] list;
    private static String categoria;
    
    private String text = "";
    
	
    private static ArrayList<Producto> listaArr  = new ArrayList<Producto>();
    
    private String lista = "nada aqui";
	private String usuario;
	private String contrasena;
	


	
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
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
		getTodos();
		System.out.println("Bodega en uso :" + bodega);
		System.out.println("Lista ARR : "+ listaArr);
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
	        for (int i = 0; i < listaArr.size(); i++) {
	        	if (listaArr.get(i).getCategoria().getNombre().equals(categoria) && listaArr.get(i).getNombre().toLowerCase().contains(text.toLowerCase())) {
		        	
	        		
		       		
		       		System.out.println("Prod Actual: "+listaArr.get(i).getNombre());
		       		stosTemp.add(listaArr.get(i));
		       		
		       	 
		       	 }
			}
	       	 
			
	        
    	}
        
        setListaArr(stosTemp);

    }
	
	
	
	
	public void getTodos() {
		
		System.out.println("Entra en gettodos");
		ArrayList<Producto> stos = new ArrayList<Producto>();
				
				//staBod.getProductos();
		
		
		for (int i = 0; i < bodegas.size(); i++) {
		
			System.out.println("Entra al for");
			
			if (bodegas.get(i).getId() == bodega) {
				
				System.out.println("Entra al for");
				
				
				for (Producto producto : bodegas.get(i).getProductos()) {
					stos.add(producto);
					System.out.println(producto.getNombre());
				}
			}
		}
		
		
		ArrayList<Producto> sumados = new ArrayList<Producto>();
		Boolean f = true;
		


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
		b = false;
		listener();
		
	}

	
	
	
	
	public ArrayList<Producto> getListaArr() {
		
		return this.listaArr;
	}

	public void setListaArr(ArrayList<Producto> listaArr) {
		System.out.println("setLista ARR "+ listaArr);
		this.listaArr = listaArr;
	}
	

	
	public void onload(int n) {
		setBodega(n);
		System.out.println("Bodega en uso :" + bodega);
		
		
		if (b){
		getTodos();
		}
		
		
	}

	public int getBodega() {
		return bodega;
	}

	public void setBodega(int bodega) {
		this.bodega = bodega;
	}
	
public String iniciarSecion() {
		
		System.out.println("Usuario: " + usuario );
		
		System.out.println("Contraseña: " + contrasena );
		
		
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

	

