/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaarchivos;

/**
 * Sirve para determinar si el tipo es carpeta o archivo
 * @author ljpalaciom
 */
public enum TipoCarpeta {

    /**
     * Es un carpeta si puede tener Carpetas dentro de sí
     */
    Carpeta,

    /**
     * Es un archivo si no puede tener Carpetas dentro de sí
     */
    Archivo;
}
