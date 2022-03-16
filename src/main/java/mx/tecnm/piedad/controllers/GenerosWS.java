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

import mx.tecnm.piedad.dao.GenerosJDBC;
import mx.tecnm.piedad.models.Generos;

@RestController
@RequestMapping("/genero")
public class GenerosWS {
	@Autowired
	GenerosJDBC repo;
	
	//Ver
	@GetMapping
	public ResponseEntity<?> consultar(){
		try {
			List<Generos> resultado = repo.consultar();
			return new ResponseEntity<List<Generos>>(resultado, HttpStatus.OK);
		}catch(DataAccessException e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	// Modificar
	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@PathVariable int id, @RequestBody Generos genero){
		repo.modificar(id, genero);
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
	public ResponseEntity<?> insertar(@RequestBody Generos nuevo_genero){
		try {
			int id = repo.insertar(nuevo_genero);
			return new ResponseEntity<>(id,HttpStatus.CREATED);
		}catch (DataAccessException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
}
