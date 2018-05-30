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
public class compra {
    private String id;
    private String nombre;
    private double precio;
    private String producto;
    private String fecha;

    public compra(String id, String nombre,  String producto,double precio, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.producto = producto;
        this.fecha = fecha;
    }
    public compra(compra c) {
        this.id = c.id;
        this.nombre = c.nombre;
        this.precio = c.precio;
        this.producto = c.producto;
        this.fecha = c.fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
