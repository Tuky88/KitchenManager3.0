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
import modelo.Complemento;
import modelo.Conection;

/**
 *
 * @author Axel Reyez
 */
public class ComplementoDAO extends ConsultaDAO
{
    ResultSet rs;

    public ComplementoDAO(String datab) 
    {
        super(new Conection(),"root","root",datab);
    }
    //Agregar
    @Override
    public void insertar(String id, double precio,int stock,int cuantosD,int cuantosS,String tipo,String usiario,String pass)
    {
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="insert into complementos (id,valor,tipo) values('"+id+"',"+precio+",'"+tipo+"')";
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
    //Modificar
    
    //Eliminar
    @Override
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
    //Consultar
    
    public LinkedList getDatos(String tipo)
    {
        ResultSet rs=null;
        LinkedList ls=new LinkedList();
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
            String sql="SELECT complemento.id, precio FROM complemento,"+tipo+" WHERE complemento.id="+tipo+".id";
             System.out.println(sql);
            rs=getDatabase().getStatement().executeQuery(sql);
            while(rs.next())
            {
                Complemento cp=new Complemento(rs.getString("id"),rs.getDouble("precio"));
                ls.add(cp);
            }rs.close();
         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        getDatabase().closeConnection();
        return ls;
    }
    public double buscarCargoExtra(String cadena)
    {
        double valor=0;
        try {
             getDatabase().MySQLConnection(getDatab(),getUser(),getContraseña());
             String sql="select * from complemento where precio>0 ";
             System.out.println(sql);
            rs=getDatabase().getStatement().executeQuery(sql);
            while(rs.next())
            {
                if(cadena.contains(rs.getString("id")))
                {
                    valor=rs.getDouble("precio");
                }
            }
             rs.close();

         } catch (Exception ex) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         getDatabase().closeConnection();
        
        return valor;
    }
    
}
