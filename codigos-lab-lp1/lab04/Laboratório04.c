#include <stdio.h>
#include <stdlib.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* A sequência de Fibonacci é uma sequência de números inteiros, começando
* normalmente por 0 e 1, na qual, cada termo subsequente corresponde à soma
* dos dois anteriores.
* 0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, ...
* Implemente uma função que receba a quantidade de termos a serem calculados
* e retorne a somatória de todos os termos.
* Exemplo:
* Digite a quantidade de termos: 5
* 0 1 1 2 3 5 8
* Somatória: 19
*/

int somarFibonacci(int qtd_termo);
void imprimirFibonacci(int soma);

void main(void){
  int n,aux;
  printf("Digite a quantidade de termos:");
  scanf("%d",&n);
  imprimirFibonacci(somarFibonacci(n));
}
int somarFibonacci(int qtd_termo){
	int x[qtd_termo+2],i,soma=0;
	x[0]=0;
	x[1]=1;
	for(i=2;i<qtd_termo+2;i++){
		x[i]=x[i-1]+x[i-2];
		soma+=x[i];
	}
	return soma;
}
void imprimirFibonacci(int soma){
	printf("Somatoria = %d\n",soma);
}
