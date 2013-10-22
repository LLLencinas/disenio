package ar.edu.celulares.applicationModel

import java.util.ArrayList
import collection.JavaConversions._
import domain._
import ar.edu.celulares.home.HomeBandas
import org.joda.time.DateTime

@org.uqbar.commons.utils.Observable
abstract class BuscadorBanda extends Buscador {
  
  var nombreBanda:String= ""
  var seleccionFestival:Festival = _
    
  var resultados: java.util.List[Banda] = _
  var bandaSeleccionada: Banda = _

  def search() = {
    resultados = new ArrayList[Banda]   
    resultados = this.buscarBanda() //Cada subclase lo define, algo asi como un ""Template Method"" CREO
  }

  def clear() = {
    
    nombreBanda = ""
    /*seleccionFestival = _
    bandaSeleccionada = _*/
  }
  
  def buscarBanda():Seq[Banda];

}

@org.uqbar.commons.utils.Observable
class BuscadorBandaPorNombre extends BuscadorBanda{
  
  def buscarBanda():Seq[Banda] ={
    return HomeBandas.search(nombreBanda)
    
  }
}


//@org.uqbar.commons.utils.Observable
//class BuscadorEntradaPorPuntoDeVenta extends BuscadorEntrada{
//  
//  def buscarEntrada():Seq[Entrada] ={
//    return HomeEntradas.searchPuestoFestival(nombrePuestoDeVenta,nombreFestival)
//    
//  }
//}




