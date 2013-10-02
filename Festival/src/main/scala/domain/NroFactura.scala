package domain
object NroFactura {

	var _nroFactura = 0;
	
	
	def SacarNroFactura(): Int =	{
		var auxiliar = _nroFactura;
		_nroFactura += 1;
		return auxiliar;
	}
}