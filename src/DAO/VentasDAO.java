/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cantidad;
import modelo.Conection;

/**
 *
 * @author Axel Reyez
 */
public class VentasDAO {
    private Conection database;
     private String user;
     private String contraseña;
     private String datab;
     private ResultSet rs;
     public VentasDAO(String datab)
{
    user="root";
          this.datab=datab;
          contraseña="root";
         database= new Conection();
     }
     public void RegistrarVenta(double valor)
     {
         try {
             database.MySQLConnection(datab,user,contraseña);
             rs=database.getStatement().executeQuery("select num from ventas where id=1");
             double actual;
             if(rs.next())
             {
               actual=rs.getDouble("num");
             actual+=valor;
             String sql="update ventas set num="+actual+" where id=1";
             System.out.println(sql);
             database.getStatement().executeUpdate(sql);  
             }
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
     }
     public void ReiniciarCuenta()
     {
         try {
             database.MySQLConnection(datab,user,contraseña);
             double actual=0;
             database.getStatement().executeUpdate("update ventas set num="+actual+"where ID=1");  

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
     }
     public double getVentas()
     {
         double actual=0;
         try {
             database.MySQLConnection(datab,user,contraseña);
             rs=database.getStatement().executeQuery("select num from ventas where id=1");
             
             if(rs.next())
             {
               actual=rs.getDouble("num");
             }
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
         return actual;
     }
     public void insertarVenta(double valor)
     {
         try {
             database.MySQLConnection(datab,user,contraseña);
             database.getStatement().execute("insert into ventass (id) values ("+valor+")");

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
         
     }
     public void borrarVentas()
     {
         try {
             database.MySQLConnection(datab,user,contraseña);
             database.getStatement().execute("Delete from ventass where id>0");

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();   
     }
     public LinkedList obtenerVentass()
     {
         LinkedList ls=new LinkedList();
          try {
             database.MySQLConnection(datab,user,contraseña);
             rs=database.getStatement().executeQuery("select * from ventass where id>0");
             while(rs.next())
             {
                 Cantidad c=new Cantidad(rs.getDouble("id"));
                 ls.add(c);
             }

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
         return ls;
     }
     
}
