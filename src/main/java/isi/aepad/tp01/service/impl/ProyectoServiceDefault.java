package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tp01.domain.Proyecto;
import isi.aepad.tp01.repository.ProyectoRepository;
import isi.aepad.tp01.service.ProyectoService;


@Service
public class ProyectoServiceDefault implements ProyectoService{

	@Autowired
	ProyectoRepository proyectoRepo;
	
	
	@Override
	public Proyecto buscarPorId(Integer id) {
		return proyectoRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el proyecto con ID "+id));
	}

	@Override
	public Proyecto guardar(Proyecto t) {
		return proyectoRepo.save(t);
	}

	@Override
	public void borrar(Integer id) {
		proyectoRepo.deleteById(id);
	}

	@Override
	public List<Proyecto> buscarTodas() {
		return proyectoRepo.findAll();
	}
	


	
	

}
