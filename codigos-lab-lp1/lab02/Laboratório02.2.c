#include <stdio.h>

//Aluno: Jo�o Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Dados tr�s valores, A, B, C, verificar se eles podem ser valores dos lados de
* um tri�ngulo e, se forem, se e um tri�ngulo escaleno, equil�tero ou is�scele,
* considerando os seguintes conceitos:
* a. O comprimento de cada lado de um tri�ngulo � menor do que a soma dos
* outros dois lados.
* b. Chama-se equil�tero o tri�ngulo que tem tr�s lados iguais.
* c. Denominam-se is�sceles o tri�ngulo que tem o comprimento de dois
* lados iguais.
* d. Recebe o nome de escaleno o tri�ngulo que tem os tr�s lados diferentes.*/

void main(void){
  float a,b,c;
  
  scanf("%f%f%f",&a,&b,&c);
  
  if((a<(b+c))&&(b<(a+c)&&(c<(a+b)))){
    if((a==b)&&(b==c)){
      printf("Triangulo Equilatero.\n");
    }else if((a==b)||(b==c)||(a==c)){
      printf("Triangulo Is�sceles.\n");
    }else{
      printf("Triangulo Escaleno.\n");
    }
  }else{
    printf("N�o forma triangulo.\n");
  }
  
  
}
