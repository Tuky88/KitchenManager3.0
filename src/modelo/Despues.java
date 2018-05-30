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
public class Despues {
    private int id;
    private double valor;
    private String nombre;
    private String telefono;

    public Despues(int id, double valor, String nombre, String telefono) {
        this.id = id;
        this.valor = valor;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public Despues(Despues d) {
        this.id = d.id;
        this.valor = d.valor;
        this.nombre = d.nombre;
        this.telefono = d.telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
