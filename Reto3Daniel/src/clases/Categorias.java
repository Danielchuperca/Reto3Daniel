package clases;

public class Categorias {
	private int idCategoria;
	private String nombre;
	public Categorias(int idCategoria, String nombre) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}
	public Categorias() {
		super();
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "idCategoria=" + idCategoria + ", nombre=" + nombre ;
	}
	
}
