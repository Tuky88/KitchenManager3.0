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
import modelo.Despues;

/**
 *
 * @author Axel Reyez
 */
public class DespuesDAO {
 private Conection database;
     private String user;
     private String contraseña;
     private String datab;
     private ResultSet rs;
     public DespuesDAO(String datab)
    {
          user="root";
          this.datab=datab;
          contraseña="root";
          database= new Conection();
     }
     public void InsertarVenta(double valor,String nombre,String telefono)
     {
         try {
             database.MySQLConnection(datab,user,contraseña);
             String sql="insert into despues (valor,nombre,telefono) values ("+valor+","+"'"+nombre+"','"+telefono+"')";
             System.out.println(sql);
             database.getStatement().execute(sql);

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
     }
     public void EliminarVenta(int id)
     {
         try {
             database.MySQLConnection(datab,user,contraseña);
             String sql="delete from despues where id="+id;
             System.out.println(sql);
             database.getStatement().execute(sql);

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
     }
     public void EliminarTodas()
     {
         try {
             database.MySQLConnection(datab,user,contraseña);
             String sql="delete from despues where id!=999";
             System.out.println(sql);
             database.getStatement().execute(sql);

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
     }
     public LinkedList obtenerDespues()
     {
         LinkedList ls=new LinkedList();
          try {
             database.MySQLConnection(datab,user,contraseña);
             rs=database.getStatement().executeQuery("select * from despues ");
             while(rs.next())
             {
                 Despues d=new Despues(rs.getInt("id"),rs.getDouble("valor"),rs.getString("nombre"),rs.getString("telefono"));
                 ls.add(d);
             }

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         database.closeConnection();
         return ls;
     }
     
}
