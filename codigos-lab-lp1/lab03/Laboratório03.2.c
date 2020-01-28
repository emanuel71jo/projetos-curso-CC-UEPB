#include <stdio.h>
#include <stdlib.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Faça um programa que calcule os X primeiros termos de uma progressão
* aritmética (PA), onde o primeiro termo e a razão são passados pelo usuário.
* an = a1 + (n – 1) . r */

int main() {
	
	int an,a1,i,r,a,x;
	scanf("%d %d %d",&x,&a1,&r);
	an=(a1+(x-1)*r);
	for(i=a1;i<=an;i+=r){
		printf("%d ",i);
	}	
	return 0;
}
