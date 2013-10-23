package ar.edu.celulares.applicationModel
import java.util.ArrayList
import collection.JavaConversions._
import domain._
import ar.edu.celulares.home._
import org.joda.time.DateTime
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer


class BuscadorBandasPorFestival(unCliente:Cliente) extends Buscador {
  var festival:Festival = _
  var cliente = unCliente
  var resultados: java.util.List[Banda] = _
  var bandaSeleccionada: Banda = _
  
  def search(){
   resultados = new ArrayList[Banda]
   var r1 = HomeEntradas.buscarEntradasFestival(cliente.toString(),festival)
   resultados = HomeEntradas.dameBandas(cliente.toString(), festival)
   var larala = resultados.length
   var o = 0
  }
  
  def clear(){
  
  }
  
}