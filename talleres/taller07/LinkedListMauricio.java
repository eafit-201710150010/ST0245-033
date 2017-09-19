package taller7;

// Una lista simplemente enlazada
public class LinkedListMauricio {

    private Node first;
    private int size;

    public LinkedListMauricio() {
        size = 0;
        first = null;
    }

    /**
     * Returns the node at the specified position in this list.
     *
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return temp.data;
    }

// Retorna el tamaño actual de la lista
    public int size() {
        return size;
    }

// Inserta un dato en la posición index
    public void insert(int data, int index) {
        Node nuevo = new Node(data);
        if (index == 0) {
            nuevo.next = first;
            first = nuevo;
            size++;
        } else {
            try {
                Node temporal = getNode(index - 1);
                nuevo.next = temporal.next;
                temporal.next = nuevo;
                size++;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No está ese índice");
            }

        }
    }

// Borra el dato en la posición index
    public void remove(int index) {
        if (size == 0) {
            System.out.println("Aún no hay elementos en la lista");
        } else if (index == 0) {
            first = first.next;
            size--;
        } else {
            try {
                Node temporal = getNode(index - 1);
                if (index == size) {
                    temporal.next = null;
                } else {
                    temporal.next = temporal.next.next;
                }
                size--;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No está ese índice");
            }
        }
    }

    private int maximoAux(Node node) {
        if (node.next == null) {
            return node.data;
        }
        return Math.max(node.data, maximoAux(node.next));
    }

    public int maximo() {
        return maximoAux(first);
    }

// Verifica si está un dato en la lista
    public boolean contains(int data) {
        if (size == 0) {
            return false;
        }
        Node temporal = first;
        while (temporal.next != null) {
            if (temporal.data == data) {
                return true;
            }
            temporal = temporal.next;
        }
        return false;
    }

    public void imprimir() {
        for (int i = 0; i < size; i++) {
            System.out.println(get(i));
        }
    }

// Imprime la lista de manera inversa
    public void imprimirInverso() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(get(i));
        }
    }
    //Compara dos listas

    public static boolean compare(LinkedListMauricio list1, LinkedListMauricio list2) {
        if (list1.size != list2.size) {
            return false;
        }
        for (int i = 0; i < list1.size; i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }
}
