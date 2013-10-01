package domain
import org.uqbar.commons.utils.Observable

@Observable
class Categoria(unNivel: Int,unCostoExtra: Double) {
	var _nivel: Int = unNivel;
	var _costoExtra:Double = unCostoExtra;
	
	def nivel = _nivel;
	def costoExtra = _costoExtra;
	
	override def toString():String = {
	  return "" + _nivel + ""
	}
}