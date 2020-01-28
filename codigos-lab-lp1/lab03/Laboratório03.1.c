#include <stdio.h>
#include <stdlib.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Faça um programa que imprima na tela um triângulo retângulo a partir de
* um numero digitado pelo usuário. No exemplo abaixo, vemos a saída do
* programa às entradas 3, 4, e 5, respectivamente.*/

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
