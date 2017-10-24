package sistemaarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author ljpalaciom
 */
public class SistemaArchivos {

    static ColeccionCarpetas tabla;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        leerArchivo("treeEtc.txt");
        long estimated = System.currentTimeMillis();
        System.out.println("Tiempo para leer el archivo: " + (estimated - startTime));
        startTime = System.currentTimeMillis();
        //Probando listar contenido de una carpeta
        LinkedList<Carpeta> coincidencias = tabla.get("bm");
        System.out.println("El contenido de las coincidencias bm:");
        System.out.println(tabla.contenidos(coincidencias));

        //Ultimo elemento del archivo
        coincidencias = tabla.get("zsh_command_not_found");
        System.out.println("El toString con zsh_command_not_found:");
        System.out.println(coincidencias);

        //Probando direccionamiento de carpetas
        coincidencias = tabla.get("ski-E3FE2DFD28D00BB5BAB6A2C4BF06AA058C93FB2FD6CC4A18.cer");
        System.out.println("La direccion de las carpetas que coinciden con ski-E3FE2DFD28D00BB5BAB6A2C4BF06AA058C93FB2FD6CC4A18.cer");
        System.out.println(tabla.direcciones(coincidencias));

        //Probando los atributos
        System.out.println("El metodo toString probado: ");
        tabla.imprimirCarpetas(coincidencias);

        System.out.println();
        leerArchivo("ejemplito.txt");
        coincidencias = tabla.get("DataSets");
        System.out.println("El contenido de las coincidencias DataSets:");
        System.out.println(tabla.contenidos(coincidencias));
        coincidencias = tabla.get("Plantillas");
        System.out.println("El contenido de las coincidencias de Plantillas con tamaño mayor a 1M:");
        System.out.println(tabla.contenidosMayor(coincidencias, "1M"));
        System.out.println("directorios que se encuentran en “Plantillas” cuyo dueño sea el usuario root");
        System.out.println(tabla.contenidosUsuario(coincidencias, "root"));

        coincidencias = tabla.get("Datos3");

        estimated = System.currentTimeMillis();
        System.out.println("Tiempo para las consultas: " + (estimated - startTime));
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
            Carpeta padre = new Carpeta(null, "", nombreRaiz, "", TipoCarpeta.Carpeta);
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
}
