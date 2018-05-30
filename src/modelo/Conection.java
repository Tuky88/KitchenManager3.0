/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Axel Reyez
 */
public class Conection {
    private Connection Conexion;
    private Statement St;

public void MySQLConnection(String db_name, String user, String pass) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/" + db_name, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        genStatement();
    }

 public void closeConnection() {
        try {
            Conexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public Connection getConexion()
 {
     return Conexion;
 }
 public Statement getStatement()
 {
     return St;
 }
 public void genStatement() throws SQLException
 {
     St=Conexion.createStatement();
 }
}

