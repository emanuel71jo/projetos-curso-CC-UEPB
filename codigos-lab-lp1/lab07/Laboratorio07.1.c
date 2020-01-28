#include <stdio.h>
#include <stdlib.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

void maximoMinimo(int *v,int N,int *maximo,int *minimo);
int main(){
    int tam,i;
    int *maiorValor=NULL,*menorValor=NULL;
    printf("Digite a quantidade de elementos do VETOR:");
    scanf("%d",&tam);
    int vetor[tam];
    for(i=0;i<tam;i++){
        printf("Digite o elemento %d do vetor: ",i+1);
        scanf("%d",&vetor[i]);
    }
    maximoMinimo(vetor,tam,&maiorValor,&menorValor);
    printf("\nO maior valor do Vetor e: %d\n",maiorValor);
    printf("O menor valor do Vetor e: %d\n",menorValor);
    return 0;
}
void maximoMinimo(int *v,int N,int *maximo,int *minimo){
    int i;
    printf("\n\tVETOR\n");
    for(i=0;i<N;i++){
        printf("%d",v[i]);
        printf("\t");
        if((i!=N)&&(i!=N-1)){
            printf(" | ");
        }
    }
    *maximo=*minimo=v[0];
    for(i=0;i<N;i++){
        if(v[i] > *maximo){
            *maximo=v[i];
        }
        if(v[i] < *minimo){
            *minimo=v[i];
        }
    }
}
