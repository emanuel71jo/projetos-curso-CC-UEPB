#include <stdio.h>
#include <stdlib.h>

//Aluno: Jo�o Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Escreva um programa que receba a entrada de um n�mero de cinco d�gitos,
* separe o n�mero em seus d�gitos componentes e os imprima separados uns dos
* outros por tr�s espa�os.*/

int main(void){
	int numero,aux1,aux2,aux3,aux4;
	
	scanf("%d",&numero);
	aux1=numero/10000;
	numero-=aux1*10000;
	aux2=numero/1000;
	numero-=aux2*1000;
	aux3=numero/100;
	numero-=aux3*100;
	aux4=numero/10;
	numero-=aux4*10;
	
	printf("%d %d %d %d %d\n",aux1,aux2,aux3,aux4,numero);

	return 0;	
}
