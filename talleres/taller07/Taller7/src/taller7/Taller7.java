/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller7;

import java.util.LinkedList;

/**
 *
 * @author cl18412
 */
public class Taller7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedListMauricio list = new LinkedListMauricio();

        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(20, 0);
        System.out.println("El valor maximo es " + list.maximo());
       
        System.out.println("Imprimir normal: ");
        list.imprimir();
        System.out.println("Imprimir invero");
        list.imprimirInverso();
        
        LinkedListMauricio list1 = new LinkedListMauricio();
        LinkedListMauricio list2 = new LinkedListMauricio();
        for (int i = 0; i < 3; i++) {
            list1.insert(i + 1, i);
            list2.insert(i + 1, i);
        } 
        System.out.println("¿Las listas son iguales? " + LinkedListMauricio.compare(list1, list2));
    }

}
