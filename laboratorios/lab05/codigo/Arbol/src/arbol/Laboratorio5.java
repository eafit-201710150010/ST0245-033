package arbol;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scastrillg
 */
public class Laboratorio5 {
    public static void dibujarArbol(BinaryTree a)
   {
       System.out.println("/* arbolito para http://www.webgraphviz.com/ */"); 
       System.out.println("digraph arbolito {");
       System.out.println("size=\"6,6\";");
       System.out.println("node [color=aquamarine, style=filled];");
       dibujarArbolAux(a.root);
       System.out.println("}");
   }
   
   public static void dibujarArbolAux(Node nodo)
   {
      if (nodo != null)
         //"x_\n__" -> "xo\n__";
         for(Node n: new Node[] {nodo.left, nodo.right} ){
            if (n != null)
               System.out.println("\"" + nodo.name + "\" -> \"" + n.name + "\";");
            dibujarArbolAux(n);
        }
   }

    
    public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
        tree.insertar("m", "santiago","");
        tree.insertar("m", "jesus", "santiago");
        tree.insertar("f", "mery", "santiago");
        tree.insertar("m", "jose", "jesus");
        tree.insertar("m", "joaquin", "mery");
        tree.insertar("f", "margarita", "jesus");
        tree.insertar("f", "margareth", "mery");
        tree.insertar("f", "manuela", "margareth");
        tree.insertar("m", "oscar", "margareth");
        tree.insertar("f", "miriam", "margarita");
        tree.insertar("m", "pedro", "margarita");
        tree.insertar("m", "juan david", "jose");
         tree.insertar("f", "gloria", "jose");
        tree.insertar("m", "jorge", "joaquin");
        tree.insertar("f", "elena", "joaquin");
            
        //Imprime el árbol familiar
        tree.recursivePrint();

        //Dibuja el árbol familiar
        dibujarArbol(tree);
        System.out.println(tree.abuelaMaterna("santiago"));
        
    }
    
}
