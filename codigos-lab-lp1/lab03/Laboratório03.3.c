#include <stdio.h>
#include <stdlib.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Faça um programa que peça um número 'n' ao usuário, e que gere um
* novo n de acordo com a seguinte regra:
* se n é par, n = n / 2
* se n é impar, n = 3 * n + 1
* imprime n
* O programa deve parar quando n tiver o valor igual a 1.
* Por exemplo, para n = 13, a saída será:
* 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1 */

int main() {
	
	int n;
	scanf("%d",&n);
	
	while(n!=1){
		if((n%2)==0){
			n/=2;
		}else{
			n=(n*3)+1;
		}
		printf("%d",n);
		if(n!=1){
			printf(" -> ");
		}
	}
	
	return 0;
}
