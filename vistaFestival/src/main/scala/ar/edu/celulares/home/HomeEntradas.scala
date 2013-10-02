package ar.edu.celulares.home
import domain.Noche
import java.util.Date
import domain.Banda
import domain.Butaca
import domain.Categoria
import domain.Sector
import domain.Fila
import domain.EntradaComun
import domain.PagoEnEfectivo
import domain.Entrada
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.utils.Observable
import domain.PagoConTarjeta
import domain.SistemaVentas
import domain.Pedido
import domain.TipoCliente_Mayor
import domain.TipoCliente_Mujer
import domain.TipoCliente_Menor
import domain.TipoCliente_Jubilado
import domain.TipoCliente_MenorDe12Acompaniado
import domain.TipoCliente_MenorDe12NoAcompaniado
import domain.Cliente

@Observable
object HomeEntradas extends CollectionBasedHome[Entrada] {
  
var descuentos = List[String]("mujeres", "menores de 18", "menores de 12", "jubilados");
  SistemaVentas.descuentos = descuentos;

  var sectorA = new Sector(80.0, 'A');
  var sectorB = new Sector(60.0, 'B');
  var sectorC = new Sector(40.0, 'C');

  var fila1 = new Fila(1, 50.0);
  var fila2 = new Fila(2, 40.0);
  var fila3 = new Fila(3, 30.0);

  var pagoTarjeta = new PagoConTarjeta();
  var pagoEfectivo = new PagoEnEfectivo();

  var butaca1_1A = new Butaca(sectorA, fila1, 1);
  var butaca2_2A = new Butaca(sectorA, fila2, 2);
  var butaca3_3A = new Butaca(sectorA, fila3, 3);
  var butaca4_1B = new Butaca(sectorB, fila1, 4);
  var butaca5_2B = new Butaca(sectorB, fila2, 5);
  var butaca6_3B = new Butaca(sectorB, fila3, 6);
  var butaca7_1C = new Butaca(sectorC, fila1, 7);
  var butaca8_2C = new Butaca(sectorC, fila2, 8);
  var butaca9_3C = new Butaca(sectorC, fila3, 9);
  var butaca10_3C = new Butaca(sectorC, fila3, 10);
  var butaca11_3C = new Butaca(sectorC, fila3, 11);
  var butaca12_3C = new Butaca(sectorC, fila3, 12);
  var butaca13_3C = new Butaca(sectorC, fila3, 13);
  var butaca14_3C = new Butaca(sectorC, fila3, 14);
  var butaca15_3C = new Butaca(sectorC, fila3, 15);
  var butaca16_3C = new Butaca(sectorC, fila3, 16);
  var butaca17_3C = new Butaca(sectorC, fila3, 17);
  var butaca18_3C = new Butaca(sectorC, fila3, 18);
  var butaca19_3C = new Butaca(sectorC, fila3, 19);
  var butaca20_3C = new Butaca(sectorC, fila3, 20);
  var butaca21_3C = new Butaca(sectorC, fila3, 21);

  var butaca22_3C = new Butaca(sectorC, fila3, 22);
  var butaca23_3C = new Butaca(sectorC, fila3, 23);
  var butaca24_3C = new Butaca(sectorC, fila3, 24);
  var butaca25_3C = new Butaca(sectorC, fila3, 25);
  var butaca26_3C = new Butaca(sectorC, fila3, 26);
  var butaca27_3C = new Butaca(sectorC, fila3, 27);
  var butaca28_3C = new Butaca(sectorC, fila3, 28);
  var butaca29_3C = new Butaca(sectorC, fila3, 29);
  var butaca30_3C = new Butaca(sectorC, fila3, 30);

  var todasLasButacas = List[Butaca](butaca1_1A, butaca2_2A,
    butaca3_3A, butaca4_1B, butaca5_2B, butaca6_3B, butaca7_1C,
    butaca8_2C, butaca9_3C, butaca10_3C, butaca11_3C, butaca13_3C, butaca14_3C,
    butaca12_3C, butaca15_3C, butaca16_3C, butaca17_3C, butaca18_3C,
    butaca19_3C, butaca20_3C, butaca21_3C, butaca22_3C, butaca23_3C, butaca24_3C, butaca25_3C, butaca26_3C,
    butaca27_3C, butaca28_3C, butaca29_3C, butaca30_3C);

  var categoria1 = new Categoria(1, 00.0);
  var categoria2 = new Categoria(2, 50.0);
  var categoria3 = new Categoria(3, 100.0);
  var categoria4 = new Categoria(4, 200.0);

  var losPiojos = new Banda(categoria3, "Los Piojos");
  var arbol = new Banda(categoria2, "Arbol");
  var laVelaPuerca = new Banda(categoria2, "La Vela Puerca");
  var NTVG = new Banda(categoria1, "NTVG");
  var callejeros = new Banda(categoria2, "Callejeros");
  var losAutentiosDecadentes = new Banda(categoria3, "Los Autenticos Decadentes");
  var rollingStone = new Banda(categoria4, "Los Rolling Stone");

  var noche1 = new Noche(new Date(2013, 7, 20), 20, 1, List[Banda](losPiojos), todasLasButacas);
  var noche2 = new Noche(new Date(2013, 7, 21), 20, 2, List[Banda](arbol), todasLasButacas);
  var noche3 = new Noche(new Date(2013, 7, 22), 19, 3, List[Banda](laVelaPuerca, NTVG), todasLasButacas);
  var noche4 = new Noche(new Date(2013, 7, 23), 19, 4, List[Banda](callejeros, rollingStone), todasLasButacas);
  var noche5 = new Noche(new Date(2013, 7, 24), 21, 5, List[Banda](losAutentiosDecadentes), todasLasButacas);

  SistemaVentas.noches = List[Noche](noche1, noche2, noche3, noche4, noche5);

  /*
 	 * Carlos es mayor
 	 * Jose es jubilado
 	 * facundo es menor
 	 * pablo es menor
 	 * pedrito es menor acompañado
 	 * florencia es mujer
 	 */
 	
 	var clienteMayor = new TipoCliente_Mayor(); 
 	var clienteMujer = new TipoCliente_Mujer();
 	var clienteMenor = new TipoCliente_Menor();
 	var clienteJubilado = new TipoCliente_Jubilado();
 	var clienteMenor12Acompaniado = new TipoCliente_MenorDe12Acompaniado();
 	var clienteMenor12NoAcompaniado = new TipoCliente_MenorDe12NoAcompaniado();
 	
 	var carlos    = new Cliente("Carlos", "Fernandez", "5432524545", "|40 anios|DNI = 17.897.364|Nacionalidad = Argentino|Sexo = Masculino");
 	var jose      = new Cliente("Josa", "Gomez", "123324545", "|60 anios|DNI = 8.897.364|Nacionalidad = Argentino|Sexo = Masculino");
 	var facundo   = new Cliente("Facundo", "Hernandez", "862466754", "|15 anios|DNI = 42.897.364|Nacionalidad = Argentino|Sexo = Masculino");
 	var pablo     = new Cliente("Pablo", "Gimenez", "543252654", "|20 anios|DNI = 37.897.364|Nacionalidad = Argentino|Sexo = Masculino");
 	var pedrito   = new Cliente("Pedrito", "Benitez", "4532524545", "|11 anios|DNI = 47.897.364|Nacionalidad = Argentino|Sexo = Masculino");
 	var florencia = new Cliente("Florencia", "Rodriguez", "734624545", "|19 anios|DNI = 39.897.364|Nacionalidad = Argentino|Sexo = Femenino");
  
 
  def getEntradaHarco(): Entrada = {    
		  var unaEntrada = new EntradaComun(carlos,clienteMayor,noche1,butaca1_1A)
//		  unaEntrada.cliente= carlos
//		  unaEntrada.noche= noche1
//		  unaEntrada.nroFactura = 1
//		  unaEntrada.precioDeVenta= 200.0
//		  unaEntrada.butaca = butaca1_1A
		  return unaEntrada
  }
  

	def entradas: java.util.List[Entrada] = allInstances
  
  
  	override def getEntityType = classOf[Entrada]

	override def createExample = new EntradaComun(carlos,clienteMayor,noche1,butaca1_1A)

	override def getCriterio(example: Entrada) = null
    
}