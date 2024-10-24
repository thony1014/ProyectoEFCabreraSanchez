package com.examen.mysql.servicio;

import java.util.List;

import com.examen.mysql.modelo.ClassMedico;

public interface IMedicoServicio {
	//declaramos los respectivos metdos
		public void RegistrarMedico(ClassMedico classmedico);
		public void EliminarMedico(Integer id);
		public ClassMedico BuscarporId(Integer id);
		public List<ClassMedico> ListadoMedicos	();
		
	}//fin de la interface...
