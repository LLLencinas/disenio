

package domain

import org.omg.DynamicAny._DynAnyFactoryStub
import org.uqbar.commons.utils.Observable

@Observable
class Cliente(nombre: String, apellido: String, nroTarjeta: String="", restoDatosLegales: String){
	var _nombre:String = nombre;
	var _apellido:String = apellido;
	var _nroTarjeta:String = nroTarjeta;
	var _restoDatosLegales:String = restoDatosLegales;

  

override def toString(): String = {
  return nombre + apellido
}

}

