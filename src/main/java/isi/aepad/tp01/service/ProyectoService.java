package isi.aepad.tp01.service;

import java.util.List;

import isi.aepad.tp01.domain.Proyecto;

public interface ProyectoService {

	public Proyecto buscarPorId(Integer id);
	
	public Proyecto guardar(Proyecto t);
	
	public void borrar(Integer id);
	
	public List<Proyecto> buscarTodas();
}
