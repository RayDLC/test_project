package org.recetas4you.controller;

import java.io.OutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.lowagie.text.DocumentException;


import org.recetas4you.model.Receta;
import org.recetas4you.repository.IDuracionRepository;
import org.recetas4you.repository.ITipoRepository;
import org.recetas4you.repository.IRecetaRepository;
import org.recetas4you.service.RecetaService;
import org.recetas4you.util.PaginacionRender;
/*import org.recetas4you.util.RecetasPDF;*/
//import org.recetas4you.empleados.util.reportes.EmpleadoExporterExcel;
//import org.recetas4you.empleados.util.reportes.EmpleadoExporterPDF;
//import com.lowagie.text.DocumentException;

@Controller
public class RecetaController {
	
	@Autowired
	private RecetaService recetaService;
	
	@Autowired
	private IDuracionRepository duracionrepo;

	@Autowired
	private ITipoRepository tiporepo;
	
	@GetMapping("/ver/{id_receta}")
	public String verDetallesDeReceta(@PathVariable(value = "id_receta") int id_receta ,Map<String,Object> modelo,RedirectAttributes flash) {
		Receta receta = recetaService.findOne(id_receta);
		if(receta == null) {
			flash.addFlashAttribute("error", "La receta no existe");
			return "redirect:/listrecetas";
		}
		
		modelo.put("receta",receta);
		modelo.put("titulo", "Detalles de la Receta " + receta.getRec_nombre());
		return "seereceta";
	}
	
	
	@GetMapping({"/","/listreceta",""})
	public String listarRecetas(@RequestParam(name = "page",defaultValue = "0") int page,Model modelo) {
		Pageable pageRequest = PageRequest.of(page, 10);
		Page<Receta> recetas = recetaService.findAll(pageRequest);
		PaginacionRender<Receta> paginacionRender = new PaginacionRender<>("/listreceta", recetas);
		 
		modelo.addAttribute("titulo","Listado de Recetas");
		/* modelo.addAttribute("id_tipo", recetas); */
		modelo.addAttribute("recetas",recetas);
		modelo.addAttribute("page", paginacionRender);	
		
		return "listreceta";
	}
	
	@GetMapping("/testCompra")
	public String testCompra() {
		
		return "testCompra";
	}
	
	
	@GetMapping("/receta/crudcargar")
	public String cargarRegReceta(Map<String,Object> modelo) {
		Receta receta = new Receta();
		modelo.put("receta", receta);
		modelo.put("titulo", "Ingresar Receta");
		modelo.put("lstTipos", tiporepo.findAll());
		modelo.put("lstDuracion", duracionrepo.findAll());
		return "crudreceta";
	}
	
	@PostMapping("/receta/crudgrabar")
	public String guardarReceta(@Valid Receta receta,BindingResult result,Model modelo,RedirectAttributes flash,SessionStatus status) {
		if(result.hasErrors()) {
			modelo.addAttribute("lstTipos", tiporepo.findAll());
			modelo.addAttribute("lstDuracion", duracionrepo.findAll());
			modelo.addAttribute("titulo", "Registro de Receta");
			return "crudreceta";
		}
		
		String mensaje = (receta.getId_receta() != 0) ? "La receta ha sido editata con exito" : "Receta registrada con exito";
		
		recetaService.save(receta);
		status.setComplete();
		flash.addFlashAttribute("success", mensaje);
		return "redirect:/listreceta";
	}
	
	@GetMapping("/receta/crud/{id_receta}")
	public String editarReceta(@PathVariable(value = "id_receta") int id_receta,Map<String, Object> modelo,RedirectAttributes flash) {
		Receta receta = null;
		if(id_receta > 0) {
			receta = recetaService.findOne(id_receta);
			if(receta == null) {
				flash.addFlashAttribute("error", "El ID de la receta no existe");
				return "redirect:/listreceta";
			}
		}
		else {
			flash.addFlashAttribute("error", "El ID de la receta no puede ser 0");
			return "redirect:/listreceta";
		}
		modelo.put("lstTipos", tiporepo.findAll());
		modelo.put("lstDuracion", duracionrepo.findAll());
		modelo.put("receta",receta);
		modelo.put("titulo", "Edición de la receta");
		return "crudreceta";
	}
	
	@GetMapping("/eliminar/{id_receta}")
	public String eliminarReceta(@PathVariable(value = "id_receta") int id_receta,RedirectAttributes flash) {
		if(id_receta > 0) {
			recetaService.delete(id_receta);
			flash.addFlashAttribute("success", "Receta eliminada con exito");
		}
		return "redirect:/listreceta";
	}	

}
