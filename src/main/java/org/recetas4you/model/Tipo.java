package org.recetas4you.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tipos")
@Data
public class Tipo {
	
	@Id
	private int id_tipo;
	private String tip_descripcion;

}
