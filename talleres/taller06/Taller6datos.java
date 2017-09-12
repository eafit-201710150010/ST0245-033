/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller6datos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author scastrillg
 */
public class Taller6datos {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Integer> patron(int n){
      ArrayList<Integer> a = new ArrayList<Integer>();
      for(int i = 1; i<=n ; i++){
         for(int j=1;j<=i;j++){
          a.add(j);
         }
      }
        System.out.println(a);
      return a;
    }
    public static void arrayInvertido(){
        
    Scanner in = new Scanner(System.in);
      int a = in.nextInt();
      ArrayList <Integer> list = new ArrayList <>();
      while(a != -1){
          list.add(a);
          a = in.nextInt();
      }
      ArrayList <Integer> listInvert = new ArrayList <>();
      for (int i = list.size()-1; i >= 0; i--) {
          listInvert.add(list.get(i));
      }
      for (Integer integer : listInvert) {
          System.out.print(integer);
      }
  }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
