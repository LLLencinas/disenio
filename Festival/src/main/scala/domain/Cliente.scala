

package domain

import org.omg.DynamicAny._DynAnyFactoryStub
import org.uqbar.commons.utils.Observable

@Observable
abstract class Cliente(){
	var _datosLegales: String;

		
def dtoTipoPersona(valorBase: Double): Double=0;

override def toString(): String = {
  return "El sucio de " + _datosLegales
}

}

