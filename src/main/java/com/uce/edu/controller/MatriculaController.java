package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	//http://localhost:8080/matriculas/nuevaMatricula
	@GetMapping("/nuevaMatricula")
	public String nuevaMatricula(Matricula matricula) {
		return"vistaNuevaMatricula";
	}
	
	@PostMapping("/guardarMatricula")
	public String guadarMatricula (@RequestParam("codigo")String codigo,@RequestParam("cedula")String cedula) {
		this.iMatriculaService.guardar(codigo, cedula);
		return"redirect:/matriculas/reporte";
	}

	@GetMapping("/reporte")
	public String reporte(Model modelo) {
		List<MatriculaDTO>lista=this.iMatriculaService.reporte();
		modelo.addAttribute("matriculas",lista);
		return"vistaReporteMatricula";
	}
}
