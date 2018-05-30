/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Conection;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Complemento;

/**
 *
 * @author Axel Reyez
 */
public class ProductoDAO extends ConsultaDAO
{
    
     private ResultSet rs;
     private String tipo;

    
     public ProductoDAO(String datab)
     {
       
          super(new Conection(),"root","root",datab);
          
     }
public String getTipo() {
        return tipo;
    }

    
    //nuevos productos
public void insertar(String id, double precio,int cuantos)
     //public void insertar(String Id, double precio,int stock,int cuantosD,int cuantosS,String tipo)
     {
         try {
             getDatabase().MySQLConnection(this.getDatab(),this.getUser(),this.getContraseña());
             String sql="insert into productos (id,cuantos,precio) values('"+id+"',"+cuantos+"')";
             System.out.println(sql);
            getDatabase().getStatement().execute(sql);
             

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }

         getDatabase().closeConnection();
     }
    //actualizar valores
      public void ActualizarPrecio(String Id,String tipo, double precio)
     {
         try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             getDatabase().getStatement().executeUpdate("update productos set precio="+precio+" where ID='"+Id+"' AND tipo='"+tipo+"'" );

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         getDatabase().closeConnection();
     }
      public void ReiniciarVentas()              
     {
         try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             getDatabase().getStatement().executeUpdate("update productos set cuantosD=0 " );

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         getDatabase().closeConnection();
     }
        public void Actualizarcuantos(String Id)
     {
         try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             rs=getDatabase().getStatement().executeQuery("select cuantos from productos where id='"+Id+"'");
             if(rs.next())
             {
                 int actual;
             actual=rs.getInt("cuantos");
             actual++;
             getDatabase().getStatement().executeUpdate("update productos set cuantos="+actual+" where ID='"+Id+"'");
             }

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         getDatabase().closeConnection();
     }
                public void restarStock(String Id,double tipo)
     {
         try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             rs=getDatabase().getStatement().executeQuery("select stock from productos where id='"+Id+"' AND Precio="+tipo);
             if(rs.next())
             {
                 int actual;
             actual=rs.getInt("stock");
             actual--;
             String sql="update productos set cuantosS="+actual+" where ID='"+Id+"' AND Precio="+tipo;
             System.out.println(sql);
             getDatabase().getStatement().executeUpdate(sql);

             }
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         getDatabase().closeConnection();
     }
     //borrar
        public void Eliminar(String Id,String Tipo)
        {
             try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="delete from productos where id='"+Id+"' AND Tipo='"+Tipo+"'";
             System.out.println(sql);
             getDatabase().getStatement().executeUpdate(sql);

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
             getDatabase().closeConnection();
        }
     //select
        public double getPrecio(String Id)
        {
            double precio=0;
            try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             rs=getDatabase().getStatement().executeQuery("select precio from productos where id='"+Id+"'");
             if(rs.next())
             precio=rs.getDouble("precio");

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
            getDatabase().closeConnection();
            return precio;
        }

        public ResultSet ObtenerTodo()
        {
            ResultSet rs=null;
            try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             rs=getDatabase().getStatement().executeQuery("select * from productos");

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
            //getDatabase().closeConnection();
            return rs;
        }
        public ResultSet ObtenerPorTipo(String Tipo)
        {
            ResultSet rs=null;
            try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             rs=getDatabase().getStatement().executeQuery("select * from  productos where tipo='"+Tipo+"'");

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
            //getDatabase().closeConnection();
            return rs;
        }
        public LinkedList getDatos(String tipo)
    {
        ResultSet rs=null;
        LinkedList ls=new LinkedList();
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
            String sql="SELECT productos.id, precio FROM productos,"+tipo+" WHERE productos.id="+tipo+".id";
             System.out.println(sql);
            rs=getDatabase().getStatement().executeQuery(sql);
            while(rs.next())
            {
                Complemento cp=new Complemento(rs.getString("id"),rs.getDouble("precio"));
                ls.add(cp);
            }
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        getDatabase().closeConnection();
        return ls;
    }

        

     
}
