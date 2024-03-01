package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService iMateriaService;
	
	//http://localhost:8080/materias/nuevaMateria
	@GetMapping("/nuevaMateria")
	public String nuevaMateria(Materia materia) {
		 return"vistaNuevaMateria";
	}
	
	@PostMapping("/guardarMateria")
	public String guardarMateria(Materia materia) {
		this.iMateriaService.guardar(materia);
		return"redirect:/materias/listaMaterias";
	}
		
	@GetMapping("/listaMaterias")
	public String listaMaterias(Model modelo) {
		List<Materia>lista=this.iMateriaService.buscarTodos();
		modelo.addAttribute("materias",lista);
		return "listaMaterias";
	}
	
	@GetMapping("/buscarPorId/{id}")
	public String buscarPorId(@PathVariable("id") Integer id, Model model) {
		Materia materia = this.iMateriaService.buscarPorId(id);
		model.addAttribute("materia", materia);
		return "vistaBusquedaMateria";

	}

}
