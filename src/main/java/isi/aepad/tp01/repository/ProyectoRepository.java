package isi.aepad.tp01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.aepad.tp01.domain.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto,Integer> {

}
