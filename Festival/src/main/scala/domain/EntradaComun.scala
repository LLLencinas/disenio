package domain

import org.joda.time._
import org.joda.convert._



class EntradaComun( uncliente: Cliente,unTipoCliente: TipoCliente, unaNoche: Noche, unaButaca: Butaca,fechaDeCompra:DateTime = null) extends Entrada(uncliente, unTipoCliente, unaNoche, unaButaca,fechaDeCompra) {

precioDeVenta=this.precioFinal();

override def devolver(fechaDevolucion : DateTime): Double ={
		//Ver bien los return algo, no le preste atencion
		if (devuelta) {
			return -1;
		}
		if  (!festival.entradasVendidas.contains(this)){
			//NO encuentra la estrada en la lista de vendidas
			return -2;
		}
		
  	  if (fechaDevolucion.isAfter(noche.fecha.plusDays(10))){
	    //No se puede devolver porque estamos en los ultimos 10 dias
	    return -3;
	    }
  	  
  	  noche.butacasLibres=noche.butacasLibres.+:(butaca);
  	  devuelta=true;
  	  return precioDeVenta*0.5;
}


override def anular() {
  
	
	anularVenta()	
	noche.butacasLibres=noche.butacasLibres.+:(butaca);
	
  	  }  



 override def precioFinal(): Double = {
   var valorEntradaBase = butaca.precioBase();
   var valorExtraPorNoche = noche.valorExtra();
   var descuentoTipoPersona = tipoCliente.dtoTipoPersona(valorEntradaBase,festival);
   var precio = valorEntradaBase + valorExtraPorNoche - descuentoTipoPersona;
   var dtoAnticipada = festival.calcularDescuentoAnticipa(precio, noche,this.fechaCompra);
   
   
   return  precio - dtoAnticipada;
    
  }
  
  override def comprar() {
    //No tendria que ser un lista contiene entrada? en vez de un "=="?
    //O tendria que sacarlo si lo verifico antes
  	noche.butacasLibres= noche.butacasLibres.diff(List(butaca));
  	festival.entradasVendidas=festival.entradasVendidas.+:(this);
  	this.imprimir();
  	
  }
 

  	
		  
}