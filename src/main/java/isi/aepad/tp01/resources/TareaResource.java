package isi.aepad.tp01.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isi.aepad.tp01.domain.Tarea;
import isi.aepad.tp01.service.TareaService;

@RestController
@RequestMapping("/api")
public class TareaResource {
	
	@Autowired
	private TareaService tareaService;

	@GetMapping("tarea")
	public ResponseEntity<List<Tarea>> buscar() {
		return  new ResponseEntity<List<Tarea>>(this.tareaService.buscarTodas(), HttpStatus.OK);
	}

	
	@GetMapping("tarea/{id}")
	public ResponseEntity<Tarea> buscar(@RequestParam(value="id") Integer idTarea) {
		return  new ResponseEntity<Tarea>(this.tareaService.buscarPorId(idTarea), HttpStatus.OK);
	}
	
	@PostMapping("tarea")
	public ResponseEntity<Tarea> crear(@RequestBody Tarea p,UriComponentsBuilder builder) {
        Tarea creado = this.tareaService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<Tarea>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/tarea/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Tarea>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("tarea")
	public ResponseEntity<Tarea> actualizar(@RequestBody Tarea p,UriComponentsBuilder builder) {
		Tarea actualizar = this.tareaService.guardar(p);
        return new ResponseEntity<Tarea>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("tarea/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idTarea) {
        this.tareaService.borrar(idTarea);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
