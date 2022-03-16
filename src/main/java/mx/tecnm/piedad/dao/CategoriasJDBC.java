package mx.tecnm.piedad.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mx.tecnm.piedad.models.Categorias;

@Repository
public class CategoriasJDBC {
	
	@Autowired
	private JdbcTemplate conexion;
	
	
	//Ver
	public List<Categorias> consultar(){
		String sql = "SELECT * FROM Categorias WHERE activo = 1";
		return conexion.query(sql, new CategoriasRM());
	}
	
	
	//Modificar 
	public void modificar(int id, Categorias categoria) {
		String sql = "UPDATE Categorias SET clasificacion = ?, descripcion = ?, fecha_modificado = NOW()"
				+ "WHERE id = ?";
		conexion.update(sql, categoria.getClasificacion(), categoria.getDescripcion(), id);	
	}
	
	
	//Eliminar
	public void desactivar(int id) {
		String sql = "UPDATE Categorias SET activo = 0, fecha_eliminado = NOW() WHERE id = ?";
		conexion.update(sql, id);
	}
	
	
	//Crear
	public int insertar(Categorias nueva_categoria) {
		String sql = "INSERT INTO Categorias (clasificacion, descripcion, activo, fecha_creado) VALUES (?,?,1,NOW())";
		conexion.update(sql, nueva_categoria.getClasificacion(), nueva_categoria.getDescripcion());
		sql = "SELECT LAST_INSERT_ID()";
		return conexion.queryForObject(sql, Integer.class);
	}
	
}
