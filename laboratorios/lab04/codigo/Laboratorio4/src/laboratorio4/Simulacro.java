package laboratorio4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author ljpalaciom
 */
public class Simulacro {
    
    public static Queue<Integer> organizar(Queue<Integer> personas) {
        int mayorEdad = 0;
        int edad = 0;
        Queue<Integer> auxiliar1 = new LinkedList<Integer>();
        Queue<Integer> auxiliar2 = new LinkedList<Integer>();
        while (personas.size() > 0) {
            edad = personas.poll();
            if (edad > mayorEdad) {
                mayorEdad = edad;
            }
            auxiliar1.offer(edad);
            auxiliar2.offer(edad);
        }
        while (!auxiliar1.isEmpty()) {
            edad = auxiliar1.poll();
            if (edad == mayorEdad) {
                personas.offer(edad);
            }
        }
        while (!auxiliar2.isEmpty()) {
            edad = auxiliar2.poll();
            if (edad != mayorEdad) {
                personas.offer(edad);
            }
            
        }
        return personas;
    }
    
    public static LinkedList<String> invertir(LinkedList<String> lista) {
        Stack<String> auxiliar = new Stack<String>();
        while (lista.size() > 0) {
            auxiliar.push(lista.removeFirst());
        }
        while (auxiliar.size() > 0) {
            lista.add(auxiliar.pop());
        }
        return lista;
    }
}
