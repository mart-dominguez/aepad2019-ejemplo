package isi.aepad.tp01.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import isi.aepad.tp01.domain.Proyecto;
import isi.aepad.tp01.service.ProyectoService;

@RestController
@RequestMapping("/api")
public class ProyectoResource {
	
	@Autowired
	private ProyectoService proyectoService;

	@GetMapping("proyecto")
	public ResponseEntity<List<Proyecto>> buscar() {
		return  new ResponseEntity<List<Proyecto>>(this.proyectoService.buscarTodas(), HttpStatus.OK);
	}

	
	@GetMapping("proyecto/{id}")
	public ResponseEntity<Proyecto> buscar(@RequestParam(value="id") Integer idProyecto) {
		return  new ResponseEntity<Proyecto>(this.proyectoService.buscarPorId(idProyecto), HttpStatus.OK);
	}
	
	@PostMapping("proyecto")
	public ResponseEntity<Proyecto> crear(@RequestBody Proyecto p,UriComponentsBuilder builder) {
        Proyecto creado = this.proyectoService.guardar(p);
        if (creado == null) {
        	return new ResponseEntity<Proyecto>(HttpStatus.NO_CONTENT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/api/proyecto/{id}").buildAndExpand(creado.getId()).toUri());
        return new ResponseEntity<Proyecto>(creado,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("proyecto")
	public ResponseEntity<Proyecto> actualizar(@RequestBody Proyecto p,UriComponentsBuilder builder) {
        Proyecto actualizar = this.proyectoService.guardar(p);
        return new ResponseEntity<Proyecto>(actualizar, HttpStatus.OK);
	}
	
	@DeleteMapping("proyecto/{id}")
	public ResponseEntity<Void> borrar(@RequestParam(value="id") Integer idProyecto) {
        this.proyectoService.borrar(idProyecto);
        return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
