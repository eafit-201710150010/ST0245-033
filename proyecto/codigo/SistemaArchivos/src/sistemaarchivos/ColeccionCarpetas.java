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

    /**
     * Este es el constructor que inicializa el HashMap.
     *
     */
    public ColeccionCarpetas() {
        tabla = new HashMap<>();
    }

    /**
     * Este metodo permite ingresar un nuevo dato a la tabla de hash.
     *
     * @param clave Esta es el nombre que se asocia con un valor de tipo carpeta
     * o archivo, asi cuando se busque la clave se obtiene este valor
     * rapidamente.
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
     * Este metodo permite obtener una lista de la tabla de hash. 
     *
     * @param clave El string que se asocia con un valor de tipo carpeta o
     * archivo.
     * @return Una LinkedList con todos las carpetas de coincidan con la clave
     * @throws java.lang.Exception Si no se encuentra el archivo
     */
    public LinkedList<Carpeta> get(String clave) throws Exception {
        LinkedList<Carpeta> retornar = (LinkedList<Carpeta>) tabla.get(clave);
        if (retornar == null) {
           throw new Exception("No such file or directory");
        }
        return retornar;
    }

    /**
     * Este metodo permite una carpeta usando el parametro direccion. Retorna
     * null si no lo encuentra.
     *
     * @param clave
     * @param direccion La direccion del archivo
     * @return
     * @throws java.lang.Exception Si no se encuentra el archivo
     */
    public Carpeta get(String clave, String direccion) throws Exception {
        String div[] = direccion.split("/");

        LinkedList<Carpeta> retornar = (LinkedList<Carpeta>) tabla.get(clave);
        LinkedList<String> dir = new LinkedList<>();
        for (int i = 0; i < div.length; i++) {
            dir.add(div[i]);
        }
        if (retornar == null) {
            throw new Exception("No such file or directory");
        } 
            for (Carpeta carpeta : retornar) {
                if (carpeta.getDireccion().hashCode() == dir.hashCode()) {
                    return carpeta;
                }
            }
        return null;
    }

    /**
     * Este metodo está hecho para imprimir todos las rutas de una lista de
     * carpetas
     *
     * @param clave
     * @throws java.lang.Exception Si no se encuentra el archivo
     */
    public void direcciones(String clave) throws Exception {
        LinkedList<Carpeta> coincidencias = get(clave);
        for (Carpeta carpeta : coincidencias) {
            System.out.println(carpeta.getDireccion());
        }
    }

    /**
     * Este metodo está hecho para imprimir todos los contenidos de una lista de
     * carpetas que se llaman igual
     *
     * @param clave
     * @throws java.lang.Exception Si no se encuentra el archivo
     */
    public void contenidos(String clave) throws Exception {
        LinkedList<Carpeta> coincidencias = get(clave);
        if (coincidencias != null) {
            for (Carpeta carpeta : coincidencias) {
                if (carpeta.getTipo() == TipoCarpeta.Carpeta) {
                    System.out.println(carpeta.listarContenido());
                }
            }
        }
    }

    /**
     * Este metodo está hecho para imprimir los contenidos de un tamaño mayor al
     * ingresado por parámetro de una lista de carpetas que se llaman igual
     *
     * @param clave
     * @param TamanoMayor
     * @throws java.lang.Exception Si no se encuentra el archivo
     *
     */
    public void contenidosMayor(String clave, String TamanoMayor) throws Exception {
        LinkedList<Carpeta> coincidencias = get(clave);
        if (coincidencias != null) {
            for (Carpeta carpeta : coincidencias) {
                if (carpeta.getTipo() == TipoCarpeta.Carpeta) {
                    System.out.println(carpeta.listarContenidoMayor(TamanoMayor));
                }
            }
        }
    }

    /**
     * Este metodo imprime todo los contenidos de un usuario ingresado por
     * parámetro de una lista de carpetas que se llaman igual
     *
     * @param clave
     * @param Usuario El dueño del directorio a buscar
     * @throws java.lang.Exception Si no se encuentra el archivo
     */
    public void contenidosUsuario(String clave, String Usuario) throws Exception {
        LinkedList<Carpeta> coincidencias = get(clave);
        if (coincidencias != null) {
            for (Carpeta carpeta : coincidencias) {
                if (carpeta.getTipo() == TipoCarpeta.Carpeta) {
                    System.out.println(carpeta.listarContenidoUsuario(Usuario));
                }
            }
        }
    }

    /**
     * Usa el metodo toString de la clase Carpeta con una lista de carpetas que
     * se llaman
     *
     * @param clave
     * @throws java.lang.Exception Si no se encuentra el archivo
     */
    public void imprimirCarpetas(String clave) throws Exception {
        LinkedList<Carpeta> coincidencias = get(clave);
        for (Carpeta coincidencia : coincidencias) {
            System.out.println(coincidencia);
        }
    }
}
