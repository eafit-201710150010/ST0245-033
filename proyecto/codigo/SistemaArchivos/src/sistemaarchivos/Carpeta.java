package sistemaarchivos;

import java.util.LinkedList;

/**
 *
 * @author ljpalaciom
 */
public class Carpeta {

    private LinkedList<String> direccion;
    private String nombre;
    private String tamano;
    private TipoCarpeta tipo;
    private LinkedList<Carpeta> contenido;
    private Carpeta padre;

    /**
     * Este es el constructor de la clase.
     * Se encarga de
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
     *
     * @param carpeta
     */
    public void add(Carpeta carpeta) {
        contenido.add(carpeta);
    }

    private void actualizarDireccion() {
        Carpeta actual = this;
        while (actual != null) {
            direccion.add(actual.nombre);
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
