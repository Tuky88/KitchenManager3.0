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
public class CompritasDAO {
private Conection database;
     private String user;
     private String contraseña;
     private String datab;
public CompritasDAO(String datab)
{
    user="root";
          this.datab=datab;
          contraseña="root";
    database=new Conection();
}
    public void Agregar(double valor)
    {
        double anterior=this.Obtener();
        try {
             database.MySQLConnection(datab,user,contraseña);
             database.getStatement().executeUpdate("update compritas set num="+(valor+anterior)+"where ID=1");
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        database.closeConnection();
    }
    public double Obtener()
    {
       ResultSet rs;
        double valor=0;
        try {
             database.MySQLConnection(datab,user,contraseña);
             rs=database.getStatement().executeQuery("select * from compritas where ID=1");
             if(rs.next())
             {
                 valor=rs.getDouble("num");
             }
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        database.closeConnection();
        return valor;
    }
public void Reiniciar()
{
    try {
             database.MySQLConnection(datab,user,contraseña);
             int actual=0;
             database.getStatement().executeUpdate("update compritas set num="+actual+" where ID=1");

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
}
public void Eliminar(double valor)
{
     double anterior=this.Obtener();
        try {
             database.MySQLConnection(datab,user,contraseña);
             database.getStatement().executeUpdate("update compritas set num="+(anterior-valor)+"where ID=1");
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        database.closeConnection();
}
}
