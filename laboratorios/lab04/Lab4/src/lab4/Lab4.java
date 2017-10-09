package lab4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author scastrillg
 */
public class Lab4 {

    static Stack arrayBlock[];
    public static Stack[] generarArray(){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    arrayBlock= new Stack[n];
        for (int i = 0; i < n; i++) {
            Stack a = new Stack();
            a.push(i);
            arrayBlock[i]= a ;
        }
    return arrayBlock;
    }
    
    public static void moverBloques(){
      Scanner in = new Scanner(System.in);
      String opcion;
        do {
        opcion = in.nextLine();
        String n[]=opcion.split(" ");
        if (n[0].equals("move")) {
            if(n[2].equals("onto")){
             moveAontoB(Integer.parseInt(n[1]),Integer.parseInt(n[3]));   
            }           
            else moveAoverB(Integer.parseInt(n[1]),Integer.parseInt(n[3]));
        }
        else if (n[0].equals("pile")) {
            if(n[2].equals("onto")){
             pileAontoB(Integer.parseInt(n[1]),Integer.parseInt(n[3]));   
            }           
            else pileAoverB(Integer.parseInt(n[1]),Integer.parseInt(n[3]));
        }
        } while (!opcion.equals("quit"));
        quit();
    }
    
      
      public static void moveAontoB(int a, int b){
          if(a!=b||arrayBlock[b].contains(a)||arrayBlock[a].contains(b)){
              while (arrayBlock[a].size()!=1) {
                  int aux =(int)arrayBlock[a].pop();
                  arrayBlock[aux].push(aux);
              }
              while (arrayBlock[b].size()!=1) {
                  int aux =(int)arrayBlock[b].pop();
                  arrayBlock[aux].push(aux);
              }
              arrayBlock[b].push(arrayBlock[a].pop());
              
          }
      }
      public static void moveAoverB(int a, int b){
          while (arrayBlock[a].size()!=1) {
                  int aux =(int)arrayBlock[a].pop();
                  arrayBlock[aux].push(aux);
              }
              
              arrayBlock[b].push(arrayBlock[a].pop());
      }
      public static void pileAontoB(int a, int b){
          while (arrayBlock[b].size()!=1) {
                  int aux =(int)arrayBlock[b].pop();
                  arrayBlock[aux].push(aux);
              }
          Stack aux = new Stack();
          while (!arrayBlock[a].isEmpty()) {
              aux.push(arrayBlock[a].pop());
          }
          while (!aux.isEmpty()) {
             arrayBlock[b].push(aux.pop()); 
          }
              
      }
      public static void pileAoverB(int a, int b){
          Stack aux = new Stack();
          while (!arrayBlock[a].isEmpty()) {
              aux.push(arrayBlock[a].pop());
          }
          while (!aux.isEmpty()) {
             arrayBlock[b].push(aux.pop()); 
          }
      }
      public static void quit(){
          for (int i = 0; i < arrayBlock.length; i++) {
              
                  System.out.println(i+": "+ arrayBlock[i]);
              
              
          }
      }
    public static void main(String[] args) {
        generarArray();
        moverBloques();
    }
    
}
