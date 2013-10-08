package ar.edu.celulares.applicationModel

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

@org.uqbar.commons.utils.Observable
class VendedorEntrada extends Serializable {
  //	Para todas las entradas
  var tipoDePago: TipoDePago = _
  var nombre: String = _
  var apellido: String = _
  var entradas: List[Entrada] = _
  var festival: Festival = _

  //	Para cada Entrada
  var tipoEntrada: Entrada = _
  var noche: Noche = _
  var tipoDeCliente: TipoCliente = _
  var butaca: Butaca = _
  var fila: Fila = _
  var sector: Sector = _
  var precioDeVenta: Double = _
  
//  var noches:Seq[Noche] = 

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