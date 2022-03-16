package mx.tecnm.piedad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.piedad.dao.CategoriasJDBC;
import mx.tecnm.piedad.models.Categorias;


@RestController
@RequestMapping("/categoria")
public class CategoriasWS {
	@Autowired
	CategoriasJDBC repo;

	
	//Ver
	@GetMapping
	public ResponseEntity<?> consultar(){
		try {
			List<Categorias> resultado = repo.consultar();
			return new ResponseEntity<List<Categorias>>(resultado, HttpStatus.OK);
		}catch(DataAccessException e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	// Modificar
	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@PathVariable int id, @RequestBody Categorias categoria){
		repo.modificar(id, categoria);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	//Eliminar
	@DeleteMapping("/{id}")
	public ResponseEntity<?> desactivar(@PathVariable int id){
		repo.desactivar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//Crear
	@PostMapping
	public ResponseEntity<?> insertar(@RequestBody Categorias nueva_categoria){
		try {
			int id = repo.insertar(nueva_categoria);
			return new ResponseEntity<>(id,HttpStatus.CREATED);
		}catch (DataAccessException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
}
