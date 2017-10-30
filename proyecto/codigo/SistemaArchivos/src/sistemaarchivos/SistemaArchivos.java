package sistemaarchivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Clase principal que contiene el metodo leerArchivo
 * @author ljpalaciom
 */
public class SistemaArchivos {

    static BufferedReader leer;
    static ColeccionCarpetas tabla;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        leerArchivo("treeEtc.txt");
        long estimated = System.currentTimeMillis();
        System.out.println("Tiempo para leer el archivo: " + (estimated - startTime) + " ms");
         try{
             menu();
         } catch(Exception e){
         }
        System.out.println("Gracias, vuelve pronto");
       Double promedio = probarLosTiempos();
       System.out.println("El promedio de una busqueda de coincidencias " + promedio);
    }

    public static void menu() throws Exception {
        leer = new BufferedReader(new InputStreamReader(System.in));
        boolean quedarme = true;
        String opcion;
        do {
            System.out.println("MENU PRINCIPAL\n"
                    + "Ingrese 0 para salir\n"
                    + "Ingrese 1 para hacer busquedas con el nombre de la carpeta o archivo\n"
                    + "Ingrese 2 para hacer búsquedas con la ruta");
            opcion = leer.readLine();
            switch (opcion) {
                case "1":
                    subMenu1();
                    break;
                case "2":
                    subMenu2();
                    break;
            }
        } while (!"0".equals(opcion));
    }

    public static void subMenu1() {

        System.out.println("MENU DE BUSQUEDAS POR NOMBRE: BUSQUEDA GENERAL\n"
                + "Ingrese 0 para volver al menu principal\n"
                + "Ingrese 1 para imprimir información de una carpeta o archivo\n"
                + "Ingrese 2 para imprimir los contenidos de una carpeta\n"
                + "Ingrese 3 para imprimir los contenidos de una carpeta por usuario\n"
                + "Ingrese 4 para imprimir los contenidos de una carpeta que pesen más de un tamaño dado\n"
                + "Ingrese 5 para imprimir las posibles rutas de una carpeta o archivo");
        String nombre, usuario, tamano;
        try {
            switch (leer.readLine()) {
                case "1":
                    System.out.println("Ingrese el nombre de la carpeta");
                    nombre = leer.readLine();
                    tabla.imprimirCarpetas(nombre);
                    System.out.println();
                    break;
                case "2":
                    System.out.println("Ingrese el nombre de la carpeta");
                    nombre =  leer.readLine();
                    tabla.contenidos(nombre);
                    System.out.println();
                    break;
                case "3":
                    System.out.println("Ingrese el nombre de la carpeta");
                    nombre =  leer.readLine();
                    System.out.println("Ingrese el nombre del usuario");
                    usuario = leer.readLine();
                    tabla.contenidosUsuario(nombre, usuario);
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Ingrese el nombre de la carpeta");
                    nombre =  leer.readLine();
                    System.out.println("Ingrese el tamano");
                    tamano = leer.readLine();
                    tabla.contenidosMayor(nombre, tamano);
                    System.out.println();
                    break;
                case "5":
                    System.out.println("Ingrese el nombre de la carpeta");
                    nombre = leer.readLine();
                    tabla.direcciones(nombre);
                    System.out.println();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void subMenu2() {
        System.out.println("MENU DE BUSQUEDAS POR RUTA: BUSQUEDA ESPECIFICA\n"
                + "Ingrese 0 para volver al menu principal\n"
                + "Ingrese 1 para imprimir información de una carpeta o archivo\n"
                + "Ingrese 2 para imprimir los contenidos de una carpeta\n"
                + "Ingrese 3 para imprimir los contenidos de una carpeta por usuario\n"
                + "Ingrese 4 para imprimir los contenidos de una carpeta que pesen más de un tamaño dado\n");
        String nombre, usuario, tamano, direccion;
        Carpeta carpeta;
        try {
            switch (leer.readLine()) {
                case "1":
                    System.out.println("Ingrese la direccion la carpeta");
                    direccion = leer.readLine();
                    nombre = direccion.substring(direccion.lastIndexOf("/") + 1);
                    carpeta = tabla.get(nombre, direccion);
                    System.out.println(carpeta);
                    System.out.println();
                    break;
                case "2":
                    System.out.println("Ingrese la direccion la carpeta");
                    direccion = leer.readLine();
                    nombre = direccion.substring(direccion.lastIndexOf("/") + 1);
                    carpeta = tabla.get(nombre, direccion);
                    System.out.println(carpeta.listarContenido());
                    System.out.println();
                    break;
                case "3":
                    System.out.println("Ingrese la direccion la carpeta");
                    direccion = leer.readLine();
                    nombre = direccion.substring(direccion.lastIndexOf("/") + 1);
                    carpeta = tabla.get(nombre, direccion);

                    System.out.println("Ingrese el usuario de la carpeta");
                    usuario = leer.readLine();
                    System.out.println(carpeta.listarContenidoUsuario(usuario));
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Ingrese la direccion la carpeta");
                    direccion = leer.readLine();
                    nombre = direccion.substring(direccion.lastIndexOf("/") + 1);
                    carpeta = tabla.get(nombre, direccion);

                    System.out.println("Ingrese el tamano");
                    tamano = leer.readLine();
                    System.out.println(carpeta.listarContenidoMayor(tamano));
                    System.out.println();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este metodo permite leer un archivo txt y luego hacer búsquedas sobre
     * éste. La primera linea es el directorio raiz etc/, no será tomado en
     * cuenta en las direcciones. El numero de caracteres hasta '[' permitiran
     * conocer la profundidad del archivo que se lee. Se incluye un archivo con
     * el formato que acepta este metodo.
     *
     * @param nombreArchivo Nombre de archivo a leer
     *
     */
    public static void leerArchivo(String nombreArchivo) {
        try {
            BufferedReader archivo = new BufferedReader(new FileReader(nombreArchivo));
            String nombreRaiz = archivo.readLine();
            tabla = new ColeccionCarpetas();
            String linea;
            int nivel = 4;
            Carpeta padre = new Carpeta(null, "", nombreRaiz.substring(1), "", TipoCarpeta.Carpeta);
            tabla.put(nombreRaiz, padre);
            Carpeta ultimoAgregado = null;

            while ((linea = archivo.readLine()) != null) {
                Scanner leerLinea = new Scanner(linea);
                if (leerLinea.hasNext()) {
                    leerLinea.useDelimiter("[a-z]");
                    String actual = leerLinea.next();

                    int numNivel = actual.length() - 1;
                    if (numNivel > nivel) {
                        ultimoAgregado.cambiarACarpeta();
                        padre = ultimoAgregado;
                        nivel += 4;
                    } else if (numNivel < nivel) {
                        padre = padre.getPadre();
                        nivel -= 4;
                    }
                    leerLinea.reset();
                    String usuario = leerLinea.next();
                    StringBuilder tamano = new StringBuilder(leerLinea.next());
                    tamano.deleteCharAt(tamano.length() - 1); //Para eliminar el ]
                    leerLinea.useDelimiter("  ");
                    String nombre = leerLinea.next();
                    ultimoAgregado = new Carpeta(padre, usuario, nombre, tamano.toString(), TipoCarpeta.Archivo);
                    tabla.put(nombre, ultimoAgregado);
                } else {
                    archivo.close();
                    leerLinea.close();
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println("No se ha encontrado el archivo treeEtc.txt en el directorio del programa o el archivo esta corrupto");
        }
    }

    public static Double probarLosTiempos() {
        Double promedio = 0.;
        long startTime = 0, estimated = 0;
        for (int i = 0; i < 100; i++) {
            startTime = System.currentTimeMillis();
            String nombre = "events";
            String ruta = "etc/acpi/events";
            try {
                tabla.contenidos(nombre);
                estimated = System.currentTimeMillis();
            } catch (Exception e) {
            }
            promedio += (estimated - startTime);
        }
        return promedio / 100;
    }
}
