package domain

import org.uqbar.commons.utils.Observable

@Observable
class Banda(unCategoria:Categoria,unNombre:String) {
	var _categoria:Categoria = unCategoria;
	var nombre: String = unNombre;
	
	
	def categoria = _categoria;
	def categoria(unaCategoria: Categoria){
			_categoria = unaCategoria
	}
	
	override def toString():String ={
	  return nombre
	}

}