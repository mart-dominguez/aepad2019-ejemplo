package isi.aepad.tp01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import isi.aepad.tp01.domain.Tarea;

public interface TareaRepository extends JpaRepository<Tarea,Integer> {

	public List<Tarea> findByProyectoIdAndFinalizada(Integer idProyecto,Boolean finalizada);

	public List<Tarea> findByProyectoId(Integer idProyecto);

}
