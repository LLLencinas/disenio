package ar.edu.celulares.applicationModel


import java.util.ArrayList
import collection.JavaConversions._
import domain.Entrada
import ar.edu.celulares.home.HomeEntradas
import org.joda.time.DateTime

/**
 * Application model que representa la búsqueda de {@link Entrada}.
 */

@org.uqbar.commons.utils.Observable
class BuscadorEntrada extends Serializable {
  
  
  var nombreCliente:String= ""
  var fechaDesde:String = ""
  var fechaHasta:String=""
  var resultados: java.util.List[Entrada] = _
  var entradaSeleccionada: Entrada = _

  // ********************************************************
  // ** Acciones
  // ********************************************************
  def search() = {
    resultados = new ArrayList[Entrada]   
    resultados = HomeEntradas.search(nombreCliente, fechaDesde,fechaHasta)
  }

  def clear() = {
    
    nombreCliente="";
    fechaDesde="";
    fechaHasta="";
      

  }

}