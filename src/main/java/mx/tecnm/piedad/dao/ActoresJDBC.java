package mx.tecnm.piedad.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mx.tecnm.piedad.models.Actores;

@Repository
public class ActoresJDBC {
	@Autowired
	private JdbcTemplate conexion;
	
	//Ver Actores
	public List<Actores> consultar()
	{
		String sql = "SELECT * FROM Actor WHERE activo = 1";
		return conexion.query(sql, new ActoresRM());
	}
	
	//Modificar Actor
	public void modificar(int id, Actores actor) {
		String sql = "UPDATE actor SET edad = ?, fechaMod = NOW()"
				+ "WHERE id = ?";
		conexion.update(sql, actor.getEdad(), id);
			
	}
	//Eliminar Actor
	public void desactivar(int id) {
		String sql = "UPDATE actor SET activo = 0, fechaDelete = NOW() WHERE id = ?";
		conexion.update(sql, id);
	}
		
	//Crear Actor
	public int insertar(Actores nuevo_actor) {
		String sql = "INSERT INTO Actor (nombre, apellido, nacionalidad, edad, fechaCreat, activo) VALUES (?,?,?,?,NOW(),1)";
		conexion.update(sql, nuevo_actor.getNombre(), nuevo_actor.getApellido(), nuevo_actor.getNacionalidad(), 
				        nuevo_actor.getEdad());
		sql = "SELECT LAST_INSERT_ID()";
		return conexion.queryForObject(sql, Integer.class);
				
	}

}
