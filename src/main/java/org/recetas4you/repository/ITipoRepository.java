package org.recetas4you.repository;

import org.recetas4you.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoRepository extends JpaRepository<Tipo, Integer>{

}
