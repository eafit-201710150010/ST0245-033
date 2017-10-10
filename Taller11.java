package taller11;

import java.util.HashMap;
import java.util.LinkedList;

public class Taller11 {

    public static void dibujarArbol(BinaryTree a) {
        System.out.println("/* arbolito para http://www.webgraphviz.com/ */");
        System.out.println("digraph arbolito {");
        System.out.println("size=\"6,6\";");
        System.out.println("node [color=aquamarine, style=filled];");
        dibujarArbolAux(a.root);
        System.out.println("}");
    }

    public static void dibujarArbolAux(Node nodo) {
        if (nodo != null) //"x_\n__" -> "xo\n__";
        {
            for (Node n : new Node[]{nodo.left, nodo.right}) {
                if (n != null) {
                    System.out.println("\"" + nodo.data + "\" -> \"" + n.data + "\";");
                }
                dibujarArbolAux(n);
            }
        }
    }

    public static void main(String[] args) {

        //Crea el árbol familiar
        BinaryTree tree = new BinaryTree();
        // ...
        tree.insertar(5);
        tree.insertar(3);
        tree.insertar(7);
        tree.insertar(6);
        tree.insertar(8);
        tree.insertar(9);
        
        //Imprime el árbol familiar
        tree.recursivePrint();

        //Dibuja el árbol familiar
        dibujarArbol(tree);
        //Ayuda con proyecto
        //HashMap<String,LinkedList<Carpeta>> hola = new HashMap();

    }
}
