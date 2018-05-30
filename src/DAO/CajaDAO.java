/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Conection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Axel Reyez
 */
public class CajaDAO 
{
private Conection database;
     private String user;
     private String contraseña;
     private String datab;
public CajaDAO(String datab)
{
    user="root";
          this.datab=datab;
          contraseña="root";
    database=new Conection();
}
    public void ModificarCaja(double valor)
    {
        try {
             database.MySQLConnection(datab,user,contraseña);
             database.getStatement().executeUpdate("update caja set valor="+valor+"where ID=1");
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        database.closeConnection();
    }
    public double ObtenerCaja()
    {
       ResultSet rs;
        double valor=0;
        try {
             database.MySQLConnection(datab,user,contraseña);
             rs=database.getStatement().executeQuery("select * from caja where ID=1");
             if(rs.next())
             {
                 valor=rs.getDouble("valor");
             }
             rs.close();
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        database.closeConnection();
        return valor;
    }
}
