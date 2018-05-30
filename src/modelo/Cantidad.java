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
public class Cantidad {
    private Double precio;

    public Cantidad(Double precio) {
        this.precio = precio;
    }
    public Cantidad(Cantidad c) {
        this.precio = c.precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
}
