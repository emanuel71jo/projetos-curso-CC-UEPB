#include <stdio.h>

//Aluno: Jo�o Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Escreva um programa que, dados dois n�meros inteiros, mostre na tela o
* maior deles, assim como a diferen�a existente entre ambos.*/

void main(void){
  int a,b;
  
  scanf("%d %d",&a,&b);
  
  if(a<b){
    printf("O maior: %d\n",b);
    printf("Diferen�a: %d\n",b-a);
  }else if(b<a){
    printf("O maior: %d\n",a);
    printf("Diferen�a: %d\n",a-b);
  }else{
    printf("S�o iguais.\n");
  }
  
}
