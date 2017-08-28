package Taller5;

import java.util.Random;

public class Taller5 {

    //ArrayMax
    public static int arrayMax(int[] array, int n) {
        int max;
        if (n == 0) {
            max = array[0];
        } else {
            max = Math.max(array[n], arrayMax(array, n - 1));
        }
        return max;
    }

    //groupSum
    public static boolean groupSum(int start, int[] nums, int target) {
        if (start == nums.length) {
            return target == 0;
        }
        return groupSum(start + 1, nums, target - nums[start])
                || groupSum(start + 1, nums, target);
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
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
     public static void tomarTiempoSum(int[] nums) {
        long startTime = System.currentTimeMillis();
        groupSum(0, nums, nums.length - 1);
        long estimado = System.currentTimeMillis() - startTime;
        System.out.println(estimado);
     }
    public static void tomarMax(int[] nums) {
        long startTime = System.currentTimeMillis();
        arrayMax(nums, nums.length - 1);
        long estimado = System.currentTimeMillis() - startTime;
        System.out.println(estimado);
    }

    public static void tomarTiempoFibonacci(int n) {
        long startTime = System.currentTimeMillis();
        fibonacci(n);
        long estimado = startTime - System.currentTimeMillis();
        System.out.println(estimado);
    }

    public static void main(String[] args) {
        int[] sum = generarArregloDeTamanoN(32);
        int [] max = generarArregloDeTamanoN(10000);
        tomarTiempoSum(sum);
        tomarMax(max);
        

    }

}
