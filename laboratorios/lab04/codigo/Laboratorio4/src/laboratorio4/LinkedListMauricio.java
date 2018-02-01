package laboratorio4;

import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada

public class LinkedListMauricio {

    private Node first;
    private Node last;
    private int size;

    public LinkedListMauricio() {
        size = 0;
        first = null;
        last = null;
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
            Node temp;
            if (index < size / 2) {
                temp = first;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
            } else {
                temp = last;
                for (int i = size - 1; i > index; i--) {
                    temp = temp.prev;
                }
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

    /**
     * Retorna el tamaño actual de la lista
     */
    public int size() {
        return size;
    }

    /**
     * Inserta un dato en la posición index
     */
    public void insert(int data, int index) {
        Node nuevo = new Node(data);
        if (size == 0) {
            first = nuevo;
            last = nuevo;
        } else if (index == 0) {
            first.prev = nuevo;
            nuevo.next = first;
            first = nuevo;
        } else if (index == size - 1) {
            nuevo.prev = last;
            last.next = nuevo;
            last = nuevo;
        } else {
            Node temp = getNode(index - 1);
            nuevo.prev = temp;
            nuevo.next = temp.next;
            temp.next = nuevo;
            temp.next.prev = nuevo;
        }
        size++;
    }

    /**
     * Borra el dato en la posición index
     *
     * @param index
     */
    public void remove(int index) {
        if (index == 0) {
            first = first.next;
            first.prev = null;
        } else if (index == size - 1) {
            last = last.prev;
            last.next = null;
        } else {
            Node temp = getNode(index - 1);
            temp.next = temp.next.next;
            temp.next.next.prev = temp;
        }
        size--;
    }

    /**
     * Verifica si está un dato en la lista
     *
     * @param data
     * @return
     */

    public boolean contains(int data) {
        Node temp = first;
        for (int i = 0; i < size; i++) {
            if (data == temp.data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}
