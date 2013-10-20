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
import domain.Pedido
import domain.TipoCliente_Mayor
import domain.TipoCliente_Mujer
import domain.TipoCliente_Menor
import domain.TipoCliente_Jubilado
import domain.TipoCliente_MenorDe12Acompaniado
import domain.TipoCliente_MenorDe12NoAcompaniado
import domain.Cliente
import domain.Festival
import domain.Pago
import org.joda.time.DateTime
import domain.NroFactura

@Observable
object HomeEntradas extends CollectionBasedHome[Entrada] {

  def entradas: java.util.List[Entrada] = allInstances

  override def getEntityType = classOf[Entrada]

  override def createExample = new EntradaComun(HomePuestosDeVenta.createExample,HomeClientes.createExample, HomeTipoDeClientes.createExample,
      HomeNoches.createExample, HomeButacas.createExample)

  override def getCriterio(example: Entrada) = null

}