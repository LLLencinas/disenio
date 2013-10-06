package domain



import org.joda.time._
import org.joda.convert._

import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import scala.collection.immutable.Nil
import scala.util.control.Exception

@Observable
abstract class Entrada( uncliente: Cliente, unTipoCliente: TipoCliente, unaNoche: Noche, unaButaca: Butaca, fechaDeCompra: DateTime) extends Entity {

	var cliente: Cliente= uncliente;
	var tipoCliente: TipoCliente= unTipoCliente;
	var noche: Noche= unaNoche;
	var butaca: Butaca= unaButaca;
	var nroFactura : Int=_;
	var precioDeVenta: Double=_;
	var fechaCompra: DateTime = fechaDeCompra
	var devuelta: Boolean = false;


	/*
tipoDePago que tenga un objeto de una clase pagoEnEfectivos o de una clase pagoConTarjeta. 
Que en el metodo comprar de la entrada llame a tipoDePago.comprar()
*/


def comprar();
  
def anular();

def anularVenta(){
  	SistemaVentas.entradasVendidas = SistemaVentas.entradasVendidas.filter(entrada=> entrada != this)
}	//Saca la entrada de la lista de entradas vendidas

  def precioFinal(): Double; 
  
  def imprimir(){
	  /*envia imprimir a la impresora fiscal*/
  }
  	
  def devolver(fechaDevolucion : DateTime): Double;
 
}