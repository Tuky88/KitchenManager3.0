/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Axel Reyez
 */
public class Tablachida extends DefaultTableModel
{
    public Tablachida(String[][] cadena ,String[] cadenita)
    {
        super(cadena,cadenita);
    }
   public boolean isCellEditable (int row, int column)
   {
       // Aquí devolvemos true o false según queramos que una celda
       // identificada por fila,columna (row,column), sea o no editable
       if (column == 0 || column==2)
          return true;
       return false;
       
   }
  
   
}