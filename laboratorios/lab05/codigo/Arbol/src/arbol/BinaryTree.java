package arbol;

/**
 *
 * @author scastrillg
 */
public class BinaryTree {

     public Node root;

    public BinaryTree() {
        root = null;
    }
      private int max2(int i, int j) {
        if (i > j) {
            return i;
        }
        return j;
    }

    private int maxheightAUX(Node node) {
        if (node == null) {
            return 0;
        } else {
            return max2(maxheightAUX(node.left), maxheightAUX(node.right)) + 1;
        }
    }

    public int maxheight() {
        return maxheightAUX(root);
    }

    private void recursivePrintAUX(Node node) {
        if (node != null) {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.name);
        }

    }

    public void recursivePrint() {
        recursivePrintAUX(root);
    }

    private Node buscar(Node nodo, String name) {
       
        if (nodo==null) {
            return nodo;
        }
        
        if (nodo.name.equals(name)) {
            return nodo;
        }
        
        Node der=buscar(nodo.right, name); 
        if(der==null){
        return buscar(nodo.left, name);
        
        }else{
        return der;
        }
    }

    public Node buscar(String name) {
        return buscar(root, name);
    }

    private void insertar(Node nodo, String n, String name, String hijo) {
        
        Node aux=buscar(hijo);
        if (n.equals("m")) {
            if (aux.right == null) {
                aux.right = new Node(n, name);
            }            
        } else if (n.equals("f")) {
            aux.left = new Node(n, name);
        }
    }

    public void insertar(String n, String name, String hijo) {
        if (root == null) {
            root = new Node(n, name);
        } else {
            insertar(root, n, name, hijo);
        }
    }
    public String abuelaMaterna(String name){
        Node aux=buscar(name);
        if (aux.left!=null && aux.left.left!=null){
        return aux.left.left.name;
        }else {
            return "";
        }
  
    }

 
}
