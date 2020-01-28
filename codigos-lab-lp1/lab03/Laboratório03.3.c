#include <stdio.h>
#include <stdlib.h>

//Aluno: Jo�o Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Fa�a um programa que pe�a um n�mero 'n' ao usu�rio, e que gere um
* novo n de acordo com a seguinte regra:
* se n � par, n = n / 2
* se n � impar, n = 3 * n + 1
* imprime n
* O programa deve parar quando n tiver o valor igual a 1.
* Por exemplo, para n = 13, a sa�da ser�:
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
