#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

typedef struct {
    char nome[30];
}ALUNO;
typedef struct elemento{
    ALUNO dados;
    struct elemento *prox;
} ELEM;
typedef struct elemento1{
    ALUNO dados;
    struct elemento1 *prox;
} Elem;
typedef struct{
    ELEM *topo;
} PILHA;
typedef struct{
    struct elemento1 *inicio;
    struct elemento1 *fim;
} Fila;
PILHA* criarPilha(){
    PILHA* pi = (PILHA*) malloc(sizeof(PILHA));
    if(pi != NULL){
        pi->topo= NULL;
    }
    return pi;
}
Fila* criarFila(){
    Fila* fi = (Fila*) malloc(sizeof(Fila));
    if(fi != NULL){
        fi->inicio= NULL;
        fi->fim= NULL;
    }
    return fi;
}
void inserirPilha(PILHA *pi, ALUNO al){
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
void inserirFila(Fila *fi, ALUNO al){
    if(fi==NULL){
        printf("\nERRO DE ALOCACAO\n");
    }
    else{
        Elem *no = (Elem*) malloc(sizeof(Elem));
        if(no != NULL){
            no->dados= al;
            no->prox= NULL;
            if(fi->fim==NULL){
                fi->inicio=no;
            }
            else{
                fi->fim->prox=no;
            }
            fi->fim=no;
        }
        else{
            printf("\nERRO DE ALOCACAO\n");
        }
    }
}
ALUNO removerFila(Fila *fi){
    if(fi==NULL){
        printf("\nERRO DE ALOCACAO\n");
    }
    else{
        if(fi->inicio==NULL){
            printf("\nFILA VAZIA\n");
        }
        else{
            Elem *no = fi->inicio;
            fi->inicio = fi->inicio->prox;
            ALUNO al = no->dados;
            if(fi->inicio== NULL){
                fi->fim= NULL;
            }
            free(no);
            return al;
        }
    }
}
ALUNO removerPilha(PILHA *pi){
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
            ALUNO nome = no->dados;
            free(no);
            return nome;
        }
    }
}
void mostrar(Fila *fi){
    if(fi == NULL){
        printf("\nERRO DE ALOCACAO\n");
    }
    else{
        if(fi->fim==NULL){
            printf("\nFILA VAZIA\n");
        }
        else{
            Elem* no = fi->inicio;
            while(no != NULL){
                printf("NOME DO ALUNO: %s\n",no->dados.nome);
                no = no->prox;
            }
        }
    }
}
int tamanhoFila(Fila *fi){
    if(fi==NULL){
        return -1;
    }
    int cont=0;
    Elem *no = fi->inicio;
    while(no != NULL){
        cont++;
        no= no->prox;
    }
    free(no);
    return cont;
}
void liberarFila(Fila *fi){
    if(fi !=NULL)
    {
        Elem * no;
        while(fi->inicio!=NULL){
            no = fi->inicio;
            fi->inicio = fi->inicio->prox;
            free(no);
        }
        free(fi);
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
int menu(){
	int op;
	system("cls");
	printf("<1> INSERIR NOVO ELEMENTO NA LISTA\n");
	printf("<2> VIZUALIZAR LISTA\n");
	printf("<3> INVERTE ELEMENTOS DA LISTA\n");
	printf("<4> SAIR\n");
	printf("OPCAO: ");scanf("%d",&op);
	system("cls");
	return op;
}
int main() {
	PILHA *pi = criarPilha();int op,i;char nome[30];
	Fila *fi = criarFila();ALUNO al;
	op=menu();
	while(op!=4){
		switch(op){
			case 1:{
				printf("DIGITE O NOME DO ALUNO:");fflush(stdin);gets(al.nome);
				inserirFila(fi,al);
				break;
			}
			case 2:{
				mostrar(fi);
				system("pause > NULL");
				break;
			}
			case 3:{
				int tamanho = tamanhoFila(fi);
				for(i=0;i<tamanho;i++){
					al = removerFila(fi);
					inserirPilha(pi,al);
				}
				for(i=0;i<tamanho;i++){
					al = removerPilha(pi);
					inserirFila(fi,al);
				}
				break;
			}
		}
		op=menu();
	}
	liberarFila(fi);
	liberarPilha(pi);
	
	return 0;
}



