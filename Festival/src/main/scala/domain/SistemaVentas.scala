package domain

/*
import org.joda.time._
import org.joda.convert._
import org.uqbar.commons.utils.Observable
import org.joda.time.format.DateTimeFormatter

@Observable
object SistemaVentas {
  var noches: List[Noche] = List.empty[Noche];
  var entradasVendidas: List[Entrada] = List.empty[Entrada];
  var diasMinDescuentoAnticipada: Int = 30;
  var porcentajeDescuentoAnticipada: Double = 0.10;
  var bandas: List[Banda] = List.empty[Banda];
  var descuentos: List[String] = List.empty[String];
  var pagosPendientes: List[Pago] = List.empty[Pago];

  def cantidadEntradas(): Int = {
    println("Sistema de ventas: cantidad de entradas vendiddas")
    var entradas = 0;
    for (unaNoche <- noches) {
      entradas += unaNoche.butacas.length;
    }
    return entradas;
  }

  def entradasDeMujeresConDescVendidas(): Int = {
    println("Sistema de ventas: entradasDeMujeresConDescuentosVendidas")
    return entradasVendidas.filter(entrada => (entrada.tipoCliente.isInstanceOf[TipoCliente_Mujer])).length;

  }

  def buscarEntradaVendida(unNroFactura: Int): Entrada = {
    println("Sistema de ventas: buscarEntradaVendida")
    var nro = unNroFactura
    return entradasVendidas.filter(e => (e.nroFactura == nro)).head
  }

  //entradasVendidas.filter(e=>(e.cliente.isInstanceOf[Cliente_Mujer])

  def calcularDescuentoAnticipa(precio: Double, noche: Noche, fechaDeCompra: DateTime): Double = {

    //System.out.println("Fecha de COmpra: " + fechaDeCompra.getDayOfMonth());
    //System.out.println("Noche: " + noche.fecha.getDayOfMonth());
	println("Sistema de ventas: calcularDescuentoAnticipada")
    var diffInDays = diferenciasDeFechas(fechaDeCompra, noche.fecha);
    if (diffInDays > diasMinDescuentoAnticipada) {
      return precio * porcentajeDescuentoAnticipada;
    } else {
      return 0.0;
    }
    return 0.0;
  }

  //  def precioFinal(entrada: Entrada): Double = {
  //    var valorEntradaBase = entrada.butaca.precioBase();
  //    var valorExtraPorNoche = entrada.noche.valorExtra();
  //    var descuentoTipoPersona = entrada.tipoCliente.dtoTipoPersona(valorEntradaBase);
  //    var precio = valorEntradaBase + valorExtraPorNoche - descuentoTipoPersona;
  //    var dtoAnticipada = this.calcularDescuentoAnticipa(precio, entrada.noche);
  //
  //    return precio - dtoAnticipada;
  //
  //  }

  def diferenciasDeFechas(fechaInicial: DateTime, fechaFinal: DateTime): Int = Days.daysBetween(fechaInicial, fechaFinal).getDays()

  //Funcion que realiza el cobro de todas los pagos pendientes
  //TODO Completar para que se pueda implementar los pagos luego de que queden pendientes
  def cobrarPagos() {
    println("Sistema de ventas: cobrar Pagos")
    for (unPago <- this.pagosPendientes) {
      unPago.cobrar()
    }

  }

  //Funcion cambia la categoria de una banda de forma dinï¿½mica
  //Por ahora hice el test con un setter nomas, 
  //porque me daba error en el filter,
  //Parece que no encontrabaa a ninguno con ese nombre
  def cambiarCategoriaBanda(nombreBanda: String, id: Int, costoExtra: Double) {
    println("Sistema de ventas: cambiarCategoria de bandas")
    var bandaBuscada = ((bandas.filter(unaBanda => unaBanda.nombre == nombreBanda)).head)
    bandaBuscada.categoria(new Categoria(id, costoExtra))

  }

  def agregarPagoPendiente(unPago: Pago) {
    pagosPendientes = pagosPendientes.+:(unPago);

  }

  def agregarBanda(unaBanda: Banda) {
    bandas = bandas.+:(unaBanda);
  }

  def agregarDescuento(unDescuento: String) {
    descuentos = descuentos.+:(unDescuento);
  }

  def sacarDescuento(unDescuento: String) {
    var nuevosDescuentos = descuentos.filterNot(elemento => elemento.equals(unDescuento));
    descuentos = nuevosDescuentos;

  }
}
 */