package domain

import java.util.Date

class EntradaVIP( uncliente: Cliente,unTipoCliente: TipoCliente, unaButaca: Butaca) extends Entrada(uncliente, unTipoCliente, null , unaButaca) {
  noche = SistemaVentas.noches.head;
  precioDeVenta=this.precioFinal();

override def devolver(): Double ={
		//Ver bien los return algo, no le preste atencion
		if (devuelta) {
			return -1;
		}
		if  (!SistemaVentas.entradasVendidas.contains(this)){
			//NO encuentra la estrada en la lista de vendidas
			return -2;
		}
  	  var hoy = new Date();
  	  var noche = SistemaVentas.noches.head;
	  if ((noche.fecha.getDate() -hoy.getDate()) > 10 ){
	    //No se puede devolver porque estamos en los ultimos 10 dias
	    return -3;
	    }
  	  for(noche <- SistemaVentas.noches){
  		  noche.butacasLibres=noche.butacasLibres.+:(butaca);
  	  }
  	  devuelta=true;
  	  return precioDeVenta*0.5;
  	}


override def anular() {
  
	anularVenta
    for(noche <- SistemaVentas.noches){
  		  noche.butacasLibres=noche.butacasLibres.+:(butaca);
  	  }
  
}


override def precioFinal(): Double = {
	var valorEntradaBase = 0.0; 
	var valorExtraPorNoche = 0.0;
	var descuentoTipoPersona = 0.0; 
	var precio = 0.0; 
	var dtoAnticipada = 0.0;
	var subtot = 0.0;
	var total =0.0;
	
  for(noche <- SistemaVentas.noches){
    valorEntradaBase = butaca.precioBase();
    valorExtraPorNoche = noche.valorExtra();
    descuentoTipoPersona = tipoCliente.dtoTipoPersona(valorEntradaBase);
    precio = valorEntradaBase + valorExtraPorNoche - descuentoTipoPersona;
    dtoAnticipada = SistemaVentas.calcularDescuentoAnticipa(precio, noche);
    subtot = precio - dtoAnticipada;
    total= total + subtot;
  }
  return total*1.5;
}
  
  override def comprar() {
    //No tendria que ser un lista contiene entrada? en vez de un "=="?
    //O tendria que sacarlo si lo verifico antes
    	if  (SistemaVentas.entradasVendidas.==(this)){
    		return ;
    	}
    	for(noche <- SistemaVentas.noches){
    		noche.butacasLibres= noche.butacasLibres.diff(List(butaca));
    	}
    	SistemaVentas.entradasVendidas=SistemaVentas.entradasVendidas.+:(this);
    	this.imprimir(); 
    	return;
  }
  	  
}