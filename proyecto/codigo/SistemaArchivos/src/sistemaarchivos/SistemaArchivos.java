/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaarchivos;

import java.io.File;
import java.io.FileNotFoundException;
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
        //leerArchivo();
     

//        //Probando listar contenido de una carpeta
//        LinkedList<Carpeta> coincidencias = tabla.get("/Plantillas");
//        System.out.println("El contenido de las coincidencias Plantillas: ");
//        System.out.println(tabla.contenidos(coincidencias));

//    //Probando direccionamiento de carpetas
//        carpeta = tabla.get("sig-alternate-sample.tex");
//        
//        System.out.println("La direccion de la carpeta " + carpeta.getDireccion());
//        
//     //Probando los atributos
//        System.out.println("El metodo toString probado: "  + carpeta);
    }

    /**
     * Este metodo permite leer un archivo txt que tenga formato de directorios
     * y luego hacer búsquedas sobre éste. El formato de archivo es:
     * nombreprincipal/ ── 4.0K /DataSets ── ── 252K treeEtc.txt Las barras
     * indican el nivel del directorio, luego se ingresa el tamaño.Después si es
     * un directorio un "/" y el nombre del directorio. Si es un archivo no se
     * le pone nada.
     *
     *
     * @return Un String vacio si todo salio bien, de lo contrario un mensaje de
     * error.
     */
    public static String leerArchivo() {
        Carpeta padre = null, actual = null;
        int nivel = 1;
        try {
            Scanner archivo = new Scanner(new File("carpeta.txt"));
            Scanner leerLinea;
            if (archivo.hasNextLine()) {
                leerLinea = new Scanner(archivo.nextLine());
                leerLinea.useDelimiter("/");
                String nombreRaiz = leerLinea.next();
                tabla = new ColeccionCarpetas(nombreRaiz);

                while (archivo.hasNextLine()) {
                    leerLinea = new Scanner(archivo.nextLine());
                    leerLinea.useDelimiter(" ");

                    String dato = leerLinea.next();
                    int numNivel = 0;
                    while (dato.equals("──")) {
                        dato = leerLinea.next();
                        numNivel++;
                    }

                    String tamano = dato;
                    leerLinea.useDelimiter("\n");
                    String aux = leerLinea.next();
                    String nombre = aux.substring(1);
                    if (numNivel > nivel) {
                        padre = actual;
                        nivel++;
                    } else if (numNivel < nivel) {
                        nivel--;
                        padre = padre.getPadre();
                    }
                    if (nombre.charAt(0) == '/') {
                        actual = new Carpeta(padre, nombre, tamano, TipoCarpeta.Carpeta);
                    } else {
                        actual = new Carpeta(padre, nombre, tamano, TipoCarpeta.Archivo);
                    }
                    tabla.put(nombre, actual);
                }
            }
        } catch (FileNotFoundException e) {
            return "No se ha encontrado el archivo Carpetas.txt en el directorio del programa";
        }

        return "";
    }

    /**
     * Sin revisar
     *
     * @return
     */
    public static String leerArchivo2() {
        Carpeta padre = null, actual = null;
        int nivel = 0;
        try {
            Scanner archivo = new Scanner(new File("carpeta.txt"));
            Scanner leerLinea;
            if (archivo.hasNextLine()) {
                leerLinea = new Scanner(archivo.nextLine());
                leerLinea.useDelimiter("/");
                String nombreRaiz = leerLinea.next();
                tabla = new ColeccionCarpetas(nombreRaiz);

                while (archivo.hasNextLine()) {
                    leerLinea = new Scanner(archivo.nextLine());
                    leerLinea.useDelimiter(" ");

                    String dato = leerLinea.next();
                    int numNivel = 0;
                    while (dato.equals("──")) {
                        dato = leerLinea.next();
                        numNivel++;
                    }

                    String tamano = dato;
                    leerLinea.useDelimiter("\n");
                    String aux = leerLinea.next();
                    String nombre = aux.substring(1);
                    if (numNivel > nivel) {
                        padre = actual;
                        nivel++;
                    } else if (numNivel < nivel) {
                        nivel--;
                        padre = padre.getPadre();
                    }
                    if (nombre.charAt(0) == '/') {
                        actual = new Carpeta(padre, nombre, tamano, TipoCarpeta.Carpeta);
                    } else {
                        actual = new Carpeta(padre, nombre, tamano, TipoCarpeta.Archivo);
                    }
                    tabla.put(nombre, actual);
                }
            }
        } catch (FileNotFoundException e) {
            return "No se ha encontrado el archivo Carpetas.txt en el directorio del programa";
        }

        return "";
    }
}
