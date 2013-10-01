package domain

import org.uqbar.commons.utils.Observable

@Observable
abstract class Pedido(){
	var _butaca: Butaca;
	var _noche: Noche;

	def generarEntrada():Entrada;
}