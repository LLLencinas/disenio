package domain

import org.uqbar.commons.utils.Observable

@Observable
class Pedido(unCliente: Cliente, unTipoDePago:TipoDePago) {
  	var _entradas:List[Entrada] = List.empty[Entrada];
	var _tipoPago:TipoDePago = unTipoDePago;
	var _cliente: Cliente = unCliente;
	

		
  def agregarEntradaComun(unTipoCliente: TipoCliente, unaNoche: Noche, unaButaca: Butaca, elCodigo: String=""): Boolean = {
      if (unaButaca.codigo.!=(elCodigo)){return false;}
	  var entradaComun = new EntradaComun( _cliente, unTipoCliente, unaNoche, unaButaca)
	  entradaComun.nroFactura = NroFactura.SacarNroFactura;
	  _entradas=_entradas.+:(entradaComun);
	  return true;
	}
  
  

  def agregarEntradaVip(unTipoCliente: TipoCliente, unaButaca: Butaca, elCodigo: String=""): Boolean = {
    for(noche <- SistemaVentas.noches){
    	if (!noche.butacasLibres.contains(unaButaca)) {return false;} 
    }  
    if (unaButaca.codigo.!=(elCodigo)){return false;}
	var entradaVip = new EntradaVIP(_cliente, unTipoCliente, unaButaca);
		entradaVip.nroFactura = NroFactura.SacarNroFactura;
	  _entradas=_entradas.+:(entradaVip);
	  return true;
  }
    
  def precioAcumulado():Double = {
    var total=0.0;
    for (entrada <- _entradas){
      total= total + entrada.precioDeVenta;
    }
    return total;
  }
  
  def precioNeto():Double = {
    var acu=this.precioAcumulado();
    if (acu>=1000.0){ acu= acu*0.9}
    return acu;
  }
  
  def comprar() {
   for (entrada <- _entradas){
     _tipoPago.comprar(entrada)
     
   }  
    
  }
  
}