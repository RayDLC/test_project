package org.recetas4you.service;

import java.util.List;

import org.recetas4you.model.Receta;
import org.recetas4you.repository.IRecetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecetaServiceImplements implements RecetaService{

	@Autowired
	private IRecetaRepository recetaRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Receta> findAll() {
		return (List<Receta>) recetaRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Receta> findAll(Pageable pageable) {
		return recetaRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Receta receta) {
		recetaRepository.save(receta);
	}

	@Override
	@Transactional(readOnly = true)
	public Receta findOne(int id_receta) {
		return recetaRepository.findById(id_receta).orElse(null);
	}

	@Override
	public void delete(int id_receta) {
		recetaRepository.deleteById(id_receta);
	}	
	

}
