package ar.edu.celulares.applicationModel

@org.uqbar.commons.utils.Observable
abstract class Buscador extends Serializable{
  
  def search();
  def clear();
}