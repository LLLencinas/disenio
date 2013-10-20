package ar.edu.celulares.applicationModel

import scala.collection.JavaConversions._
import domain.Entrada
import ar.edu.celulares.home.HomeEntradas
import ar.edu.celulares.home.HomeEntradas
import domain.Cliente
import domain.Noche
import domain.Butaca
import java.util.Date
import domain.TipoDePago
import domain.TipoCliente
import domain.Sector
import domain.Fila
import domain.Festival
import ar.edu.celulares.home.HomeNoches
import ar.edu.celulares.home.HomeButacas
import domain.PuestoDeVenta



@org.uqbar.commons.utils.Observable
class VendedorEntrada extends Serializable {
  
  type JList[A] = java.util.List[A]
  //	Para todas las entradas
  var tipoDePago: TipoDePago = _
  var nombre: String = _
  var apellido: String = _
  var entradas: List[Entrada] = _
  var _festival: Festival = _
  var puestoDeVenta:PuestoDeVenta=_
  
  /**Getters y Setters necesarios para algunos combos que dependen de otros**/
  
  /**No se si esta bien el filter con esas condiciones pero funciona PARECE**/
  def festival = _festival
  def festival_=(unFestival: Festival) {
    _festival = unFestival
    nochesDisponibles = HomeNoches.noches.filter { _.festival == festival }
  }
  
  def fila = _fila
  def fila_=(unaFila: Fila) {
    _fila = unaFila
    butacasDisponibles = HomeButacas.butacas.filter { x => (x.fila == fila && x.sector == sector)}
  }
  
  def sector = _sector
  def sector_=(unSector: Sector) {
    _sector = unSector
    butacasDisponibles = HomeButacas.butacas.filter {x => (x.fila == fila && x.sector == sector)}
  }
  
  /**Fin Getters y Setters**/
  

  //	Para cada Entrada
  var tipoEntrada: Entrada = _
  var noche: Noche = _
  var tipoDeCliente: TipoCliente = _
  var butaca: Butaca = _
  var _fila: Fila = _
  var _sector: Sector = _
  var precioDeVenta: Double = _
  
  
  var nochesDisponibles:JList[Noche] = _
  var butacasDisponibles: JList[Butaca] = _
  def precioEnPesos: String = { return "$" + precioDeVenta }

  def clearTodo() = {
    tipoDePago = null
    nombre = null
    apellido = null
    entradas = null
    festival = null
    clearEntrada()
  }

  def clearEntrada() = {
    tipoEntrada = null
    noche = null
    tipoDeCliente = null
    butaca = null
    fila = null
    sector = null
    precioDeVenta = 0.0
  }

  
  
  
}