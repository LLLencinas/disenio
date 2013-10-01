
package domain

class PedidoComun(unaNoche: Noche, unaButaca:Butaca,unTipoDePago:TipoDePago) extends Pedido {
  	var _noche:Noche = unaNoche;
	var _butaca:Butaca = unaButaca;
	var _tipoPago:TipoDePago = unTipoDePago
	
//	def noche =  _noche;
//	def butaca = _butaca;
		
override def generarEntrada():Entrada={
	  var entradaComun = new EntradaComun(unTipoDePago);
	  entradaComun.noche = _noche;
	  return entradaComun;
	  
	}

}