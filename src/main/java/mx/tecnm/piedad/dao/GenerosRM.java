package mx.tecnm.piedad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.piedad.models.Generos;

public class GenerosRM implements RowMapper<Generos>{

	@Override
	public Generos mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Generos genero = new Generos();
		genero.setId(rs.getInt("id"));
		genero.setNombre(rs.getString("nombre"));
		genero.setActivo(rs.getInt("activo"));
		genero.setFecha_eliminado(rs.getString("fecha_eliminado"));
		genero.setFecha_modificado(rs.getString("fecha_modificado"));
		genero.setFecha_creado(rs.getString("fecha_creado"));
		
		return genero;
	}

}
