package ec.edu.ups.controller;

import java.io.Serializable;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.EJB.BodegaFacade;
import ec.edu.ups.EJB.CategoriaFacade;
import ec.edu.ups.EJB.CiudadFacade;
import ec.edu.ups.EJB.PersonaFacade;
import ec.edu.ups.EJB.ProductoFacade;
import ec.edu.ups.EJB.ProvinciaFacade;
import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Ciudad;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Provincia;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class CreacionDatos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
    private CategoriaFacade ejbCategoria;
	@EJB
	private ProductoFacade ejbProducto;
	@EJB
	private BodegaFacade ejbBodega;
	@EJB
	private ProvinciaFacade ejbProvincia;
	@EJB
	private CiudadFacade ejbCiudad;
	@EJB
	private PersonaFacade ejbPersona;
	
	public void creacionPrincipal() {
		
		Categoria cat=new Categoria(1, "Limpieza");
		Categoria cat2=new Categoria(2, "Jardineria");
		Categoria cat3=new Categoria(3, "Cuidado perdonal");
		Categoria cat4=new Categoria(4, "Cocina");
		Categoria cat7=new Categoria(7, "Electrodomesticos");
		
		ejbCategoria.create(cat);
		ejbCategoria.create(cat2);
		ejbCategoria.create(cat3);
		ejbCategoria.create(cat4);
		ejbCategoria.create(cat7);
		
		Producto pord=new Producto(1, "Axion",(float) 2.50, 30, 'S', cat);
		Producto pord2=new Producto(2, "Cloro",(float) 2.15, 40, 'S', cat);
		Producto pord3=new Producto(3, "Papel Hijienico",(float) 1.50, 50, 'S', cat);
		Producto pord4=new Producto(4, "Detergente",(float) 3.0, 60, 'S', cat);
		
		Producto pord5=new Producto(5, "Tijeras de Podar",(float) 35.0, 10, 'S', cat2);
		Producto pord6=new Producto(6, "Tierra",(float) 35.0, 10, 'S', cat2);
		Producto pord7=new Producto(7, "Lampon",(float) 25, 15, 'S', cat2);
		
		Producto pord8=new Producto(8, "Crema Hidratante",(float) 10.0, 10, 'S', cat3);
		Producto pord9=new Producto(9, "Protector solar",(float) 18.00, 10, 'S', cat3);
		Producto pord10=new Producto(10, "Serum",(float) 20.50, 10, 'S', cat3);
		
		Producto pord11=new Producto(11, "Platos",(float) 6, 100, 'S', cat4);
		Producto pord12=new Producto(12, "Cubiertos",(float) 1.50, 100, 'S', cat4);
		Producto pord13=new Producto(13, "Cuchillos",(float) 3, 70, 'S', cat4);
		

		Producto pord20=new Producto(20, "Lavadora",(float) 600.0, 10, 'S', cat7);
		Producto pord21=new Producto(21, "Secadora",(float) 600.0, 10, 'S', cat7);
		Producto pord22=new Producto(22, "Refrigeradora",(float) 1000.0, 5, 'S', cat7);
		
		
		Provincia provi = new Provincia(1, "Azuay");
		Provincia provi2 = new Provincia(2, "Guayas");
		Provincia provi3 = new Provincia(3, "Pichincha");
		
		ejbProvincia.create(provi);
		ejbProvincia.create(provi2);
		ejbProvincia.create(provi3);
		
		Ciudad ciudad = new Ciudad(1, "Cuenca", provi);
		Ciudad ciudad2 = new Ciudad(2, "Guayaquil", provi2);
		Ciudad ciudad3 = new Ciudad(3, "Quito", provi3);
		
		ejbCiudad.create(ciudad);
		ejbCiudad.create(ciudad2);
		ejbCiudad.create(ciudad3);
		
		Bodega bodega = new Bodega(1, "Bodega 1", "Centro historico", ciudad);
		Bodega bodega2 = new Bodega(2, "Bodega 2", "malecon 2000", ciudad2);
		Bodega bodega3 = new Bodega(3, "Bodega 3", "Panecillo", ciudad3);
		
		bodega.addProductos(pord);
		bodega.addProductos(pord2);
		bodega.addProductos(pord6);
		bodega.addProductos(pord9);
		bodega.addProductos(pord10);
		bodega.addProductos(pord11);
		bodega.addProductos(pord20);
		bodega.addProductos(pord21);
		
		bodega2.addProductos(pord3);
		bodega2.addProductos(pord7);
		bodega2.addProductos(pord12);
		bodega2.addProductos(pord13);
		bodega2.addProductos(pord22);
		
		bodega3.addProductos(pord4);
		bodega3.addProductos(pord5);
		bodega3.addProductos(pord8);
		
		ejbBodega.create(bodega);
		ejbBodega.create(bodega2);
		ejbBodega.create(bodega3);
		
		Persona persona = new Persona(1, "Juan", "Barrera","0106113301","Paute", "0980990592", "barrerajuan930@gmail.com", "5665", 'E');
		Persona persona2 = new Persona(2, "Katy", "Barrera","0106114309","Paute", "0980990593", "katerinbarrera21@gmail.com", "5665", 'A');
		Persona persona3 = new Persona(3, "John", "Chiqui","0106114302","Cuenca", "0980990592", "johnChiqui@gmail.com", "5665", 'C');
		
		ejbPersona.create(persona);
		ejbPersona.create(persona2);
		ejbPersona.create(persona3);
	}
	
	public void listarProductosBodega() {

        List<Producto> sta = ejbBodega.find(1).getProductos();

        for (Producto producto : sta) {
            System.out.println(producto.getNombre());
        }
    }
	
}
