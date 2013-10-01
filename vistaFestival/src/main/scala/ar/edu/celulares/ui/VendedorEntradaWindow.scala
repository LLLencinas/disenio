package ar.edu.celulares.ui

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import java.awt.Color
import org.uqbar.arena.windows.SimpleWindow
import ar.edu.celulares.applicationModel.MostradorEntrada
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.actions.MessageSend

class VendedorEntradaWindow(parent: WindowOwner) extends Dialog[MostradorEntrada](parent,new MostradorEntrada) {
  
  getModelObject().cargarEntradaharco
  
  override def createMainTemplate(mainPanel: Panel) = {
    this. setTitle("Vendedor de Entradas")
    this.setTaskDescription("Ingrese los datos necesarios para generar la entrada")
    
    super.createMainTemplate(mainPanel)
    
  }
  
  override def createFormPanel(mainPanel: Panel) = {
	var verEntradaPanel = new Panel(mainPanel)
	verEntradaPanel.setLayout(new ColumnLayout(2))

    new Label(verEntradaPanel).setText("Numero de Factura:")
    new Label(verEntradaPanel) .setForeground(Color.RED)
		.bindValueToProperty("nroFactura")
		
	new Label(verEntradaPanel).setText("Cliente:")
    new Label(verEntradaPanel).setForeground(Color.RED)
		.bindValueToProperty("cliente")
		
	new Label(verEntradaPanel).setText("Precio:")
    new Label(verEntradaPanel).setForeground(Color.RED)
		.bindValueToProperty("precioEnPesos")
		
	new Label(verEntradaPanel).setText("Noche:")
    new Label(verEntradaPanel).setForeground(Color.RED)
		.bindValueToProperty("noche")	
		
    new Label(verEntradaPanel).setText("Butaca:")
    new Label(verEntradaPanel).setForeground(Color.RED)
		.bindValueToProperty("butaca")
		
	new Label(verEntradaPanel).setText("Tipo de Pago:")
    new Label(verEntradaPanel).setForeground(Color.RED)
		.bindValueToProperty("tipoDePago")
    

    //Creo un label por cada informacion que tenga de la entrada
  }
    
	override def addActions(actions: Panel) = {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(new MessageSend(this, "accept"))
			.setAsDefault.disableOnError

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick(new MessageSend(this, "cancel"))
	}
  

}