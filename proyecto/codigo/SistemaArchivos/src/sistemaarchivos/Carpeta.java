package sistemaarchivos;

import java.util.LinkedList;

/**
 * Esta clase es una plantilla para objetos tipo carpeta y/o archivo. Se ayuda
 * de la enumeracion TipoCarpeta
 *
 * @see TipoCarpeta
 * @author ljpalaciom
 */
public class Carpeta {

    /**
     * Esta es la ruta donde está la carpeta o archivo. Tiene el siguiente orden
     * [...,rutaAbuelo,rutaPadre,rutaActual]
     */
    private LinkedList<String> direccion;

    /**
     * El nombre del dato tipo carpeta o archivo
     */
    private String nombre;
    /**
     * El usuario de la carpeta
     */
    private String usuario;

    /**
     * El tamano dado en un string donde los primeros digitos son numeros y el
     * ultimo digito las unidades de medida
     */
    private String tamano;
    /**
     * Gracias a la enumeracion la carpeta puede ser de dos tipos, carpeta o
     * archivo. Si es carpeta tiene hijos, si es un archivo no.
     *
     * @see TipoCarpeta
     */
    private TipoCarpeta tipo;
    /**
     * Son los hijos de la carpeta. En caso tal de ser un archivo, esta variable
     * no se inicializa.
     */
    private LinkedList<Carpeta> contenido;
    /**
     * Cada carpeta y/o archivo sabe quien es su padre. Esto para ayudar el
     * metodo actualizarDireccion
     */
    private Carpeta padre;

    /**
     * Este es el constructor de la clase. Usa el metodo actualizarDireccion
     *
     * @param padre La ruta padre del archivo
     * @param usuario
     * @param nombre Nombre del archivo
     * @param tamano Tamaño del archivo.
     * @param tipo El tipo puede ser Archivo o Carpeta segun la Enum TipoCarpeta
     */
    public Carpeta(Carpeta padre, String usuario, String nombre, String tamano, TipoCarpeta tipo) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.tamano = tamano;
        this.tipo = tipo;
        this.padre = padre;
        direccion = new LinkedList<>();
        if (tipo == TipoCarpeta.Carpeta) {
            contenido = new LinkedList<>();
        }
        if (padre != null) {
            padre.contenido.add(this);
        }
        actualizarDireccion();
    }

    /**
     * Este metodo permite añadir una carpeta a LinkedList de Contenidos
     *
     * @param carpeta
     */
    public void add(Carpeta carpeta) {
        contenido.add(carpeta);
    }

    /**
     * Este metodo se usa para construir la ruta de un archivo.
     */
    private void actualizarDireccion() {
        Carpeta actual = this;
        while (actual != null) {
            direccion.addFirst(actual.nombre);
            actual = actual.padre;
        }
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public String getTamano() {
        return tamano;
    }

    /**
     *
     * @return
     */
    public TipoCarpeta getTipo() {
        return tipo;
    }

    /**
     * Este metodo permite cambiar de tipo Archivo a tipo Carpeta Es útil para
     * el método leerArchivo en el main, porque no se sabe el tipo de un objeto
     * hasta que se lee el siguiente
     */
    public void cambiarACarpeta() {
        this.tipo = TipoCarpeta.Carpeta;
        contenido = new LinkedList<>();
    }

    /**
     *
     * @return
     */
    public LinkedList<String> getDireccion() {
        return direccion;
    }

    /**
     * Este metodo lista todos los contenidos de una sóla carpeta.
     *
     * @return
     */
    public LinkedList<String> listarContenido() {
        LinkedList<String> hijos = new LinkedList();
        for (Carpeta carpeta : contenido) {
            hijos.add(carpeta.getNombre());
        }
        return hijos;
    }

    private static boolean auxEsMasPesado(String tam1, String tam2) {
        return Double.parseDouble(tam1) > Double.parseDouble(tam2);
    }

    private static boolean esMasPesado(String tamano, String limite) {
        Character carp1 = tamano.charAt(tamano.length() - 1);
        Character carp2 = limite.charAt(limite.length() - 1);
        if (Character.isDigit(carp1)) {
            if (Character.isDigit(carp2)) {
                return auxEsMasPesado(tamano, limite);
            } else {
                return false;
            }

        } else if (carp1 == 'K') {
            if (Character.isDigit(carp2)) {
                return true;
            } else if (carp2 == 'K') {
                return auxEsMasPesado(tamano.substring(0, tamano.length() - 1), limite.substring(0, limite.length() - 1));
            } else {
                return false;
            }
        } else if (carp1 == 'M') {
            if (Character.isDigit(carp2) || carp2 == 'K') {
                return true;
            } else if (carp2 == 'M') {
                return auxEsMasPesado(tamano.substring(0, tamano.length() - 1), limite.substring(0, limite.length() - 1));
            } else {
                return false;
            }
        } else {
            if (Character.isDigit(carp2) || carp2 == 'K' || carp2 == 'M') {
                return true;
            } else {
                return auxEsMasPesado(tamano.substring(0, tamano.length() - 1), limite.substring(0, limite.length() - 1));
            }
        }

    }

    /**
     * Este método permite listar contenidos si pesan mas que un limite
     * ingresado por parametro
     *
     * @param limite Se listaran los contenidos que pesen más que este parámetro
     * @return
     */
    public LinkedList<String> listarContenidoMayor(String limite) {
        LinkedList<String> hijos = new LinkedList();
        for (Carpeta carpeta : contenido) {
            if (esMasPesado(carpeta.tamano, limite)) {
                hijos.add(carpeta.getNombre());
            }
        }
        return hijos;
    }

    /**
     * Este metodo permite listar contenidos por Usuario
     *
     * @param usuario El dueño del directorio a buscar
     * @return
     */
    public LinkedList<String> listarContenidoUsuario(String usuario) {
        LinkedList<String> hijos = new LinkedList();
        for (Carpeta carpeta : contenido) {
            if (carpeta.usuario.equals(usuario)) {
                hijos.add(carpeta.getNombre());
            }
        }
        return hijos;
    }

    /**
     *
     * @return Directorio padre
     */
    public Carpeta getPadre() {
        return padre;
    }

    @Override
    public String toString() {
        return "Carpeta{" + "direccion=" + direccion + ", nombre=" + nombre + ", usuario=" + usuario + ", tamano=" + tamano + ", tipo=" + tipo + '}';
    }

}
