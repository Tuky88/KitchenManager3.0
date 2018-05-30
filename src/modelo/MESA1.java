/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Axel Reyez
 */

import DAO.ComplementoDAO;
import DAO.CreditoDAO;
import DAO.DespuesDAO;
import DAO.EmpleadoDAO;
import DAO.ProductoDAO;
import DAO.TicketDAO;
import DAO.VentasDAO;
import DAO.ZetDAO;
import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableColumnModel;
import java.awt.Desktop;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MESA1 extends javax.swing.JPanel {

   double x,tot=0,valor=0,i=0;
    double maximo=0;
    double superestado=0,turno=0;
    double subtotal=0;
   int estado=0;
    String nombre;
    String user;
    String BD;
    String ruta;
    String rutaC;
    String rutareporte;
    String rutaticket;
   double paquete=0;

  
    
     Tablachida modelo;
     Tablachida modelo6;
     RowSorter<TableModel> sorter = new TableRowSorter<>(modelo);

     
   boolean t=true;
   boolean f=false;
          
    public MESA1(String nombre,String BD,String Usuario) throws IllegalAccessException, InstantiationException, ClassNotFoundException, Exception {
        this.BD=BD;
        this.nombre=nombre;
        this.user=Usuario;  
    ruta="C:\\Users\\"+user+"\\Documents\\Comanda\\";
    rutaC="C:\\Users\\"+user+"\\Documents\\Comanda\\comanda.txt";
    rutareporte="C:\\Users\\"+user+"\\Documents\\Reportes\\";
    rutaticket="C:\\Users\\"+user+"\\Documents\\Tickets\\";
        try {
              
             UIManager.setLookAndFeel("UpperEssential.UpperEssentialLookAndFeel");
         } catch (UnsupportedLookAndFeelException ex) {
             Logger.getLogger(Chapatas.class.getName()).log(Level.SEVERE, null, ex);
         }
         Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
UIManager.put("OptionPane.messageFont", font);
UIManager.put("OptionPane.buttonFont", font);
UIManager.put("JComboBox.MaximumRowCount",12);
UIManager.put("JComboBox.Background",Color.white);
   
        initComponents();
       trampita1.setVisible(f);
       trampita2.setVisible(f);
       
       
         this.continfo.setVisible(f);
         if(nombre.equals("OUT"))
         {
             this.acttrampita();
            
         }
reiniciador();        
       // actualizar("todas");
VentasDAO ventivirips=new VentasDAO(BD);
TicketDAO ticket=new TicketDAO(BD);
maximo=ventivirips.getVentas();

turno=ticket.getNumero();
    String cabecera []={"Producto","Precio","#C"};
    String cabecera1 []={"Producto","Precio"};
    String datos[][]={};

modelo = new Tablachida(datos,cabecera);

modelo6 = new Tablachida(datos,cabecera1);
ComandaM1.setModel(modelo);
int val=350;
int val1=25;
TableColumnModel columnModel = ComandaM1.getColumnModel();
columnModel.getColumn(0).setPreferredWidth(val);
columnModel.getColumn(1).setPreferredWidth(val1);
columnModel.getColumn(2).setPreferredWidth(val1);


reloj hilo=new reloj(Hora);


 hilo.start();

DateFormat df= DateFormat.getDateInstance();
Date Fecha = new Date();
int tamaño=30;
ComandaM1.setRowHeight(tamaño);


DateFormat df2 = DateFormat.getDateInstance(DateFormat.LONG);
Dia.setText(df2.format(Fecha));


    }
    public String getNombreLlevar()
    {
        return this.Nombrellevar.getText();
    }
    public String getNumeroLlevar()
    {
        return this.Telefonollevar.getText();
    }
    public String getDireccionLlevar()
    {
        return this.Direccionllevar.getText();
    }
      public void reiniciador()
{
    
    this.CPan.setVisible(false);
this.CCarne.setVisible(false);
this.CAderezo.setVisible(false);
this.CQueso.setVisible(false);
this.BebidaC.setVisible(false);
this.BebidaF.setVisible(false);
this.CEspecial.setVisible(false);
this.CPAlitas.setVisible(false);
this.CPCostillas.setVisible(false);
this.CPostre.setVisible(false);
this.CPasta.setVisible(false);
this.CSalsa.setVisible(false);
this.CDesayuno.setVisible(false);
this.CPPasta.setVisible(false);
this.CPSalsa.setVisible(false);
        this.limpiar.setVisible(false);
this.Agregar.setEnabled(false);
         ComandaM1.setRowSorter(sorter);
         this.CSaborD.setVisible(f);
         this.CSaborS.setVisible(f);
         this.CPSaborD.setVisible(f);
         this.CPSaborS.setVisible(f);
this.PPasta.setVisible(false);
this.PEnsalada.setVisible(false);
this.PCrepa.setVisible(false);
        this.HPaquete.setVisible(false);
    
}
      public void acttrampita()
      {
          trampita1.doClick();
      }

    void limpiarTabla()
{
     for(int i=0;i<modelo.getRowCount();i++)
        {
            
            modelo.removeRow(i);
            i=i-1;
        }
}


    public String getNamed()
{
    return this.nombre;
}

    void eliminar(){
    double resta;
    String sub,valors;
    double sub1,valor1;
   resta=(double) modelo.getValueAt(ComandaM1.getSelectedRow(),1);
   


   sub=this.TotalC.getText();
   sub1=Double.parseDouble(sub);
   valor1=sub1-resta;
   tot-=resta;
   valors=Double.toString(valor1);
    modelo.removeRow(ComandaM1.getSelectedRow());
    this.TotalC.setText(valors);
}
    

   public void Registro(double sumita) 
    {
     VentasDAO ventivirips=new VentasDAO(BD);
TicketDAO ticket=new TicketDAO(BD);
ventivirips.RegistrarVenta(sumita);
ticket.AumentarConteo();
    }

double valor(String cadenita){
    valor=0;
    String comanda=cadenita;
    String cadenita2;
                
                 cadenita2=cadenita.substring(0,cadenita.indexOf("/"));
    if(comanda.contains("Especial") ||comanda.contains("Bebida") ||comanda.contains("Postre") 
            ||comanda.contains("Desayuno"))
    {
        cadenita2=cadenita.substring(cadenita2.length()+1,cadenita.length());
        if(cadenita2.contains("Alitas") || cadenita2.contains("Costillas") || cadenita2.contains("Huevos al gusto"))
        {
            cadenita2=cadenita2.substring(0,cadenita2.indexOf("/"));
        }
        if(cadenita.contains("Bebida"))
                {
                    cadenita2=cadenita2.substring(0,cadenita2.indexOf("/"));
                }
        
    }
    if(cadenita.contains("1/2"))
    {
        valor+=paqueteprecio();
    }
 
ProductoDAO p=new ProductoDAO(BD);
valor+=p.getPrecio(cadenita2);

    return valor;
}
double paqueteprecio()
{
    valor=0;
 ProductoDAO p=new ProductoDAO(BD);
valor+=p.getPrecio("Paquete");

    return valor;
}

    public void limpiar(){
        
        this.Agregar.setEnabled(false);
        extra.clearSelection();
        if(this.HPaquete.isSelected())
            this.HPaquete.doClick();
        this.BebidaC.setSelectedIndex(0);
this.BebidaF.setSelectedIndex(0);
this.CEspecial.setSelectedIndex(0);
this.CPAlitas.setSelectedIndex(0);
this.CPCostillas.setSelectedIndex(0);
this.CPostre.setSelectedIndex(0);
this.BebidaC.setSelectedIndex(0);
    this.CPan.setSelectedIndex(0);
    this.CCarne.setSelectedIndex(0);
    this.CAderezo.setSelectedIndex(0);
    this.CQueso.setSelectedIndex(0);
    this.CSaborD.setSelectedIndex(0);
    this.CSaborS.setSelectedIndex(0);
    this.CPasta.setSelectedIndex(0);
    this.CSalsa.setSelectedIndex(0);
   this.BebidaF.setSelectedIndex(0);
    this.CPSaborD.setSelectedIndex(0);
    this.CPPasta.setSelectedIndex(0);
    this.CPSalsa.setSelectedIndex(0);
    this.CDesayuno.setSelectedIndex(0);
    this.limpiarMenu();
    this.Efectivo.setSelected(t);
}
 
    int paquete()
    {
    int resp = 1;
     if(this.PCrepa.isSelected() || this.PPasta.isSelected() || this.PEnsalada.isSelected())
         {
             if(this.PPasta.isSelected())
             {
                 if(this.CPPasta.getSelectedIndex()!=0 && this.CPSalsa.getSelectedIndex()!=0){
                 resp=0;
             }
                 else 
                 {
                     resp=2;
                 }
             }
             if(this.PEnsalada.isSelected())
             {
                 resp=0;
             }
             if(this.PCrepa.isSelected())
             {
                 if((this.CPSaborD.getSelectedIndex()==0 && this.CPSaborS.getSelectedIndex()!=0) || (this.CPSaborD.getSelectedIndex()!=0 && this.CPSaborS.getSelectedIndex()==0))
                 {
                 resp=0;
                 }
                 else
                 {
                     resp=2;
                 }
               
             }
        } 
    if(resp==0){
    return 0; 
    }
    else
     {
     return 1;
    }
}
public double extracomplemento(String nom)
{
    ComplementoDAO com=new ComplementoDAO(BD);
    return com.buscarCargoExtra(nom);
}
    void  enviaratabla(String nombre)
 {
    
    
    x=valor(nombre);
    x+=extracomplemento(nombre);
   String num=(String)this.numC.getValue();
  Object datos[]={nombre,x,num};
  tot=x+tot;
  this.TotalC.setText(Double.toString(tot));
modelo.addRow(datos);  
}

 
void imprimircomanda() 
{
        try {
            String ruta=rutaC;
            File archivo = new File(ruta);
            BufferedWriter bw=null;
            bw = new BufferedWriter(new FileWriter(archivo));
             bw.write("\n"+nombre+"\n");
             bw.write(Hora.getText());
            for(int i=0;i<this.ComandaM1.getRowCount();i++)
            {
                String cadenita=(String)this.ComandaM1.getValueAt(i,0);
                bw.write("\n\n"+cadenita );
            }
            bw.close();
            Desktop d = Desktop.getDesktop();
            /*Verifica que el ambiente del SO soporte los procedimientos*/
            if(Desktop.isDesktopSupported()){
                /*si es así manos a la obra*/
                d.print(new File(ruta));
                
            }
           
        } catch (IOException ex) {
            Logger.getLogger(MESA1.class.getName()).log(Level.SEVERE, null, ex);
        }
}
void imprimirTicket(String Encabezado,int estado,int tipo)  
{
    try{
        TicketDAO ticket= new TicketDAO(BD);
        
     String ruta =rutaticket+
this.Dia.getText()+"#1"+".txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Chatapas Bistro\n");
            bw.write(nombre+"\n");
            bw.write("Ticket:#"+ticket.getNumero());
            bw.write(Encabezado+"\n");
            DateFormat df= DateFormat.getDateInstance();
Date Fecha = new Date();
String tipito;
switch(tipo)
{
    case 0:
        tipito="Efectivo";
    break;
    case 1:
        tipito="Credito";
    break;
    case 2:
        tipito="Mixto";
    break;
    case 3:
        tipito="Zet";
        break;
    default:
        tipito="Otro";
}
DateFormat df2 = DateFormat.getDateInstance(DateFormat.SHORT);
            bw.write("\t\t"+df2.format(Fecha));
            bw.write("\n");
            bw.write("\t\t"+"Pago en:"+tipito);
            bw.write("\n");
            bw.write("\nCliente:1"+"\n");
            int actual=0,anterior=0;
            int i=0;
            do
            {
                
                if(i>0)
                {
                    
                    
                    actual=Integer.parseInt((String)this.ComandaM1.getValueAt(i,2));
                    anterior=Integer.parseInt((String)this.ComandaM1.getValueAt(i-1,2));
                    subtotal+=(double)this.ComandaM1.getValueAt(i-1,1);
                    if(actual!=(anterior))
                    {
                        
                        bw.write("\nSubtotal:\t$"+subtotal+"\n");
                        bw.write("\nCliente:"+actual+"\n");
                        subtotal=0;
                    }
                }
                String cadenita=(String)this.ComandaM1.getValueAt(i,0);
                 String comanda, cadenita2;
                
                 cadenita2=cadenita.substring(0,cadenita.indexOf("/"));
                 comanda=cadenita2;
    if(comanda.contains("Especial") ||comanda.contains("Bebida") ||comanda.contains("Postre") 
            ||comanda.contains("Desayuno"))
    {
        cadenita2=cadenita.substring(cadenita2.length()+1,cadenita.length());
        if(cadenita2.contains("Alitas") || cadenita2.contains("Costillas") || cadenita2.contains("Huevos al gusto"))
        {
            cadenita2=cadenita2.substring(0,cadenita2.indexOf("/"));
        }
        if(cadenita.contains("Bebida"))
                {
                    cadenita2=cadenita2.substring(0,cadenita2.indexOf("/"));
                }
    }
                 if(estado==0)
                 {
                     contar(cadenita2);
                 }
               bw.write("\n"+cadenita2 + "\t\t$"+ this.ComandaM1.getValueAt(i,1));
               i++;
            }while(i<this.ComandaM1.getRowCount());
            if(!this.ComandaM1.getValueAt(i-1,2).equals("1"))
            {
                subtotal+=(double)this.ComandaM1.getValueAt(i-1,1);
            bw.write("\nSubtotal:\t$"+subtotal+"\n");
            }
            bw.write("\n");
            bw.write("\n" +"Total:\t$"+this.TotalC.getText() );
            //bw.write("\n\t"+c.generarCantidad(this.TotalC.getText().substring(0,this.TotalC.getText().indexOf("."))));
            bw.write("\n" +"Pago:\t$" +this.PagoC.getText());
             //bw.write("\n"+c.generarCantidad(this.PagoC.getText().substring(0,this.PagoC.getText().indexOf("."))));
            bw.write("\n" +"Cambio:\t$" +this.CambioC.getText());
             //bw.write("\n"+c.generarCantidad(this.CambioC.getText().substring(0,this.CambioC.getText().indexOf("."))));
            if(!this.getNombreLlevar().equals("-"))
            {
            bw.write("\n\n\nCliente:"+this.getNombreLlevar());
            bw.write("\nTelefono:"+this.getNumeroLlevar());
            bw.write("\nDireccion:"+this.getDireccionLlevar());
            bw.write("\n");
            }
            bw.write("\n\nGRACIAS POR SU PREFERENCIA" );
            subtotal=0;
        
        bw.close();
        
       Desktop d = Desktop.getDesktop();
        /*Verifica que el ambiente del SO soporte los procedimientos*/
        if(Desktop.isDesktopSupported()){
            /*si es así manos a la obra*/
           d.print(new File(ruta));
          
        }
       
    } catch (IOException ex) {
        
ex.printStackTrace();

}
}

private void duplicar() {
        double valor;
        String comanda; 
        comanda=(String) modelo.getValueAt(this.ComandaM1.getSelectedRow(), 0);
        valor=(double)modelo.getValueAt(this.ComandaM1.getSelectedRow(),1); 
        
        Object datos[]={comanda,valor};
  tot+=valor;
  this.TotalC.setText(Double.toString(tot));
modelo.addRow(datos);  
        
    }

private void Apaquete(){
    String cadenin = (String)this.ComandaM1.getValueAt(ComandaM1.getSelectedRow(),0);
String cadenin2=cadenin.substring(0,cadenin.indexOf("/"));
        if(cadenin2.equals("Pizza") || cadenin2.equals("Chatapa") || cadenin2.equals("Crepa") || cadenin2.equals("Pasta") || cadenin2.equals("Pizzeta") )
            
{
   if(!((String)this.ComandaM1.getValueAt(ComandaM1.getSelectedRow(),0)).contains("1/2"))
{
    String cadenon="1/2 ";
    int opcion = JOptionPane.showOptionDialog(null, "¿Que complemento desea agregar?", "ADVERTENCIA!", 2, JOptionPane.WARNING_MESSAGE, null, new String[]{"Ensalada", "Pasta","Crepa"}, null); 
switch(opcion)
        {
            case 0:
            cadenon+="Ensalada";
                break;
            case 1:
            cadenon+="Pasta";
            break;
            case 2:
            cadenon+="Crepa";
            break;
        }
if(opcion>=1)
{
    cadenon+="/"+JOptionPane.showInputDialog(null,"Especificaciones:");
}
       
this.ComandaM1.setValueAt((Object)cadenin+cadenon,ComandaM1.getSelectedRow(),0);
tot+=paqueteprecio();
double valoractual=(double)this.ComandaM1.getValueAt(ComandaM1.getSelectedRow(),1);
double valoractual2= (valoractual)+paqueteprecio();
this.ComandaM1.setValueAt((Object)valoractual2,ComandaM1.getSelectedRow(),1);
this.TotalC.setText(Double.toString(tot));
}
else
{
    JOptionPane.showMessageDialog(null,"Ya es paquete");
} 
}

else
    JOptionPane.showMessageDialog(null,"Operacion no permitida");
    
}
private void Asolo(){
   String cadenin = (String)this.ComandaM1.getValueAt(ComandaM1.getSelectedRow(),0);

   if(((String)this.ComandaM1.getValueAt(ComandaM1.getSelectedRow(),0)).contains("1/2"))
{
    String cadenin2=cadenin.substring(0,cadenin.indexOf("1"));
    String cadenon="1/2 ";
    
this.ComandaM1.setValueAt((Object)cadenin2,ComandaM1.getSelectedRow(),0);
tot-=paqueteprecio();
double valoractual=(double)this.ComandaM1.getValueAt(ComandaM1.getSelectedRow(),1);
double valoractual2= (valoractual)-paqueteprecio();
this.ComandaM1.setValueAt((Object)valoractual2,ComandaM1.getSelectedRow(),1);
this.TotalC.setText(Double.toString(tot));
}
else
{
    JOptionPane.showMessageDialog(null,"No es paquete");
}
   
}

void cargarpan()
{
    
        this.CPan.removeAllItems();
        this.CPan.addItem("Pan");
    ComplementoDAO cp=new ComplementoDAO(BD);
    LinkedList ls;
    ls=cp.getDatos("Pan");
    while(!ls.isEmpty())
    {
        Complemento com=new Complemento((Complemento)ls.pop());
        this.CPan.addItem(com.getNombre());
    }
}
void cargarqueso()
{
    String data="Queso";
    
        this.CQueso.removeAllItems();
        this.CQueso.addItem(data);
ComplementoDAO cp=new ComplementoDAO(BD);
    LinkedList ls;
    ls=cp.getDatos("Queso");
    while(!ls.isEmpty())
    {
        Complemento com=new Complemento((Complemento)ls.pop());
        this.CQueso.addItem(com.getNombre());
    }
}
void cargaraderezo()
{
    String data="Aderezo";
    
        this.CAderezo.removeAllItems();
        this.CAderezo.addItem(data);

        ComplementoDAO cp=new ComplementoDAO(BD);
    LinkedList ls;
    ls=cp.getDatos("Aderezo");
    while(!ls.isEmpty())
    {
        Complemento com=new Complemento((Complemento)ls.pop());
        this.CAderezo.addItem(com.getNombre());
    }
}
void cargarcarne()
{
    String data="Carne";
        this.CCarne.removeAllItems();
        this.CCarne.addItem(data);
           data="Saladas";
        this.CSaborS.removeAllItems();
        this.CSaborS.addItem(data);
        this.CPSaborS.removeAllItems();
        this.CPSaborS.addItem(data);

        ComplementoDAO cp=new ComplementoDAO(BD);
    LinkedList ls;
    ls=cp.getDatos("Carne");
    while(!ls.isEmpty())
    {
        Complemento com=new Complemento((Complemento)ls.pop());
        this.CCarne.addItem(com.getNombre());
        this.CSaborS.addItem(com.getNombre());
        this.CPSaborS.addItem(com.getNombre());
    }
}
void cargarcrepad()
{
    String data="Dulces";
        this.CSaborD.removeAllItems();
        this.CSaborD.addItem(data);
        this.CPSaborD.removeAllItems();
        this.CPSaborD.addItem(data);
        ComplementoDAO cp=new ComplementoDAO(BD);
    LinkedList ls;
    ls=cp.getDatos("crepad");
    while(!ls.isEmpty())
    {
        Complemento com=new Complemento((Complemento)ls.pop());
        this.CSaborD.addItem(com.getNombre());
        this.CPSaborD.addItem(com.getNombre());
    }

}
void cargarpasta()
{
    String data="Pasta";
    
        this.CPasta.removeAllItems();
        this.CPasta.addItem(data);
        this.CPPasta.removeAllItems();
        this.CPPasta.addItem(data);
       
        ComplementoDAO cp=new ComplementoDAO(BD);
    LinkedList ls;
    ls=cp.getDatos("pasta");
    while(!ls.isEmpty())
    {
        Complemento com=new Complemento((Complemento)ls.pop());
        this.CPasta.addItem(com.getNombre());
        this.CPPasta.addItem(com.getNombre());
    }
}
void cargaralitas()
{
    String data="Alitas";
    
        this.CPAlitas.removeAllItems();
        this.CPAlitas.addItem(data);
        ComplementoDAO cp=new ComplementoDAO(BD);
        LinkedList ls;
        ls=cp.getDatos("alitas");
        while(!ls.isEmpty())
        {
        Complemento com=new Complemento((Complemento)ls.pop());
        this.CPAlitas.addItem(com.getNombre());
        }
}
void cargarcostillas()
{
    String data="Costillas";
    
         this.CPCostillas.removeAllItems();
         this.CPCostillas.addItem(data);
        ComplementoDAO cp=new ComplementoDAO(BD);
        LinkedList ls;
        ls=cp.getDatos("costillas");
        while(!ls.isEmpty())
            {
            Complemento com=new Complemento((Complemento)ls.pop());
            this.CPCostillas.addItem(com.getNombre());
            }
}
void cargarsalsa()
{
    String data="Salsa";
    
        this.CSalsa.removeAllItems();
        this.CSalsa.addItem(data);
        this.CPSalsa.removeAllItems();
        this.CPSalsa.addItem(data);
        ComplementoDAO cp=new ComplementoDAO(BD);
        LinkedList ls;
        ls=cp.getDatos("salsa");
        while(!ls.isEmpty())
            {
            Complemento com=new Complemento((Complemento)ls.pop());
            this.CSalsa.addItem(com.getNombre());
            this.CPSalsa.addItem(com.getNombre());
            }
}
void cargarbebidaf()
{
    String data="Frías";
    
        this.BebidaF.removeAllItems();
        this.BebidaF.addItem(data);
        ProductoDAO cp=new ProductoDAO(BD);
        LinkedList ls;
        ls=cp.getDatos("bebidaf");
        while(!ls.isEmpty())
            {
            Complemento com=new Complemento((Complemento)ls.pop());
            this.BebidaF.addItem(com.getNombre());
            }
}
void cargarbebidac()
{
    String data="Calientes";
    
        this.BebidaC.removeAllItems();
        this.BebidaC.addItem(data);

        ProductoDAO cp=new ProductoDAO(BD);
        LinkedList ls;
        ls=cp.getDatos("bebidac");
        while(!ls.isEmpty())
            {
            Complemento com=new Complemento((Complemento)ls.pop());
            this.BebidaC.addItem(com.getNombre());
            }
}
void cargardesayuno()
{
    String data="Desayuno";
    
        this.CDesayuno.removeAllItems();
        this.CDesayuno.addItem(data);

        ProductoDAO cp=new ProductoDAO(BD);
        LinkedList ls;
        ls=cp.getDatos("desayuno");
        while(!ls.isEmpty())
            {
            Complemento com=new Complemento((Complemento)ls.pop());
            this.CDesayuno.addItem(com.getNombre());
            }
}
void cargarespecial()
{
    String data="Especial";
    
        this.CEspecial.removeAllItems();
        this.CEspecial.addItem(data);

        ProductoDAO cp=new ProductoDAO(BD);
        LinkedList ls;
        ls=cp.getDatos("especial");
        while(!ls.isEmpty())
            {
            Complemento com=new Complemento((Complemento)ls.pop());
            this.CEspecial.addItem(com.getNombre());
            }
}
void cargarpostre()
{
    String data="Postre";
    
        this.CPostre.removeAllItems();
        this.CPostre.addItem(data);

        ProductoDAO cp=new ProductoDAO(BD);
        LinkedList ls;
        ls=cp.getDatos("postre");
        while(!ls.isEmpty())
            {
            Complemento com=new Complemento((Complemento)ls.pop());
            this.CPostre.addItem(com.getNombre());
            }
}
public void actualizar(String name)
{
    switch(name)
    {
        case "Paquete":
             paquete=paqueteprecio();
        case "pan":
            this.cargarpan();
        break;
            case "queso":
            this.cargarqueso();
        break;
                case "aderezo":
            this.cargaraderezo();
        break;
                    case "carne":
            this.cargarcarne();
        break;
                        case "crepad":
            this.cargarcrepad();
        break;
                            case "pasta":
            this.cargarpasta();
        break;
                                case "alitas":
            this.cargaralitas();
        break;
                                    case "costillas":
            this.cargarcostillas();
        break;
         case "salsa":
            this.cargarsalsa();
        break;
             case "bebidaf":
            this.cargarbebidaf();
        break;
                 case "bebidac":
            cargarbebidac();
        break;
                     case "desayuno":
            cargardesayuno();
        break;
                         case "especial":
            cargarespecial();
        break;
                             case "postre":
            cargarpostre();
        break;
                             case "todas":
            this.cargarpan();
       paquete=paqueteprecio();
            this.cargarqueso();
        
            this.cargaraderezo();
        
            this.cargarcarne();
       
            this.cargarcrepad();
        
            this.cargarpasta();
       
            this.cargaralitas();
        
            this.cargarcostillas();
       
            this.cargarsalsa();
       
            this.cargarbebidaf();
       
            this.cargarbebidac();
       
            this.cargardesayuno();
       
            this.cargarespecial();
        
            this.cargarpostre();
            System.out.println("yes");
                                 break;
            
                                                    
    }
    
}


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        apgo = new javax.swing.ButtonGroup();
        pedidos = new javax.swing.ButtonGroup();
        extra = new javax.swing.ButtonGroup();
        derecho = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        Duplicar = new javax.swing.JMenuItem();
        ConvertirPaquete = new javax.swing.JMenuItem();
        ConvertirSolo = new javax.swing.JMenuItem();
        CobrarIndividual = new javax.swing.JMenuItem();
        Imprimir = new javax.swing.JMenuItem();
        Mover = new javax.swing.JMenu();
        mesad1 = new javax.swing.JMenuItem();
        mesad2 = new javax.swing.JMenuItem();
        mesad3 = new javax.swing.JMenuItem();
        mesad4 = new javax.swing.JMenuItem();
        mesad5 = new javax.swing.JMenuItem();
        mesad6 = new javax.swing.JMenuItem();
        mesad7 = new javax.swing.JMenuItem();
        mesad8 = new javax.swing.JMenuItem();
        chapatas1 = new modelo.Chapatas();
        jMenuItem1 = new javax.swing.JMenuItem();
        contenedor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComandaM1 = new javax.swing.JTable();
        area = new javax.swing.JPanel();
        Agregar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        CPCostillas = new javax.swing.JComboBox();
        CPAlitas = new javax.swing.JComboBox();
        CPSaborS = new javax.swing.JComboBox();
        CPSaborD = new javax.swing.JComboBox();
        CPSalsa = new javax.swing.JComboBox();
        CPPasta = new javax.swing.JComboBox();
        jPanel39 = new javax.swing.JPanel();
        numC = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        PPasta = new javax.swing.JRadioButton();
        PEnsalada = new javax.swing.JRadioButton();
        PCrepa = new javax.swing.JRadioButton();
        HPaquete = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        Chatapa = new javax.swing.JRadioButton();
        Pizzeta = new javax.swing.JRadioButton();
        Crepa = new javax.swing.JRadioButton();
        Pasta = new javax.swing.JRadioButton();
        Bebida = new javax.swing.JRadioButton();
        Desayuno = new javax.swing.JRadioButton();
        Ensalada = new javax.swing.JRadioButton();
        Postre = new javax.swing.JRadioButton();
        Especiales = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        CPan = new javax.swing.JComboBox();
        CCarne = new javax.swing.JComboBox();
        CQueso = new javax.swing.JComboBox();
        CAderezo = new javax.swing.JComboBox();
        CDesayuno = new javax.swing.JComboBox();
        BebidaF = new javax.swing.JComboBox();
        BebidaC = new javax.swing.JComboBox();
        CSaborD = new javax.swing.JComboBox();
        CSaborS = new javax.swing.JComboBox();
        CPasta = new javax.swing.JComboBox();
        CSalsa = new javax.swing.JComboBox();
        CEspecial = new javax.swing.JComboBox();
        CPostre = new javax.swing.JComboBox();
        trampita1 = new javax.swing.JButton();
        trampita2 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        Total = new javax.swing.JLabel();
        Pago = new javax.swing.JLabel();
        Cambio = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        Liberar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        TotalC = new javax.swing.JFormattedTextField();
        CambioC = new javax.swing.JFormattedTextField();
        PagoC = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        Efectivo = new javax.swing.JRadioButton();
        PagarDespues = new javax.swing.JRadioButton();
        Mixto = new javax.swing.JRadioButton();
        Tarjeta = new javax.swing.JRadioButton();
        Zet = new javax.swing.JRadioButton();
        Dia = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        ImprimirComanda = new javax.swing.JButton();
        continfo = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Direccionllevar = new javax.swing.JTextArea();
        Total7 = new javax.swing.JLabel();
        Nombrellevar = new javax.swing.JTextField();
        Telefonollevar = new javax.swing.JTextField();
        Pago7 = new javax.swing.JLabel();
        Cambio7 = new javax.swing.JLabel();

        derecho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                derechoMouseClicked(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        derecho.add(Eliminar);

        Duplicar.setText("Duplicar");
        Duplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DuplicarActionPerformed(evt);
            }
        });
        derecho.add(Duplicar);

        ConvertirPaquete.setText("APaquete");
        ConvertirPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertirPaqueteActionPerformed(evt);
            }
        });
        derecho.add(ConvertirPaquete);

        ConvertirSolo.setText("ASolo");
        ConvertirSolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertirSoloActionPerformed(evt);
            }
        });
        derecho.add(ConvertirSolo);

        CobrarIndividual.setText("CobrarIndividual");
        CobrarIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CobrarIndividualActionPerformed(evt);
            }
        });
        derecho.add(CobrarIndividual);

        Imprimir.setText("Imprimir ");
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });
        derecho.add(Imprimir);

        Mover.setText("Mover");
        Mover.setToolTipText("");

        mesad1.setText("Mesa1");
        Mover.add(mesad1);

        mesad2.setText("Mesa2");
        Mover.add(mesad2);

        mesad3.setText("Mesa3");
        Mover.add(mesad3);

        mesad4.setText("Mesa4");
        Mover.add(mesad4);

        mesad5.setText("Mesa5");
        Mover.add(mesad5);

        mesad6.setText("Barra1");
        Mover.add(mesad6);

        mesad7.setText("Barra2");
        Mover.add(mesad7);

        mesad8.setText("OUT");
        Mover.add(mesad8);

        derecho.add(Mover);

        jMenuItem1.setText("jMenuItem1");

        contenedor.setBackground(new java.awt.Color(255, 255, 255));

        ComandaM1.setAutoCreateRowSorter(true);
        ComandaM1.setFont(new java.awt.Font("Ebrima", 0, 10)); // NOI18N
        ComandaM1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Producto", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ComandaM1.setComponentPopupMenu(derecho);
        ComandaM1.setGridColor(new java.awt.Color(0, 102, 204));
        ComandaM1.setSelectionForeground(new java.awt.Color(51, 0, 51));
        jScrollPane1.setViewportView(ComandaM1);

        area.setBackground(new java.awt.Color(255, 255, 255));
        area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));
        area.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                areaMouseMoved(evt);
            }
        });

        Agregar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Agregar.setForeground(new java.awt.Color(0, 102, 204));
        Agregar.setText("Agregar");
        Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AgregarMouseClicked(evt);
            }
        });
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        CPCostillas.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CPCostillas.setForeground(new java.awt.Color(0, 102, 204));
        CPCostillas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Costillas" }));
        CPCostillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPCostillasActionPerformed(evt);
            }
        });

        CPAlitas.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CPAlitas.setForeground(new java.awt.Color(0, 102, 204));
        CPAlitas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alitas" }));
        CPAlitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPAlitasActionPerformed(evt);
            }
        });

        CPSaborS.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CPSaborS.setForeground(new java.awt.Color(0, 102, 204));
        CPSaborS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Saladas" }));
        CPSaborS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPSaborSActionPerformed(evt);
            }
        });

        CPSaborD.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CPSaborD.setForeground(new java.awt.Color(0, 102, 204));
        CPSaborD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dulces" }));
        CPSaborD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPSaborDActionPerformed(evt);
            }
        });

        CPSalsa.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CPSalsa.setForeground(new java.awt.Color(0, 102, 204));
        CPSalsa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Salsa" }));
        CPSalsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPSalsaActionPerformed(evt);
            }
        });

        CPPasta.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CPPasta.setForeground(new java.awt.Color(0, 102, 204));
        CPPasta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pasta" }));
        CPPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPPastaActionPerformed(evt);
            }
        });

        numC.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        numC.setModel(new javax.swing.SpinnerListModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        numC.setAutoscrolls(true);
        numC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 255), 2, true));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(numC, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(numC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("Cliente:");

        extra.add(PPasta);
        PPasta.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        PPasta.setForeground(new java.awt.Color(51, 51, 255));
        PPasta.setText("Pasta");
        PPasta.setContentAreaFilled(false);
        PPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPastaActionPerformed(evt);
            }
        });

        extra.add(PEnsalada);
        PEnsalada.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        PEnsalada.setForeground(new java.awt.Color(51, 51, 255));
        PEnsalada.setText("Ensalada");
        PEnsalada.setContentAreaFilled(false);
        PEnsalada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PEnsaladaActionPerformed(evt);
            }
        });

        extra.add(PCrepa);
        PCrepa.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        PCrepa.setForeground(new java.awt.Color(51, 51, 255));
        PCrepa.setText("Crepa");
        PCrepa.setContentAreaFilled(false);
        PCrepa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCrepaActionPerformed(evt);
            }
        });

        HPaquete.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        HPaquete.setForeground(new java.awt.Color(51, 51, 255));
        HPaquete.setText("Hazlo paquete");
        HPaquete.setContentAreaFilled(false);
        HPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HPaqueteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CPPasta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CPSalsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CPSaborD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(CPSaborS, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CPAlitas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PPasta)
                            .addComponent(PEnsalada)
                            .addComponent(PCrepa))
                        .addGap(30, 30, 30)
                        .addComponent(HPaquete)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPCostillas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPCostillas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPAlitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPSaborS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPSaborD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPSalsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPPasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(HPaquete)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(PPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PEnsalada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PCrepa)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pedidos.add(Chatapa);
        Chatapa.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        Chatapa.setForeground(new java.awt.Color(51, 51, 255));
        Chatapa.setText("Chatapa");
        Chatapa.setContentAreaFilled(false);
        Chatapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChatapaActionPerformed(evt);
            }
        });

        pedidos.add(Pizzeta);
        Pizzeta.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        Pizzeta.setForeground(new java.awt.Color(51, 51, 255));
        Pizzeta.setText("Pizzeta");
        Pizzeta.setContentAreaFilled(false);
        Pizzeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PizzetaActionPerformed(evt);
            }
        });

        pedidos.add(Crepa);
        Crepa.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        Crepa.setForeground(new java.awt.Color(51, 51, 255));
        Crepa.setText("Crepa");
        Crepa.setContentAreaFilled(false);
        Crepa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrepaActionPerformed(evt);
            }
        });

        pedidos.add(Pasta);
        Pasta.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        Pasta.setForeground(new java.awt.Color(51, 51, 255));
        Pasta.setText("Pasta");
        Pasta.setContentAreaFilled(false);
        Pasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PastaActionPerformed(evt);
            }
        });

        pedidos.add(Bebida);
        Bebida.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        Bebida.setForeground(new java.awt.Color(51, 51, 255));
        Bebida.setText("Bebida");
        Bebida.setContentAreaFilled(false);
        Bebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BebidaActionPerformed(evt);
            }
        });

        pedidos.add(Desayuno);
        Desayuno.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        Desayuno.setForeground(new java.awt.Color(51, 51, 255));
        Desayuno.setText("Desayuno");
        Desayuno.setContentAreaFilled(false);
        Desayuno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesayunoActionPerformed(evt);
            }
        });

        pedidos.add(Ensalada);
        Ensalada.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        Ensalada.setForeground(new java.awt.Color(51, 51, 255));
        Ensalada.setText("Ensalada");
        Ensalada.setContentAreaFilled(false);
        Ensalada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnsaladaActionPerformed(evt);
            }
        });

        pedidos.add(Postre);
        Postre.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        Postre.setForeground(new java.awt.Color(51, 51, 255));
        Postre.setText("Postre");
        Postre.setContentAreaFilled(false);
        Postre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostreActionPerformed(evt);
            }
        });

        pedidos.add(Especiales);
        Especiales.setFont(new java.awt.Font("Sylfaen", 0, 17)); // NOI18N
        Especiales.setForeground(new java.awt.Color(51, 51, 255));
        Especiales.setText("Especiales");
        Especiales.setContentAreaFilled(false);
        Especiales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EspecialesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Especiales)
                    .addComponent(Ensalada)
                    .addComponent(Postre)
                    .addComponent(Bebida)
                    .addComponent(Chatapa)
                    .addComponent(Pizzeta)
                    .addComponent(Crepa)
                    .addComponent(Pasta)
                    .addComponent(Desayuno))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(Chatapa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pizzeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Crepa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bebida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Desayuno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Ensalada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Postre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Especiales)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        CPan.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CPan.setForeground(new java.awt.Color(0, 102, 204));
        CPan.setMaximumRowCount(15);
        CPan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pan" }));
        CPan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPanActionPerformed(evt);
            }
        });

        CCarne.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CCarne.setForeground(new java.awt.Color(0, 102, 204));
        CCarne.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Carne" }));
        CCarne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCarneActionPerformed(evt);
            }
        });

        CQueso.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CQueso.setForeground(new java.awt.Color(0, 102, 204));
        CQueso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Queso" }));
        CQueso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CQuesoActionPerformed(evt);
            }
        });

        CAderezo.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CAderezo.setForeground(new java.awt.Color(0, 102, 204));
        CAderezo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aderezo" }));
        CAderezo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CAderezoActionPerformed(evt);
            }
        });

        CDesayuno.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CDesayuno.setForeground(new java.awt.Color(0, 102, 204));
        CDesayuno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Desayuno" }));
        CDesayuno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDesayunoActionPerformed(evt);
            }
        });

        BebidaF.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        BebidaF.setForeground(new java.awt.Color(0, 102, 204));
        BebidaF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Frias" }));
        BebidaF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BebidaFItemStateChanged(evt);
            }
        });
        BebidaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BebidaFActionPerformed(evt);
            }
        });

        BebidaC.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        BebidaC.setForeground(new java.awt.Color(0, 102, 204));
        BebidaC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Calientes" }));
        BebidaC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BebidaCItemStateChanged(evt);
            }
        });
        BebidaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BebidaCActionPerformed(evt);
            }
        });

        CSaborD.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CSaborD.setForeground(new java.awt.Color(0, 102, 204));
        CSaborD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dulces" }));
        CSaborD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CSaborDItemStateChanged(evt);
            }
        });
        CSaborD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSaborDActionPerformed(evt);
            }
        });

        CSaborS.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CSaborS.setForeground(new java.awt.Color(0, 102, 204));
        CSaborS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Saladas" }));
        CSaborS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CSaborSItemStateChanged(evt);
            }
        });
        CSaborS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSaborSActionPerformed(evt);
            }
        });

        CPasta.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CPasta.setForeground(new java.awt.Color(0, 102, 204));
        CPasta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pasta" }));
        CPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPastaActionPerformed(evt);
            }
        });

        CSalsa.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CSalsa.setForeground(new java.awt.Color(0, 102, 204));
        CSalsa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Salsa" }));
        CSalsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSalsaActionPerformed(evt);
            }
        });

        CEspecial.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CEspecial.setForeground(new java.awt.Color(0, 102, 204));
        CEspecial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Especial" }));
        CEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CEspecialActionPerformed(evt);
            }
        });

        CPostre.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        CPostre.setForeground(new java.awt.Color(0, 102, 204));
        CPostre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Postre" }));
        CPostre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPostreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(CPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CCarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CQueso, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CAderezo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BebidaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BebidaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CSaborD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CSaborS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CSalsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPostre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CCarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CQueso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CAderezo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BebidaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BebidaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CSaborD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CSaborS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CSalsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPostre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        trampita1.setText("jButton1");
        trampita1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trampita1ActionPerformed(evt);
            }
        });

        trampita2.setText("jButton1");
        trampita2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trampita2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout areaLayout = new javax.swing.GroupLayout(area);
        area.setLayout(areaLayout);
        areaLayout.setHorizontalGroup(
            areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, areaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar))
                .addGroup(areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(areaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(areaLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(trampita1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trampita2))))
        );
        areaLayout.setVerticalGroup(
            areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(areaLayout.createSequentialGroup()
                        .addComponent(Agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(areaLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addGroup(areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(trampita1)
                            .addComponent(trampita2))
                        .addGap(36, 36, 36)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));

        Total.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Total.setForeground(new java.awt.Color(51, 51, 255));
        Total.setText("Total:");

        Pago.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Pago.setForeground(new java.awt.Color(51, 51, 255));
        Pago.setText("Pago:");

        Cambio.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Cambio.setForeground(new java.awt.Color(51, 51, 255));
        Cambio.setText("Cambio:");

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        limpiar.setForeground(new java.awt.Color(51, 51, 255));
        limpiar.setText("Limpiar mesa");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        Liberar.setBackground(new java.awt.Color(255, 255, 255));
        Liberar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Liberar.setForeground(new java.awt.Color(51, 51, 255));
        Liberar.setText("Liberar Mesa");
        Liberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LiberarActionPerformed(evt);
            }
        });

        Cancelar.setBackground(new java.awt.Color(255, 255, 255));
        Cancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Cancelar.setForeground(new java.awt.Color(51, 51, 255));
        Cancelar.setText("Cancelar pedido");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        TotalC.setForeground(new java.awt.Color(102, 102, 255));
        TotalC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.0"))));
        TotalC.setText("0");
        TotalC.setFocusable(false);
        TotalC.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N

        CambioC.setForeground(new java.awt.Color(102, 102, 255));
        CambioC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.0"))));
        CambioC.setText("0");
        CambioC.setFocusable(false);
        CambioC.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N

        PagoC.setForeground(new java.awt.Color(102, 102, 255));
        PagoC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.0"))));
        PagoC.setText("0");
        PagoC.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        PagoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagoCActionPerformed(evt);
            }
        });
        PagoC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PagoCKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PagoCKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Total))
                            .addComponent(Pago, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Cambio, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TotalC)
                            .addComponent(CambioC, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PagoC, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Liberar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total)
                    .addComponent(TotalC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pago)
                    .addComponent(PagoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CambioC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cambio, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addComponent(limpiar)
                .addGap(2, 2, 2)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Liberar))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        jPanel9.setFocusable(false);

        Efectivo.setBackground(new java.awt.Color(0, 51, 51));
        apgo.add(Efectivo);
        Efectivo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Efectivo.setForeground(new java.awt.Color(51, 51, 255));
        Efectivo.setSelected(true);
        Efectivo.setText("Efectivo");
        Efectivo.setContentAreaFilled(false);
        Efectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EfectivoMouseClicked(evt);
            }
        });
        Efectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EfectivoActionPerformed(evt);
            }
        });

        PagarDespues.setBackground(new java.awt.Color(0, 51, 51));
        apgo.add(PagarDespues);
        PagarDespues.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PagarDespues.setForeground(new java.awt.Color(51, 51, 255));
        PagarDespues.setText("PD");
        PagarDespues.setContentAreaFilled(false);
        PagarDespues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagarDespuesActionPerformed(evt);
            }
        });

        Mixto.setBackground(new java.awt.Color(0, 51, 51));
        apgo.add(Mixto);
        Mixto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Mixto.setForeground(new java.awt.Color(51, 51, 255));
        Mixto.setText("Efectivo/Tarjeta");
        Mixto.setActionCommand("");
        Mixto.setContentAreaFilled(false);
        Mixto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MixtoActionPerformed(evt);
            }
        });

        Tarjeta.setBackground(new java.awt.Color(0, 51, 51));
        apgo.add(Tarjeta);
        Tarjeta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Tarjeta.setForeground(new java.awt.Color(51, 51, 255));
        Tarjeta.setText("Tarjeta");
        Tarjeta.setContentAreaFilled(false);
        Tarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TarjetaActionPerformed(evt);
            }
        });

        Zet.setBackground(new java.awt.Color(0, 51, 51));
        apgo.add(Zet);
        Zet.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Zet.setForeground(new java.awt.Color(51, 51, 255));
        Zet.setText("iZettle");
        Zet.setContentAreaFilled(false);
        Zet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(Efectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tarjeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Zet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mixto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PagarDespues)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Efectivo)
                    .addComponent(PagarDespues)
                    .addComponent(Mixto)
                    .addComponent(Tarjeta)
                    .addComponent(Zet)))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Dia.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        Dia.setForeground(new java.awt.Color(51, 51, 255));
        Dia.setText("jLabel3");

        Hora.setFont(new java.awt.Font("Poor Richard", 0, 30)); // NOI18N
        Hora.setForeground(new java.awt.Color(51, 51, 255));
        Hora.setText("jLabel4");

        ImprimirComanda.setBackground(new java.awt.Color(255, 255, 255));
        ImprimirComanda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ImprimirComanda.setForeground(new java.awt.Color(51, 51, 255));
        ImprimirComanda.setText("Imprimir Comanda");
        ImprimirComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirComandaActionPerformed(evt);
            }
        });

        continfo.setBackground(new java.awt.Color(255, 255, 255));
        continfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255), 2));

        Direccionllevar.setColumns(20);
        Direccionllevar.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        Direccionllevar.setRows(5);
        jScrollPane9.setViewportView(Direccionllevar);

        Total7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Total7.setForeground(new java.awt.Color(51, 51, 255));
        Total7.setText("Nombre:");

        Nombrellevar.setForeground(new java.awt.Color(0, 51, 204));
        Nombrellevar.setText("-");

        Telefonollevar.setForeground(new java.awt.Color(0, 51, 204));
        Telefonollevar.setText("-");
        Telefonollevar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefonollevarActionPerformed(evt);
            }
        });

        Pago7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Pago7.setForeground(new java.awt.Color(51, 51, 255));
        Pago7.setText("Telefono:");

        Cambio7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Cambio7.setForeground(new java.awt.Color(51, 51, 255));
        Cambio7.setText("Dirección:");

        javax.swing.GroupLayout continfoLayout = new javax.swing.GroupLayout(continfo);
        continfo.setLayout(continfoLayout);
        continfoLayout.setHorizontalGroup(
            continfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(continfoLayout.createSequentialGroup()
                .addGroup(continfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Total7)
                    .addComponent(Cambio7)
                    .addComponent(Pago7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(continfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9)
                    .addComponent(Nombrellevar)
                    .addComponent(Telefonollevar))
                .addContainerGap())
        );
        continfoLayout.setVerticalGroup(
            continfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(continfoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(continfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total7)
                    .addComponent(Nombrellevar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(continfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Telefonollevar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pago7))
                .addGap(13, 13, 13)
                .addGroup(continfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(continfoLayout.createSequentialGroup()
                        .addComponent(Cambio7)
                        .addGap(57, 57, 57))
                    .addGroup(continfoLayout.createSequentialGroup()
                        .addComponent(jScrollPane9)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(area, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ImprimirComanda, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(Hora)
                            .addComponent(Dia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addComponent(continfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addComponent(area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenedorLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(Hora)
                                .addGap(30, 30, 30)
                                .addComponent(ImprimirComanda))
                            .addGroup(contenedorLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(continfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ChatapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChatapaActionPerformed
        limpiar();

            
        // TODO add your handling code here:
    }//GEN-LAST:event_ChatapaActionPerformed

    private void PizzetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PizzetaActionPerformed
        limpiar();
        this.CCarne.setVisible(true);
        this.CAderezo.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_PizzetaActionPerformed

    private void CrepaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrepaActionPerformed
        limpiar();
        this.CSaborD.setVisible(true);
        this.CSaborS.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_CrepaActionPerformed

    private void PastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PastaActionPerformed
        limpiar();
        this.CPasta.setVisible(true);
        this.CSalsa.setVisible(true);
    }//GEN-LAST:event_PastaActionPerformed

    private void CPanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPanActionPerformed

    }//GEN-LAST:event_CPanActionPerformed

    private void HPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HPaqueteActionPerformed
        int paq;
        if(this.HPaquete.isSelected())
        {

            this.PCrepa.setVisible(true);
            this.PPasta.setVisible(true);
            this.PEnsalada.setVisible(true);
            this.PPasta.setEnabled(true);
            this.PEnsalada.setEnabled(true);
            this.PCrepa.setEnabled(true);
            this.Agregar.setEnabled(false);

        }
        else
        {
            this.PPasta.setVisible(false);
            this.PEnsalada.setVisible(false);
            this.PCrepa.setVisible(false);
            this.PPasta.setVisible(false);
            this.PEnsalada.setVisible(false);
            this.PCrepa.setVisible(false);
            this.CPPasta.setVisible(false);
            this.CPSalsa.setVisible(false);
            this.CPSaborS.setVisible(false);
            this.CPSaborD.setVisible(false);

        }
        if(this.Pasta.isSelected())
        this.PPasta.setVisible(false);
        if(this.Crepa.isSelected())
        this.PCrepa.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_HPaqueteActionPerformed

    private void CCarneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCarneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CCarneActionPerformed

    private void CAderezoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CAderezoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_CAderezoActionPerformed

    private void PPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPastaActionPerformed

        this.Agregar.setEnabled(false);
        if(this.PPasta.isSelected())
        {
            this.CPSaborS.setVisible(f);
            this.CPSaborD.setVisible(false);
            this.CPPasta.setVisible(true);
            this.CPSalsa.setVisible(true);
        }
        else
        {

            this.CPSaborD.setVisible(true);
            this.CPPasta.setVisible(false);
            this.CPSalsa.setVisible(false);
            this.CPSaborS.setVisible(f);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_PPastaActionPerformed

    private void PEnsaladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PEnsaladaActionPerformed

        if(this.PEnsalada.isSelected()){
            this.CPPasta.setVisible(false);
            this.CPSalsa.setVisible(false);
            this.CPSaborS.setVisible(f);
            this.CPSaborD.setVisible(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_PEnsaladaActionPerformed

    private void PCrepaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCrepaActionPerformed
        this.Agregar.setEnabled(false);
        if(this.PCrepa.isSelected())
        {

            this.CPSaborD.setVisible(true);
            this.CPSaborS.setVisible(true);
            this.CPPasta.setVisible(false);
            this.CPSalsa.setVisible(false);

        }
        else
        {
            this.CPSaborS.setVisible(false);
            this.CPSaborD.setVisible(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_PCrepaActionPerformed

    private void CQuesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CQuesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CQuesoActionPerformed

    private void CSaborDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSaborDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSaborDActionPerformed

    private void CSaborSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSaborSActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_CSaborSActionPerformed

    private void CPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPastaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_CPastaActionPerformed

    private void CSalsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSalsaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSalsaActionPerformed

    private void AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgregarMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_AgregarMouseClicked

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        String comanda = null;
        String complementos= null;
        String paquete = null;

        if(this.Chatapa.isSelected()){
            comanda="Chatapa";
            complementos="/";

        }
        else if(this.Pizzeta.isSelected()){
            comanda="Pizzeta";
            complementos="/" + this.CCarne.getSelectedItem() +"/" + this.CAderezo.getSelectedItem();

        }
        else if(this.Crepa.isSelected()){
            comanda="Crepa";
            if(this.CSaborD.getSelectedIndex()!=0){
                complementos="/" + this.CSaborD.getSelectedItem();
            }
            else
            complementos="/"+this.CSaborS.getSelectedItem();
        }
        else if(this.Pasta.isSelected()){
            comanda="Pasta";
            complementos="/"+this.CPasta.getSelectedItem() + "/" + this.CSalsa.getSelectedItem();
        }
        else if(this.Bebida.isSelected()){
            comanda="Bebida";
            if(this.BebidaF.getSelectedIndex()!=0){
                complementos="/" + this.BebidaF.getSelectedItem()+"/F/";

            }
            else
            complementos="/"+this.BebidaC.getSelectedItem()+"/C/";
        }
        else if(this.Desayuno.isSelected()){
            comanda="Desayuno";
            if(this.CDesayuno.getSelectedItem().equals("Huevos al gusto")){
                String huevos=JOptionPane.showInputDialog(null,"¿Cómo desea sus huevos?");
                complementos="/"+this.CDesayuno.getSelectedItem()+"/"+huevos;
            }else

            complementos="/"+this.CDesayuno.getSelectedItem();
        }
        else if(this.Ensalada.isSelected())
        {
            comanda="Ensalada";
            complementos="/"+this.CCarne.getSelectedItem()+"/"+this.CAderezo.getSelectedItem();
        }
        else if(this.Especiales.isSelected())
        {
            comanda="Especial";
            if(this.CEspecial.getSelectedItem().equals("Alitas") || this.CEspecial.getSelectedItem().equals("Costillas"))
            {
                if(this.CEspecial.getSelectedItem().equals("Alitas"))
                {
                    complementos="/"+this.CEspecial.getSelectedItem()+"/"+this.CPAlitas.getSelectedItem();
                }
                else
                complementos="/"+this.CEspecial.getSelectedItem()+"/"+this.CPCostillas.getSelectedItem();
            }
            else
            complementos="/"+this.CEspecial.getSelectedItem();
        }
        else if(this.Postre.isSelected())
        {
            comanda="Postre";
            complementos="/"+this.CPostre.getSelectedItem();
        }
        if(this.HPaquete.isSelected()){
            if(this.PPasta.isSelected()){
                paquete="Pasta/" + this.CPPasta.getSelectedItem()+ "/" + this.CPSalsa.getSelectedItem();
            }
            if(this.PEnsalada.isSelected()){
                paquete="Ensalada";
            }
            if(this.PCrepa.isSelected()){
                paquete="Crepa/" + this.CPSaborD.getSelectedItem();
            }
        }

        comanda=comanda+complementos;
        int confirmado;String fina="";
        if(this.HPaquete.isSelected()){
            fina=comanda+"1/2"+paquete;

        }
        else{
            if(!this.HPaquete.isSelected()){
                fina=comanda;

            }
        }

        enviaratabla(fina);

        double debe,paga,cambia;
        this.TotalC.setText(Double.toString(tot));
        if(!this.PagoC.getText().equals(""))
        {
            paga=Double.parseDouble(this.PagoC.getText());
            debe=tot;
            cambia=paga-debe;
            if(cambia>=0)
            this.CambioC.setText(Double.toString(cambia));
            else
            this.CambioC.setText("$");
        }
        else
        this.PagoC.setText("0");

    }//GEN-LAST:event_AgregarActionPerformed

    private void CPSaborDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPSaborDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPSaborDActionPerformed

    private void CPPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPPastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPPastaActionPerformed

    private void CPSalsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPSalsaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPSalsaActionPerformed

    private void BebidaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BebidaFActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_BebidaFActionPerformed

    private void BebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BebidaActionPerformed
        limpiar();
        this.CPan.setVisible(false);
        this.CCarne.setVisible(false);
        this.CAderezo.setVisible(false);
        this.CQueso.setVisible(false);
        this.CSaborD.setVisible(false);
        this.CSaborS.setVisible(false);

        this.CPasta.setVisible(false);
        this.CSalsa.setVisible(false);
        this.BebidaC.setVisible(true);
        this.BebidaF.setVisible(true);
        this.CEspecial.setVisible(false);
        this.CPAlitas.setVisible(false);
        this.CPCostillas.setVisible(false);
        this.CPostre.setVisible(false);
        this.BebidaF.setVisible(true);
        this.CDesayuno.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_BebidaActionPerformed

    private void DesayunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesayunoActionPerformed
        limpiar();
        this.CPan.setVisible(false);
        this.CCarne.setVisible(false);
        this.CAderezo.setVisible(false);
        this.CQueso.setVisible(false);
        this.CSaborD.setVisible(false);
        this.CSaborS.setVisible(false);
        this.CPasta.setVisible(false);
        this.CSalsa.setVisible(false);
        this.BebidaC.setVisible(false);
        this.BebidaF.setVisible(false);
        this.CEspecial.setVisible(false);
        this.CPAlitas.setVisible(false);
        this.CPCostillas.setVisible(false);
        this.CPostre.setVisible(false);
        this.BebidaF.setVisible(false);
        this.CDesayuno.setVisible(true);
        this.HPaquete.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_DesayunoActionPerformed

    private void CDesayunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDesayunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CDesayunoActionPerformed

    private void EnsaladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnsaladaActionPerformed
        limpiar();
        this.CPan.setVisible(false);
        this.CCarne.setVisible(true);
        this.CAderezo.setVisible(true);
        this.CQueso.setVisible(false);
        this.CSaborD.setVisible(false);
        this.CSaborS.setVisible(false);
        this.CPasta.setVisible(false);
        this.CSalsa.setVisible(false);
        this.BebidaC.setVisible(false);
        this.BebidaF.setVisible(false);
        this.CEspecial.setVisible(false);
        this.CPAlitas.setVisible(false);
        this.CPCostillas.setVisible(false);
        this.CPostre.setVisible(false);
        this.BebidaF.setVisible(false);
        this.CDesayuno.setVisible(false);
        this.HPaquete.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_EnsaladaActionPerformed

    private void PostreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostreActionPerformed
        limpiar();
        this.CPan.setVisible(false);
        this.CCarne.setVisible(false);
        this.CAderezo.setVisible(false);
        this.CQueso.setVisible(false);
        this.CSaborD.setVisible(false);
        this.CSaborS.setVisible(false);
        this.CPasta.setVisible(false);
        this.CSalsa.setVisible(false);
        this.BebidaC.setVisible(false);
        this.BebidaF.setVisible(false);
        this.CEspecial.setVisible(f);
        this.CPAlitas.setVisible(false);
        this.CPCostillas.setVisible(false);
        this.CPostre.setVisible(t);
        this.BebidaF.setVisible(false);
        this.CDesayuno.setVisible(false);
        this.HPaquete.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_PostreActionPerformed

    private void EspecialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EspecialesActionPerformed
        limpiar();
        this.CPan.setVisible(false);
        this.CCarne.setVisible(false);
        this.CAderezo.setVisible(false);
        this.CQueso.setVisible(false);
        this.CSaborD.setVisible(false);
        this.CSaborS.setVisible(false);
        this.CPasta.setVisible(false);
        this.CSalsa.setVisible(false);
        this.BebidaC.setVisible(false);
        this.BebidaF.setVisible(false);
        this.CEspecial.setVisible(t);
        this.CPAlitas.setVisible(false);
        this.CPCostillas.setVisible(false);
        this.CPostre.setVisible(false);
        this.BebidaF.setVisible(false);
        this.CDesayuno.setVisible(f);
        this.HPaquete.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_EspecialesActionPerformed

    private void BebidaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BebidaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BebidaCActionPerformed

    private void CPostreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPostreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPostreActionPerformed

    private void CEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CEspecialActionPerformed
        if(this.CEspecial.getItemCount()!=0)
        {
            if(this.CEspecial.getSelectedItem().equals("Alitas"))
            {
                this.CPAlitas.setVisible(t);
            }
            if(this.CEspecial.getSelectedItem().equals("Costillas"))
            {
                this.CPCostillas.setVisible(t);
            }
            else
            {
                this.CPCostillas.setVisible(f);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_CEspecialActionPerformed

    private void CPSaborSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPSaborSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPSaborSActionPerformed

    private void CPAlitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPAlitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPAlitasActionPerformed

    private void CPCostillasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPCostillasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPCostillasActionPerformed

    private void areaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaMouseMoved

        if(this.Chatapa.isSelected() || this.Pizzeta.isSelected() || this.Crepa.isSelected() || this.Pasta.isSelected() 
            || this.Bebida.isSelected() || this.Desayuno.isSelected() || this.Ensalada.isSelected() || this.Postre.isSelected() || this.Especiales.isSelected())
        {
            if(this.Chatapa.isSelected())
            {
                this.HPaquete.setVisible(true);
                
                    if(this.HPaquete.isSelected()){
                        if(paquete()==0){
                            this.Agregar.setEnabled(true);
                        }
                        else
                        {
                            this.Agregar.setEnabled(false);
                        }
                    }
                    else{
                        this.Agregar.setEnabled(true);
                    }

                

            }
            else if(this.Pizzeta.isSelected())
            {
                this.HPaquete.setVisible(true);
                if(this.CCarne.getSelectedIndex()!=0 && this.CAderezo.getSelectedIndex()!=0 )
                {
                    if(this.HPaquete.isSelected()){
                        if(paquete()==0){
                            this.Agregar.setEnabled(true);
                        }
                        else
                        {
                            this.Agregar.setEnabled(false);
                        }
                    }
                    else{
                        this.Agregar.setEnabled(true);
                    }
                }
            }
            else if(this.Crepa.isSelected())
            {
                this.HPaquete.setVisible(true);

                if(this.HPaquete.isSelected()){
                    if(paquete()==0){
                        if((this.CSaborD.getSelectedIndex()==0 && this.CSaborS.getSelectedIndex()!=0) || (this.CSaborD.getSelectedIndex()!=0 && this.CSaborS.getSelectedIndex()==0))
                        {
                            this.Agregar.setEnabled(t);
                        }
                        else
                        this.Agregar.setEnabled(f);
                    }else
                    {
                        this.Agregar.setEnabled(false);
                    }
                }
                else{
                    if((this.CSaborD.getSelectedIndex()==0 && this.CSaborS.getSelectedIndex()!=0) || (this.CSaborD.getSelectedIndex()!=0 && this.CSaborS.getSelectedIndex()==0))
                    {
                        this.Agregar.setEnabled(t);
                    }
                    else
                    this.Agregar.setEnabled(f);

                }

            }
            else if(this.Pasta.isSelected())
            {
                this.HPaquete.setVisible(true);
                if((this.CPasta.getSelectedIndex()!=0 && this.CSalsa.getSelectedIndex()!=0))
                {
                    if(this.HPaquete.isSelected()){
                        if(paquete()==0){
                            this.Agregar.setEnabled(true);
                        }
                        else
                        {
                            this.Agregar.setEnabled(false);
                        }
                    }
                    else{
                        this.Agregar.setEnabled(true);
                    }
                }
                else{
                    this.Agregar.setEnabled(false);
                }
            }

                else if(this.Bebida.isSelected()){
                    this.HPaquete.setVisible(false);
                    if((this.BebidaF.getSelectedIndex()!=0 && this.BebidaC.getSelectedIndex()==0) || (this.BebidaF.getSelectedIndex()==0 && this.BebidaC.getSelectedIndex()!=0)){
                        this.Agregar.setEnabled(t);
                    }
                    else{
                        this.Agregar.setEnabled(false);
                    }

                }

                else if(this.Desayuno.isSelected()){
                    this.HPaquete.setVisible(false);
                    if((this.CDesayuno.getSelectedIndex()!=0)){
                        if(this.HPaquete.isSelected()){

                        }else{
                            this.Agregar.setEnabled(true);
                        }
                    }
                    else{
                        this.Agregar.setEnabled(false);
                    }

                }
                else if(this.Especiales.isSelected())
                {
                    if(this.CEspecial.getSelectedItem().equals("Alitas"))
                    {
                        if(this.CPAlitas.getSelectedIndex()!=0)
                        {
                            this.Agregar.setEnabled(true);
                        }
                        else
                        {
                            this.Agregar.setEnabled(f);
                        }
                    }
                    else if(this.CEspecial.getSelectedItem()=="Costillas")
                    {
                        if(this.CPCostillas.getSelectedIndex()!=0)
                        {
                            this.Agregar.setEnabled(true);
                        }
                        else
                        {
                            this.Agregar.setEnabled(f);
                        }
                    }
                    else if(this.CEspecial.getSelectedIndex()!=0)
                    {
                        this.Agregar.setEnabled(t);
                    }
                    else
                    {
                        this.Agregar.setEnabled(f);
                    }
                }
                else if(this.Postre.isSelected())
                {
                    if(this.CPostre.getSelectedIndex()!=0)
                    {
                        this.Agregar.setEnabled(t);
                    }
                    else
                    this.Agregar.setEnabled(f);
                }
                else if(this.Ensalada.isSelected())
                {
                    if(this.CCarne.getSelectedIndex()!=0 && this.CAderezo.getSelectedIndex()!=0)
                    {
                        this.Agregar.setEnabled(t);
                    }
                    else
                    this.Agregar.setEnabled(f);
                }

            }
    }//GEN-LAST:event_areaMouseMoved
public void agregarACredito(double tot)
{
    CreditoDAO credito=new CreditoDAO(BD);
    credito.Agregar(tot);
}
public void agregarAZet(double tot)
{
    ZetDAO zet=new ZetDAO(BD);
    zet.Agregar(tot);
}
    public void agregarventa(double tot)
{
    VentasDAO ventas=new VentasDAO(BD);
    ventas.insertarVenta(tot);
}
    public void cobrarTarjeta(double tot)
{
    agregarventa(tot); 
    agregarACredito(tot);
    Registro(tot);
                            
}
    public void cobrarZet(double tot)
{
    agregarventa(tot); 
    agregarAZet(tot);
    Registro(tot);
                            
}
public void cobrarEfectivo(double tot)
{
    agregarventa(tot);
    Registro(tot);
}
public void cobrarMixto(double tot)
{
    Registro(tot);
    agregarventa(tot);
                             
                            double cuanto;
                            String validar;
                            validar=JOptionPane.showInputDialog(this,"Cuanto desea pagar con Tarjeta");
                            while(validar.trim().length()==0)
                            {
                                validar=JOptionPane.showInputDialog(this,"Cuanto desea pagar con Tarjeta");
                            }
                            cuanto=Double.parseDouble(validar);
                            if(cuanto<tot)
                            {
                                double residuo=tot-cuanto;
                               JOptionPane.showConfirmDialog(this,"Falta por pagar:$"+residuo);
                               agregarACredito(cuanto);
                            }
}
public void CobrarDespues(double tot)
{
    DespuesDAO d=new DespuesDAO(BD);
    d.InsertarVenta(tot, this.Nombrellevar.getText(),this.Telefonollevar.getText());
    
}
    private void LiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LiberarActionPerformed

        if(this.TotalC.getText().equals("0"))
        {
            JOptionPane.showMessageDialog(this,"Mesa vacía");
        }
        else
        {
            if(this.PagoC.getText().equals("$") || this.CambioC.getText().equals("$"))
            {
                JOptionPane.showMessageDialog(this,"Falta pagar");
            }
            else
            {
                if(this.Tarjeta.isSelected() || this.Mixto.isSelected() || this.Efectivo.isSelected() || this.PagarDespues.isSelected() || this.Zet.isSelected())
            {
                //
                int confirmado = JOptionPane.showConfirmDialog(null,"¿Desea Liberar la mesa?");
                if(confirmado==0)
                {
                        if(this.PagarDespues.isSelected())
                            {
                            if(this.nombre.equals("OUT"))
                            {
                                if(BD.equals("chatapas"))
                                {
                                this.imprimirTicket("CLIENTE",1,3);
                                }
                                CobrarDespues(tot);
                                tot=0;
                            }
                            else
                                {
                                    JOptionPane.showMessageDialog(this,"Opción invalida para esta mesa");
                                }
                            }
                        if(this.Efectivo.isSelected())
                            {
                                this.cobrarEfectivo(tot);
                                tot=0;
                            }
                        if(this.Mixto.isSelected())
                            {
                                this.cobrarMixto(tot);
                                tot=0;
                            }
                        if(this.Tarjeta.isSelected())
                            {
                                this.cobrarTarjeta(tot);
                                tot=0;
                            }
                        if(this.Zet.isSelected())
                        {
                            this.cobrarZet(tot);
                            tot=0;
                        }
                 
                    if(this.Tarjeta.isSelected() || this.Mixto.isSelected() || this.Efectivo.isSelected())
                    {
                        int tipo=35;
                        if(this.Efectivo.isSelected())
                            tipo=0;
                        if(this.Tarjeta.isSelected())
                            tipo=1;
                        if(this.Mixto.isSelected())
                            tipo=2;
                        if(this.Zet.isSelected())
                            tipo=3;
                        
                        
                        if(BD.equals("chatapas"))
                        {
                        this.imprimirTicket("CLIENTE",0,tipo);
                        JOptionPane.showMessageDialog(this,"Retire el ticket de la bandeja");
                        this.imprimirTicket("CAJA",1,tipo);
                        }
                       
                    
                    }
                //
                }
                this.limpiar.doClick();
            }
            }
        }
    }//GEN-LAST:event_LiberarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed

        int confirmado = JOptionPane.showConfirmDialog(null,"¿Desea Cancelar el pedido?");

        if (JOptionPane.OK_OPTION == confirmado)
        {
            this.limpiar();
            this.limpiarTabla();
            pedidos.clearSelection();
            this.TotalC.setText("0");
            tot=0;

        }        // TODO add your handling code here:
    }//GEN-LAST:event_CancelarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        this.limpiar();
        this.limpiarTabla();
        pedidos.clearSelection();
        this.limpiar.setVisible(false);
        this.TotalC.setText("0");
        this.CambioC.setText("0");
        this.PagoC.setText("0");
        // TODO add your handling code here:
    }//GEN-LAST:event_limpiarActionPerformed

    private void EfectivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EfectivoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_EfectivoMouseClicked

    private void EfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EfectivoActionPerformed

    private void PagarDespuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagarDespuesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PagarDespuesActionPerformed

    private void MixtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MixtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MixtoActionPerformed

    private void ImprimirComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirComandaActionPerformed
        imprimircomanda();        // TODO add your handling code here:
    }//GEN-LAST:event_ImprimirComandaActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        eliminar();        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarActionPerformed

    private void DuplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DuplicarActionPerformed
        duplicar();
        // TODO add your handling code here:
    }//GEN-LAST:event_DuplicarActionPerformed

    private void ConvertirPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertirPaqueteActionPerformed
        Apaquete();

        // TODO add your handling code here:
    }//GEN-LAST:event_ConvertirPaqueteActionPerformed

    private void ConvertirSoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertirSoloActionPerformed
        Asolo();
        // TODO add your handling code here:
    }//GEN-LAST:event_ConvertirSoloActionPerformed

    private void derechoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_derechoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_derechoMouseClicked

    private void TelefonollevarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonollevarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonollevarActionPerformed

    private void trampita1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trampita1ActionPerformed
        this.continfo.setVisible(t);
        info infa=new info();
        infa.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_trampita1ActionPerformed

    private void trampita2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trampita2ActionPerformed
//this.actualizar("todas");        // TODO add your handling code here:
    }//GEN-LAST:event_trampita2ActionPerformed

    private void PagoCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PagoCKeyPressed
char car=(char) evt.getKeyCode();
        if(car==evt.VK_ENTER){
            double debe,paga,cambia;
            this.TotalC.setText(Double.toString(tot));
            if(!this.PagoC.getText().equals(""))
            {
                paga=Double.parseDouble(this.PagoC.getText());
                debe=tot;
                cambia=paga-debe;
                if(cambia>=0)
                this.CambioC.setText(Double.toString(cambia));
                else
                this.CambioC.setText("$");
            }
            else
            this.PagoC.setText("0");
            
        }        // TODO add your handling code here:
    }//GEN-LAST:event_PagoCKeyPressed

    private void BebidaFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BebidaFItemStateChanged
this.BebidaC.setSelectedIndex(0);        // TODO add your handling code here:
    }//GEN-LAST:event_BebidaFItemStateChanged

    private void BebidaCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BebidaCItemStateChanged
this.BebidaF.setSelectedIndex(0);        // TODO add your handling code here:
    }//GEN-LAST:event_BebidaCItemStateChanged

    private void CSaborDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CSaborDItemStateChanged
this.CSaborS.setSelectedIndex(0);        // TODO add your handling code here:
    }//GEN-LAST:event_CSaborDItemStateChanged

    private void CSaborSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CSaborSItemStateChanged
this.CSaborD.setSelectedIndex(0);        // TODO add your handling code here:
    }//GEN-LAST:event_CSaborSItemStateChanged

    private void CobrarIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CobrarIndividualActionPerformed
String cliente=(String)this.ComandaM1.getValueAt(this.ComandaM1.getSelectedRow(),2); 
int dialogButton = JOptionPane.YES_NO_OPTION;
int resp=JOptionPane.showConfirmDialog(null,"Cobrar para el cliente "+cliente);
if(JOptionPane.OK_OPTION == resp)
{
   CobrarIndividual(cliente);
}


// TODO add your handling code here:
    }//GEN-LAST:event_CobrarIndividualActionPerformed

    private void PagoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PagoCActionPerformed

    private void PagoCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PagoCKeyTyped
char c=evt.getKeyChar(); 
             
         
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
             JOptionPane.showMessageDialog(this, "Ingresa solo numeros");
               
          } 
         
        // TODO add your handling code here:
    }//GEN-LAST:event_PagoCKeyTyped

    private void TarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TarjetaActionPerformed

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
   JPasswordField jpf = new JPasswordField(); 
     JLabel titulo = new JLabel ("Operación exclusiva del administrador"); 
     
     JOptionPane.showConfirmDialog (this, new Object[]{titulo, jpf}, "Inicio de sesión", JOptionPane.OK_CANCEL_OPTION); 

     char p[] = jpf.getPassword(); 
     String pass = new String(p); 
EmpleadoDAO empleado= new  EmpleadoDAO(BD);

if(empleado.validarPass(pass)==1)
{
     int tipo=35;
                        if(this.Efectivo.isSelected())
                            tipo=0;
                        if(this.Tarjeta.isSelected())
                            tipo=1;
                        if(this.Mixto.isSelected())
                            tipo=2;
        this.imprimirTicket("CLIENTE",0,tipo);
                        JOptionPane.showMessageDialog(this,"Retire el ticket de la bandeja");
                        this.imprimirTicket("CAJA",0,tipo);
                        this.limpiar.doClick();
}
else
{
    JOptionPane.showMessageDialog(this,"Operación no autorizada");
}

        // TODO add your handling code here:
    }//GEN-LAST:event_ImprimirActionPerformed

    private void ZetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZetActionPerformed
public void contar(String cadena)
{
    ProductoDAO producto=new ProductoDAO(BD);
    producto.Actualizarcuantos(cadena);
}
    private class Validar implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
            char c=e.getKeyChar(); 
             
         
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              e.consume(); 
               
             JOptionPane.showMessageDialog(null, "Ingresa solo numeros");
               
          } 
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
        
    }
    public void imprimirIndividual(Double debe, Double cambio ,Double pago,String cliente,int estado,String encabezado)
    {
        try{
     String ruta =rutaticket+
this.Dia.getText()+"#1"+".txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Chatapas Bistro\n");
            bw.write(nombre+"\n");
            DateFormat df= DateFormat.getDateInstance();
Date Fecha = new Date();

DateFormat df2 = DateFormat.getDateInstance(DateFormat.SHORT);
            bw.write("\t\t"+df2.format(Fecha));
            bw.write("\n");
            bw.write("\nCliente:"+encabezado+"\n");
            bw.write("\nCliente:"+cliente+"\n");
            int actual=0,anterior=0;
            
            for(int i=0;i<this.ComandaM1.getRowCount();i++)
            {
              String supuesto=(String)this.ComandaM1.getValueAt(i, 2);
              if(supuesto.equals(cliente))
              {
                  String cadenita=(String)this.ComandaM1.getValueAt(i,0);
                 String comanda, cadenita2;
                
                 cadenita2=cadenita.substring(0,cadenita.indexOf("/"));
                 comanda=cadenita2;
    if(comanda.contains("Especial") ||comanda.contains("Bebida") ||comanda.contains("Postre") 
            ||comanda.contains("Desayuno"))
    {
        cadenita2=cadenita.substring(cadenita2.length()+1,cadenita.length());
        if(cadenita2.contains("Alitas") || cadenita2.contains("Costillas") || cadenita2.contains("Huevos al gusto"))
        {
            cadenita2=cadenita2.substring(0,cadenita2.indexOf("/"));
        }
        if(cadenita.contains("Bebida"))
                {
                    cadenita2=cadenita2.substring(0,cadenita2.indexOf("/"));
                }
    }
                 if(estado==0)
                 {
                     contar(cadenita2);
                 }
               bw.write("\n"+cadenita2 + "\t\t$"+ this.ComandaM1.getValueAt(i,1));
               //this.modelo.removeRow(i);
              }
            }

            bw.write("\n");
            bw.write("\n" +"Total:\t$"+debe );
            bw.write("\n" +"Pago:\t$" +pago);
             //bw.write("\n"+c.generarCantidad(this.PagoC.getText().substring(0,this.PagoC.getText().indexOf("."))));
            bw.write("\n" +"Cambio:\t$" +cambio);
             //bw.write("\n"+c.generarCantidad(this.CambioC.getText().substring(0,this.CambioC.getText().indexOf("."))));
            bw.write("\n\nGRACIAS POR SU PREFERENCIA" );
        bw.close();
        
       Desktop d = Desktop.getDesktop();
        /*Verifica que el ambiente del SO soporte los procedimientos*/
        if(Desktop.isDesktopSupported()){
            /*si es así manos a la obra*/
           d.print(new File(ruta));
          
        }
       
    } catch (IOException ex) {
        
ex.printStackTrace();

}
}
    public void CobrarIndividual(String quien)
{
    double subtotalP=0;
    for(int i=0;i<this.ComandaM1.getRowCount();i++)
    {
        String sospechoso=(String)this.ComandaM1.getValueAt(i,2);
        if(sospechoso.equals(quien))
        {
           subtotalP+=(Double)this.ComandaM1.getValueAt(i,1); 
        }
        
    }
  
      JFormattedTextField total= new JFormattedTextField();
    JFormattedTextField recibido= new JFormattedTextField();
    recibido.addKeyListener(new Validar());
    JLabel p1=new JLabel("Total:");
    JLabel p2=new JLabel("Recibido:");
    JRadioButton efectivo=new JRadioButton("Efectivo");
    JRadioButton credito=new JRadioButton("Credito");
    JRadioButton zet=new JRadioButton("Izettle");
    JRadioButton mixto=new JRadioButton("Mixto");
    ButtonGroup grupo=new ButtonGroup();
    grupo.add(efectivo);
    grupo.add(credito);
    grupo.add(zet);
    grupo.add(mixto);
    efectivo.setSelected(true);
    total.setText(Double.toString(subtotalP));
    total.setFocusable(false);
    recibido.setText("0");
 int dialogButton = JOptionPane.YES_NO_OPTION;
    int resp=JOptionPane.showConfirmDialog (this, new Object[]{efectivo,credito,zet,mixto,p1,total,p2,recibido}, "Cobro Individual",dialogButton);
    if(resp==0)
    {
        if(recibido.getText().trim().length()!=0)
        {
            double cambiesito,paguito;
            paguito=Double.parseDouble(recibido.getText());
            cambiesito=paguito-subtotalP;
            if(cambiesito>=0)
            {
                JOptionPane.showMessageDialog(this,"Cambio:"+cambiesito);
                imprimirIndividual(subtotalP,cambiesito,paguito,quien,0,"CAJA");
                JOptionPane.showMessageDialog(this,"Retire el ticket de la bandeja");
                imprimirIndividual(subtotalP,cambiesito,paguito,quien,1,"COPIA CLIENTE");
                this.TotalC.setText(Double.toString(Double.parseDouble(this.TotalC.getText())-subtotalP));
                tot-=subtotalP;
                if(efectivo.isSelected())
                {
                    cobrarEfectivo(subtotalP);
                }
                else if(credito.isSelected())
                {
                    cobrarTarjeta(subtotalP);
                }
                else if(mixto.isSelected())
                {
                    cobrarMixto(subtotalP);
                }
                else if(zet.isSelected())
                {
                    cobrarZet(subtotalP);
                }
                int in;
                for(in=0;in<this.ComandaM1.getRowCount();in++)
                {
                    String sospechoso=(String)this.ComandaM1.getValueAt((int) in,2);
                if(sospechoso.equals(quien))
                {
                    modelo.removeRow(in);
                    in--;
                }
            }
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Fallo en la operación.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Campo Vacio");
        }
    }       
}
   public void moverA(MESA1 nueva)
{

        nueva.tot+=this.tot;
    nueva.TotalC.setText(this.TotalC.getText());
for(int impo=0;impo<this.ComandaM1.getRowCount();impo++)
{
    String nombre=(String)this.ComandaM1.getValueAt(impo,0);
    double valorsito=(double)this.ComandaM1.getValueAt(impo,1);
    String num=(String)this.ComandaM1.getValueAt(impo,2);
    Object datos[]={nombre,valorsito,num};
    nueva.modelo.addRow(datos);
    nueva.TotalC.setText(Double.toString(nueva.tot));
}
this.tot=0;
        this.limpiar();
        this.limpiarTabla();
        this.pedidos.clearSelection();
        this.limpiar.setVisible(false);
        this.TotalC.setText("0");
    
}
public void limpiarMenu()
{
    this.CPan.setVisible(false);
        this.CCarne.setVisible(false);
        this.CAderezo.setVisible(false);
        this.CQueso.setVisible(false);
        this.CSaborD.setVisible(false);
        this.CSaborS.setVisible(false);
        this.CPasta.setVisible(false);
        this.CSalsa.setVisible(false);
        this.BebidaC.setVisible(false);
        this.BebidaF.setVisible(false);
        this.CEspecial.setVisible(f);
        this.CPAlitas.setVisible(false);
        this.CPCostillas.setVisible(false);
        this.CPostre.setVisible(false);
        this.BebidaF.setVisible(false);
        this.CDesayuno.setVisible(f);
        this.HPaquete.setVisible(false);
}

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JRadioButton Bebida;
    public javax.swing.JComboBox BebidaC;
    public javax.swing.JComboBox BebidaF;
    public javax.swing.JComboBox CAderezo;
    public javax.swing.JComboBox CCarne;
    public javax.swing.JComboBox CDesayuno;
    public javax.swing.JComboBox CEspecial;
    public javax.swing.JComboBox CPAlitas;
    public javax.swing.JComboBox CPCostillas;
    public javax.swing.JComboBox CPPasta;
    public javax.swing.JComboBox CPSaborD;
    public javax.swing.JComboBox CPSaborS;
    public javax.swing.JComboBox CPSalsa;
    public javax.swing.JComboBox CPan;
    public javax.swing.JComboBox CPasta;
    public javax.swing.JComboBox CPostre;
    public javax.swing.JComboBox CQueso;
    public javax.swing.JComboBox CSaborD;
    public javax.swing.JComboBox CSaborS;
    public javax.swing.JComboBox CSalsa;
    private javax.swing.JLabel Cambio;
    private javax.swing.JLabel Cambio7;
    public javax.swing.JFormattedTextField CambioC;
    private javax.swing.JButton Cancelar;
    public javax.swing.JRadioButton Chatapa;
    private javax.swing.JMenuItem CobrarIndividual;
    public javax.swing.JTable ComandaM1;
    private javax.swing.JMenuItem ConvertirPaquete;
    private javax.swing.JMenuItem ConvertirSolo;
    private javax.swing.JRadioButton Crepa;
    private javax.swing.JRadioButton Desayuno;
    private javax.swing.JLabel Dia;
    private javax.swing.JTextArea Direccionllevar;
    private javax.swing.JMenuItem Duplicar;
    private javax.swing.JRadioButton Efectivo;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JRadioButton Ensalada;
    private javax.swing.JRadioButton Especiales;
    private javax.swing.JCheckBox HPaquete;
    private javax.swing.JLabel Hora;
    private javax.swing.JMenuItem Imprimir;
    private javax.swing.JButton ImprimirComanda;
    private javax.swing.JButton Liberar;
    private javax.swing.JRadioButton Mixto;
    public javax.swing.JMenu Mover;
    private javax.swing.JTextField Nombrellevar;
    private javax.swing.JRadioButton PCrepa;
    private javax.swing.JRadioButton PEnsalada;
    private javax.swing.JRadioButton PPasta;
    public javax.swing.JRadioButton PagarDespues;
    private javax.swing.JLabel Pago;
    private javax.swing.JLabel Pago7;
    public javax.swing.JFormattedTextField PagoC;
    private javax.swing.JRadioButton Pasta;
    private javax.swing.JRadioButton Pizzeta;
    private javax.swing.JRadioButton Postre;
    private javax.swing.JRadioButton Tarjeta;
    private javax.swing.JTextField Telefonollevar;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel Total7;
    public javax.swing.JFormattedTextField TotalC;
    public javax.swing.JRadioButton Zet;
    private javax.swing.ButtonGroup apgo;
    public javax.swing.JPanel area;
    private modelo.Chapatas chapatas1;
    private javax.swing.JPanel contenedor;
    public javax.swing.JPanel continfo;
    public javax.swing.JPopupMenu derecho;
    private javax.swing.ButtonGroup extra;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JButton limpiar;
    public javax.swing.JMenuItem mesad1;
    public javax.swing.JMenuItem mesad2;
    public javax.swing.JMenuItem mesad3;
    public javax.swing.JMenuItem mesad4;
    public javax.swing.JMenuItem mesad5;
    public javax.swing.JMenuItem mesad6;
    public javax.swing.JMenuItem mesad7;
    public javax.swing.JMenuItem mesad8;
    private javax.swing.JSpinner numC;
    public javax.swing.ButtonGroup pedidos;
    private javax.swing.JButton trampita1;
    public javax.swing.JButton trampita2;
    // End of variables declaration//GEN-END:variables
}
