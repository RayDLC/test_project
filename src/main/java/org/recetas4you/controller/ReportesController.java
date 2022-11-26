package org.recetas4you.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javax.servlet.http.HttpServletResponse;

import org.recetas4you.repository.IDuracionRepository;
import org.recetas4you.repository.ITipoRepository;
import org.recetas4you.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class ReportesController {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private ResourceLoader resourceLoader;

	@GetMapping("/reportelista")
	public void reporteLista(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=\"ReporteListaReceta.pdf\";");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:Recetas.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@GetMapping("/reporteTipo")
	public void reporteGrafico(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=\"ReporteTipoGrafico.pdf\";");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:RecetasGrafico.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@GetMapping("/reporteDuracion")
	public void reporteReceta(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=\"ReporteDuracionGrafico.pdf\";");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:RecetasDuracionG.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
