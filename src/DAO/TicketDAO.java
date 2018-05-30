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
public class TicketDAO {
    private Conection database;
     private String user;
     private String contraseña;
     private String datab;
     private ResultSet rs;
     
     public TicketDAO(String datab)
{
    user="root";
          this.datab=datab;
          contraseña="root";
         database= new Conection();
     }
     
     public void AumentarConteo()
     {
         try {
             database.MySQLConnection(datab,user,contraseña);
             rs=database.getStatement().executeQuery("select num from ticket where id=1");
             int actual;
             if(rs.next())
             {
               actual=rs.getInt("num");
             actual++;
             database.getStatement().executeUpdate("update ticket set num="+actual+" where ID=1");  
             }
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
     }
    public void ReiniciarConteo()
     {
         try {
             database.MySQLConnection(datab,user,contraseña);
             int actual=0;
             database.getStatement().executeUpdate("update ticket set num="+actual+" where ID=1");

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
     }
    public int getNumero()
    {
        int actual=0;
        try {
             database.MySQLConnection(datab,user,contraseña);
             rs=database.getStatement().executeQuery("select num from ticket where id=1");
            if(rs.next())
             actual=rs.getInt("num");
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
      return actual;  
    }
}
