package ec.edu.ups.entidades;

public class Pedido {
	
	private Producto producto;
	private String cantidad;
	
	public Pedido(Producto producto, String cantidad) {
		this.setProducto(producto);
		this.setCantidad(cantidad);
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
