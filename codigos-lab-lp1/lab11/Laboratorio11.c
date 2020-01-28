#include <stdio.h>
#include <stdlib.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

typedef struct{
    int contato;
    char nome[30];
    struct lista *prox;

}lista;
void inserir(lista **p){
	system("cls");
    lista *atual, *novo, *anterior;
    int contato;char nome[30];
    novo = (lista *) malloc(sizeof(lista));
    atual = *p;
    anterior = NULL;
    printf("<1> Informe seu nome: ");fflush(stdin);gets(nome);
    printf("<2> Informe seu telefone:");fflush(stdin);scanf("%d",&contato);
    novo->contato = contato;
    strcpy(novo->nome,nome);
    if(atual == NULL){
        novo->prox = NULL;
        *p = novo;
    } else{
        while(atual != NULL && atual->nome < nome){
            anterior = atual;
            atual = atual->prox;
        }

        novo->prox = atual;

        if(anterior == NULL){
            *p = novo;
        } else{
            anterior->prox = novo;
        }
    }
}
void mostraLista(lista *p){
	int i=1;
	system("cls");
    while(p != NULL){
    	printf("CONTATO %d\n",i);
        printf("NOME: %s\n", p->nome);
        printf("TELEFONE: %d\n",p->contato);
        i++;
        p = p->prox;
    }
}
void libera(lista *LISTA){
    lista *proxNode,*atual;
    atual = LISTA->prox;
    while(atual != NULL){
        proxNode = atual->prox;
        free(atual);
        atual = proxNode;
    }

}
int menu(){
	system("cls");
	int op;
	printf("<1> Inserir contato.\n");
	printf("<2> Mostrar contatos.\n");
	printf("<3> Liberar lista.\n");
	printf("<4> Sair.\n");
	printf("OPCAO: ");
	scanf("%d",&op);
	return op;
}
int main(void){
    lista *l = NULL;int op;
    op=menu();
    while(op!=4){
    	switch(op){
    		case 1:{
    			inserir(&l);
				break;
			}
			case 2:{
				mostraLista(l);
				system("pause > NULL");
				break;
			}
			case 3:{
				libera(&l);
				break;
			}
		}
		op=menu();
	}

    return 0;
}
