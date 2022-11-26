package org.recetas4you.repository;

import java.util.List;

import org.recetas4you.model.Receta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRecetaRepository extends PagingAndSortingRepository<Receta, Integer>{
	
	 
}
