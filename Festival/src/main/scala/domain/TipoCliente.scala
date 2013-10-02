package domain

import org.uqbar.commons.utils.Observable

@Observable
abstract class TipoCliente(){
  
	def dtoTipoPersona(precioBase:Double) : Double;
}

class TipoCliente_MenorDe12Acompaniado() extends TipoCliente() {


	override def dtoTipoPersona(precioBase:Double):Double = {
			if(SistemaVentas.descuentos.contains("menores de 12"))
				return (precioBase *0.50);
			else
				return 0.0;
	} 

}

class TipoCliente_MenorDe12NoAcompaniado() extends TipoCliente() {

	override def dtoTipoPersona(precioBase:Double):Double = {
			return 0.0;
	} 
}

class TipoCliente_Menor() extends TipoCliente() {
  		
	override def dtoTipoPersona(precioBase:Double):Double = {
			if(SistemaVentas.descuentos.contains("menores de 18")){
				if (precioBase > 100) 
					return (precioBase *0.20);
				if((precioBase <= 100) && (precioBase > 50)){
					return (10.0);
				}
				else
					return 0;	
			}
			return 0.0;
	}
}

class TipoCliente_Mayor() extends TipoCliente() {
	override def dtoTipoPersona(precioBase:Double):Double = {
			return 0;
	}
}

class TipoCliente_Jubilado() extends TipoCliente() {
	override def dtoTipoPersona(precioBase:Double):Double = {
			if(SistemaVentas.descuentos.contains("jubilados")){
				return (precioBase* 0.15);
			}
			return 0;
	}
}
  
  
class TipoCliente_Mujer() extends TipoCliente() {

	override def dtoTipoPersona(precioBase:Double):Double = {
			if(SistemaVentas.descuentos.contains("mujeres")){
				if ((SistemaVentas.entradasDeMujeresConDescVendidas / SistemaVentas.cantidadEntradas) < 0.20){
					return (precioBase *0.20);
				}
			}
			return 0;
	} 
}