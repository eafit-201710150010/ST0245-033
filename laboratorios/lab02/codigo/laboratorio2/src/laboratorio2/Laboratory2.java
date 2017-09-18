/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;

import java.util.*;

/**
 * @author mauricio toro
 * @author santiago Castrillon
 * @author kevyn gomez
 * @author luis javier palacio
 */
public class Laboratory2
{
  
    /**
     * Este algoritmo suma todos todos los valores contenidos en un arreglo
     * @param A Este es el arreglo que se utilizará como prueba para
     * la ejecucion del algoritmo
     * @return retorna la suma total del arreglo
     */
  public static int ArraySum(int[] A)
  {          
      int sum = 0;
      for (int i = 0; i < A.length; i++)
         sum = sum + A[i];
      return sum;
  }
  

  /**
   * es un algoritmo qie busca el valor mas grande contenido en el arreglo
   * @param A Este es el arreglo que se utilizará como prueba para
     * la ejecucion del algoritmo
   * @return retorna el valor mas grande que contiene el arreglo
   */
  public static int ArrayMax(int[] A)
  {
      int max = A[0];
      for (int i = 0; i < A.length; i++)
         if (A[i] > max)
           max = A[i];
      return max;
  }
  

  /**
   * es un algoritmo de ordenamiento que compara cada posicion con el resto de posiciones del arreglo y las va ordenando a medida que aumenta el ciclo
   * @param A Este es el arreglo que se utilizará como prueba para
     * la ejecucion del algoritmo
   */
  public static void InsertionSort(int[] A)
  {
       int temp,j;
       for (int i = 0; i < A.length; i++)
       {
         j = i;
         while (j > 0 && A[j-1] > A[j])
           {
               temp = A[j];
               A[j] = A[j-1];
               A[j-1] = temp;
               j = j-1;
            }           
       }
       //System.out.println(Arrays.toString(A));
  }

     
  /**
   * este es el metodo auxiliar, aqui se crea el arreglo tmp
   * @param a arreglo a utilizar
   */
	public static void mergeSort(int [ ] a)
	{
		int[] tmp = new int[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}

/**
 * es un algoritmo de ordenamiento que utiliza la busqueda binaria para encontrar facilmente el valor a buscar
 * @param a arreglo a utilizar
 * @param tmp ultima posicion del arreglo
 * @param left numero de la izquierda
 * @param right numero de la derecha 
 */
	private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}

/**
 * aqui se modifica el arreglo tmp dependiendo de los valores iniciales y finales de left y right
 * @param a arreglo a utilizar      
 * @param tmp ultima posicion del arreglo
 * @param left numero de la izquierda
 * @param right numero de la derecha 
 * @param rightEnd guarda el ultimo valor de la derecha
 */
    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right] )
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
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
        ArraySum(nums);
        long tiempo = System.currentTimeMillis() - start;
        System.out.println("La suma del array se demora: " + tiempo);

        start = System.currentTimeMillis();
        ArrayMax(nums);
        tiempo = System.currentTimeMillis() - start;
        System.out.println("El valor maximo del arreglo demora: " + tiempo);

    }
    /**
    Este algoritmo toma los tiempos de insertion sort e imprime cuanto demoro
    */
    public static void tomarTiemposInsertionsort(int nums[]) {
        long start = System.currentTimeMillis();
        InsertionSort(nums);
        long tiempo = System.currentTimeMillis() - start;
        System.out.println("Para Insertion Sort demora: " + tiempo);
    }
     /**
    Este algoritmo toma los tiempos de merge sort e imprime cuanto demoro
    */
    public static void tomarTiemposMergesort(int nums[]) {
        long start = System.currentTimeMillis();
        mergeSort(nums);
        long tiempo = System.currentTimeMillis() - start;
        System.out.println("Para Merge Sort demora: " + tiempo);
    }
    

    public static void main(String[] args) {
        int n = 100000000;

        int nums[] = generarArregloDeTamanoN(n);
        tomarTiempos(nums);
        tomarTiemposInsertionsort(nums);
        tomarTiemposMergesort(nums);
    }

}