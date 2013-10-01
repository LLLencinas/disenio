
//import java.util.Conversion


package domain
import org.uqbar.commons.utils.Observable

@Observable
abstract class TipoDePago {
	def comprar(unaEntrada:Entrada,cod:String);
}

class PagoEnEfectivo extends TipoDePago(){
  
override def toString():String = {
			return "Efectivo"
	}
	def comprar(unaEntrada:Entrada,cod: String) {
	    if  (SistemaVentas.entradasVendidas.==(unaEntrada)){
	      return
	      }
	    unaEntrada.realizarCompra(cod);
	    
	    
  }
 }
	


class PagoConTarjeta() extends TipoDePago(){
  var _sisCobro: SistemaDeCobro = null
  
 def comprar(unaEntrada:Entrada,cod:String) {
	//usa la api
	  
		if  (SistemaVentas.entradasVendidas.==(unaEntrada)){
	      return;	//NO encuentra la estrada en la lista de vendidas 
	    }
	     print("Ingrese el apellido y nombre del comprador : " )
	     val nombreCliente = Console.readLine
	     print("Ingrese el numero de tarjeta del comprador : " )
	     val numeroTarjeta =  Console.readLine
	     
	    
	     try {
	    	 _sisCobro.cobrar(unaEntrada.precioDeVenta, nombreCliente, numeroTarjeta)
		   } catch {	
				case e: DesconexionException => SistemaVentas.agregarPagoPendiente(unaEntrada,nombreCliente,numeroTarjeta)
				case e: ValidacionException =>  
				  		return
				  		//loguear venta no realizada o informar por pantalla
			}
	    
	    finally{
  		unaEntrada.realizarCompra(cod:String);
	    }
  }
  
  override def toString(): String ={
    return "Tarjeta"
  }
  
  
  
	
} 

