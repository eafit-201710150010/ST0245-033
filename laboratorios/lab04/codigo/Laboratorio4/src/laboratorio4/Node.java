package laboratorio4;

// Un nodo para una lista simplemente enlazada
public class Node {

    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        next = null;
        prev = null;
        this.data = data;
    }

}
