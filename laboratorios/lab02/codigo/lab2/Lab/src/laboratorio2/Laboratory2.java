package laboratorio2;

import java.util.*;

public class Laboratory2
{
  // Computer the sum of an array
  public static int ArraySum(int[] A)
  {          
      int sum = 0;
      for (int i = 0; i < A.length; i++)
         sum = sum + A[i];
      return sum;
  }
  
  // Computes the maximum value of an array
  public static int ArrayMax(int[] A)
  {
      int max = A[0];
      for (int i = 0; i < A.length; i++)
         if (A[i] > max)
           max = A[i];
      return max;
  }
  
  // Sorts an array using Insertion Sort
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

      // Sorts an array using Merge Sort
      // Taken from www.cs.cmu.edu/
	public static void mergeSort(int [ ] a)
	{
		int[] tmp = new int[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}


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
    Este algoritmo toma los tiempos de fibonacci e imprime cuanto demoro
    */
    public static void tomarTiemposInsertionsort(int nums[]) {
        long start = System.currentTimeMillis();
        InsertionSort(nums);
        long tiempo = System.currentTimeMillis() - start;
        System.out.println("Para Insertion Sort demora: " + tiempo);
    }
    
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