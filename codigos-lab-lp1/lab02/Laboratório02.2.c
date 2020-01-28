#include <stdio.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Dados três valores, A, B, C, verificar se eles podem ser valores dos lados de
* um triângulo e, se forem, se e um triângulo escaleno, equilátero ou isóscele,
* considerando os seguintes conceitos:
* a. O comprimento de cada lado de um triângulo é menor do que a soma dos
* outros dois lados.
* b. Chama-se equilátero o triângulo que tem três lados iguais.
* c. Denominam-se isósceles o triângulo que tem o comprimento de dois
* lados iguais.
* d. Recebe o nome de escaleno o triângulo que tem os três lados diferentes.*/

void main(void){
  float a,b,c;
  
  scanf("%f%f%f",&a,&b,&c);
  
  if((a<(b+c))&&(b<(a+c)&&(c<(a+b)))){
    if((a==b)&&(b==c)){
      printf("Triangulo Equilatero.\n");
    }else if((a==b)||(b==c)||(a==c)){
      printf("Triangulo Isósceles.\n");
    }else{
      printf("Triangulo Escaleno.\n");
    }
  }else{
    printf("Não forma triangulo.\n");
  }
  
  
}
