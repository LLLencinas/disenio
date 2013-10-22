package ar.edu.celulares.home

import scala.collection.JavaConversions.asScalaBuffer
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable
import org.apache.commons.collections15.Predicate
import org.uqbar.commons.utils.ApplicationContext

import domain.Banda
import domain.Categoria
//import domain.Festival
//import domain.Noche

@Observable
object HomeBandas extends CollectionBasedHome[Banda]  {
  
  this.create(HomeCategorias.get(3), "Los Piojos");
  this.create(HomeCategorias.get(2), "Arbol");
  this.create(HomeCategorias.get(2), "La Vela Puerca");
  this.create(HomeCategorias.get(1), "NTVG");
  this.create(HomeCategorias.get(2), "Callejeros");
  this.create(HomeCategorias.get(3), "Los Autenticos Decadentes");
  this.create(HomeCategorias.get(4), "Los Rolling Stone");
  
  def create(unCategoria:Categoria,unNombre:String) {
    var banda= new Banda(unCategoria, unNombre)
    this.create(banda)
  }

  def search(nombre:String = "") = {
    bandas.filter { banda => this.coincide(banda.nombre, nombre) }
  }
  
  /*def searchXFestival(nombre:String = "", festival:Festival)  = {
    var ban: List[Banda] = List.empty[Banda];
    for(noche <- festival.noches){
      ban=ban.++(noche.bandas)
    } 
    ban=ban.removeDuplicates
    bandas.filter { banda => this.coincide(banda.nombre, nombre) }
  }*/

  def coincide(valorPosta: String, valorEntrante:String): Boolean = {
    if (valorEntrante == "") 
      return true
    return valorPosta.toString().toLowerCase().contains(valorEntrante.toString().toLowerCase())
  }
  
  def get(nombre:String = ""): Banda=
    bandas.find(banda => this.coincide(banda.nombre,nombre)).getOrElse(null) // Acá hay que pensar algo.

  def bandas: java.util.List[Banda] = allInstances


  override def getEntityType = classOf[Banda]

  override def createExample = new Banda(HomeCategorias.createExample,"Alcides")

  override def getCriterio(example: Banda) = null

}