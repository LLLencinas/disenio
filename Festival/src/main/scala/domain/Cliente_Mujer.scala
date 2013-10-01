package domain


class Cliente_Mujer(datosLegales:String, estaAcompaniado: Boolean) extends Cliente {
	var _datosLegales: String = datosLegales;
  
		
 override def dtoTipoPersona(precioBase:Double):Double = {
   if(SistemaVentas.descuentos.contains("mujeres"))
		if ((SistemaVentas.entradasDeMujeresConDescVendidas / SistemaVentas.cantidadEntradas) < 0.20) 
			return (precioBase *0.20);
		else
		  return 0;
   else
     return 0;
} 

}