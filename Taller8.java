package Taller8;

import java.util.*;

/**
 *
 * @author
 */
public class Taller8 {

    //Punto 1
    public static Stack<Integer> inversa(Stack<Integer> stack) {
        Queue<Integer> cola = new LinkedList<>();
        while (!stack.isEmpty()) {
            cola.add(stack.pop());
        }
        while (!cola.isEmpty()) {
            stack.push(cola.remove());
        }

        return stack;
    }

    //Punto 2
    public static void cola(Queue<String> queue) {
        while (!queue.isEmpty()) {
            System.out.println("Atendiendo a: " + queue.remove());
        }
    }

    //notacion polaca
    public static int polaca(String string) {
        Stack<Integer> pila = new Stack<>();
        for (int i = 0; i < string.length(); i += 2) {
             
            if (Character.isDigit(actual)) {
                pila.push(Character.getNumericValue(actual));
            } else {
                
                int factor1 = pila.pop();
                int factor2 = pila.pop();
                int aux;
                switch (actual) {
                    case '+':
                        aux = factor1 + factor2;
                        pila.push(aux);
                        break;
                    case '-':
                        aux = factor1 - factor2;
                        pila.push(aux);
                        break;
                    case '*':
                        aux = factor1 * factor2;
                        pila.push(aux);
                        break;
                    case '/':
                        aux = factor1 / factor2;
                        pila.push(aux);
                        break;
                }
                string = string.split(" ");
            }
        }
        return pila.pop();
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Juan");
        queue.add("María");
        queue.add("Pedro");
        cola(queue);
      
        String s1 = "3 5 * 12 + 13 -";
        System.out.println(polaca(s1));
    }
}
