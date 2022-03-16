package mx.tecnm.piedad.models;

public class Generos {
	private int id;
	 private String nombre;
	 private int activo;
	 private String fecha_eliminado;
	 private String fecha_modificado;
	 private String fecha_creado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public String getFecha_eliminado() {
		return fecha_eliminado;
	}
	public void setFecha_eliminado(String fecha_eliminado) {
		this.fecha_eliminado = fecha_eliminado;
	}
	public String getFecha_modificado() {
		return fecha_modificado;
	}
	public void setFecha_modificado(String fecha_modificado) {
		this.fecha_modificado = fecha_modificado;
	}
	public String getFecha_creado() {
		return fecha_creado;
	}
	public void setFecha_creado(String fecha_creado) {
		this.fecha_creado = fecha_creado;
	}

}
