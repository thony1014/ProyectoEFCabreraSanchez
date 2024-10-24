package com.examen.mysql.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.mysql.modelo.ClassMedico;
import com.examen.mysql.repositorio.IMedicoRepository;

public class ClassMedicoServicioImp implements IMedicoServicio{

	//aplicamos la inyeccion de dependencia.
	@Autowired
	private IMedicoRepository imedicorepository;
		
	@Override
	public void RegistrarMedico(ClassMedico classmedico) {
		//invocamos el metodo registrar..
		imedicorepository.save(classmedico);
		
	}//fin del registrar...

	@Override
	public void EliminarMedico(Integer id) {
		//invocamos el metodo eliminar..
		imedicorepository.deleteById(id);
		
	}//fin del eliminar...

	@Override
	public ClassMedico BuscarporId(Integer id) {
		//invocamos el metodo buscar..
		return imedicorepository.findById(id).orElse(null);
	} //fin del buscar.

	@Override
	public List<ClassMedico> ListadoMedicos() {
		//invocamos el metodo listado
		return (List<ClassMedico>) imedicorepository.findAll();
	} //fin del listado

}
