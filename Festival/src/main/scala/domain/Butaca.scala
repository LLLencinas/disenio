package domain

import org.uqbar.commons.utils.Observable

@Observable
class Butaca(unSector : Sector, unaFila:Fila,unId:Int) {

		var sector : Sector = unSector;
		var fila : Fila = unaFila;
		var id: Int = unId;
		var codigo: String = "";
		
		def precioBase(): Double ={
		  return sector.precioBase + fila.precioBase;
		}
		
		def setCodigo(unCodigo: String){
		  codigo=unCodigo;
		}
		
		override def toString():String ={
		  return ""+id+" (Sector "+ sector.toString+", Fila "+fila.toString +")"
		}
		
}