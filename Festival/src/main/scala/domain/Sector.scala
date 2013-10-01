package domain

import org.uqbar.commons.utils.Observable

@Observable
class Sector(unPrecio: Double, unSector: Char) {
	var _precioBase:Double = unPrecio;
	var sector: Char = unSector;

	def precioBase = _precioBase
	
	override def toString(): String ={
	  return "" + sector + ""
	}
}