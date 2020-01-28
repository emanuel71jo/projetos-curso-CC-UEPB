#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

typedef struct{
    int numero;
}NUM;
typedef struct elemento{
    NUM dados;
    struct elemento *prox;
} ELEM;
typedef struct{
    ELEM *topo;
} PILHA;
PILHA* criar(){
    PILHA* pi = (PILHA*) malloc(sizeof(PILHA));
    if(pi != NULL){
        pi->topo= NULL;
    }
    return pi;
}
void inserir(PILHA *pi, NUM al){
    if(pi==NULL){
        printf("\nERRO DE ALOCACAO\n");
    }
    else{
        ELEM *no = (ELEM*) malloc(sizeof(ELEM));
        if(no != NULL){
            no->dados= al;
            if(pi->topo==NULL){
                no->prox= NULL;
            }
            else{
                no->prox= pi->topo;
            }
            pi->topo=no;
        }
        else{
            printf("\nERRO DE ALOCACAO\n");
        }
    }
}
int remover(PILHA *pi){
    if(pi==NULL){
        printf("\nERRO DE ALOCACAO\n");
    }
    else{
        if(pi->topo==NULL){
            printf("\nPILHA VAZIA\n");
        }
        else{
            ELEM *no = pi->topo;
            pi->topo = pi->topo->prox;
            int n = no->dados.numero;
            free(no);
            return n;
        }
    }
}
void liberarPilha(PILHA *pi){
    if(pi !=NULL)
    {
        ELEM * no;
        while(pi->topo!=NULL){
            no = pi->topo;
            pi->topo = pi->topo->prox;
            free(no);
        }
        free(pi);
    }
}
int main() {
	PILHA *pi = criar();NUM al;int qtd,menor,maior,aux,n,i;float media;
	printf("Digite a quantidade de numeros para a pilha:");scanf("%d",&qtd);
	for(i=0;i<qtd;i++){
		printf("Digite o elemento %d da pilha:",i+1);scanf("%d",&al.numero);
		inserir(pi,al);
	}
	menor = remover(pi);
	maior = remover(pi);
	if(menor > maior){
		aux = menor;
		menor = maior;
		maior = aux;
	}
	media = menor + maior;
	for(i=0;i<qtd-2;i++){
		n = remover(pi);
		media += n;
		if ( menor > n){
			menor = n;
		}
		if( maior < n){
			maior = n;
		}
	}
	printf("\nO MAIOR: %d\nO MENOR: %d\nA MEDIA: %.2f\n",maior,menor,media/qtd);
	liberarPilha(pi);
	
	return 0;
}



