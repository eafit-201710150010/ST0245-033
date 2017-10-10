package laboratorio3;

import java.util.*;

public class Laboratory2 {

    /**
     * Este método recibe una lista y devuelve la multiplicación de todos los
     * números introducidos en ella
     *
     * @param list
     * @return Un entero
     */
    public static int multiply(List<Integer> list) {
        int acum = 1;
        for (int i = 0; i < list.size(); i++) {
            acum *= list.get(i);
        }
        return acum;
    }

    /**
     * Este metodo toma una lista y le añade un dato siempre y cuando el dato no
     * este incluido en la lista
     *
     * @param list es la lista que usaremos para añadir el dato
     * @param data es el dato que añadiremos a la lista
     */
    public static void smartInsert(List<Integer> list, int data) {
        if (!list.contains(data)) {
            list.add(data);
        }
        System.out.println(list);
    }

    /**
     * Este metodo busca la posicion optima para poner un pivote que equilibre
     * los pesos
     *
     * @param list lista que contiene las materas
     */
    public static void pivote(List<Integer> list) {
        int izq = 0;
        int der = 0;
        int res = 0;
        int total = 100000000;
        int pos = 0;
        for (int i = 1; i < list.size() - 2; i++) {
            for (int j = 0; j < i; j++) {
                izq += list.get(j);
            }
            for (int j = i + 1; j < list.size() - 2; j++) {
                der += list.get(j);
            }
            res = Math.abs(izq - der);
            if (res < total) {
                total = res;
                pos = i;
            }
        }
        System.out.println(pos + 1);
    }

    /**
     * Este método recibe neveras, en la forma en que están ordenadas en el
     * almacén, y las solicitudes, según el orden en que llegaron, asigna las
     * neveras a cada tienda.
     *
     * @param neveras
     * @param solicitudes
     */
    public static void ejercicio4(List neveras, List<Solicitud> solicitudes) {
        for (int i = solicitudes.size() - 1; i >= 0; i--) {
            Solicitud soli = solicitudes.get(i);
            while (soli.getCantidad() > 0 && neveras.size() > 0) {
                Nevera last = (Nevera) neveras.get(neveras.size()- 1);
                soli.getAsignadas().add(last);
                soli.setCantidad(soli.getCantidad() - 1);
                neveras.remove(last);
            }
        }
    }

    /**
     * Tests the methods.
     *
     * @param args
     */
    public static void main(String[] args) {

        LinkedList<Integer> linked = new LinkedList<>();
        linked.addAll(Arrays.asList(new Integer[]{1, 3, 5, 7}));

        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Integer[]{2, 4, 6, 8}));

        // Multiply
        System.out.println("Multiplicacion: ");
        System.out.println(multiply(linked));
        System.out.println(multiply(array) + "/n");
        
        System.out.println("Almacen de neveras: ");
        // Almacen de neveras
        LinkedList<Nevera> almacen = new LinkedList<>();
        almacen.add(new Nevera(1, "haceb"));
        almacen.add(new Nevera(2, "lg"));
        almacen.add(new Nevera(3, "ibm"));
        almacen.add(new Nevera(4, "haceb"));
        almacen.add(new Nevera(5, "lg"));
        almacen.add(new Nevera(6, "ibm"));
        almacen.add(new Nevera(7, "haceb"));
        almacen.add(new Nevera(8, "lg"));
        almacen.add(new Nevera(9, "ibm"));
        almacen.add(new Nevera(8, "lg"));
        almacen.add(new Nevera(9, "ibm"));

        LinkedList<Solicitud> solicitudes = new LinkedList<>();

        solicitudes.add(new Solicitud("eafit", 10));
        solicitudes.add(new Solicitud("la14", 2));
        solicitudes.add(new Solicitud("olimpica", 4));
        solicitudes.add(new Solicitud("éxito", 1));
        ejercicio4(almacen, solicitudes);

        for (int i = solicitudes.size() - 1; i >= 0; i--) {
            Solicitud soli = solicitudes.get(i);
            System.out.print(soli.getNombre() + ":");
            System.out.println(soli.getAsignadas());

        }
        System.out.println("");
        
        //Para pivote y smartInsert Pivote
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(8);
        a.add(2);
        a.add(3);
        a.add(5);
        a.add(7);
        a.add(4);

        //Pivote
        System.out.print("El pivote es: ");
        pivote(a);

        //smartInsert
        smartInsert(a, 6);
        smartInsert(a, 6);
    }

}
