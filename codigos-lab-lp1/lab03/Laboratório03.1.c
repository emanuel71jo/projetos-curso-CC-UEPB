#include <stdio.h>
#include <stdlib.h>

//Aluno: Jo�o Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Fa�a um programa que imprima na tela um tri�ngulo ret�ngulo a partir de
* um numero digitado pelo usu�rio. No exemplo abaixo, vemos a sa�da do
* programa �s entradas 3, 4, e 5, respectivamente.*/

int main() {
	char c='*';
	int i,n,j,m=1;
	scanf("%d",&n);
	
	for(i=0;i<n;i++){
		for(j=0;j<m;j++){
			printf("%c ",c);
		}
		printf("\n");
		m++;
	}
	
	
	return 0;
