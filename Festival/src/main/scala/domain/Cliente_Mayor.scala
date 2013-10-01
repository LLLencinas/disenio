
package domain

class Cliente_Mayor(datosLegales:String) extends Cliente {
	var _datosLegales: String = datosLegales;
  
 override def dtoTipoPersona(precioBase:Double):Double = {
  return 0;
	}
 
}