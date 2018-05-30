package modelo;

import DAO.*;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Axel Reyez
 */
public class Admin extends javax.swing.JPanel {

 double x,tot=0,i=0;
 double valor=0;
    int turno=0;double maximo=0;

    int superestado=0;
    double subtotal=0;
    Reporte reporte;
    String user;
    String BD;
    String ruta;
    String rutaC;
    String rutareporte;
    String rutaticket;
   int paquete=0;

   ResultSet rs;
   
    
    
     Tablachida modelo6,model;

     
String cabecera1 []={"Producto","Precio"};
    String datos[][]={};
    String cabecera []={"Codigo","Total","Nombre","Teléfono"};


     Alta a;
   boolean t=true;
   boolean f=false;
          
    public Admin(revisador r,String BD,String Usuario) throws IllegalAccessException, InstantiationException, ClassNotFoundException, Exception {
        this.BD=BD;
        this.user=Usuario;
        
           ruta="C:\\Users\\"+user+"\\Documents\\Comanda\\";
    rutaC="C:\\Users\\"+user+"\\Documents\\Comanda\\comanda.txt";
    rutareporte="C:\\Users\\"+user+"\\Documents\\Reportes\\";
    rutaticket="C:\\Users\\"+user+"\\Documents\\Tickets\\";
    a=new Alta(BD,user);
    reporte=new Reporte(BD);
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
        
          opciones.setVisible(false);
          a.setVisible(false);
        
reloj hilo=new reloj(Hora);


 hilo.start();
DateFormat df= DateFormat.getDateInstance();
Date Fecha = new Date();
DateFormat df2 = DateFormat.getDateInstance(DateFormat.SHORT);
Dia.setText(df2.format(Fecha));

this.AgregarC.setVisible(f);
this.AgregarP.setVisible(f);
this.EliminarC.setVisible(f);
this.EliminarP.setVisible(f);
this.PanelC.setVisible(f);
this.PanelP.setVisible(f);
modelo6 = new Tablachida(datos,cabecera1);
tablita.setModel(modelo6);
model = new Tablachida(datos,cabecera);
tabla.setModel(model);
TableColumnModel columnModelo6 = tablita.getColumnModel();
columnModelo6.getColumn(0).setPreferredWidth(450);
columnModelo6.getColumn(1).setPreferredWidth(200);

    }
    public void recGastos()
    {
      CompritasDAO compras=new CompritasDAO(BD);
      compras.Reiniciar();
    }
public double getGastos()
{
    CompritasDAO compras=new CompritasDAO(BD);
    return compras.Obtener();
}
public int getTicket()
{
    TicketDAO ticket=new TicketDAO(BD);
    return ticket.getNumero();
    
}
public double getVentas()
{
    VentasDAO ventas= new VentasDAO(BD);
    return ventas.getVentas();
}
public double getCredito()
{
    CreditoDAO credito=new CreditoDAO(BD);
    return credito.getNumero();
}
public double getZet()
{
    ZetDAO zet=new ZetDAO(BD);
    return zet.getNumero();
}
public double getCaja()
{
    CajaDAO caja=new CajaDAO(BD);
    return caja.ObtenerCaja();
}
public void actualizarCaja(double caja)
{
    CajaDAO caj=new CajaDAO(BD);
    caj.ModificarCaja(caja);
}
public void resVentas()
{
    VentasDAO ventas=new VentasDAO(BD);
    ventas.ReiniciarCuenta();
}


    void imprimirtodoregistro(double inicial,double Tventas,double Tcompras,double Cfinal,double tarjeta,double zet)
    {
        try {
            String ruta=rutaticket+"todo.txt";
            File archivo = new File(ruta);
            BufferedWriter bw=null;
            bw = new BufferedWriter(new FileWriter(archivo));
            int i=1;
            bw.write("Ventas del dìa:"+Dia.getText()+"\n");
            bw.write(Hora.getText()+"\n");
            bw.write("Caja inicial:"+inicial+"\n\n");
            bw.write("\nVentas totales\n\n");
            LinkedList ls;
            VentasDAO v=new VentasDAO(BD);
            ls=v.obtenerVentass();
          while(!ls.isEmpty())
          {
          Cantidad c=new Cantidad((Cantidad)ls.pop());
          bw.write("\n["+i+"]\t$"+c.getPrecio());
          i++;
          }

            bw.write("\n\nEfectivo: $"+(Tventas-tarjeta));
            bw.write("\n\nTerminal: $"+tarjeta);
            bw.write("\n\nIZettle: $"+zet);
            bw.write("\n\nVentas totales: $"+Tventas);
            bw.write("\n\nCompras totales: $"+Tcompras);
            bw.write("\n\nCaja actual:"+Cfinal);
            
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
  void ReiniciarCredito()       
  {
      CreditoDAO credito=new CreditoDAO(BD);
      credito.Reiniciar();
  }
    void ReiniciarZet()       
  {
      ZetDAO credito=new ZetDAO(BD);
      credito.Reiniciar();
  }
   
public void descartarVentas()
{
    VentasDAO ventas=new VentasDAO(BD);
    ventas.borrarVentas();
}
public void resTicket()
{
    TicketDAO ticket=new TicketDAO(BD);
    ticket.ReiniciarConteo();
}


void acttp()
{
    if(this.Cproducto.getSelectedIndex()!=0)
{
    for(int i=0;i<modelo6.getRowCount();i++)
        {
            modelo6.removeRow(i);
            i=i-1;
        }

ProductoDAO p=new ProductoDAO(BD);
LinkedList ls;
ls=p.getDatos((String)this.Cproducto.getSelectedItem());

            while(!ls.isEmpty())
            {
                Complemento co=new Complemento((Complemento)ls.pop());
                String nombre;
                double valor;
                nombre=co.getNombre();
                valor=co.getPrecio();
                Object datos[]={nombre,valor};
                this.modelo6.addRow(datos);
                
                
            }

}        // TODO add your handling code here:
    }   
void cambiartabla()
{
    DespuesDAO d=new DespuesDAO(BD);
        LinkedList ls;
        ls=d.obtenerDespues();
        for(int i=0;i<this.tabla.getRowCount();i++)
        {
            this.model.removeRow(i);
            i--;
        }
        while(!ls.isEmpty())
        {
            Despues de=new Despues((Despues)ls.pop());
            Object datitos[]={de.getId(),de.getValor(),de.getNombre(),de.getTelefono()};
            this.model.addRow(datitos);
        }
}
void acttc()
{
   if(this.Ccomplemento.getSelectedIndex()!=0)
{

           for(int i=0;i<modelo6.getRowCount();i++)
           {
               modelo6.removeRow(i);
               i=i-1;
           }
          ComplementoDAO p=new ComplementoDAO(BD);
LinkedList ls;
ls=p.getDatos((String)this.Ccomplemento.getSelectedItem());

            while(!ls.isEmpty())
            {
                Complemento co=new Complemento((Complemento)ls.pop());
                String nombre;
                double valor;
                nombre=co.getNombre();
                valor=co.getPrecio();
                Object datos[]={nombre,valor};
                this.modelo6.addRow(datos);
                
                
            }
       }

  
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carga = new javax.swing.ButtonGroup();
        opciones = new javax.swing.JTabbedPane();
        jPanel64 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        Hora = new javax.swing.JLabel();
        Dia = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Maximo = new javax.swing.JTextField();
        Orden = new javax.swing.JTextField();
        corte = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        registrar2 = new javax.swing.JButton();
        registrar3 = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        ProductoR = new javax.swing.JRadioButton();
        ComplementoR = new javax.swing.JRadioButton();
        jPanel48 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();
        Eprecio = new javax.swing.JLabel();
        PanelC = new javax.swing.JPanel();
        Ccomplemento = new javax.swing.JComboBox();
        complemento = new javax.swing.JTextField();
        Ecomplemento = new javax.swing.JLabel();
        PanelP = new javax.swing.JPanel();
        Cproducto = new javax.swing.JComboBox();
        producto = new javax.swing.JTextField();
        Eproducto = new javax.swing.JLabel();
        precio = new javax.swing.JFormattedTextField();
        AgregarC = new javax.swing.JButton();
        AgregarP = new javax.swing.JButton();
        EliminarC = new javax.swing.JButton();
        EliminarP = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Vieja = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        Nueva = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        Confirmar = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jPanel50 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cajav = new javax.swing.JButton();
        cajat = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        CodigoPago = new javax.swing.JTextField();
        TotalPago = new javax.swing.JTextField();
        NombrePAgo = new javax.swing.JTextField();
        TelefonoPago = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tipopago = new javax.swing.JComboBox();

        opciones.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        opciones.setFont(new java.awt.Font("Sitka Subheading", 1, 20)); // NOI18N
        opciones.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                opcionesStateChanged(evt);
            }
        });
        opciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionesMouseClicked(evt);
            }
        });

        Hora.setBackground(new java.awt.Color(204, 255, 255));
        Hora.setFont(new java.awt.Font("Poor Richard", 0, 30)); // NOI18N
        Hora.setForeground(new java.awt.Color(153, 255, 255));
        Hora.setText("jLabel4");

        Dia.setBackground(new java.awt.Color(204, 255, 255));
        Dia.setFont(new java.awt.Font("Poor Richard", 0, 30)); // NOI18N
        Dia.setForeground(new java.awt.Color(153, 255, 255));
        Dia.setText("jLabel3");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hora)))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Hora)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        jLabel1.setText("Ordenes realizadas");

        jLabel3.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        jLabel3.setText("Total del dia");

        Maximo.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        Maximo.setText("0");
        Maximo.setFocusable(false);

        Orden.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        Orden.setText("0");
        Orden.setFocusable(false);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Orden, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(Maximo))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Orden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Maximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        corte.setFont(new java.awt.Font("Poor Richard", 0, 48)); // NOI18N
        corte.setText("CORTE DE CAJA");
        corte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corteActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Poor Richard", 0, 30)); // NOI18N
        jButton2.setText("Ventas Dia");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel64Layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(corte, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel64Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(corte, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        opciones.addTab("Estado", jPanel64);

        registrar2.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        registrar2.setText("Registrar compra");
        registrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar2ActionPerformed(evt);
            }
        });

        registrar3.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        registrar3.setText("Reportes de compras");
        registrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(registrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197)
                .addComponent(registrar3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrar2)
                    .addComponent(registrar3))
                .addGap(112, 112, 112))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        opciones.addTab("Compras", jPanel1);

        carga.add(ProductoR);
        ProductoR.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        ProductoR.setSelected(true);
        ProductoR.setText("Producto");
        ProductoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductoRActionPerformed(evt);
            }
        });

        carga.add(ComplementoR);
        ComplementoR.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        ComplementoR.setText("Complemento");
        ComplementoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplementoRActionPerformed(evt);
            }
        });

        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablitaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablita);

        Eprecio.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        Eprecio.setText("Precio");

        Ccomplemento.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        Ccomplemento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Listado complementos", "pan", "queso", "aderezo", "carne", "crepad", "pasta", "alitas", "costillas", "salsa" }));
        Ccomplemento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CcomplementoItemStateChanged(evt);
            }
        });
        Ccomplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CcomplementoActionPerformed(evt);
            }
        });

        complemento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        complemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complementoActionPerformed(evt);
            }
        });

        Ecomplemento.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        Ecomplemento.setText("Complemento");

        javax.swing.GroupLayout PanelCLayout = new javax.swing.GroupLayout(PanelC);
        PanelC.setLayout(PanelCLayout);
        PanelCLayout.setHorizontalGroup(
            PanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Ecomplemento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Ccomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        PanelCLayout.setVerticalGroup(
            PanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ccomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ecomplemento))
                .addGap(15, 15, 15))
        );

        Cproducto.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        Cproducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Listado productos", "bebidaf", "bebidac", "postre", "desayuno", "especial", "base" }));
        Cproducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CproductoItemStateChanged(evt);
            }
        });
        Cproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CproductoActionPerformed(evt);
            }
        });

        producto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });

        Eproducto.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        Eproducto.setText("Producto");

        javax.swing.GroupLayout PanelPLayout = new javax.swing.GroupLayout(PanelP);
        PanelP.setLayout(PanelPLayout);
        PanelPLayout.setHorizontalGroup(
            PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Eproducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Cproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        PanelPLayout.setVerticalGroup(
            PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Eproducto))
                .addGap(15, 15, 15))
        );

        precio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        precio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(Eprecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eprecio)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        AgregarC.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        AgregarC.setText("Agregar");
        AgregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarCActionPerformed(evt);
            }
        });

        AgregarP.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        AgregarP.setText("Agregar");
        AgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPActionPerformed(evt);
            }
        });

        EliminarC.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        EliminarC.setText("Eliminar");
        EliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCActionPerformed(evt);
            }
        });

        EliminarP.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        EliminarP.setText("Eliminar");
        EliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ComplementoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ProductoR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(AgregarC)
                    .addComponent(AgregarP)
                    .addComponent(EliminarC)
                    .addComponent(EliminarP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ProductoR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComplementoR)
                .addGap(155, 155, 155)
                .addComponent(AgregarC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AgregarP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EliminarC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EliminarP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        opciones.addTab("Productos", jPanel47);

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña anterior");

        Vieja.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña nueva");

        Nueva.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel5.setText("Confirmar");

        Confirmar.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(Nueva, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(Vieja, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Vieja, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nueva, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        opciones.addTab("Contraseña", jPanel37);

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel6.setText("Caja:");

        cajav.setFont(new java.awt.Font("Poor Richard", 0, 24)); // NOI18N
        cajav.setText("Modificar");
        cajav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajavActionPerformed(evt);
            }
        });

        cajat.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####0.###"))));
        cajat.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cajav, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(cajat))
                .addContainerGap(369, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(cajav)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        opciones.addTab("Caja", jPanel50);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel7.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N
        jLabel7.setText("Codigo:");

        jLabel8.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N
        jLabel8.setText("Total:");

        jLabel9.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N
        jLabel9.setText("Nombre:");

        jButton3.setFont(new java.awt.Font("Poor Richard", 0, 18)); // NOI18N
        jButton3.setText("Cobrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Poor Richard", 0, 18)); // NOI18N
        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Poor Richard", 0, 18)); // NOI18N
        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N
        jLabel10.setText("Teléfono:");

        CodigoPago.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N
        CodigoPago.setToolTipText("");

        TotalPago.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N

        NombrePAgo.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N

        TelefonoPago.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N
        jLabel11.setText("Tipo pago");

        tipopago.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N
        tipopago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pago", "Efectivo", "Tarjeta", "Mixto" }));
        tipopago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipopagoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CodigoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombrePAgo)
                            .addComponent(TelefonoPago)))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipopago, 0, 179, Short.MAX_VALUE)))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(CodigoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(NombrePAgo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(TelefonoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipopago, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        opciones.addTab("Pagos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(opciones)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(opciones)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void corteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corteActionPerformed

        
    }//GEN-LAST:event_corteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String ruta=rutaticket+"todo.txt";
            File archivo = new File(ruta);
            BufferedWriter bw=null;
            bw = new BufferedWriter(new FileWriter(archivo));
            int i=1;
            bw.write("Ventas del dìa:"+Dia.getText()+"\n");
            bw.write(Hora.getText()+"\n");
            bw.write("\nVentas totales\n\n");
            LinkedList ls;
            VentasDAO v=new VentasDAO(BD);
            ls=v.obtenerVentass();
          while(!ls.isEmpty())
          {
          Cantidad c=new Cantidad((Cantidad)ls.pop());
          bw.write("\n["+i+"]\t$"+c.getPrecio());
          i++;
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void registrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar2ActionPerformed
        a.setVisible(true);
        a.altamos.doClick();// TODO add your handling code here:
    }//GEN-LAST:event_registrar2ActionPerformed

    private void registrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar3ActionPerformed
        
        reporte.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_registrar3ActionPerformed

    private void ProductoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductoRActionPerformed
        if(this.ProductoR.isSelected())
        {
            this.Ccomplemento.setVisible(f);
            this.AgregarC.setVisible(f);
            this.EliminarC.setVisible(f);
            this.Ecomplemento.setVisible(f);
            this.complemento.setVisible(f);
            this.producto.setVisible(t);
            this.AgregarP.setVisible(t);
            this.EliminarP.setVisible(t);
            this.Eproducto.setVisible(t);
            this.Cproducto.setVisible(t);
            this.precio.setVisible(t);
            this.Eprecio.setVisible(t);
            this.PanelP.setVisible(t);
        }// TODO add your handling code here:
    }//GEN-LAST:event_ProductoRActionPerformed

    private void ComplementoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComplementoRActionPerformed
        if(this.ComplementoR.isSelected())
        {
            this.Ccomplemento.setVisible(t);
            this.AgregarC.setVisible(t);
            this.EliminarC.setVisible(t);
            this.Ecomplemento.setVisible(t);
            this.complemento.setVisible(t);
            this.producto.setVisible(false);
            this.AgregarP.setVisible(false);
            this.EliminarP.setVisible(false);
            this.Eproducto.setVisible(f);
            this.precio.setVisible(t);
            this.Eprecio.setVisible(t);
            this.Cproducto.setVisible(f);
            this.PanelC.setVisible(t);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ComplementoRActionPerformed

    private void tablitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablitaMouseClicked
        if(tablita.getSelectedRow()!=-1)
        {
            this.producto.setText((String) tablita.getValueAt(tablita.getSelectedRow(),0));
            this.complemento.setText((String) tablita.getValueAt(tablita.getSelectedRow(),0));
            this.precio.setText(Double.toString((Double)tablita.getValueAt(tablita.getSelectedRow(),1)));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tablitaMouseClicked

    private void AgregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarCActionPerformed

        

        // TODO add your handling code here:
    }//GEN-LAST:event_AgregarCActionPerformed

    private void AgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPActionPerformed
     
        // TODO add your handling code here:
    }//GEN-LAST:event_AgregarPActionPerformed

    private void EliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCActionPerformed
               // TODO add your handling code here:
    }//GEN-LAST:event_EliminarCActionPerformed

    private void EliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_EliminarPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EmpleadoDAO em=new EmpleadoDAO(BD);
               String contraseña=em.getContraseña();
                if(Vieja.getText().equals(contraseña))
                {
                    if(this.Nueva.getText().equals(Confirmar.getText())){
                        em.ActualizarContraseña(Confirmar.getText());
                        JOptionPane.showMessageDialog(null,"Cambio realizado");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Contraseña invalida");
                }
            

                // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cajavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajavActionPerformed
        valor=new Float(cajat.getText());
       CajaDAO c=new CajaDAO(BD);
       c.ModificarCaja(valor);
               
        // TODO add your handling code here:
    }//GEN-LAST:event_cajavActionPerformed

    private void opcionesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionesStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionesStateChanged

    private void complementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_complementoActionPerformed

    private void CcomplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CcomplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CcomplementoActionPerformed

    private void CcomplementoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CcomplementoItemStateChanged
        acttc();  // TODO add your handling code here:
    }//GEN-LAST:event_CcomplementoItemStateChanged

    private void CproductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CproductoItemStateChanged
      acttp();   // TODO add your handling code here:
    }//GEN-LAST:event_CproductoItemStateChanged

    private void CproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CproductoActionPerformed

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productoActionPerformed

    private void opcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionesMouseClicked
if(opciones.getSelectedIndex()==2)
{
    this.ComplementoR.doClick();
}
// TODO add your handling code here:
    }//GEN-LAST:event_opcionesMouseClicked

    private void tipopagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipopagoItemStateChanged
        
    }//GEN-LAST:event_tipopagoItemStateChanged

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        int id;
        double valorsin;
        String nombre,telefono;
        id=(Integer)this.model.getValueAt(this.tabla.getSelectedRow(),0);
        valorsin=(Double)this.model.getValueAt(this.tabla.getSelectedRow(),1);
        nombre=(String)this.model.getValueAt(this.tabla.getSelectedRow(),2);
        telefono=(String)this.model.getValueAt(this.tabla.getSelectedRow(),3);
        this.CodigoPago.setText(""+id);
        this.TotalPago.setText(""+valorsin);
        this.NombrePAgo.setText(nombre);
        this.TelefonoPago.setText(telefono);
    }//GEN-LAST:event_tablaMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!this.CodigoPago.getText().equals("") && this.tipopago.getSelectedIndex()!=0)
        {
            DespuesDAO d=new DespuesDAO(BD);
            d.EliminarVenta(Integer.parseInt(this.CodigoPago.getText()));
            Double toti=Double.parseDouble(this.TotalPago.getText());
            switch(this.tipopago.getSelectedIndex())
            {
                case 1:
                    this.cobrarEfectivo(toti);
                    break;
                case 2:
                    this.cobrarTarjeta(toti);
                    break;
                case 3:
                    this.cobrarMixto(toti);
                    break;
            }
        }
        this.cambiartabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
if(!this.CodigoPago.getText().equals(""))
        {
            DespuesDAO d=new DespuesDAO(BD);
            d.EliminarVenta(Integer.parseInt(this.CodigoPago.getText()));
        }
this.cambiartabla();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
this.CodigoPago.setText("");
this.NombrePAgo.setText("");
this.TotalPago.setText("");
this.TelefonoPago.setText("");
this.tipopago.setSelectedIndex(0);// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed
   public void Registro(double sumita) 
    {
     VentasDAO ventivirips=new VentasDAO(BD);
TicketDAO ticket=new TicketDAO(BD);
ventivirips.RegistrarVenta(sumita);
ticket.AumentarConteo();
    }
    public void agregarACredito(double tot)
{
    CreditoDAO credito=new CreditoDAO(BD);
    credito.Agregar(tot);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton AgregarC;
    public javax.swing.JButton AgregarP;
    public javax.swing.JComboBox Ccomplemento;
    private javax.swing.JTextField CodigoPago;
    private javax.swing.JRadioButton ComplementoR;
    private javax.swing.JPasswordField Confirmar;
    public javax.swing.JComboBox Cproducto;
    public javax.swing.JLabel Dia;
    private javax.swing.JLabel Ecomplemento;
    public javax.swing.JButton EliminarC;
    public javax.swing.JButton EliminarP;
    private javax.swing.JLabel Eprecio;
    private javax.swing.JLabel Eproducto;
    public javax.swing.JLabel Hora;
    public javax.swing.JTextField Maximo;
    private javax.swing.JTextField NombrePAgo;
    private javax.swing.JPasswordField Nueva;
    public javax.swing.JTextField Orden;
    private javax.swing.JPanel PanelC;
    private javax.swing.JPanel PanelP;
    private javax.swing.JRadioButton ProductoR;
    private javax.swing.JTextField TelefonoPago;
    private javax.swing.JTextField TotalPago;
    private javax.swing.JPasswordField Vieja;
    private javax.swing.JFormattedTextField cajat;
    private javax.swing.JButton cajav;
    private javax.swing.ButtonGroup carga;
    public javax.swing.JTextField complemento;
    public javax.swing.JButton corte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JTabbedPane opciones;
    public javax.swing.JFormattedTextField precio;
    public javax.swing.JTextField producto;
    private javax.swing.JButton registrar2;
    private javax.swing.JButton registrar3;
    public javax.swing.JTable tabla;
    private javax.swing.JTable tablita;
    private javax.swing.JComboBox tipopago;
    // End of variables declaration//GEN-END:variables
}
