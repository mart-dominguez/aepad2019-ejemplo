package isi.aepad.tp01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.aepad.tp01.domain.Tarea;
import isi.aepad.tp01.repository.TareaRepository;
import isi.aepad.tp01.service.TareaService;

@Service
public class TareaServiceDefault implements TareaService{
	@Autowired
	private TareaRepository tareaRepo;
	
	@Override
	public Tarea buscarPorId(Integer id) {
		return tareaRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la tarea con ID "+id));

	}

	@Override
	public List<Tarea> buscarTerminadas(Integer idProyecto) {
		return tareaRepo.findByProyectoIdAndFinalizada(idProyecto, true);
	}
	
	@Override
	public List<Tarea> buscarPorProyecto(Integer idProyecto) {
		return tareaRepo.findByProyectoId(idProyecto);
	}

	@Override
	public Tarea guardar(Tarea t) {
		return tareaRepo.save(t);
	}

	@Override
	public void borrar(Integer id) {
		tareaRepo.deleteById(id);
	}

	@Override
	public List<Tarea> buscarTodas() {
		return tareaRepo.findAll();
	}
	
}
