package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.Tarea;

public interface TareaService {
	public Tarea buscarPorId(Integer id);
	
	public List<Tarea> buscarTerminadas(Integer idProyecto);

	public List<Tarea> buscarPorProyecto(Integer idProyecto);

	public Tarea guardar(Tarea t);
	
	public void borrar(Integer id);
	
	public List<Tarea> buscarTodas();
}
