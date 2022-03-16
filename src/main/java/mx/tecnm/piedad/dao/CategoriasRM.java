package mx.tecnm.piedad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.piedad.models.Categorias;

public class CategoriasRM implements RowMapper<Categorias> {

	@Override
	public Categorias mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categorias categoria = new Categorias();
		categoria.setId(rs.getInt("id"));
		categoria.setClasificacion(rs.getString("clasificacion"));
	    categoria.setDescripcion(rs.getString("descripcion"));
		categoria.setActivo(rs.getInt("activo"));
		categoria.setFecha_eliminado(rs.getString("fecha_eliminado"));
		categoria.setFecha_modificado(rs.getString("fecha_modificado"));
		categoria.setFecha_creado(rs.getString("fecha_creado"));
		
		
		return categoria;
	}

}
