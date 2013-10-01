package domain
import org.uqbar.commons.utils.Observable

@Observable
class Fila(unNumero:Int, unPrecioBase:Double) {
	var numeroFila: Int = unNumero;
	var _precioBase:Double = unPrecioBase;
	
	def precioBase = _precioBase
	
	override def toString():String = {
	  return "" +numeroFila + ""
	}
}