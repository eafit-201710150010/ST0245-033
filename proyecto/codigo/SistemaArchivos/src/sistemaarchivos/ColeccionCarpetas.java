/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaarchivos;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Esta clase contiene la tabla de hash que permite la eficiencia de las
 * búsquedas de datos.
 *
 * @author ljpalaciom
 */
public class ColeccionCarpetas {

    private HashMap tabla;
    private String nombreTabla;

    /**
     * Este es el constructor que inicializa el HashMap.
     *
     * @param nombreTabla En el archivo txt se recibe un nombre inicial, este se
     * ingresa aqui como el nombre de la tabla.
     */
    public ColeccionCarpetas(String nombreTabla) {
        tabla = new HashMap<>();
        this.nombreTabla = nombreTabla;
    }

    /**
     * Este metodo permite ingresar un nuevo dato a la tabla de hash.
     *
     * @param clave Esta es la que se asocia con un valor de tipo carpeta o
     * archivo, asi cuando se busque la clave se obtiene este valor rapidamente.
     * @param carpeta
     */
    public void put(String clave, Carpeta carpeta) {
        LinkedList<Carpeta> auxiliar = (LinkedList<Carpeta>) tabla.get(clave);
        if (auxiliar == null) {
            auxiliar = new LinkedList<>();
        }
        auxiliar.add(carpeta);
        tabla.put(clave, auxiliar);
    }

    /**
     * Este metodo permite obtener una lista de la tabla de hash. Retorna null
     * si no lo encuentra.
     *
     * @param clave El string que se asocia con un valor de tipo carpeta o
     * archivo.
     * @return Una LinkedList con todos las carpetas de coincidan con la clave
     */
    public LinkedList<Carpeta> get(String clave) {
        return (LinkedList<Carpeta>) tabla.get(clave);
    }

     /**
     * Este metodo está hecho para retornar todos las rutas de una lista de
     * carpetas
     * @param coincidencias La lista de coincidencias que se analizará
     * @return Este metodo retorna una lista enlazada de listas de cadenas de
     * caracteres.
     */
    public LinkedList<LinkedList<String>> direcciones (LinkedList<Carpeta> coincidencias) {
        LinkedList<LinkedList<String>> retornar = new LinkedList<>();
        for (Carpeta carpeta : coincidencias) {
            retornar.add(carpeta.getDireccion()); 
        }
        return retornar;
    }

    /**
     * Este metodo está hecho para retornar todos los contenidos de una lista de
     * carpetas
     * @param coincidencias
     * @return Este metodo retorna una lista enlazada de listas de cadenas de
     * caracteres.
     */
    public LinkedList<LinkedList<String>> contenidos(LinkedList<Carpeta> coincidencias) {
        LinkedList<LinkedList<String>> retornar = new LinkedList<>();
        for (Carpeta carpeta : coincidencias) {
            if (carpeta.getTipo() == TipoCarpeta.Carpeta) {
                retornar.add(carpeta.listarContenido());
            }
        }
        return retornar;
    }

}
