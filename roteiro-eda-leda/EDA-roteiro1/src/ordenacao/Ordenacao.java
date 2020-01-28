/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenacao;

/**
 *
 * @author usuario
 */
public class Ordenacao {
    private int array[];
    
    public int[] insertionSort(int a[]){
        this.array = a;
        
        for(int j = 0; j < array.length; j++){
            int key = array[j];
            int i = j;
            while(i > 0 && key < array[i - 1]){
                array[i] = array[i - 1];
                i--;
            }
            array[i] = key;
        }
        return this.array;
    }
    
    public int[] bubbleSort(int a[]){
        this.array = a;
        boolean houveTroca = true;
        while(houveTroca){
            houveTroca = false;
            for(int i = 0; i < array.length - 1; i++){
                if(array[i] > array[i + 1]){
                    int aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                    houveTroca = true;
                }
            }
        }
        return this.array;
    }
    
    public int[] selectionSort(int a[]){
        this.array = a;
        for(int i = 0; i < array.length - 2; i++){
            int menor = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[menor] > array[j]){
                    menor = j;
                }
            }
            if(menor != i){
                int aux = array[menor];
                array[menor] = array[i];
                array[i] = aux;
            }
        }
        return this.array;
    }
}
