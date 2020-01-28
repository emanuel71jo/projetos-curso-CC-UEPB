#include <stdio.h>
#include <stdlib.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Usando apenas as técnicas aprendidas até então, escreva um programa que
* calcule o quadrado e o cubo dos números de 0 a 5 e use tabulações para imprimir
* a tabela. */

void main(void) {
	int a=0,b=1,c=2,d=3,e=4,f=5;
	printf("Numero\t\tQuadrado\tCubo\n\n");
	printf("%d\t\t%d\t\t%d\n",a,a*a,a*a*a);
	printf("%d\t\t%d\t\t%d\n",b,b*b,b*b*b);
	printf("%d\t\t%d\t\t%d\n",c,c*c,c*c*c);
	printf("%d\t\t%d\t\t%d\n",d,d*d,d*d*d);
	printf("%d\t\t%d\t\t%d\n",e,e*e,e*e*e);
	printf("%d\t\t%d\t\t%d\n",f,f*f,f*f*f);
	printf("----------------------------------");
	
}
