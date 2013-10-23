package ar.edu.celulares.applicationModel
import domain._

@org.uqbar.commons.utils.Observable
abstract class Buscador extends Serializable{
  def search();
  def clear();
}