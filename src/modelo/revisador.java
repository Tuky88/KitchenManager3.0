/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Axel Reyez
 */
public class revisador {
    private int valor;
    private String cambiar;
    public revisador(int valor){
        this.valor=valor;
    }
    public int getValor()
    {
        return valor;
    }
    public void setValor(int valor)
    {
        this.valor=valor;
    }
    public void setCambiar(String cambiar)
    {
        this.cambiar=cambiar;
    }
    public String getCambiar()
    {
        return this.cambiar;
    }
}
