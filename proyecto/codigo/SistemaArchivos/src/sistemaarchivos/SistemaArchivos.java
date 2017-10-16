/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
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
        leerArchivo2();

        //Probando listar contenido de una carpeta
        LinkedList<Carpeta> coincidencias = tabla.get("bm");
        System.out.println("El contenido de las coincidencias bm:");
        System.out.println(tabla.contenidos(coincidencias));

        //Probando direccionamiento de carpetas
        coincidencias = tabla.get("ski-E3FE2DFD28D00BB5BAB6A2C4BF06AA058C93FB2FD6CC4A18.cer");

        System.out.println("La direccion de las carpetas que coinciden con ski-E3FE2DFD28D00BB5BAB6A2C4BF06AA058C93FB2FD6CC4A18.cer");
        System.out.println(tabla.direcciones(coincidencias));
        //Probando los atributos
        System.out.println("El metodo toString probado: ");
        tabla.imprimirCarpetas(coincidencias);
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
        try {
            BufferedReader archivo = new BufferedReader(new FileReader("treeEtc.txt"));
            String nombreRaiz = archivo.readLine();
            tabla = new ColeccionCarpetas(nombreRaiz);

            String linea;
            int nivel = 1;
            Carpeta padre = null, ultimoAgregado = null;
            while ((linea = archivo.readLine()) != null) {
                Scanner leerLinea = new Scanner(linea);
                if (leerLinea.hasNext()) {
                    String actual = leerLinea.next();
                    int numNivel = 1;
                    while (actual.startsWith("│")) {
                        numNivel++;
                        actual = leerLinea.next();
                    }
                    if (numNivel > nivel) {
                        padre = ultimoAgregado;
                        ultimoAgregado.setTipo(TipoCarpeta.Carpeta);
                        nivel++;
                    } else if (numNivel < nivel) {
                        padre = padre.getPadre();
                        nivel--;
                    }
                    //Esto porque todas las lineas tienen antes de los corchetes un |--[root
                    actual = leerLinea.next();
                    StringBuilder tamano = new StringBuilder(leerLinea.next());
                    //Para eliminar el ]
                    tamano.deleteCharAt(tamano.length() - 1);
                    String nombre = leerLinea.next();
                    ultimoAgregado = new Carpeta(padre, nombre, tamano.toString(), TipoCarpeta.Archivo);
                    tabla.put(nombre, ultimoAgregado);;
                } else {
                    break;
                }
            }
        } catch (IOException ex) {

        }
        return "";
    }
}
