package domain

import java.util.Date
import java.util.Calendar

import org.uqbar.commons.utils.Observable

@Observable
object SistemaVentas {
	var noches: List[Noche] = List.empty[Noche];
	var entradasVendidas: List[Entrada] = List.empty[Entrada];
	var diasMinDescuentoAnticipada: Int = 30;
	var porcentajeDescuentoAnticipada:Double = 0.10;
	var bandas: List[Banda] = List.empty[Banda];
	var descuentos: List[String] = List.empty[String];
	var pagosPendientes: List[Pago] = List.empty[Pago];


def cantidadEntradas():Int ={
  var entradas=0;
  for(unaNoche <- noches){
    entradas += unaNoche.butacas.length;
  }
  return entradas;
}

def entradasDeMujeresConDescVendidas(): Int ={
  entradasVendidas.filter(entrada =>(entrada.cliente.isInstanceOf[Cliente_Mujer])).length;
  return 0;
}

	
def crearEntrada(unCliente: Cliente, unPedido: Pedido): Entrada = {

    var ultNroFact:Int=0;
	if(entradasVendidas.size==0)
	   ultNroFact=1;
   else	
	   ultNroFact = entradasVendidas.last.nroFactura + 1
   var entrada= unPedido.generarEntrada();
   entrada.butaca=unPedido._butaca;
   entrada.cliente = unCliente;
   entrada.nroFactura = ultNroFact;
   entrada.precioDeVenta = entrada.precioFinal();
   
   return entrada;
 }
 
  def crearEntradas(unCliente: Cliente,pedidos: List[Pedido]): List[Entrada] = {
	var entradas:List[Entrada]= List.empty[Entrada];
	var costoTotal:Double =0;
	var ultNroFact:Int=0;
	
    for(pedido <- pedidos){
      var unaEntrada = crearEntrada(unCliente, pedido);
      costoTotal= costoTotal + unaEntrada.precioDeVenta;
      //println("precio de entrada combo"+ unaEntrada.precioDeVenta);
      entradas=entradas.+:(unaEntrada);
    }
    
    if(costoTotal > 1000.0){
    	for(entrada <- entradas){
    		entrada.precioDeVenta=entrada.precioDeVenta*0.90;
    	}
    }
    
   return entradas;
 }
 
	
 def buscarEntradaVendida(unNroFactura: Int): Entrada = {
   var nro= unNroFactura
   return entradasVendidas.filter(e=>(e.nroFactura == nro)).head
 }
 
 
 //entradasVendidas.filter(e=>(e.cliente.isInstanceOf[Cliente_Mujer])
 
  
 def calcularDescuentoAnticipa(precio: Double, noche: Noche): Double = {
   var hoy = new Date();
   var diffInDays =  diferenciasDeFechas(noche.fecha, hoy);
   
   	//println("diferencia de dias con la fecha=" + diffInDays );
		 if (diffInDays > diasMinDescuentoAnticipada) {
		   return precio*porcentajeDescuentoAnticipada;
		 }
		 else{
		   return 0.0;
		 }
   return 0.0; 
  }
 
 def precioFinal(entrada: Entrada): Double = {
   var valorEntradaBase = entrada.butaca.precioBase();
   var valorExtraPorNoche = entrada.noche.valorExtra();
   var descuentoTipoPersona = entrada.cliente.dtoTipoPersona(valorEntradaBase);
   var precio = valorEntradaBase + valorExtraPorNoche - descuentoTipoPersona;
   var dtoAnticipada = this.calcularDescuentoAnticipa(precio, entrada.noche);
   
   return  precio - dtoAnticipada;
    
  }
 
 
 //Esta funcion no funciona bien, busque por internet y no funco ninguna.LUCAS
 //FIXME
  def diferenciasDeFechas(fechaInicial:Date, fechaFinal:Date):Int = {
    var diff = new Date(fechaFinal.getTime() - fechaInicial.getTime());

    var calendar = Calendar.getInstance();
    calendar.setTime(diff);
    var hours = calendar.get(Calendar.HOUR_OF_DAY);
    var minutes = calendar.get(Calendar.MINUTE);
    var seconds = calendar.get(Calendar.SECOND);
    var days = calendar.get(Calendar.DAY_OF_MONTH);
    return days

    
  }
  
  //Funcion cambia la categoria de una banda de forma din�mica
  //Por ahora hice el test con un setter nomas, 
  //porque me daba error en el filter,
  //Parece que no encontrabaa a ninguno con ese nombre
  def cambiarCategoriaBanda(nombreBanda: String, id: Int, costoExtra: Double){
	 var bandaBuscada =	((bandas.filter(unaBanda=>unaBanda.nombre == nombreBanda)).head)
	 bandaBuscada.categoria(new Categoria(id,costoExtra))
	 
  }
  
  def agregarPagoPendiente(unaEntrada:Entrada,nombre:String,tarjeta:String) {
    pagosPendientes.+:(new Pago(unaEntrada,nombre,tarjeta));
    
  }
  
  def agregarBanda(unaBanda:Banda){
     bandas = bandas.+:(unaBanda);
  }
  
  def agregarDescuento(unDescuento: String ){
    descuentos = descuentos.+:(unDescuento);
  }
  
  def sacarDescuento(unDescuento: String){
    var nuevosDescuentos = descuentos.filterNot(elemento => elemento.equals(unDescuento));
    descuentos = nuevosDescuentos;
    
  }
  
  
    
    //final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al d�a 
//		 var hoy = new Date(); //Fecha de hoy 
//     
//		  
//		 var calendar = new GregorianCalendar(fechaInicial.getYear(), 
//		     fechaInicial.getMonth()-1, fechaInicial.getDate()); 
//		 var fecha = new java.sql.Date(calendar.getTimeInMillis());
//		 
//		 var diferencia = ( hoy.getTime() - fecha.getTime() )/MILLSECS_PER_DAY; 
//		 System.out.println(diferencia)
//    
    
/*
        var df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        var fechaInicioString = df.format(fechaInicial);

        var fechaInicial2 = df.parse(fechaInicioString);
        var fechaFinalString = df.format(fechaFinal);
        var fechaFinal2 = df.parse(fechaFinalString);
        

        var fechaInicialMs = fechaInicial2.getTime();
        var fechaFinalMs = fechaFinal2.getTime();
        var diferencia = fechaFinalMs - fechaInicialMs;
        var dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return (dias.asInstanceOf[Int]);
        * 
        */
//    }
 
 
}