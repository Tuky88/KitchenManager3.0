/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DAO.EmpleadoDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Axel Reyez
 */
public class interfaz extends javax.swing.JFrame {
            MESA1 m1;
            MESA1 m2;
            MESA1 m3;
            MESA1 m4 ;
            MESA1 m5 ;
            MESA1 barra ;
            MESA1 barra1;
            MESA1 out ;
            revisador r;
            info inf;
            Admin ad;
            private int bandera=0;
            private String BD;
            private String Usuario;
            
            
 Conection db=new Conection();
   int paquete=0;

   ResultSet rs;
   principalito menu=new principalito();
   public void actualizarRegistros(String cadenita)
   {
       m1.actualizar(cadenita);
       m2.actualizar(cadenita);
        m3.actualizar(cadenita);
       m4.actualizar(cadenita);
        m5.actualizar(cadenita);
       barra.actualizar(cadenita);
       barra1.actualizar(cadenita);
        out.actualizar(cadenita);
   }
   private class AcCAgregado implements ActionListener{
                @Override
		public void actionPerformed(ActionEvent ae){
				try {

            String sql="SELECT * FROM  "+ad.Ccomplemento.getSelectedItem() +" WHERE  id='"+ad.complemento.getText()+"'";
            if(!ad.complemento.getText().equals("") && ad.Ccomplemento.getSelectedIndex()!=0 && !ad.precio.getText().equals(""))
            {
                rs=db.getStatement().executeQuery(sql);
                if(rs.next())
                {

                    sql="SELECT * FROM complemento  WHERE  id='"+ad.complemento.getText()+"'";
                    rs=db.getStatement().executeQuery(sql);
                    if(rs.next())
                    {
                        if(rs.getInt("precio")==Double.parseDouble(ad.precio.getText()))
                        {
                            JOptionPane.showMessageDialog(null,"Complemento ya existente!");
                        }
                        else
                        {
                            sql="update complemento set precio="+Double.parseDouble(ad.precio.getText())+  " WHERE  id='"+ad.complemento.getText()+"'";
                            db.getStatement().executeUpdate(sql);
                            JOptionPane.showMessageDialog(null,"Se modificó el precio del producto");
                            ad.acttc();
                        }
                    }

                }
                else
                {
                    String sql1="INSERT INTO "+ad.Ccomplemento.getSelectedItem() +"(id) VALUES ('"+ad.complemento.getText()+"')";
                    db.getStatement().executeUpdate(sql1);
                    sql1="INSERT INTO complemento" +"(id,precio) VALUES ('"+ad.complemento.getText()+"',"+Double.parseDouble(ad.precio.getText())+")";
                    db.getStatement().executeUpdate(sql1);
                    JOptionPane.showMessageDialog(null,"Cargado con exito");
                    String cadenita=(String) ad.Ccomplemento.getSelectedItem();
                   m1.actualizar(cadenita);
       m2.actualizar(cadenita);
        m3.actualizar(cadenita);
       m4.actualizar(cadenita);
        m5.actualizar(cadenita);
       barra.actualizar(cadenita);
       barra1.actualizar(cadenita);
        out.actualizar(cadenita);
                    ad.acttc();
                }

            }

        }catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            System.exit(0);
        }
			}
	}
   private class AcPAgregado implements ActionListener{
                @Override
		public void actionPerformed(ActionEvent ae){
				
              try {

            String sql="SELECT * FROM  "+ad.Cproducto.getSelectedItem() +" WHERE  id='"+ad.producto.getText()+"'";
            if(!ad.producto.getText().equals("") && ad.Cproducto.getSelectedIndex()!=0 && !ad.precio.getText().equals(""))
            {
                rs=db.getStatement().executeQuery(sql);
                if(rs.next())
                {

                    sql="SELECT * FROM productos  WHERE  id='"+ad.producto.getText()+"'";
                    rs=db.getStatement().executeQuery(sql);
                    if(rs.next())
                    {
                        if(rs.getInt("precio")==Double.parseDouble(ad.precio.getText()))
                        {
                            JOptionPane.showMessageDialog(null,"Producto ya existente!");
                        }
                        else
                        {
                            sql="update productos set precio="+Double.parseDouble(ad.precio.getText())+  " WHERE  id='"+ad.producto.getText()+"'";
                            db.getStatement().executeUpdate(sql);
                            JOptionPane.showMessageDialog(null,"Se modificó el precio del producto");
                            ad.acttp();
                        }
                    }

                }
                else
                {
                    String sql1="INSERT INTO "+ad.Cproducto.getSelectedItem() +"(id) VALUES ('"+ad.producto.getText()+"')";
                    db.getStatement().executeUpdate(sql1);
                    JOptionPane.showMessageDialog(null,"Cargado con exito");
                    sql1="INSERT INTO productos" +"(id,cuantos,precio) VALUES ('"+ad.producto.getText()+"',0,"+Double.parseDouble(ad.precio.getText())+")";
                    db.getStatement().executeUpdate(sql1);
                     String cadenita=(String) ad.Cproducto.getSelectedItem();
                   m1.actualizar(cadenita);
       m2.actualizar(cadenita);
        m3.actualizar(cadenita);
       m4.actualizar(cadenita);
        m5.actualizar(cadenita);
       barra.actualizar(cadenita);
        barra1.actualizar(cadenita);
        out.actualizar(cadenita);


                    ad.acttp();
                }

            }
        }catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            System.exit(0);
        }
       }
   }
    private class AcCEliminado implements ActionListener{
		public void actionPerformed(ActionEvent ae){
				try {
            if(!ad.complemento.getText().equals("") && ad.Ccomplemento.getSelectedIndex()!=0)
            {
                String sql="Delete  FROM  "+ad.Ccomplemento.getSelectedItem() +" WHERE  id='"+ad.complemento.getText()+"'";

                db.getStatement().executeUpdate(sql);
                String sql1="DELETE FROM complemento WHERE id='"+ad.complemento.getText()+"'";
                db.getStatement().executeUpdate(sql1);
                JOptionPane.showMessageDialog(null,"Eliminado con exito");
                     String cadenita=(String) ad.Ccomplemento.getSelectedItem();
                   m1.actualizar(cadenita);
       m2.actualizar(cadenita);
        m3.actualizar(cadenita);
       m4.actualizar(cadenita);
        m5.actualizar(cadenita);
       barra.actualizar(cadenita);
        barra1.actualizar(cadenita);
        out.actualizar(cadenita);
                ad.acttc();
                

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Campo vacio");
            }

        }catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            System.exit(0);
        } 

			}
	}
   private class AcPEliminado implements ActionListener{
		public void actionPerformed(ActionEvent ae){
				try {

            String sql="SELECT * FROM  "+ad.Cproducto.getSelectedItem() +" WHERE  id='"+ad.producto.getText()+"'";
            if(!ad.producto.getText().equals("") && ad.Cproducto.getSelectedIndex()!=0)
            {
                rs=db.getStatement().executeQuery(sql);
                if(rs.next())
                {
                    String sql1="DELETE FROM "+ad.Cproducto.getSelectedItem() +" WHERE id='"+ad.producto.getText()+"'";
                    db.getStatement().executeUpdate(sql1);
                    sql1="DELETE FROM productos WHERE id='"+ad.producto.getText()+"'";
                    db.getStatement().executeUpdate(sql1);
                    JOptionPane.showMessageDialog(null,"Producto eliminado");
                   String cadenita=(String) ad.Cproducto.getSelectedItem();
                   m1.actualizar(cadenita);
       m2.actualizar(cadenita);
        m3.actualizar(cadenita);
       m4.actualizar(cadenita);
        m5.actualizar(cadenita);
       barra.actualizar(cadenita);
        barra1.actualizar(cadenita);
        out.actualizar(cadenita);
                    ad.acttp();

                }

            }

        }catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            System.exit(0);
        }
                }
   }
   
   
   public interfaz()
   {
       
   }
    public interfaz(String BD,String Usuario) throws Exception {
        this.BD=BD;
        this.Usuario=Usuario;
        //db.MySQLConnection(this.BD,"root","root");
        menu.barrita.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barritaMouseClicked(evt);
            }

            private void barritaMouseClicked(MouseEvent evt) {
                if(menu.barrita.getSelectedIndex()==8 && bandera==0)
            
{
    JPasswordField jpf = new JPasswordField(); 
     JLabel titulo = new JLabel ("Contenido restringido identifiquese:"); 
     
     JOptionPane.showConfirmDialog (menu, new Object[]{titulo, jpf}, "Inicio de sesión", JOptionPane.OK_CANCEL_OPTION); 

     char p[] = jpf.getPassword(); 
     String pass = new String(p); 
     EmpleadoDAO emp=new EmpleadoDAO(BD);
     bandera=emp.validarPass(pass);
     

   
}
        else
        {
            bandera=0;
            ad.opciones.setVisible(false);
        }
            
        if(bandera==1)
        {
            refrescardatos();
        ad.opciones.setVisible(true);
        ad.Orden.setText(Integer.toString(ad.getTicket()));
        ad.Maximo.setText(Double.toString(ad.getVentas()));
        ad.cambiartabla();
        }
        
            }

            private void refrescardatos() {
               ad.maximo=ad.getVentas();
               ad.turno=ad.getTicket();
            }
        });
        try {
            try {
                try {
                    UIManager.setLookAndFeel("UpperEssential.UpperEssentialLookAndFeel");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Chapatas.class.getName()).log(Level.SEVERE, null, ex);
            }
            JFrame.setDefaultLookAndFeelDecorated(true);
            java.awt.Font font = new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.PLAIN, 40);
            this.setTitle("Chapatas bistro");
            this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo.jpg")).getImage());
            this.setResizable(false);
            inf=new info();
            inf.setVisible(true);
             m1 =new MESA1("Mesa 1",BD,Usuario);
             m2 =new MESA1("Mesa 2",BD,Usuario);
            m3 =new MESA1("Mesa 3",BD,Usuario);
             m4 =new MESA1("Mesa 4",BD,Usuario);
             m5 =new MESA1("Mesa 5",BD,Usuario);
             barra =new MESA1("Barra 1",BD,Usuario);
             barra1=new MESA1("Barra 2",BD,Usuario);
             out =new MESA1("OUT",BD,Usuario);
            
             m1.mesad1.addActionListener(new MoverM1());
            m1.mesad2.addActionListener(new MoverM2());
            m1.mesad3.addActionListener(new MoverM3());
            m1.mesad4.addActionListener(new MoverM4());
            m1.mesad5.addActionListener(new MoverM5());
            m1.mesad6.addActionListener(new MoverB());
            m1.mesad7.addActionListener(new MoverB1());
            m1.mesad8.addActionListener(new MoverO());
            m2.mesad1.addActionListener(new MoverM1());
            m2.mesad2.addActionListener(new MoverM2());
            m2.mesad3.addActionListener(new MoverM3());
            m2.mesad4.addActionListener(new MoverM4());
            m2.mesad5.addActionListener(new MoverM5());
            m2.mesad6.addActionListener(new MoverB());
            m2.mesad7.addActionListener(new MoverB1());
            m2.mesad8.addActionListener(new MoverO());
            m3.mesad1.addActionListener(new MoverM1());
            m3.mesad2.addActionListener(new MoverM2());
            m3.mesad3.addActionListener(new MoverM3());
            m3.mesad4.addActionListener(new MoverM4());
            m3.mesad5.addActionListener(new MoverM5());
            m3.mesad6.addActionListener(new MoverB());
            m3.mesad7.addActionListener(new MoverB1());
            m3.mesad8.addActionListener(new MoverO());
            m4.mesad1.addActionListener(new MoverM1());
            m4.mesad2.addActionListener(new MoverM2());
            m4.mesad3.addActionListener(new MoverM3());
            m4.mesad4.addActionListener(new MoverM4());
            m4.mesad5.addActionListener(new MoverM5());
            m4.mesad6.addActionListener(new MoverB());
            m4.mesad7.addActionListener(new MoverB1());
            m4.mesad8.addActionListener(new MoverO());

            m5.mesad1.addActionListener(new MoverM1());
            m5.mesad2.addActionListener(new MoverM2());
            m5.mesad3.addActionListener(new MoverM3());
            m5.mesad4.addActionListener(new MoverM4());
            m5.mesad5.addActionListener(new MoverM5());
            m5.mesad6.addActionListener(new MoverB());
            m5.mesad7.addActionListener(new MoverB1());
            m5.mesad8.addActionListener(new MoverO());
           
            barra.mesad1.addActionListener(new MoverM1());
            barra.mesad2.addActionListener(new MoverM2());
            barra.mesad3.addActionListener(new MoverM3());
            barra.mesad4.addActionListener(new MoverM4());
            barra.mesad5.addActionListener(new MoverM5());
            barra.mesad6.addActionListener(new MoverB());
            barra.mesad7.addActionListener(new MoverB1());
            barra.mesad8.addActionListener(new MoverO());

            
            barra1.mesad1.addActionListener(new MoverM1());
            barra1.mesad2.addActionListener(new MoverM2());
            barra1.mesad3.addActionListener(new MoverM3());
            barra1.mesad4.addActionListener(new MoverM4());
            barra1.mesad5.addActionListener(new MoverM5());
            barra1.mesad6.addActionListener(new MoverB());
            barra1.mesad7.addActionListener(new MoverB1());
            barra1.mesad8.addActionListener(new MoverO());

            
            out.mesad1.addActionListener(new MoverM1());
            out.mesad2.addActionListener(new MoverM2());
            out.mesad3.addActionListener(new MoverM3());
            out.mesad4.addActionListener(new MoverM4());
            out.mesad5.addActionListener(new MoverM5());
            out.mesad6.addActionListener(new MoverB());
            out.mesad7.addActionListener(new MoverB1());
            out.mesad8.addActionListener(new MoverO());




           
           
             r=new revisador(0);
             ad=new Admin(r,BD,Usuario);
            m1.setBackground(Color.red);
            menu.barrita.addTab("Mesa 1", m1);
            menu.barrita.addTab("Mesa 2", m2);
            menu.barrita.addTab("Mesa 3", m3);
            menu.barrita.addTab("Mesa 4", m4);
            menu.barrita.addTab("Mesa 5", m5);
            menu.barrita.addTab("Barra 1", barra);
            menu.barrita.addTab("Barra 2", barra1);
            menu.barrita.addTab("Out", out);
            menu.barrita.addTab("Admin",ad);
            this.add(menu);
            this.m1.continfo.add(inf);
      
           ad.AgregarC.addActionListener(new AcCAgregado());
            ad.AgregarP.addActionListener(new AcPAgregado());
            ad.EliminarC.addActionListener(new AcCEliminado());
            ad.EliminarP.addActionListener(new AcPEliminado());
            ad.corte.addActionListener(new CorteFinal());  
           this.setVisible(true);
           this.pack();
         } catch (InstantiationException ex) {
             Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
           Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
       } catch (Exception ex) {
           Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
      private class CorteFinal implements ActionListener{
		public void actionPerformed(ActionEvent ae){
		double nuevacaja=0;
                double credito=0;
                double zet=0;
                credito = ad.getCredito();
        double cajita=0;
                    cajita = ad.getCaja();
        double gastos=ad.getGastos();
                zet=ad.getZet();
        String hoy,nombrearchivo,turno1,cadena=ad.rutareporte;
            Calendar c = Calendar.getInstance();
            
                    String dia = Integer.toString(c.get(Calendar.DATE));
                    String mes = Integer.toString(1+(c.get(Calendar.MONTH)));
                    String ano = Integer.toString(c.get(Calendar.YEAR));

        hoy=dia+"-"+mes+"-"+ano;
        nombrearchivo="Reporte del "+hoy+ ".pdf";

        Document documento = new Document();
        FileOutputStream ficheroPdf;
        String fin ;
        try
        {

            fin=cadena+nombrearchivo;
            ficheroPdf = new FileOutputStream(fin);
            
            PdfWriter.getInstance(
                documento,
                ficheroPdf
            ).setInitialLeading(20);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.toString());
        } catch (DocumentException ex) {
            Logger.getLogger(Chapatas.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            
            String r="";
            String r2=" ";
            boolean aux=false;

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Chapatas.class.getName()).log(Level.SEVERE, null, ex);
            }

            documento.open();
            Paragraph para1=new Paragraph();
            documento.add(new Paragraph("Chatapas Bistro ",FontFactory.getFont("arial",30)));
            Paragraph parrafo2 = new Paragraph("\nReporte de ventas  Generado el: " + ad.Dia.getText()+ " \n Hora de registro : " + ad.Hora.getText(),FontFactory.getFont("arial",25));
            parrafo2.setAlignment(2);

            documento.add(parrafo2);

            
            Paragraph parrafo5 = new Paragraph("\nCaja anterior: "+"$"+ cajita+"\n\n",FontFactory.getFont("arial",18));
            parrafo5.setAlignment(2);
            documento.add(parrafo5);
            PdfPTable tabla = new PdfPTable(2);
            PdfPTable tabla1 = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            tabla1.setWidthPercentage(100);
            float[] medidaCeldas = {8f,4f};
            float[] medidaCeldas1 = {4f,5f,4f};
            
            try {
                tabla.setWidths(medidaCeldas);
            } catch (DocumentException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                tabla1.setWidths(medidaCeldas1);
            } catch (DocumentException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            PdfPCell celda,celda1,celda2,cabecera,cabecera1,cabecerita,cabecerita2,cabecerita1,cabecerita3,celda3;
            rs=db.getStatement().executeQuery("SELECT  * FROM productos WHERE cuantos>0");
            cabecera = new PdfPCell (new Paragraph("Producto",  FontFactory.getFont("arial",20)));

                cabecera1 = new PdfPCell (new Paragraph("Vendidos",FontFactory.getFont("arial",20)));
                
                tabla.addCell(cabecera);
                tabla.addCell(cabecera1);
                tabla.completeRow();
            while(rs.next())
            {
                String nombre="",fecha="";
                int precio=0;
                nombre=rs.getString("id");

                precio=rs.getInt("cuantos");

                celda = new PdfPCell (new Paragraph(nombre,  FontFactory.getFont("arial",20)));

                celda1 = new PdfPCell (new Paragraph(Integer.toString(precio),FontFactory.getFont("arial",20)));

                tabla.addCell(celda);
                tabla.addCell(celda1);

                tabla.completeRow();

            }
            int letra=18;
            db.getStatement().execute("UPDATE  productos SET cuantos=0 WHERE id!='" + "popo"+ "' "  );
            documento.add(tabla);
            ad.maximo=ad.getVentas();
            Paragraph parrafo3 = new Paragraph("Total en efectivo: "+"$"+ (ad.maximo-credito-zet) +"\n",FontFactory.getFont("arial",letra));
            parrafo3.setAlignment(2);
            documento.add(parrafo3);
            Paragraph parrafo7 = new Paragraph("Terminal: "+"$"+credito+"\n\n",FontFactory.getFont("arial",letra));
            parrafo7.setAlignment(2);
            documento.add(parrafo7);
            Paragraph parrafo9 = new Paragraph("iZettle: "+"$"+zet+"\n\n",FontFactory.getFont("arial",letra));
            parrafo9.setAlignment(2);
            documento.add(parrafo9);
            Paragraph parrafo8 = new Paragraph("Total: "+"$"+(ad.maximo)+"\n\n",FontFactory.getFont("arial",letra));
            parrafo8.setAlignment(2);
            documento.add(parrafo8);
            rs=db.getStatement().executeQuery("SELECT  * FROM compras WHERE Fecha='"+ad.Dia.getText()+"'");
            cabecerita = new PdfPCell (new Paragraph("ID",  FontFactory.getFont("arial",20)));
            cabecerita3 = new PdfPCell (new Paragraph("Nombre",  FontFactory.getFont("arial",20)));
                cabecerita1 = new PdfPCell (new Paragraph("Producto",FontFactory.getFont("arial",20)));
            
                tabla1.addCell(cabecerita);
                tabla1.addCell(cabecerita3);
                tabla1.addCell(cabecerita1);
                

                tabla1.completeRow();
            while(rs.next())
            {
                String nombre="",producto="";
                double precio=0;
                String ID=rs.getString("ID");
                nombre=rs.getString("Nombre");
                precio=rs.getDouble("Costo");
                producto=rs.getString("Producto");
                celda3 = new PdfPCell (new Paragraph(ID,FontFactory.getFont("arial",20)));
                celda = new PdfPCell (new Paragraph(nombre,  FontFactory.getFont("arial",20)));
                celda1 = new PdfPCell (new Paragraph(producto,FontFactory.getFont("arial",20)));
                celda2 = new PdfPCell (new Paragraph(Double.toString(precio),FontFactory.getFont("arial",20)));
                
                tabla.addCell(celda3);
                tabla1.addCell(celda);
                tabla1.addCell(celda1);
                tabla1.addCell(celda2);
                tabla1.completeRow();

            }
            documento.add(tabla1);
            Paragraph parrafo4 = new Paragraph("Gastos: "+"$"+ gastos,FontFactory.getFont("arial",letra));
            parrafo4.setAlignment(2);
            documento.add(parrafo4);
            nuevacaja=cajita+ad.maximo-gastos-credito;

            Paragraph parrafo6 = new Paragraph("Caja actual: "+"$"+ nuevacaja,FontFactory.getFont("arial",18));
            parrafo6.setAlignment(2);
            documento.add(parrafo6);

            documento.close();
        }catch (SQLException sqle)
        {
            System.out.println(sqle.getMessage());
            System.exit(0);
        } catch (DocumentException ex) {
         Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
     }
        ad.actualizarCaja(nuevacaja);
        ad.imprimirtodoregistro(cajita,ad.maximo,gastos,nuevacaja,credito,zet);
        JOptionPane.showMessageDialog(menu,"Hasta mañana!");
        ad.resTicket();
        ad.resVentas();
        ad.ReiniciarZet();
        ad.ReiniciarCredito();
ad.descartarVentas();
ad.recGastos();  
        System.exit(0);
     }
                }

      private class MoverM1 implements ActionListener
      {

        @Override
        public void actionPerformed(ActionEvent e) {
           switch(menu.barrita.getSelectedIndex())
                   {
               case 0:
                   JOptionPane.showMessageDialog(menu,"Es la misma mesa");
                   break;
               case 1:
                   m2.moverA(m1);
                   break;
               case 2:
                   m3.moverA(m1);
                   break;
               case 3:
                   m4.moverA(m1);
                   break;
               case 4:
                   m5.moverA(m1);
                   break;
                   
               case 5:
                   barra.moverA(m1);
                   break;
                case 6:
                   barra1.moverA(m1);
                   break;
                case 7:
                   out.moverA(m1);
                   break;
           }
        }
          
      }
      private class MoverM2 implements ActionListener
      {

        @Override
        public void actionPerformed(ActionEvent e) {
           switch(menu.barrita.getSelectedIndex())
                   {
               case 0:
                   m1.moverA(m2);
                   break;
               case 1:
                   JOptionPane.showMessageDialog(menu,"Es la misma mesa");
                   break;
               case 2:
                   m3.moverA(m2);
                   break;
               case 3:
                   m4.moverA(m2);
                   break;
               case 4:
                   m5.moverA(m2);
                   break;
                   
               case 5:
                   barra.moverA(m2);
                   break;
                case 6:
                   barra1.moverA(m2);
                   break;
                case 7:
                   out.moverA(m2);
                   break;
           }
        }
          
      }
      private class MoverM3 implements ActionListener
      {

        @Override
        public void actionPerformed(ActionEvent e) {
           switch(menu.barrita.getSelectedIndex())
                   {
               case 0:
                   m1.moverA(m3);
                   break;
               case 1:
                   m2.moverA(m3);
                   break;
               case 2:
                   JOptionPane.showMessageDialog(menu,"Es la misma mesa");
                   break;
               case 3:
                   m4.moverA(m3);
                   break;
               case 4:
                   m5.moverA(m3);
                   break;
                   
               case 5:
                   barra.moverA(m3);
                   break;
                case 6:
                   barra1.moverA(m3);
                   break;
                case 7:
                   out.moverA(m3);
                   break;
           }
        }
          
      }
      private class MoverM4 implements ActionListener
      {

        @Override
        public void actionPerformed(ActionEvent e) {
           switch(menu.barrita.getSelectedIndex())
                   {
               case 0:
                   m1.moverA(m4);
                   break;
               case 1:
                   m2.moverA(m4);
                   break;
               case 2:
                   m3.moverA(m4);
                   break;
               case 3:
                  JOptionPane.showMessageDialog(menu,"Es la misma mesa");
                   break;
               case 4:
                   m5.moverA(m4);
                   break;
                   
               case 5:
                   barra.moverA(m4);
                   break;
                case 6:
                   barra1.moverA(m4);
                   break;
                case 7:
                   out.moverA(m4);
                   break;
           }
        }
          
      }
      private class MoverM5 implements ActionListener
      {

        @Override
        public void actionPerformed(ActionEvent e) {
           switch(menu.barrita.getSelectedIndex())
                   {
               case 0:
                   m1.moverA(m5);
                   break;
               case 1:
                   m2.moverA(m5);
                   break;
               case 2:
                   m3.moverA(m5);
                   break;
               case 3:
                   m4.moverA(m5);
                   break;
               case 4:
                   JOptionPane.showMessageDialog(menu,"Es la misma mesa");
                   break;
                   
               case 5:
                   barra.moverA(m5);
                   break;
                case 6:
                   barra1.moverA(m5);
                   break;
                case 7:
                   out.moverA(m5);
                   break;
           }
        }
          
      }
      private class MoverB implements ActionListener
      {

        @Override
        public void actionPerformed(ActionEvent e) {
           switch(menu.barrita.getSelectedIndex())
                   {
               case 0:
                   m1.moverA(barra);
                   break;
               case 1:
                   m2.moverA(barra);
                   break;
               case 2:
                   m3.moverA(barra);
                   break;
               case 3:
                   m4.moverA(barra);
                   break;
               case 4:
                   m5.moverA(barra);
                   break;
                   
               case 5:
                   JOptionPane.showMessageDialog(menu,"Es la misma mesa");
                   break;
                case 6:
                   barra1.moverA(barra);
                   break;
                case 7:
                   out.moverA(barra);
                   break;
           }
        }
          
      }
      private class MoverB1 implements ActionListener
      {

        @Override
        public void actionPerformed(ActionEvent e) {
           switch(menu.barrita.getSelectedIndex())
                   {
               case 0:
                   m1.moverA(barra1);
                   break;
               case 1:
                   m2.moverA(barra1);
                   break;
               case 2:
                   m3.moverA(barra1);
                   break;
               case 3:
                   m4.moverA(barra1);
                   break;
               case 4:
                   m5.moverA(barra1);
                   break;
                   
               case 5:
                   barra.moverA(barra1);
                   break;
                case 6:
                   JOptionPane.showMessageDialog(menu,"Es la misma mesa");
                   break;
                case 7:
                   out.moverA(barra1);
                   break;
           }
        }
          
      }
      private class MoverO implements ActionListener
      {

        @Override
        public void actionPerformed(ActionEvent e) {
           switch(menu.barrita.getSelectedIndex())
                   {
               case 0:
                   m1.moverA(out);
                   break;
               case 1:
                   m2.moverA(out);
                   break;
               case 2:
                   m3.moverA(out);
                   break;
               case 3:
                   m4.moverA(out);
                   break;
               case 4:
                   m5.moverA(out);
                   break;
                   
               case 5:
                   barra.moverA(out);
                   break;
                case 6:
                   barra1.moverA(out);
                   break;
                case 7:
                    JOptionPane.showMessageDialog(menu,"Es la misma mesa");
                   break;
           }
        }
          
      }
        
  

                
                   
               

      
 
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1183, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
// TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
