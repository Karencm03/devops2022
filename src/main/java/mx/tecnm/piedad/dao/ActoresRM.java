package mx.tecnm.piedad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.piedad.models.Actores;


public class ActoresRM  implements RowMapper<Actores>{

	@Override
	public Actores mapRow(ResultSet rs, int rowNum) throws SQLException {
		Actores actor = new Actores();
		actor.setId(rs.getInt("Id"));
		actor.setNombre(rs.getString("Nombre"));
		actor.setApellido(rs.getString("Apellido"));
		actor.setNacionalidad(rs.getString("Nacionalidad"));
		actor.setEdad(rs.getString("Edad"));
		actor.setFechaDelete(rs.getString("fechaDelete"));
		actor.setFechaMod(rs.getNString("fechaMod"));
		actor.setFechaCreat(rs.getString("fechaCreat"));
		actor.setActivo(rs.getInt("activo"));
		
		return actor;}

}
