
//import java.util.Conversion


package domain

import org.uqbar.commons.utils.Observable
import scala.collection.immutable.Nil
import java.sql.Struct
//import java.util.Conversion

@Observable
abstract class TipoDePago {

	def comprar(unaEntrada:Entrada): Boolean;
}

class PagoEnEfectivo extends TipoDePago(){
	def comprar(unaEntrada:Entrada): Boolean = {
	    if  (SistemaVentas.entradasVendidas.==(unaEntrada)){
	      return false;
	      }
	    unaEntrada.comprar();
	    return true;
	    
  }
	
}


class PagoConTarjeta() extends TipoDePago(){
  var _sisCobro: SistemaDeCobro = null
  
 override def comprar(unaEntrada:Entrada) : Boolean = {
	//usa la api
	  
		if  (SistemaVentas.entradasVendidas.==(unaEntrada)){
	      return false;	//NO encuentra la estrada en la lista de vendidas 
	    }
	     val nombreCliente = unaEntrada.cliente._apellido.+(", ").+(unaEntrada.cliente._nombre);
	     val numeroTarjeta = unaEntrada.cliente._nroTarjeta;
	     
	    unaEntrada.comprar();
	     
	     try {
	    	 _sisCobro.cobrar(unaEntrada.precioDeVenta, nombreCliente, numeroTarjeta);
	    	 return true;
		   } catch {	
				case e: DesconexionException =>{ SistemaVentas.agregarPagoPendiente(new Pago(unaEntrada,nombreCliente,numeroTarjeta));unaEntrada.anularVenta}
				case e: ValidacionException =>  unaEntrada.anular()
				  		//loguear venta no realizada o informar por pantalla
			}
	    return false;
  }
  
  
  
	
} 

