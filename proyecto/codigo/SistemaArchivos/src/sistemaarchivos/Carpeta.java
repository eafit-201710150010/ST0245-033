package sistemaarchivos;

import java.util.LinkedList;

/**
 * Esta clase es una plantilla para objetos tipo carpeta y/o archivo. Se ayuda de la enumeracion TipoCarpeta
 * @see TipoCarpeta
 * @author ljpalaciom
 */
public class Carpeta {
    /**
     * Esta es la ruta donde está la carpeta o archivo. Tiene el siguiente orden [rutaHija,rutaPadre]
     */
    private LinkedList<String> direccion;
    /**
     * El nombre del dato tipo carpeta o archivo
     */
    private String nombre;
    /**
     * El tamano dado en un string donde los primeros digitos son numeros y el ultimo digito las 
     * unidades de medida
     */
    private String tamano;
    /**
     * Gracias a la enumeracion el la carpeta puede ser de dos tipos, carpeta o archivo. Si es carpeta tiene
     * hijos, si es un archivo no.
     * @see TipoCarpeta 
     */
    private TipoCarpeta tipo;
    /**
     * Son los hijos de la carpeta. En caso tal de ser un archivo, esta variable no se inicializa.
     */
    private LinkedList<Carpeta> contenido;
    /**
     * Cada carpeta y/o archivo sabe quien es su padre. Esto para ayudar el metodo actualizarDireccion
     */
    private Carpeta padre;

    /**
     * Este es el constructor de la clase. 
     * Usa el metodo actualizarDireccion
     * @param padre
     * @param nombre
     * @param tamano
     * @param tipo
     */
    public Carpeta(Carpeta padre, String nombre, String tamano, TipoCarpeta tipo) {
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
     * @param carpeta
     */
    public void add(Carpeta carpeta) {
        contenido.add(carpeta);
    }
    /**
     * Este metodo se usa para construir la ruta de un archivoz.   * 
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
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @param tamano
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    /**
     *
     * @return
     */
    public TipoCarpeta getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(TipoCarpeta tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public LinkedList<String> getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(LinkedList<String> direccion) {
        this.direccion = direccion;
    }

    /**
     * Este metodo lista todos los contenidos de una sóla carpeta.
     * @return
     */
    public LinkedList<String> listarContenido() {
        LinkedList<String> hijos = new LinkedList();
        for (Carpeta carpeta : contenido) {
            hijos.add(carpeta.getNombre());
        }
        return hijos;
    }

    /**
     *
     * @param contenido
     */
    public void setContenido(LinkedList<Carpeta> contenido) {
        this.contenido = contenido;
    }

    /**
     *
     * @return
     */
    public Carpeta getPadre() {
        return padre;
    }

    @Override
    public String toString() {
        return "Carpeta{" + "direccion=" + direccion + ", nombre=" + nombre + ", tamano=" + tamano + ", tipo=" + tipo + '}';
    }
    
}
