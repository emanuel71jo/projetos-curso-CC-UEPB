
package ordenacao;

import static java.lang.Math.pow;
import java.util.Random;

public class Teste {
    static int TAM = 10000;
    
    public static void main(String[] args) {
        
        int array[] = new int[TAM];
        int array1[] = new int[TAM];
        int array2[] = new int[TAM];
        double tempoInicial, tempoFinal;
        
        Ordenacao ordenar = new Ordenacao();
        //geraArray(array);
        //geraArrayCrescente(array);
        geraArrayDecrescente(array);
        array1 = array.clone();
        array2 = array.clone();
        
        
        System.out.println("ARRAY 1 DESORDENADO");        
        mostrarArray(array);
        System.out.println("\nARRAY 1 ORDENADO POR (INSERTION SORT)");   
        tempoInicial = System.currentTimeMillis();
        ordenar.insertionSort(array);
        tempoFinal = System.currentTimeMillis();       
        mostrarArray(array);
        System.out.println("\nARRAY ORDENADO: " + arrayOrdenado(array));
        System.out.printf("\nTEMPO: %.10f",  (tempoFinal - tempoInicial));
        System.out.println("\n\n");
        
        
        System.out.println("ARRAY 2 DESORDENADO");
        mostrarArray(array1);
        System.out.println("\nARRAY 2 ORDENADO POR (BUBBLE SORT)"); 
        tempoInicial = System.currentTimeMillis();
        ordenar.bubbleSort(array1);
        tempoFinal = System.currentTimeMillis();
        mostrarArray(array1);
        System.out.println("\nARRAY ORDENADO: " + arrayOrdenado(array1));
        System.out.printf("\nTEMPO: %.10f",  (tempoFinal - tempoInicial));
        System.out.println("\n\n");
         
        
        System.out.println("ARRAY 3 DESORDENADO");
        mostrarArray(array2);
        System.out.println("\nARRAY 3 ORDENADO POR (SELECTION SORT)"); 
        tempoInicial = System.currentTimeMillis();
        ordenar.selectionSort(array2);
        tempoFinal = System.currentTimeMillis(); 
        mostrarArray(array2);
        System.out.println("\nARRAY ORDENADO: " + arrayOrdenado(array2));
        System.out.printf("\nTEMPO: %.10f",  (tempoFinal - tempoInicial));
        System.out.println("");
        
        
        
    }
    
    
    public static void mostrarArray(int array[]){
        for(int i = 0; i < array.length; i++){
            System.out.print("" + array[i] + " | ");
        }
    }
    
    public static void geraArray(int array[]){
        Random gerador = new Random();
        for(int i = 0; i < TAM; i++){
            array[i] = gerador.nextInt(TAM);
        }
    }
    
    public static void geraArrayDecrescente(int array[]){
        for(int i = TAM - 1, j = 0; i >= 0; i--, j++){
            array[i] = j;
        }
    }
    
    public static void geraArrayCrescente(int array[]){
        for(int i = 0; i < TAM; i++){
            array[i] = i;
        }
    }
    
    public static String arrayOrdenado(int array[]){
        for(int i = 0; i < TAM - 1; i++){
            if(array[i] > array[i + 1]){
                return "NÃO ESTA ORDENADO";
            }
        }
        
        return "ESTA ORDENADO";
    }
    
}
