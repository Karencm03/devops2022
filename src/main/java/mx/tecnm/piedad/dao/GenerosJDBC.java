package mx.tecnm.piedad.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mx.tecnm.piedad.models.Generos;

@Repository
public class GenerosJDBC {
	@Autowired
	private JdbcTemplate conexion;
	
	
	//Ver
	public List<Generos> consultar(){
		String sql = "SELECT * FROM Genero WHERE activo = 1";
		return conexion.query(sql, new GenerosRM());
	}
	
	
	//Modificar
	public void modificar(int id, Generos genero) {
		String sql = "UPDATE Genero SET nombre = ?, fecha_modificado = NOW()"
				+ "WHERE id = ?";
		conexion.update(sql, genero.getNombre(), id);	
	}
	
	
	//Eliminar
	public void desactivar(int id) {
		String sql = "UPDATE Genero SET activo = 0, fecha_eliminado = NOW() WHERE id = ?";
		conexion.update(sql, id);
	}
	
	
	//Crear
	public int insertar(Generos nuevo_genero) {
		String sql = "INSERT INTO Genero (nombre, activo, fecha_creado) VALUES (?,1,NOW())";
		conexion.update(sql, nuevo_genero.getNombre());
		sql = "SELECT LAST_INSERT_ID()";
		return conexion.queryForObject(sql, Integer.class);
	}

}
