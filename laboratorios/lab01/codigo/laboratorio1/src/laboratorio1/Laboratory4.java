package laboratorio1;

/**
 * Laboratorio 4 de Estructuras de Datos 1
 *
 * @author Mauricio Toro
 * @version 1
 */
import java.util.*;

public class Laboratory4 {
    // Computes the sum of an array recursively

    public static int ArraySum(int[] nums, int n) {
        if (n == 0) {
            return nums[0];
        }
        return nums[n] + ArraySum(nums, n - 1);
    }

    // Computes the maximum value of an array recursively
    public static int ArrayMax(int[] A, int n) {

        if (n == 0) {
            return A[0];
        }
        return Math.max(A[n], ArrayMax(A, n - 1));
    }

    // Computes Fibonnacci series recursively
    public static int Fibonnacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return Fibonnacci(n - 1) + Fibonnacci(n - 2);
    }
  /**
    Este algoritmo genera un arreglo de tamaño n 
  */
    public static int[] generarArregloDeTamanoN(int n) {
        int max = 5000;
        int[] array = new int[n];
        Random generator = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = generator.nextInt(max);
        }
        return array;
    }

    /**
     * Este algoritmo imprime el tiempo de ejecucion de los tres algoritmos para
     * un número n.
     *
     * @param nums Este es el arreglo que se utilizará como prueba para los
     * algoritmos
     */
    public static void tomarTiempos(int nums[]) {
        long start = System.currentTimeMillis();
        ArraySum(nums, nums.length - 1);
        long tiempo = System.currentTimeMillis() - start;
        System.out.println("La suma del array se demora: " + tiempo);

        start = System.currentTimeMillis();
        ArrayMax(nums, nums.length - 1);
        tiempo = System.currentTimeMillis() - start;
        System.out.println("El valor maximo del arreglo demora: " + tiempo);

    }
    /**
    Este algoritmo toma los tiempos de fibonacci e imprime cuanto demoro
    */
    public static void tomarTiemposFibonachi(int n) {
        long start = System.currentTimeMillis();
        Fibonnacci(n);
        long tiempo = System.currentTimeMillis() - start;
        System.out.println("Para fibonachi demora: " + tiempo);
    }

    public static void main(String[] args) {
        int n = 10000000;

        int nums[] = generarArregloDeTamanoN(n);
        tomarTiempos(nums);
        tomarTiemposFibonachi(1);
    }

}
