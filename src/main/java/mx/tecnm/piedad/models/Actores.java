package mx.tecnm.piedad.models;

public class Actores {

	private int id;
	private String Nombre;
	private String Apellido;
	private String Nacionalidad;
	private String Edad;
	private String fechaDelete;
	private String fechaMod;
	private String fechaCreat;
	private int activo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getEdad() {
		return Edad;
	}
	public void setEdad(String edad) {
		Edad = edad;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public String getFechaDelete() {
		return fechaDelete;
	}
	public void setFechaDelete(String fechaDelete) {
		this.fechaDelete = fechaDelete;
	}
	public String getFechaCreat() {
		return fechaCreat;
	}
	public void setFechaCreat(String fechaCreat) {
		this.fechaCreat = fechaCreat;
	}
	public String getFechaMod() {
		return fechaMod;
	}
	public void setFechaMod(String fechaMod) {
		this.fechaMod = fechaMod;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
}