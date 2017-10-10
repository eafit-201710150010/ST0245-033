package taller11;

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
            System.out.println(node.data);
        }

    }

    public void recursivePrint() {
        recursivePrintAUX(root);
    }

    private boolean buscar(Node nodo, int n) {
        if (nodo == null) {
            return false;
        }
        if (nodo.data == n) {
            return true;
        }
        if (n > nodo.data) {
            return buscar(nodo.right, n);
        } else {
            return buscar(nodo.left, n);
        }
    }

    public boolean buscar(int n) {
        return buscar(root, n);
    }

    private void insertar(Node nodo, int n) {
        if (n > nodo.data) {
            if (nodo.right == null) {
                nodo.right = new Node(n);
            } else {
                insertar(nodo.right, n);
            }
        } else if (nodo.left == null) {
            nodo.left = new Node(n);
        } else {
            insertar(nodo.left, n);
        }
    }

    public void insertar(int n) {
        if (root == null) {
            root = new Node(n);
        } else {
            insertar(root, n);
        }
    }

    private Node getNode(Node nodo, int n) {
        if (nodo == null) {
            return null;
        }
        if (nodo.data == n) {
            return nodo;
        }
        if (n > nodo.data) {
            return getNode(nodo.right, n);
        } else {
            return getNode(nodo.left, n);
        }
    }
        /**
         * Por implementar
         */
//    private boolean borrar(Node raiz, int n) {
//        Node nodo = getNode(raiz, n);
//        if (nodo == null) {
//            return false;
//        }
//        return true;
//    }
//
//    public void borrar(int n) {
//        borrar(root,n);
//    }
}
