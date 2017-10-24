/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaarchivos;

import java.util.LinkedList;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ljpalaciom
 */
public class ColeccionCarpetasTest {

    ColeccionCarpetas instance;

    public ColeccionCarpetasTest() {
        instance = new ColeccionCarpetas();
    }

    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test of contenidos method, of class ColeccionCarpetas.
     */
    @Test
    public void testContenidos() {
        System.out.println("contenidos");
        Carpeta raiz = new Carpeta(null, "root", "raiz", "512k", TipoCarpeta.Carpeta);

        Carpeta abuelo1 = new Carpeta(raiz, "root", "abuelo1", "512k", TipoCarpeta.Carpeta);
        Carpeta padre1 = new Carpeta(abuelo1, "root", "padre1", "512k", TipoCarpeta.Carpeta);
        Carpeta hijo = new Carpeta(padre1, "root", "hijo", "512k", TipoCarpeta.Carpeta);

        Carpeta abuelo2 = new Carpeta(raiz, "root", "abuelo2", "512k", TipoCarpeta.Carpeta);
        Carpeta padre2 = new Carpeta(abuelo2, "root", "padre2", "512k", TipoCarpeta.Carpeta);

        //Esto para que hallan dos coincidencias
        instance.put("raiz", raiz);
        instance.put("raiz", abuelo1);

        instance.put("padre1", padre1);
        instance.put("abuelo2", abuelo2);
        instance.put("padre2", padre2);
        instance.put("hijo", hijo);

        LinkedList<LinkedList<String>> expResult = new LinkedList<>();
        expResult.add(raiz.listarContenido());
        expResult.add(abuelo1.listarContenido());
        LinkedList<Carpeta> coincidencias = (LinkedList<Carpeta>) instance.get("raiz");
        LinkedList<LinkedList<String>> result = instance.contenidos(coincidencias);

        assertEquals(expResult, result);
    }

    @Test
    public void testDirecciones() {
        System.out.println("Direcciones");
        Carpeta raiz = new Carpeta(null, "root", "raiz", "512k", TipoCarpeta.Carpeta);

        Carpeta abuelo1 = new Carpeta(raiz, "root", "abuelo1", "512k", TipoCarpeta.Carpeta);
        Carpeta padre1 = new Carpeta(abuelo1, "root", "padre1", "512k", TipoCarpeta.Carpeta);
        Carpeta hijo = new Carpeta(padre1, "root", "hijo", "512k", TipoCarpeta.Carpeta);

        Carpeta abuelo2 = new Carpeta(raiz, "root", "abuelo2", "512k", TipoCarpeta.Carpeta);
        Carpeta padre2 = new Carpeta(abuelo2, "root", "padre2", "512k", TipoCarpeta.Carpeta);
        Carpeta hijo1 = new Carpeta(padre2, "root", "hijo", "512k", TipoCarpeta.Carpeta);

        instance.put("raiz", raiz);

        instance.put("abuelo1", abuelo1);
        instance.put("padre1", padre1);
        instance.put("abuelo2", abuelo2);
        instance.put("padre2", padre2);

        //Esto para que hallan dos coincidencias
        instance.put("hijo", hijo);
        instance.put("hijo", hijo1);

        LinkedList<LinkedList<String>> expResult = new LinkedList<>();
        expResult.add(hijo.getDireccion());
        expResult.add(hijo1.getDireccion());

        LinkedList<Carpeta> coincidencias = (LinkedList<Carpeta>) instance.get("hijo");
        LinkedList<LinkedList<String>> result = instance.direcciones(coincidencias);
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class ColeccionCarpetas.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        String clave = "raiz";
        ColeccionCarpetas instance = new ColeccionCarpetas();
        Carpeta raiz = new Carpeta(null, "root", "raiz", "512k", TipoCarpeta.Carpeta);
        Carpeta abuelo1 = new Carpeta(raiz, "root", "abuelo1", "512k", TipoCarpeta.Carpeta);
        Carpeta padre1 = new Carpeta(abuelo1, "root", "padre1", "512k", TipoCarpeta.Carpeta);
        Carpeta hijo = new Carpeta(padre1, "root", "hijo", "512k", TipoCarpeta.Carpeta);
        Carpeta abuelo2 = new Carpeta(raiz, "root", "abuelo2", "512k", TipoCarpeta.Carpeta);
        Carpeta padre2 = new Carpeta(abuelo2, "root", "padre2", "512k", TipoCarpeta.Carpeta);
        Carpeta hijo1 = new Carpeta(padre2, "root", "hijo", "512k", TipoCarpeta.Carpeta);
        //Esto para que hallan dos coincidencias
        instance.put("raiz", raiz);
        instance.put("raiz", abuelo1);
        instance.put("padre1", padre1);
        instance.put("abuelo2", abuelo2);
        instance.put("padre2", padre2);
        instance.put("hijo", hijo);

        LinkedList<Carpeta> expResult = new LinkedList<>();
        expResult.add(raiz);
        expResult.add(abuelo1);
        LinkedList<Carpeta> result = instance.get(clave);
        assertEquals(expResult, result);
    }

    /**
     * Test of contenidosMayor method, of class ColeccionCarpetas.
     */
    @Test
    public void testContenidosMayor() {
        System.out.println("contenidosMayor");
        LinkedList<Carpeta> coincidencias = new LinkedList<Carpeta>();
        String TamanoMayor = "511M";
        ColeccionCarpetas instance = new ColeccionCarpetas();

        Carpeta raiz = new Carpeta(null, "root", "raiz", "", TipoCarpeta.Carpeta);
        Carpeta abuelo1 = new Carpeta(raiz, "root", "abuelo1", "513M", TipoCarpeta.Carpeta);
        Carpeta padre1 = new Carpeta(raiz, "root", "padre1", "512", TipoCarpeta.Carpeta);
        Carpeta hijo = new Carpeta(raiz, "root", "hijo", "512M", TipoCarpeta.Carpeta);
        Carpeta abuelo2 = new Carpeta(raiz, "root", "abuelo2", "512K", TipoCarpeta.Carpeta);
        Carpeta padre2 = new Carpeta(raiz, "root", "padre2", "512G", TipoCarpeta.Carpeta);
        Carpeta hijo1 = new Carpeta(raiz, "root", "hijo1", "511M", TipoCarpeta.Carpeta);

        coincidencias.add(raiz);
        instance.put("raiz", raiz);
        instance.put("abuelo1", abuelo1);
        instance.put("padre1", padre1);
        instance.put("abuelo2", abuelo2);
        instance.put("padre2", padre2);
        instance.put("hijo1", hijo1);
        instance.put("hijo", hijo);

        LinkedList<LinkedList<String>> expResult = new LinkedList<>();
        expResult.add(new LinkedList<>());
        expResult.get(0).add(abuelo1.getNombre());
        expResult.get(0).add(hijo.getNombre());
        expResult.get(0).add(padre2.getNombre());
        LinkedList<LinkedList<String>> result = instance.contenidosMayor(coincidencias, TamanoMayor);
        assertEquals(expResult, result);

    }

    /**
     * Test of contenidosUsuario method, of class ColeccionCarpetas.
     */
    @Test
    public void testContenidosUsuario() {
        System.out.println("contenidosUsuario");
        String Usuario = "mauro";
        ColeccionCarpetas instance = new ColeccionCarpetas();
        Carpeta raiz = new Carpeta(null, "root", "raiz", "512k", TipoCarpeta.Carpeta);
        Carpeta abuelo1 = new Carpeta(raiz, "mauro", "abuelo1", "512k", TipoCarpeta.Carpeta);
        Carpeta padre1 = new Carpeta(abuelo1, "mauro", "padre1", "512k", TipoCarpeta.Carpeta);
        Carpeta hijo = new Carpeta(padre1, "root", "hijo", "512k", TipoCarpeta.Carpeta);
        Carpeta abuelo2 = new Carpeta(raiz, "root", "abuelo2", "512k", TipoCarpeta.Carpeta);
        Carpeta padre2 = new Carpeta(abuelo2, "root", "padre2", "512k", TipoCarpeta.Carpeta);
        Carpeta hijo1 = new Carpeta(padre2, "root", "hijo", "512k", TipoCarpeta.Carpeta);

        //Esto para que hallan dos coincidencias
        instance.put("raiz", raiz);
        instance.put("raiz", abuelo1);
        instance.put("padre1", padre1);
        instance.put("abuelo2", abuelo2);
        instance.put("padre2", padre2);
        instance.put("hijo", hijo);
        LinkedList<Carpeta> coincidencias = instance.get("raiz");
        LinkedList<LinkedList<String>> expResult = new LinkedList<>();
        expResult.add(new LinkedList<>());
        expResult.add(new LinkedList<>());
        expResult.get(0).add(abuelo1.getNombre());
        expResult.get(1).add(padre1.getNombre());
        LinkedList<LinkedList<String>> result = instance.contenidosUsuario(coincidencias, Usuario);
        assertEquals(expResult, result);;
    }

    /**
     * Test of get method, of class ColeccionCarpetas.
     */
    @Test
    public void testGet_String() {
        ColeccionCarpetas instance = new ColeccionCarpetas();
        System.out.println("get");
        String clave = "abuelo1";
        String direccion = "raiz/padre1";
        Carpeta raiz = new Carpeta(null, "root", "raiz", "512k", TipoCarpeta.Carpeta);
        Carpeta abuelo1 = new Carpeta(raiz, "mauro", "abuelo1", "512k", TipoCarpeta.Carpeta);
        Carpeta padre1 = new Carpeta(raiz, "mauro", "padre1", "512k", TipoCarpeta.Carpeta);
        instance.put("raiz", raiz);
        instance.put("abuelo1", abuelo1);
        instance.put("abuelo1", padre1);
        
        Carpeta expResult = padre1;
        Carpeta result = instance.get(clave, direccion);
        assertEquals(expResult, result);
    }
     @Test
    public void peorDeLosCasos() {
        System.out.println("peorDeLosCasos");
        Scanner sc = new Scanner(System.in);
        Carpeta padre = new Carpeta(null, "root", "hijo", "512k", TipoCarpeta.Carpeta);
        Carpeta expResult = padre;
        String direccion = "hijo";
        instance.put(direccion, padre);
        for (int i = 0; i < 2326; i++) {
            Carpeta actual = new Carpeta(padre, "root", "hijo", "512k", TipoCarpeta.Carpeta);
            instance.put("hijo", actual);
            padre = actual;
        }
        Carpeta result = instance.get("hijo", direccion);
        assertEquals(expResult, result);
    }

}
