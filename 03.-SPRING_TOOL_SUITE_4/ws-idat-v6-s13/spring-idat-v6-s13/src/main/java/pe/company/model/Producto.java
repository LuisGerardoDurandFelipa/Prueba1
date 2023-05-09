package pe.company.model;

public class Producto {

	private Long id_producto;
    private String producto;
    private String marca;
    private double precio;
    private int stock;
    
	public Producto() {
	}

	public Producto(Long id_producto, String producto, String marca, double precio, int stock) {
		this.id_producto = id_producto;
		this.producto = producto;
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

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
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
