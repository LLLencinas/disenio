package ar.edu.celulares.ui

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.windows.Dialog
import ar.edu.celulares.applicationModel.MostradorEntrada

class MenuPrincipalWindow(parent: WindowOwner) extends SimpleWindow[MostradorEntrada](parent,new MostradorEntrada) {
  //PUse el model MostradorEntrada porque sino me daba error porque no tenia ninguno, PREGUNTAR!!!!
  override def createMainTemplate(mainPanel: Panel) = {
    this. setTitle("Festival 2013 - Menu principal")
    this.setTaskDescription("Seleccione la operatoria que desea realizar")
    
    super.createMainTemplate(mainPanel)
    
  }
  
  override def createFormPanel(mainPanel: Panel) = {}
    
  override def addActions(actionsPanel: Panel) {
    new Button(actionsPanel)
      .setCaption("Preview De Entrada X")
      .onClick(new MessageSend(this,"mostrarEntradaHarco"));

    new Button(actionsPanel) //
      .setCaption("Vender Entrada")
      .onClick(new MessageSend(this,"venderEntrada"));

    new Button(actionsPanel) //
      .setCaption("Anular Entrada")
      .onClick(new MessageSend(this, "anularEntrada"));
    
    new Button(actionsPanel) //
      .setCaption("Buscar Entrada")
      .onClick(new MessageSend(this, "buscarEntradas"));
  
  }
  
  
  /**-------------ACCIONES ----------------**/
  
  def mostrarEntradaHarco(){
    this.openDialog(new MostradorEntradaWindow(this))
  }
  
  def venderEntrada(){
    this.openDialog(new VendedorEntradaWindow(this))
  }
    
  def anularEntrada(){
    this.openDialog(new MostradorEntradaWindow(this))
  }
  
  def buscarEntradas(){
    this.openDialog(new BuscadorEntradaWindow(this))
  }
  
  
  def openDialog(dialog:Dialog[_]){
    dialog.open
  }
  

}