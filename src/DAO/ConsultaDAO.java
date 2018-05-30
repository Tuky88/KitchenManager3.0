/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Conection;

/**
 *
 * @author Alexander
 */
public class ConsultaDAO {
    private Conection database;
     private String user;
     private String contraseña;
     private String datab;

    public ConsultaDAO(Conection database, String user, String contraseña, String datab) {
        this.database = database;
        this.user = user;
        this.contraseña = contraseña;
        this.datab = datab;
    }

     
    public Conection getDatabase() {
        return database;
    }

    public void setDatabase(Conection database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDatab() {
        return datab;
    }

    public void setDatab(String datab) {
        this.datab = datab;
    }
     
   public void Eliminar(String id)
    {
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="delete from complementos where id='"+id+"'";
             System.out.println(sql);
            getDatabase().getStatement().execute(sql);
             

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
            finally
         {
             JOptionPane.showMessageDialog(null, "Agregado con exito");
         }
         getDatabase().closeConnection();
        
    }
       public void insertar(String id, double precio,int stock,int cuantosD,int cuantosS,String tipo,String usiario,String pass)
    {
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="insert into complementos (id) values('"+id+"')";
             System.out.println(sql);
            getDatabase().getStatement().execute(sql);
             

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
            finally
         {
             JOptionPane.showMessageDialog(null, "Agregado con exito");
         }
         getDatabase().closeConnection();
        
    }
}
