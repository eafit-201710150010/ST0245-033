/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaarchivos;

import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static sistemaarchivos.SistemaArchivos.tabla;

/**
 *
 * @author ljpalaciom
 */
public class ColeccionCarpetasTest {

    ColeccionCarpetas instance;

    public ColeccionCarpetasTest() {
        instance = new ColeccionCarpetas("Pruebas");
    }

    /**
     * Test of contenidos method, of class ColeccionCarpetas.
     */
    @Test
    public void testContenidos() {
        System.out.println("contenidos");
        Carpeta raiz = new Carpeta(null, "raiz", "512k", TipoCarpeta.Carpeta);

        Carpeta abuelo1 = new Carpeta(raiz, "abuelo1", "512k", TipoCarpeta.Carpeta);
        Carpeta padre1 = new Carpeta(abuelo1, "padre1", "512k", TipoCarpeta.Carpeta);
        Carpeta hijo = new Carpeta(padre1, "hijo", "512k", TipoCarpeta.Carpeta);

        Carpeta abuelo2 = new Carpeta(raiz, "abuelo2", "512k", TipoCarpeta.Carpeta);
        Carpeta padre2 = new Carpeta(abuelo2, "padre2", "512k", TipoCarpeta.Carpeta);

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
        Carpeta raiz = new Carpeta(null, "raiz", "512k", TipoCarpeta.Carpeta);

        Carpeta abuelo1 = new Carpeta(raiz, "abuelo1", "512k", TipoCarpeta.Carpeta);
        Carpeta padre1 = new Carpeta(abuelo1, "padre1", "512k", TipoCarpeta.Carpeta);
        Carpeta hijo = new Carpeta(padre1, "hijo", "512k", TipoCarpeta.Carpeta);

        Carpeta abuelo2 = new Carpeta(raiz, "abuelo2", "512k", TipoCarpeta.Carpeta);
        Carpeta padre2 = new Carpeta(abuelo2, "padre2", "512k", TipoCarpeta.Carpeta);
        Carpeta hijo1 = new Carpeta(padre2, "hijo", "512k", TipoCarpeta.Carpeta);

       
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
        System.out.println(expResult);
        assertEquals(expResult, result);
    }

}
