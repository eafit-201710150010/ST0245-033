/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaarchivos;

import java.util.HashMap;

/**
 *
 * @author ljpalaciom
 */
public class ColeccionCarpetas {

    private HashMap tabla;
    private String nombreTabla;

    /**
     *
     * @param nombreTabla
     */
    public ColeccionCarpetas(String nombreTabla) {
        tabla = new HashMap<>();
        this.nombreTabla = nombreTabla;
    }

    /**
     *
     * @param clave
     * @param carpeta
     */
    public void put(String clave, Carpeta carpeta) {
        tabla.put(clave, carpeta);
    }

    /**
     *
     * @param clave
     * @return
     */
    public Carpeta get(String clave) {
        return (Carpeta) tabla.get(clave);
    }

 
}
