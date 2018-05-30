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
import javax.swing.JOptionPane;
import modelo.Conection;
import modelo.compra;

/**
 *
 * @author Axel Reyez
 */
public class ComprasDAO extends ConsultaDAO
{
   

    public ComprasDAO(String datab) 
    {
     super(new Conection(),"root","root",datab);
    }
    public void RegistrarCompra(String id,String nombre,String producto,double precio,String fecha)
    {
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="insert into compras (id,nombre,producto,costo,fecha) values('"+id+"','"+nombre+"',"+producto+",'"+precio+"','"+fecha+"')";
             System.out.println(sql);
            getDatabase().getStatement().execute(sql);
             

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         getDatabase().closeConnection();
    }
    public void EliminarCompra(String id,String nombre,double precio,String fecha,String Nombre)
    {
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="delete from compras where '"+id+"'=id AND '"+nombre+"'=producto AND "+precio+"=costo AND '"+fecha+"'=fecha AND '"+Nombre+"'=Nombre";
             System.out.println(sql);
            getDatabase().getStatement().execute(sql);
             

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
           
         getDatabase().closeConnection();
    }
    public compra BuscarId(String id)
    {
        compra c=null;
        ResultSet rs;
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="select * from compras where id='"+id+"'";
             System.out.println(sql);
            rs=getDatabase().getStatement().executeQuery(sql);
            if(rs.next())
            {
                c=new compra(rs.getString("id"),rs.getString("nombre"),rs.getString("producto"),rs.getDouble("costo"),rs.getString("fecha"));
            }
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return c;
    }
    public LinkedList BuscarFecha(String fecha)
    {
        LinkedList ls;
        ls = new LinkedList();
        ResultSet rs=null;
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="select * from compras where fecha='"+fecha+"'";
             System.out.println(sql);
            rs=getDatabase().getStatement().executeQuery(sql);
            while(rs.next())
            {
                compra c=new compra(rs.getString("id"),rs.getString("nombre"),rs.getString("producto"),rs.getDouble("costo"),rs.getString("fecha"));
                ls.add(c);
            }
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return ls;
    }
    public String ObtenerNombre(String id)
    {
        String nombre="";
        ResultSet rs=null;
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="select * from compras where id='"+id+"'";
             System.out.println(sql);
            rs=getDatabase().getStatement().executeQuery(sql);
            if(rs.next())
            {
                nombre=rs.getString("Nombre");
            }
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return nombre;
    }
    public double totalCompras(String fechita)
    {
        double value=0;
        ResultSet rs;
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="select * from compras";
             System.out.println(sql);
           rs =getDatabase().getStatement().executeQuery(sql);
             while(rs.next())
             {
                 if(rs.getString("Fecha").equals(fechita))
                 {
                     value+=rs.getDouble("costo");
                 }
             }

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }

         getDatabase().closeConnection();
        
    return value;}
    public void Agregar(double valor)
    {
        double anterior=this.Obtener();
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             getDatabase().getStatement().executeUpdate("update compras set num="+(valor+anterior)+"where ID=1");
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        getDatabase().closeConnection();
    }
    public double Obtener()
    {
       ResultSet rs;
        double valor=0;
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             rs=getDatabase().getStatement().executeQuery("select * from compritas where ID=1");
             if(rs.next())
             {
                 valor=rs.getDouble("num");
             }rs.close();
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        getDatabase().closeConnection();
        return valor;
    }

     
    
}
