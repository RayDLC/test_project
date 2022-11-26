package org.recetas4you.repository;

import java.util.List;

import org.recetas4you.model.Duracion;
import org.recetas4you.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuracionRepository extends JpaRepository<Duracion, Integer>{

}
