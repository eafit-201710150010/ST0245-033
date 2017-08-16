package taller4;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Taller4 {

    public static void arraySum(int[] Sum) {
        int suma = 0;
        for (int i = 0; i < Sum.length; i++) {
            suma += Sum[i];
        }
    }

    public static int[] generarArregloDeTamanoN(int n) {
        int max = 5000;
        int[] array = new int[n];
        Random generator = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = generator.nextInt(max);
        }
        return array;
    }

    public static void imprimirTablas(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                //System.out.println(i + "*" + j + " = " + i * j);
            }
        }
    }

    public static int[] ordenamientoInsercion(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && a[j - 1] > a[j] ) {
                int aux = a[j];
                a[j] = a[j - 1];
                a[j - 1] = aux;
                j--;
            }
        }
        return a;
    }

    public static long tomarTiempoSuma(int a[]) {
        long startTime = System.currentTimeMillis();
        arraySum(a);
        long estimatedTime = System.currentTimeMillis() - startTime;
        return estimatedTime;
    }

    public static long tomarTiempoOrdena(int [] a ) {
        long startTime = System.currentTimeMillis();
        ordenamientoInsercion(a);
        long estimatedTime = System.currentTimeMillis() - startTime;
        return estimatedTime;
    }
    
    public static long tomarTiempoTabla(int n) {
        long startTime = System.currentTimeMillis();
        imprimirTablas(n);
        long estimatedTime = System.currentTimeMillis() - startTime;
        return estimatedTime;
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] a = generarArregloDeTamanoN(n);
        System.out.println("En la suma " + tomarTiempoSuma(a));
        System.out.println("En el ordenamiento " + tomarTiempoOrdena(a));  
        System.out.println("En la multiplicación " + tomarTiempoTabla(n));

    }

}
