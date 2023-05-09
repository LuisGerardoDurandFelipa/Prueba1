package pe.company.model;

public class Producto {
	
	//1.- CREACION DE LOS ATRIBUTOS DE LA CLASE 
	private Long id_producto;
	private String nombre;
	private String marca;
	private double precio;
	private int stock;
	
	
	//2.-GENERAMOS LOS CONSTRUCTORES Y GET AND SET
	
	public Producto() {
	}


	public Producto(Long id_producto, String nombre, String marca, double precio, int stock) {
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.stock = stock;
	}


	public Long getId_producto() {
		return id_producto;
	}


	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
