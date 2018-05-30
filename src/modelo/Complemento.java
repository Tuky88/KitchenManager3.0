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
public class Complemento {
    private String Nombre;
    private double precio;

    public Complemento(String Nombre, double precio) {
        this.Nombre = Nombre;
        this.precio = precio;
    }
    public Complemento(Complemento o) {
        this.Nombre = o.Nombre;
        this.precio = o.precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
