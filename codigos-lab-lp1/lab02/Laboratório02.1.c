#include <stdio.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Escreva um programa que, dados dois números inteiros, mostre na tela o
* maior deles, assim como a diferença existente entre ambos.*/

void main(void){
  int a,b;
  
  scanf("%d %d",&a,&b);
  
  if(a<b){
    printf("O maior: %d\n",b);
    printf("Diferença: %d\n",b-a);
  }else if(b<a){
    printf("O maior: %d\n",a);
    printf("Diferença: %d\n",a-b);
  }else{
    printf("São iguais.\n");
  }
  
}
