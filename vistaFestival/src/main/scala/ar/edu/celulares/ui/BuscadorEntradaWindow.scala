package ar.edu.celulares.ui


import java.awt.Color
import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import com.uqbar.commons.collections.Transformer
import ar.edu.celulares.applicationModel.BuscadorEntrada
import org.uqbar.arena.widgets.Selector
import domain.Cliente
import org.uqbar.arena.bindings.ObservableProperty
import ar.edu.celulares.home.HomeClientes
import domain.Entrada
import ar.edu.celulares.controller.FechaTransformer


/**
 * Ventana de búsqueda de celulares.
 *
 * @see BuscadorCelular el modelo subyacente.
 *
 * @author ?
 */
class BuscadorEntradaWindow(parent: WindowOwner) extends Dialog[BuscadorEntrada](parent, new BuscadorEntrada) {

  getModelObject.search()

  
  override def createMainTemplate(mainPanel: Panel) = {
    this.setTitle("Buscador")
    this.setTaskDescription("Ingrese los parametros de busqueda")

    super.createMainTemplate(mainPanel)

    this.createResultsGrid(mainPanel)
  }

  // *************************************************************************
  // * FORMULARIO DE BUSQUEDA
  // *************************************************************************
  /**
   * El panel principal de busqueda permite filtrar un par de cosas
   */
  override def createFormPanel(mainPanel: Panel) = {
    var searchFormPanel = new Panel(mainPanel)
    searchFormPanel.setLayout(new ColumnLayout(2))

    var labelNombreCliente = new Label(searchFormPanel)
    labelNombreCliente.setText("Nombre de Cliente:")
    labelNombreCliente.setForeground(Color.BLUE)
    
    new TextBox(searchFormPanel).bindValueToProperty("nombreCliente")	

    var labelFechaDesde = new Label(searchFormPanel)
    labelFechaDesde.setText("Fecha desde(AAAA-MM-DD):")
    labelFechaDesde.setForeground(Color.BLUE)
    
    new TextBox(searchFormPanel).bindValueToProperty("fechaDesde")					
    
    var labelFechaHasta= new Label(searchFormPanel)
    labelFechaHasta.setText("Fecha hasta(AAAA-MM-DD):")
    labelFechaHasta.setForeground(Color.BLUE)
    
    new TextBox(searchFormPanel).bindValueToProperty("fechaHasta")					
  }

  /**
   * Acciones asociadas de la pantalla principal
   */
  override def addActions(actionsPanel: Panel) {
    new Button(actionsPanel)
      .setCaption("Buscar")
      .onClick(new MessageSend(getModelObject, "search"))
      .setAsDefault
      .disableOnError

    new Button(actionsPanel) //
      .setCaption("Limpiar")
      .onClick(new MessageSend(getModelObject, "clear"))
  }

  // *************************************************************************
  // ** RESULTADOS DE LA BUSQUEDA
  // *************************************************************************
  def createResultsGrid(mainPanel: Panel) {
    var table = new Table[Entrada](mainPanel, classOf[Entrada])
    table.setHeigth(200)
    table.setWidth(500)
    table.bindItemsToProperty("resultados")						
    this.describeResultsGrid(table)
  }

  /**
   * Define las columnas de la grilla Cada columna se puede bindear 1) contra una propiedad del model, como
   * en el caso del número o el nombre 2) contra un transformer que recibe el model y devuelve un tipo
   * (generalmente String), como en el caso de Recibe Resumen de Cuenta
   *
   * @param table
   */
  def describeResultsGrid(table: Table[Entrada]) {
    new Column[Entrada](table) //
      .setTitle("Nro de Factura")
      .setFixedSize(70)
      .bindContentsToProperty("nroFactura")
      
    new Column[Entrada](table) //
      .setTitle("Cliente")
      .setFixedSize(100)
      .bindContentsToProperty("nombreCliente")		

    new Column[Entrada](table) //
      .setTitle("Fecha")
      .setFixedSize(100)
      .bindContentsToTransformer(new FechaTransformer)						

    new Column[Entrada](table)
      .setTitle("Festival")
      .setFixedSize(120)
      .bindContentsToProperty("festival")							
      
   new Column[Entrada](table)
      .setTitle("Precio")
      .setFixedSize(70)
      .bindContentsToProperty("precioDeVenta")   						

  }

  // ********************************************************
  // ** Acciones
  // ********************************************************

  }

