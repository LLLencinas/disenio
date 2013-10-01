package domain

import java.util.Date
import org.uqbar.commons.utils.Observable

@Observable
class Noche(unaFecha:Date,unaHora:Int, unId :Int,
    lasBandas:List[Banda],lasButacas:List[Butaca]) {
  
	var fecha: Date = unaFecha;
	var horaInicio: Int = unaHora;
	var bandas: List[Banda] = lasBandas;
	var butacasLibres: List[Butaca] = lasButacas;
	var butacasDePromocion: List[Butaca] = List.empty[Butaca];;
	var butacas: List[Butaca] = lasButacas;
	var id: Int  = unId;
	
	def reservarButaca(unaButacaPromocional: Butaca, suCodigo: String): Boolean ={
	  unaButacaPromocional.setCodigo(suCodigo);
	  butacasLibres= butacasLibres.diff(List(unaButacaPromocional));
  	  butacasDePromocion= butacasDePromocion.+:(unaButacaPromocional);
	  return true
	}
	
	
	def valorExtra():Double = {
	  return this.maxCategoria().costoExtra;
	}
	
	def maxCategoria():Categoria = {
			var categorias: List[Categoria] = bandas map {unaBanda => unaBanda.categoria};
		    
			var maximo:Categoria = categorias maxBy {_.nivel}
			println( "El Costo extra de  " + maximo.nivel + "es " + maximo.costoExtra );
			return maximo
	}
	
	def cambiarCategoriaBanda(unNombreBanda:String, unId: Int, costoExtra: Int){
	  
	}

	override def toString():String = {
	  return "" + id + ""	//Si o si tengo que devolver un String
	}
}