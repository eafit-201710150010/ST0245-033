/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author ljpalaciom
 */
public class Bank {
    /**
     * Este metodo, inspirado en el tingo tango, remueve el primer elemento de una lista de filas y la agrega
     * al final de la lista. Si la fila esta vacia se borra de la lista
     * @param filas 
     */
    public static void remover(LinkedList<Queue> filas) {
        filas.addLast(filas.remove());
        if (filas.getLast().isEmpty()) {
            filas.removeLast();
        }
    }
/**
 * Este metodo realiza la simulacion de un banco con un numero n de filas pero con solo dos cajeros
 * @param filas Una LinkedList de colas para hacer la simulacion
 */
    public static void simular(LinkedList<Queue> filas) {
        while (!filas.isEmpty()) {
            System.out.println("Al cajero 1 " + filas.getFirst().remove());
            remover(filas);
            System.out.println("Al cajero 2 " + filas.getFirst().remove());
            remover(filas);
        }
    }
}
