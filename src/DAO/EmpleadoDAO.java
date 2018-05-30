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
public class EmpleadoDAO extends ConsultaDAO
{
      
private ResultSet rs;

     public EmpleadoDAO(String db)
     {
          super(new Conection(),"root","root",db);         
     }

    /**
     *
     * @param id
     * @param precio
     * @param stock
     * @param cuantosD
     * @param cuantosS
     * @param tipo
     * @param usiario
     * @param pass
     */
    @Override
public void insertar(String id, double precio,int stock,int cuantosD,int cuantosS,String tipo,String usiario,String pass)
     {
         try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="insert into usuarios (id,contraseña,tipo) values('"+usiario+"','"+pass+"','"+tipo+"')";
             System.out.println(sql);
            getDatabase().getStatement().execute(sql);
             

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
           
         getDatabase().closeConnection();
     }
@Override
     public void Eliminar(String usiario)
        {
             try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             getDatabase().getStatement().executeUpdate("delete from usuarios where Id='"+usiario+"'");

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
             getDatabase().closeConnection();
        }
public int validarPass(String pass)
        {
            int bandera=0;
            String contra=" ";
            try {
                System.out.println(this.getDatab());
             getDatabase().MySQLConnection(this.getDatab(),getUser(),getContraseña());
             rs=getDatabase().getStatement().executeQuery("select * from password ");
             
             if(rs.next())
             {
                 contra=rs.getString("pass");
                 if(contra.equals(pass))
             {
                 bandera=1;
             }
             }
             
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
     getDatabase().closeConnection();
            return bandera ;
        }
public String tipoUsuario(String Id)
        {
            String tipo=" ";
            try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             rs=getDatabase().getStatement().executeQuery("select tipo from usuarios where id='"+Id+"'");
             if(rs.next())
             {
                 tipo=rs.getString("tipo");
             }

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
            getDatabase().closeConnection();
            return tipo;
        }
public void ActualizarContraseña(String contra)
{
    try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="update password set contraseña='"+contra+"'";
             System.out.println(sql);
            getDatabase().getStatement().execute(sql);
             

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    getDatabase().closeConnection();
}
public boolean VerificarUsuario(String id)
{
    boolean bandera=false;
    try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="select * from usuarios where id='"+id+"'";
             System.out.println(sql);
            rs=getDatabase().getStatement().executeQuery(sql);
            if(rs.next())
            {
                bandera=true;
            }
    } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    getDatabase().closeConnection();
return bandera;
}
}