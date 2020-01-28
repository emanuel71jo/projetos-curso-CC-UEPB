#include <stdio.h>
#include <stdlib.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

struct atendimento{
    char tipoAtendimento[15],senha[10],nome[20];
};
typedef struct elemento{
    struct atendimento dados;
    struct elemento *prox;
} Elem;
typedef struct fila{
    struct elemento *inicio;
    struct elemento *fim;
} Fila;
Fila* criar(){
    Fila* fi = (Fila*) malloc(sizeof(Fila));
    if(fi != NULL){
        fi->inicio= NULL;
        fi->fim= NULL;
    }
    return fi;
}
void liberar(Fila *fi){
    if(fi !=NULL){
        Elem * no;
        while(fi->inicio!=NULL){
            no = fi->inicio;
            fi->inicio = fi->inicio->prox;
            free(no);
        }
        free(fi);
    }
}
int tamanho(Fila *fi){
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
void vazia(Fila *fi){
    int tam = tamanho(fi);
    if(fi !=NULL){
        if(fi->inicio==NULL){
            printf("\nFILA VAZIA\n");
        }
        else{
            printf("\nFILA NAO VAZIA\n");
        }
        printf("\nFILA COM %d ELEMENTO(S)\n",tam);
    }
    else{
        printf("\nERRO DE ALOCACAO\n");
    }
}
void inserir(Fila *fi, struct atendimento a){
    if(fi==NULL){
        printf("\nERRO DE ALOCACAO\n");
    }
    else{
        Elem *no = (Elem*) malloc(sizeof(Elem));
        if(no != NULL){
            no->dados= a;
            no->prox= NULL;
            if(fi->fim==NULL){
                fi->inicio=no;
            }
            else{
                fi->fim->prox=no;
            }
            fi->fim=no;
            printf("\nELEMENTO INSERIDO\n");
        }
        else{
            printf("\nERRO DE ALOCACAO\n");
        }
    }
}
void remover(Fila *fi){
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
            if(fi->inicio== NULL){
                fi->fim= NULL;
            }
            free(no);
            printf("\nELEMENTO REMOVIDO\n");
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
                printf("NOME: %s\n",no->dados.nome);
                printf("SENHA: %s\n",no->dados.senha);
                printf("TIPO: %s\n",no->dados.tipoAtendimento);
                printf("*******************************\n");
                no = no->prox;
            }
        }
    }
}
int menu(){
    int op;
    printf("\n0 - SAIR\n");
    printf("1 - MOSTRAR FILA\n");
    printf("2 - VERIFICAR FILA VAZIA\n");
    printf("3 - INSERIR\n");
    printf("4 - REMOVER\n");
    printf("\nOPCAO: ");
    scanf("%d",&op);
    putchar('\n');
    return op;
}
void novoAtendimento(struct atendimento *al){
    int op;
    printf("<1> DIGITE A SENHA: ");fflush(stdin);gets(al->senha);
    printf("<2> DIGITE O NOME: ");fflush(stdin);gets(al->nome);
}
int menuFila(){
    int op;
    printf("\n0 - VOLTAR\n");
    printf("1 - FILA PREFERENCIAL\n");
    printf("2 - FILA COMUM\n");
    printf("\nOPCAO: ");
    scanf("%d",&op);
    putchar('\n');
    return op;
}
int menuVazia(){
    int op;
    printf("\n0 - VOLTAR\n");
    printf("1 - FILA PREFERENCIAL\n");
    printf("2 - FILA COMUM\n");
    printf("\nOPCAO: ");
    scanf("%d",&op);
    putchar('\n');
    return op;
}
int menuInserir(){
    int op;
    printf("\n0 - VOLTAR\n");
    printf("1 - FILA PREFERENCIAL\n");
    printf("2 - FILA COMUM\n");
    printf("\nOPCAO: ");
    scanf("%d",&op);
    putchar('\n');
    return op;
}
int menuRemover(){
    int op;
    printf("\n0 - VOLTAR\n");
    printf("1 - FILA PREFERENCIAL\n");
    printf("2 - FILA COMUM\n");
    printf("\nOPCAO: ");
    scanf("%d",&op);
    putchar('\n');
    return op;
}
void main(){
    int o,op1;
    Fila *prefe = criar();
    Fila *comum = criar();
    struct atendimento al;
    while((o=menu())!=0){
        switch(o){
        case 0:
            break;
        case 1:
            op1=menuFila();
            if(op1==1){
                mostrar(prefe);
            }else if(op1==2){
                mostrar(comum);
            }
            break;
        case 2:
            op1=menuVazia();
            if(op1==1){
                vazia(prefe);
            }else if(op1==2){
                vazia(comum);
            }
            break;
        case 3:
            op1=menuInserir();
            novoAtendimento(&al);
            if(op1==1){
                strcpy(al.tipoAtendimento,"PREFERENCIAL");
                inserir(prefe,al);
            }else if(op1==2){
                strcpy(al.tipoAtendimento,"COMUM");
                inserir(comum,al);
            }
            break;
        case 4:
            op1=menuInserir();
            if(op1==1){
                remover(prefe);
            }else if(op1==2){
                remover(comum);
            }
            break;
        default:
            printf("OPCAO INVALIDA\n\n");
        }
    }
    liberar(prefe);
    liberar(comum);
}
