#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

typedef struct{
    char nome;
}FRASE;
typedef struct elemento{
    FRASE dados;
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
void inserir(PILHA *pi, FRASE al){
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
char remover(PILHA *pi){
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
            char nome = no->dados.nome;
            free(no);
            return nome;
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
	PILHA *pi = criar();FRASE al;char nome[30];fflush(stdin);
	printf("DIGITE A FRASE A VERIFICAR:");
	gets(nome);
	int i;
	for(i=0;i<strlen(nome);i++){
		al.nome=nome[i];
		inserir(pi,al);

	}
	char nomeVolta[30];
	for(i=0;i<strlen(nome);i++){
		nomeVolta[i]=remover(pi);
	}
	if(!strcmp(nome,nomeVolta)){
		printf("A frase e palindroma");
	}else{
		printf("A frase nao e palindroma");
	}
	liberarPilha(pi)
	return 0;
}


