package clases;

public class PedidoProducto {
	private int idPedidoProducto;
	private Pedidos idPedido;
	private Productos idProductos;
	private int unidades;
	private double precio;
	
	public PedidoProducto(Pedidos idPedido, Productos idProductos, int unidades, double precio) {
		super();
		this.idPedido = idPedido;
		this.idProductos = idProductos;
		this.unidades = unidades;
		this.precio = precio;
	}
	public PedidoProducto() {
		super();
	}
	public PedidoProducto(int idPedidoProducto, Pedidos idPedido, Productos idProductos, int unidades, double precio) {
		super();
		this.idPedidoProducto = idPedidoProducto;
		this.idPedido = idPedido;
		this.idProductos = idProductos;
		this.unidades = unidades;
		this.precio = precio;
	}
	
	public int getIdPedidoProducto() {
		return idPedidoProducto;
	}
	public void setIdPedidoProducto(int idPedidoProducto) {
		this.idPedidoProducto = idPedidoProducto;
	}
	public Pedidos getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Pedidos idPedido) {
		this.idPedido = idPedido;
	}
	public Productos getIdProductos() {
		return idProductos;
	}
	public void setIdProductos(Productos idProductos) {
		this.idProductos = idProductos;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "PedidoProducto [idPedidoProducto=" + idPedidoProducto + ", idPedido=" + idPedido + ", idProductos="
				+ idProductos + ", unidades=" + unidades + ", precio=" + precio + "]";
	}
	
	
}	
