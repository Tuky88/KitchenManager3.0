/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conection;

/**
 *
 * @author Axel Reyez
 */
public class CreditoDAO {
    private Conection database;
     private String user;
     private String contraseña;
     private String datab;
     private ResultSet rs;
     
     public CreditoDAO(String datab)
{
    user="root";
          this.datab=datab;
          contraseña="root";
         database= new Conection();
     }
     

    public void Reiniciar()
     {
         try {
             database.MySQLConnection(datab,user,contraseña);
             double actual=0;
             database.getStatement().executeUpdate("update credito set num="+actual+" where ID=1");

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
     }
    public double getNumero()
    {
        double actual=0;
        try {
             database.MySQLConnection(datab,user,contraseña);
             rs=database.getStatement().executeQuery("select num from credito where id=1");
            if(rs.next())
             actual=rs.getDouble("num");
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
      return actual;  
    }
    public void Agregar(double actual)
     {
         double nuevo=this.getNumero();
         try {
             database.MySQLConnection(datab,user,contraseña);
             database.getStatement().executeUpdate("update credito set num="+(actual+nuevo)+" where ID=1");

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
     }
}
