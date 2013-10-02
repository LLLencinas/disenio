package ar.edu.celulares.applicationModel

import domain.Entrada
import ar.edu.celulares.home.HomeEntradas
import ar.edu.celulares.home.HomeEntradas
import domain.Cliente
import domain.Noche
import domain.Butaca
import java.util.Date
import domain.TipoDePago
import domain.TipoCliente


@org.uqbar.commons.utils.Observable
class VendedorEntrada extends Serializable {

	var cliente: Cliente=_;
	var tipoCliente:TipoCliente=_
	var noche: Noche=_;
	var butaca: Butaca=_;
	var nroFactura : Int=_;
	var precioDeVenta: Double=_;
	var fechaCompra: Date = new Date();
	var devuelta: Boolean = false;
	
	
	def precioEnPesos:String ={ return "$" + precioDeVenta}

	def cargarEntradaharco = { 
	  var entrada: Entrada = HomeEntradas.getEntradaHarco()
	  cliente = entrada.cliente
	  noche = entrada.noche
	  butaca = entrada.butaca
	  nroFactura = entrada.nroFactura
	  precioDeVenta= entrada.precioDeVenta
	  fechaCompra= entrada.fechaCompra
	  devuelta= entrada.devuelta
	  
	}

	def clear() = {
		nroFactura = 0
	}



}