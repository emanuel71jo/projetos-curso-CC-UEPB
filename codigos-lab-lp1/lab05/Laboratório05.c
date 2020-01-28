#include <stdio.h>
#define DIM 4

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

/* Implemente um programa que dado um vetor bidimensional 3x3, deverá zerar
* todos os elementos do vetor. Para tanto, cada elemento do vetor deverá ser
* incrementado por vez. Implementado funções que tenham a tarefa de somar os
* elementos do vetor, imprimi-los e decrementá-los. Assuma que serão digitados apenas
* valores Negativos e/ou neutros. */


void alterarValor(int v[DIM][DIM]){
    int i,j,maior=v[0][0],imaior,jmaior;
    for(i=0;i<DIM;i++){
        for(j=0;j<DIM;j++){
            if(v[i][j]<=maior){
                imaior=i;
                jmaior=j;
                maior=v[i][j];
            }
        }
    }
    if(maior<0){
        v[imaior][jmaior]+=1;
    }
}
int somarElementos(int v[DIM][DIM]){
    int i, j, soma=0;
    alterarValor(v);
    for(i=0;i<DIM;i++){
        for(j=0;j<DIM;j++){
            soma+=v[i][j];
        }
    }
    return soma;
}
void imprimir(int v[DIM][DIM]){
    int i,j;
    for(i=0;i<DIM;i++){
        for(j=0;j<DIM;j++){
                printf("%3d",v[i][j]);
        }
        printf("\n");
    }
}
main(){
    int matriz[DIM][DIM]={{-1,-3, -4,-2},{-2,-3,-0,0},{-3,-2,-1,-4},{-1,-2,-3,-4}};
    printf("MATRIZ ORIGINAL\n");
    imprimir(matriz);
    printf("\nITERACOES\n\n");
    int soma;
    while(1){
        soma=somarElementos(matriz);
        imprimir(matriz);
        printf("SOMA DOS ELEMENTOS = %d\n\n",soma);
        if(soma==0){
            break;
        }
    }
}
