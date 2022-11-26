package org.recetas4you.repository;

import org.recetas4you.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecetaRepositoryVoids extends JpaRepository<Receta, Integer>{

}
