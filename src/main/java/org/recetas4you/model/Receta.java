package org.recetas4you.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Entity
@Table(name="recetas")
@Data
public class Receta {
	
	@Id
	@Column(name="id_receta")
	private int id_receta;
	
	@NotEmpty
	@Column(name="rec_nombre")
	private String rec_nombre;
	
	@ManyToOne
	@JoinColumn(name ="id_tipo",insertable=false,updatable=false)
	private Tipo tipo;
	
	@PositiveOrZero
	@Column(name="id_tipo")
	private int id_tipo;
	
	@ManyToOne
	@JoinColumn(name ="id_duracion",insertable=false,updatable=false)
	private Duracion duracion;
	
	@PositiveOrZero
	@Column(name="id_duracion")
	private int id_duracion;
	
	@NotEmpty
	@Column(name="rec_ingredientes")
	private String rec_ingredientes;
	
	@NotEmpty
	@Column(name="rec_instrucciones")
	private String rec_instrucciones;
	
}
