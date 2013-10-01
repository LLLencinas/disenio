package domain


class PedidoVIP(unaButaca:Butaca,unTipoDePago:TipoDePago) extends Pedido  {
	 var _butaca:Butaca = unaButaca;
	 var _noche:Noche = SistemaVentas.noches.head;
	 var _tipoDePago:TipoDePago = unTipoDePago;

	def butaca = _butaca;
		
override def generarEntrada():Entrada={
	  var entradaVIP = new EntradaVIP(unTipoDePago);
	  return entradaVIP;
	  
	}
}