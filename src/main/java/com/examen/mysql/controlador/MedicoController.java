package com.examen.mysql.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.mysql.modelo.ClassMedico;
import com.examen.mysql.servicio.IMedicoServicio;

@Controller
@RequestMapping("/Vistas")
public class MedicoController {
	//inyeccion de dependencia..
		@Autowired
		private IMedicoServicio imedicoservicio;
		
		//creamos el metodo listado
		@GetMapping("ListadoMedicos")
		public String ListadoMedico(Model modelo) {
			//recuperamos el listado de medicos
			List<ClassMedico> listado=imedicoservicio.ListadoMedicos();
			//enviamos la data hacia la vista
			modelo.addAttribute("listado",listado);
			//retornamos
			return "/Vistas/ListadoMedicos";
		}  //fin del metodo listado
	
		//creamos el metodo registrar producto
		@GetMapping("/RegistrarMedico")
		public String RegistrarMedico(Model modelo) {
			//realizamos la respectiva instancia..
			ClassMedico clmedico=new ClassMedico();
			//enviamos a la vista
			modelo.addAttribute("regmedico",clmedico);
			//retornamos
			return "/Vistas/FrmRegMedico";
			
		}//fin del metodo registrar..
	
		//realizamos el metodo  guardar
		//con postmapping..
		@PostMapping("/GuardarMedico")
		public String GuardarMedico(@ModelAttribute
				ClassMedico clmed,
				Model modelo) {
			imedicoservicio.RegistrarMedico(clmed);
			//emitimo un mensaje por consola
			System.out.println("datos registrados en bd");
			//retornamos al listado
		return "redirect:/Vistas/ListadoMedicos";
		} //fin del metodo guardar..
		
		//creamos el metodo editar...
		@GetMapping("/EditarMedico/{id}")
		public String Editar(@PathVariable("id") 
		Integer idmedico,Model modelo) {
			ClassMedico clmedico=imedicoservicio.BuscarporId(idmedico);
			//enviamos hacia la vista..
			modelo.addAttribute("regmedico",clmedico);
			//retornamos el frmregMedico :)
			return "/Vistas/FrmRegMedico";
		}//fin del metodo editar..
		
		//creamos el metodo eliminar..
		public String eliminar(@PathVariable("id") Integer idmedico,
				Model modelo) {
			//invocamos al metodo
			imedicoservicio.EliminarMedico(idmedico);
			//actualizamos el listado
			List<ClassMedico> listado=imedicoservicio.ListadoMedicos();
			//enviamos a la vista
			modelo.addAttribute("listado",listado);
			//redireccionamos
			return "redirect:/Vistas/ListadoMedicos";
		} //fin del metodo eliminar...	
	

}
