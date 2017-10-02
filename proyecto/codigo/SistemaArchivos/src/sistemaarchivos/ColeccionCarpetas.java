/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaarchivos;

import java.util.HashMap;

/**
 * Esta clase contiene la tabla de hash que permite la eficiencia de las búsquedas de datos.
 * @author ljpalaciom
 */
public class ColeccionCarpetas {

    private HashMap tabla;
    private String nombreTabla;

    /**
     * Este es el constructor que inicializa el HashMap. 
     * @param nombreTabla En el archivo txt se recibe un nombre inicial, este se ingresa aqui como el nombre de la tabla. 
     */
    public ColeccionCarpetas(String nombreTabla) {
        tabla = new HashMap<>();
        this.nombreTabla = nombreTabla;
    }

    /**
     * Este metodo permite ingresar un nuevo dato a la tabla de hash.
     * @param clave Esta es la que se asocia con un valor de tipo carpeta o archivo, 
     * asi cuando se busque la clave se obtiene este valor rapidamente.
     * @param carpeta
     */
    public void put(String clave, Carpeta carpeta) {
        tabla.put(clave, carpeta);
    }

    /**
     * Este metodo permite obtener un valor de la tabla de hash.
     * Retorna null si no lo encuentra.
     * @param clave El string que se asocia con un valor de tipo carpeta o archivo. 
     * @return
     */
    public Carpeta get(String clave) {
        return (Carpeta) tabla.get(clave);
    }

 
}
