/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio3;

import java.util.ArrayList;

/**
 *
 * @author ljpalaciom
 */
public class Solicitud {
    private final String nombre;
    private int cantidad;
    private ArrayList <Nevera> asignadas;

    public Solicitud(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        asignadas = new ArrayList<>();
    }

    public ArrayList<Nevera> getAsignadas() {
        return asignadas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
