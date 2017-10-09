package laboratorio4;

import java.util.LinkedList;
import java.util.Queue;

public class Laboratorio3 {
    
    public static void main(String[] args) {
        
        LinkedListMauricio list = new LinkedListMauricio();
        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        System.out.println(list.contains(3));
        list.remove(2);
        System.out.println(list.contains(3));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //Bank
        LinkedList<Queue> filas = new LinkedList<>();
        Queue<String> primera = new LinkedList();
        Queue<String> segunda = new LinkedList();
        Queue<String> tercera = new LinkedList();
        Queue<String> cuarta = new LinkedList();
        primera.add("Armando 1");
        primera.add("Armando 2");
        
        segunda.add("Felipe 1");
        segunda.add("Felipe 2");
        segunda.add("Felipe 3");
        
        tercera.add("Laura 1");
        
        cuarta.add("Daniela 1");
        cuarta.add("Daniela 2");
        cuarta.add("Daniela 3");
        cuarta.add("Daniela 4");
        
        filas.add(primera);
        filas.add(segunda);
        filas.add(tercera);
        filas.add(cuarta);
        Bank.simular(filas);

        //Invertir cadenas
        LinkedList<String> lista = new LinkedList<>();
        lista.add("dias");
        lista.add("bueno");
        lista.add("Muy");
        System.out.println(lista);
        lista = Simulacro.invertir(lista);
        System.out.println(lista);

        //Personas 
        Queue<Integer> personas = new LinkedList();
        personas.add(25);
        personas.add(40);
        personas.add(80);
        personas.add(80);
        personas.add(35);
        personas.add(55);
        personas = Simulacro.organizar(personas);
        System.out.println(personas);
        
    }
    
}
