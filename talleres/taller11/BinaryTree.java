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
                nodo.right.padre = nodo;
            } else {
                insertar(nodo.right, n);
            }
        } else if (nodo.left == null) {
            nodo.left = new Node(n);
            nodo.left.padre = nodo;
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

    private void caso1(Node nodo, Node left, Node right, boolean isLeft) {
        if (isLeft) {
            nodo.padre.left = null;
        } else {
            nodo.padre.right = null;
        }
    }

    private void caso2(Node nodo, Node left, Node right, boolean isLeft) {
        Node auxiliar = left;
        if (auxiliar == null) {
            auxiliar = right;
        }
        if (isLeft) {
            nodo.padre.left = auxiliar;
        } else {
            nodo.padre.right = auxiliar;
        }
    }

    private void caso3(Node nodo, Node left, Node right) {
        Node temp = right;
        boolean isLeft = true;
        System.out.println("soy temp " + temp + " Mi hijo es: " + temp.left);
        while (temp.left != null) {
            System.out.println("Entre");
            temp = temp.left;
        }

        if (temp == right) {
            isLeft = false;
        }
        nodo.data = temp.data;
        left = temp.left;
        right = temp.right;

        if (right == null) {
            caso1(temp, left, right, isLeft);
        } else {
            caso2(temp, left, right, isLeft);
        }

    }

    private boolean borrar(Node raiz, int n) {
        Node nodo = getNode(raiz, n);
        if (nodo == null) {
            return false;
        }

        Node left = nodo.left;
        Node right = nodo.right;
        if (nodo == raiz) {
            caso3(nodo, left, right);
        } else {
            boolean isLeft = false;
            if (nodo == nodo.padre.left) {
                isLeft = true;
            }
            //Sin hijos
            if (left == null && right == null) {
                caso1(nodo, left, right, isLeft);
            } //Con un hijo
            else if (left == null || right == null) {
                caso2(nodo, left, right, isLeft);
            } else {
                caso3(nodo, left, right);
            }
        }
        return true;
    }

    public void borrar(int n) {
        borrar(root, n);
    }
}
