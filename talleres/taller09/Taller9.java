package taller9;

import java.util.HashMap;

/**
 *
 * @author
 */
public class Taller9 {

    //pedrito 1
    public static void agregar(HashMap empresas, String key, String value) {
        empresas.put(key, value);
        empresas.put(value, key);
    }

    //pedrito 2
    public static String buscar(HashMap empresas, String key) {
        return (String) empresas.get(key);
    }

    //pedrito 3
    public static boolean contienekey(HashMap empresas, String key) {
        return empresas.containsKey(key);
    }

    public static void main(String[] args) {
        //Pedrito
        HashMap<String, String> empresas = new HashMap();
        agregar(empresas, "Google", "Estados Unidos");
        agregar(empresas, "La locura", "Colombia");
        agregar(empresas, "Nokia", "Finlandia");
        agregar(empresas, "Sony", "Japon");
        if (contienekey(empresas, "Google")) {
            System.out.println(buscar(empresas, "Google"));
        } else {
            System.out.println("No esta agregado esa empresa");
        }

        if (contienekey(empresas, "Motorola")) {
            System.out.println(buscar(empresas, "Motorola"));
        } else {
            System.out.println("No esta agregado esa empresa");
        }
        //4 punto
        if (contienekey(empresas, "Estados Unidos")) {
            System.out.println("Hay empresas de Estados Unidos");
        } else {
            System.out.println("No hay empresas de Estados Unidos");
        }
        if (contienekey(empresas, "India")) {
            System.out.println("Hay empresas de Estados Unidos");
        } else {
            System.out.println("No hay empresas de la India");
        }

        //Telefonos
        UnaTablaDeHash tabla = new UnaTablaDeHash();
        tabla.put("Robledo", 3319084);
        tabla.put("Luis Felipe", 5586978);
        tabla.put("Fajardo", 6689085);
        tabla.put("Fernando", 0);
        tabla.put("Farbicio", 508975);
        System.out.println(tabla.get("Farbicio"));
    }

}
