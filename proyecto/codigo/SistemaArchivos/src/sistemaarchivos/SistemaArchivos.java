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
        leerArchivo();
        //Para agregar a las pruebas de Junit en el futuro
//        Carpeta Padre1 = new Carpeta(null, "Alpha", "500M", TipoCarpeta.Carpeta);
//        Carpeta Padre2 = new Carpeta(Padre1, "Beta", "500M", TipoCarpeta.Carpeta);
//        Carpeta Padre3 = new Carpeta(Padre2, "Cisko", "500M", TipoCarpeta.Carpeta);
//        Carpeta Hijo = new Carpeta(Padre3, "Rafa", "500M", TipoCarpeta.Archivo);
//        tabla.put("Beta", Padre1);
//        tabla.put("Cisko", Padre2);
//        tabla.put("Rafa", Padre3);
//        tabla.put("Rafa", Hijo);
//        Carpeta hijo = tabla.get("Rafa");
//        System.out.println();
//        System.out.println(hijo.getDireccion());
//        System.out.println(Padre1.listarContenido());
       //Probando listar contenido de una carpeta
        Carpeta carpeta = tabla.get("/Plantillas");
        System.out.println("El contenido de la carpeta Plantillas: " + carpeta.listarContenido());
        
    //Probando direccionamiento de carpetas
        carpeta = tabla.get("sig-alternate-sample.tex");
        
        System.out.println("La direccion de la carpeta " + carpeta.getDireccion());
        
     //Probando los atributos
        System.out.println("El metodo toString probado: "  + carpeta);
    }

    /**
     * Este metodo permite leer un archivo txt que tenga formato de directorios
     * y luego hacer búsquedas sobre éste.
     *  El formato de archivo es: 
     * nombreprincipal/
     * ── 4.0K /DataSets
     * ── ── 252K treeEtc.txt
     * Las barras indican el nivel del directorio, luego se ingresa el tamaño.Después si es un directorio un 
     * "/" y el nombre del directorio. Si es un archivo no se le pone nada.


     * @return Un String vacio si todo salio bien, de lo contrario un mensaje de error.
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
}
