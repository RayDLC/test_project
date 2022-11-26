package org.recetas4you.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="duracion")
@Data
public class Duracion {
	
	@Id
	private int id_duracion;
	private String dur_descripcion;

}
