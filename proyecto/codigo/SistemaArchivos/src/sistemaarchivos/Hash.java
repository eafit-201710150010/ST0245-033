/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaarchivos;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase por implementar
 * @author ljpalaciom
 */
public class Hash {
    String nombreRaiz;
    private ArrayList<LinkedList<Carpeta>> lista;

    /**
     *
     * @param nombreRaiz
     */
    public Hash(String nombreRaiz) {
        lista = new ArrayList<>();
        this.nombreRaiz = nombreRaiz;
    }

    /**
     *
     * @param carpeta
     */
    public void add(Carpeta carpeta) {
        String nombre = carpeta.getNombre();
        int key = obtenerKey(nombre);
        if(lista.get(key) == null){
            lista.add(new LinkedList<>());
        } else{
         lista.get(key).add(carpeta);
        }
    }

    /**
     *
     * @param nombre
     */
    public void remove(String nombre){
    
    }

    /**
     *
     * @param nombre
     * @return
     */
    public Carpeta get(String nombre){
        int key = obtenerKey(nombre);
        LinkedList <Carpeta> auxiliar = lista.get(key);
        for (Carpeta carpeta : auxiliar) {
            if(carpeta.getNombre().equals(nombre)){
                return carpeta;
            }
        }
        return null;
    }
  
    private int obtenerKey(String nombre) {
            int hval = 0;
            for (int i = 0; i < nombre.length(); i++) {
                hval += nombre.charAt(i);
            }
        return (hval % lista.size());
    }

}
