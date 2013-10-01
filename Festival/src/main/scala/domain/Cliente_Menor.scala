
package domain


class Cliente_Menor(datosLegales:String) extends Cliente {
	var _datosLegales: String = datosLegales;
  
		
 override def dtoTipoPersona(precioBase:Double):Double = {
   if(SistemaVentas.descuentos.contains("menores de 18")){
		if (precioBase > 100) 
			return (precioBase *0.20);
		if((precioBase <= 100) && (precioBase > 50)){
		   //println("DescuentoClienteMenor=" + (10));
			return (10.0);
			}
		else
		  return 0;	
 }else
   return 0;
   
		//Puse este else porque sino me daba error
		//"type mismatch found unit required double"
} 
  
}