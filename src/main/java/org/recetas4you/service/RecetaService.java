package org.recetas4you.service;

import java.util.List;

import org.recetas4you.model.Receta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetaService{

	
	public List<Receta> findAll();
	
	public Page<Receta> findAll(Pageable pageable);
	
	public void save(Receta receta);
	
	public Receta findOne(int id_receta);
	
	public void delete(int id_receta);
	
}
