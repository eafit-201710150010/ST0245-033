package taller6;

/**
 *
 * @author ljpalaciom
 */
import java.util.Arrays;

public class MiArrayList {

    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[];

    // Inicializa los atributos size en cero y elements como un arreglo de tamaño  DEFAULT_CAPACITY. No, no recibe parámetros.
    public MiArrayList() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY];
    }

    // Retorna el tamaño de la lista
    public int size() {
        return size;
    }

    // Agrega un elemento e a la última posición de la lista
    public void add(int e) {
        if (size == elements.length) {
            duplicarArreglo();
        }
        elements[size] = e;
        size++;
    }

    // Retorna el elemento que se encuentra en la posición i de la lista
    public int get(int i) throws Exception {
        return elements[i];
    }

    // Agrega un elemento e en la posición index de la lista
    public void add(int index, int e) throws Exception {
        if (index <= size) {
            if (elements.length == size) {
                duplicarArreglo();
            }
            moverDerecha(index);
            elements[index] = e;
            size++;
        } else {
            throw new Exception("index invalido");
        }
    }

    private void duplicarArreglo() {
        int[] aux = Arrays.copyOf(elements, elements.length * 2);
        elements = aux;
    }

    private void moverDerecha(int index) {
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }

}
