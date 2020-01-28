#include <stdio.h>
#include <string.h>
#include <stdlib.h>

//Aluno: Jo�o Emanuel 2016.2
//email: emanuel71jo@gmail.com


typedef struct{
    int codigo,qtde;
    char nome_livro[20],nome_autor[20],area_livro[20];
}Li;
typedef struct{
    int matricula,qtde_emprestimo;
    char nome_aluno[30],cpf[20],livro1[20],livro2[20];
}Al;
int main(void){
    int opcao_acervo,opcao,opcao_aluno;

    int menu(void);
    int menu_acervo(void);
    void cadastro_livro(void);
    void editar_livro(void);
    int remover_livro(void);
    int listar_livro(void);
    int menu_aluno(void);
    void cadastro_aluno(void);
    int listar_aluno(void);
    void editar_aluno(void);
    int remover_aluno(void);
    int menu_editar_livro(void);
    int menu_editar_aluno(void);
    void novo_emprestimo(void);
    int menu_emprestimo(void);
    void emprestimo(void);

    menu_inicio:
    opcao=menu();
    switch(opcao){

        case 1:{
            menu_acervo:
            opcao_acervo=menu_acervo();
            system("clear");
            switch(opcao_acervo){

                case 1:{
                    cadastro_livro();
                    system("clear");
                    printf("\n\nCadastrado com sucesso!!\n\n");
                    goto menu_acervo;
                    break;
                }

                case 2:{
                    editar_livro();
                    goto menu_acervo;
                    break;
                }

                case 3:{
                    int a;
                    a=remover_livro();
                    if(a==1){
                        system("clear");
                        goto menu_inicio;
                    }
                    if(a==0){
                        exit (0);
                    }
                    break;
                }

                case 4:{
                    int x;
                    x=listar_livro();
                    if(x==1){
                        system("clear");
                        goto menu_inicio;
                    }
                    if(x==0){
                        exit(0);
                    }
                    break;
                }
                case 5:{
                    goto menu_inicio;
                    break;
                }
                default:{
                    printf("\nOpção Inválida.\n");
                    goto menu_acervo;
                }
            }
            break;
        }
        case 2:{
            menu_aluno:
            opcao_aluno=menu_aluno();
            system("clear");
            switch(opcao_aluno){
                case 1:{
                    cadastro_aluno();
                    system("clear");
                    printf("\n\nCadastrado com sucesso!!\n\n");
                    goto menu_aluno;
                    break;
                }
                case 2:{
                    int a;
                    a=remover_aluno();
                    if(a==1){
                        system("clear");
                        goto menu_inicio;
                    }
                    if(a==0){
                        exit (0);
                    }
                    break;
                }
                case 3:{
                    editar_aluno();
                    goto menu_aluno;
                    break;
                }
                case 4:{
                    int y;
                    y=listar_aluno();
                    if(y==1){
                        system("clear");
                        goto menu_inicio;
                    }
                    if(y==0){
                        exit(0);
                    }
                    break;
                }
                case 5:{
                    goto menu_inicio;
                    break;
                }
                default:{
                    printf("\nOpção Inválida.\n");
                    goto menu_aluno;
                }
            }
            break;
        }
        case 3:{
            emprestimo();
            goto menu_inicio;
            break;
        }
        case 4:{
            exit(0);
        }
        default:{
            printf("\nOpção Inválida.\n");
            system("sleep 2");
            goto menu_inicio;
        }
    }
}
int menu(void){
    int a;
    system("clear");
    printf("<1> Acervo.\n");
    printf("<2> Aluno.\n");
    printf("<3> Empréstimo.\n");
    printf("<4> Sair.\n");
    scanf("%d",&a);
    system("clear");
    return a;
}
int menu_acervo(void){
    int a;
    in:
    printf("<1> Cadastro.\n");
    printf("<2> Editar.\n");
    printf("<3> Remover.\n");
    printf("<4> Listar.\n");
    printf("<5> Voltar.\n");
    scanf("%d",&a);
    if ((a<1)||(a>5)){
        printf("\nOpção Inválida.\n");
        goto in;
    }else{
        return a;
    }
}
void cadastro_livro(void){
    Li livros;
    FILE *arquivo=fopen("livros.txt","a+b");
    system("clear");
    printf("Codigo: ");
    scanf("%d",&livros.codigo);
    printf("Livro: ");
    scanf("%s",livros.nome_livro);
    printf("Autor: ");
    scanf("%s",livros.nome_autor);
    printf("Qtde: ");
    scanf("%d",&livros.qtde);
    printf("Area: ");
    scanf("%s",livros.area_livro);
    fwrite(&livros,sizeof(Li),1,arquivo);
    fclose(arquivo);

}
void editar_livro(void){
    system("clear");
    int menu_editar_livro(void);
    int posicao=0,achou=0;
    char aux1[30];
    printf("Livro: ");
    scanf("%s",aux1);
    FILE *arquivo=fopen("livros.txt","r+b");
    Li livro;
    system("clear");
    int op=-1;
    int aux;
    while((fread(&livro,sizeof(Li),1,arquivo)==1)&&(op!=0)){
        if(strcmp(aux1,livro.nome_livro)==0){
            in:
            aux=menu_editar_livro();
            switch(aux){
                case 1:{
                    printf("Digite o novo nome livro: ");
                    scanf("%s",livro.nome_livro);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&livro,sizeof(Li),1,arquivo)==sizeof(Li);
                    break;
                }
                case 2:{
                    printf("Digite o novo nome autor: \n");
                    scanf("%s",livro.nome_autor);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&livro,sizeof(Li),1,arquivo)==sizeof(Li);
                    break;
                }
                case 3:{
                    printf("Digite nova area: \n");
                    scanf("%s",livro.area_livro);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&livro,sizeof(Li),1,arquivo)==sizeof(Li);
                    break;
                }
                case 4:{
                    printf("Digite novo codigo: \n");
                    scanf("%d",&livro.codigo);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&livro,sizeof(Li),1,arquivo)==sizeof(Li);
                    break;
                }
                case 5:{
                    printf("Digite a nova qtde: \n");
                    scanf("%d",&livro.qtde);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&livro,sizeof(Li),1,arquivo)==sizeof(Li);
                    break;
                }
                default:{
                    printf("\nOpção Inválida.\n");
                    goto in;
                }
            }
            posicao=posicao+sizeof(Li);
            fseek(arquivo,posicao,SEEK_SET);
        }
    }
    op=-1;
    fclose(arquivo);
}
int remover_livro(void){
    system("clear");
    Li livros;
    int codigo;
    printf("Digite o codigo do livro a ser removido: ");
    scanf("%d",&codigo);
    FILE *arquivo=fopen("livros.txt","rb");
    FILE *arquivo1=fopen("aux.txt","a+b");
    while(fread(&livros,sizeof(Li),1,arquivo)==1){
        if(livros.codigo!=codigo){
            fwrite(&livros,sizeof(Li),1,arquivo1);
        }
    }
    fclose(arquivo1);
    fclose(arquivo);
    system("rm livros.txt");
    system("mv aux.txt livros.txt");
    char ch;
    in:
    printf("\nMenu inicial? s\\n.");
    scanf("%s",&ch);
    switch(ch){
        case 's':
        case 'S':{
            return 1;
        }
        case 'n':
        case 'N':{
            return 0;
        }
        default:{
            printf("\nOpção Inválida.\n");
            goto in;
        }
    }
}
int listar_livro(void){
    system("clear");
    Li livros;
    int i=1;
    FILE *arquivo=fopen("livros.txt","rb");
    while(fread(&livros,sizeof(Li),1,arquivo)==1){
        printf("\n\tLIVRO %d\n\n",i);
        printf("Livro: %s\n",livros.nome_livro);
        printf("Autor: %s\n",livros.nome_autor);
        printf("Codigo: %d\n",livros.codigo);
        printf("Area: %s\n",livros.area_livro);
        i++;
    }
    fclose(arquivo);
    char ch;
    in:
    printf("\nMenu inicial? s\\n.");
    scanf("%s",&ch);
    switch(ch){
        case 's':
        case 'S':{
            return 1;
        }
        case 'n':
        case 'N':{
            return 0;
        }
        default:{
            printf("\nOpção Inválida.\n");
            goto in;
        }
    }
}
int menu_aluno(void){
    int a;
    in:
    printf("<1> Cadastrar.\n");
    printf("<2> Remover.\n");
    printf("<3> Editar.\n");
    printf("<4> Listar.\n");
    printf("<5> Voltar.");
    scanf("%d",&a);
    if ((a<1)||(a>5)){
        printf("\nOpção Inválida.\n");
        goto in;
    }else{
        return a;
    }
}
void cadastro_aluno(void){
    Al aluno;
    FILE *arquivo=fopen("alunos.txt","a+b");
    printf("Matricula: ");
    scanf("%d",&aluno.matricula);
    printf("CPF: ");
    scanf("%s",aluno.cpf);
    printf("Nome: ");
    scanf("%s",aluno.nome_aluno);
    fwrite(&aluno,sizeof(Al),1,arquivo);
    fclose(arquivo);
}
int listar_aluno(void){
    system("clear");
    Al aluno;
    int i=1;
    FILE *arquivo=fopen("alunos.txt","rb");
    while(fread(&aluno,sizeof(Al),1,arquivo)==1){
        printf("\n\tALUNO %d\n\n",i);
        printf("Matricula: %d\n",aluno.matricula);
        printf("Nome: %s\n",aluno.nome_aluno);
        printf("CPF: %s\n",aluno.cpf);
        i++;
    }
    fclose(arquivo);
    char ch;
    in:
    printf("\nMenu inicial? s\\n.");
    scanf("%s",&ch);
    switch(ch){
        case 's':
        case 'S':{
            return 1;
        }
        case 'n':
        case 'N':{
            return 0;
        }
        default:{
            printf("\nOpção Inválida.\n");
            goto in;
        }
    }
}
void editar_aluno(void){
    system("clear");
    int main();
    int menu_editar_aluno(void);
    int posicao=0,achou=0;
    char aux1[30];
    printf("Aluno: ");
    scanf("%s",aux1);
    FILE *arquivo=fopen("alunos.txt","r+b");
    Al aluno;
    system("clear");
    int op=-1;
    int aux;
    while((fread(&aluno,sizeof(Al),1,arquivo)==1)&&(op!=0)){
        if(strcmp(aux1,aluno.nome_aluno)==0){
            in:
            aux=menu_editar_aluno();
            switch(aux){
                case 1:{
                    printf("Digite a nova matricula: ");
                    scanf("%d",&aluno.matricula);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&aluno,sizeof(Al),1,arquivo)==sizeof(Al);
                    break;
                }
                case 2:{
                    printf("Digite o novo nome aluno: \n");
                    scanf("%s",aluno.nome_aluno);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&aluno,sizeof(Al),1,arquivo)==sizeof(Al);
                    break;
                }
                case 3:{
                    printf("Digite o novo CPF: \n");
                    scanf("%s",aluno.cpf);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&aluno,sizeof(Al),1,arquivo)==sizeof(Al);
                    break;
                }
                case 4:{
                    posicao=posicao+sizeof(Al);
                    fseek(arquivo,posicao,SEEK_SET);
                    fclose(arquivo);
                    main();
                }

                default:{
                    printf("\nOpção Inválida.\n");
                    goto in;
                }
            }
            posicao=posicao+sizeof(Al);
            fseek(arquivo,posicao,SEEK_SET);
        }
    }
    op=-1;
    fclose(arquivo);
}
int remover_aluno(void){
    system("clear");
    Al aluno;
    int matricula;
    printf("Digite a matricula do aluno a ser removido: ");
    scanf("%d",&matricula);
    FILE *arquivo=fopen("alunos.txt","rb");
    FILE *arquivo1=fopen("aux.txt","a+b");
    while(fread(&aluno,sizeof(Al),1,arquivo)==1){
        if(aluno.matricula!=matricula){
            fwrite(&aluno,sizeof(Al),1,arquivo1);
        }
    }
    fclose(arquivo1);
    fclose(arquivo);
    system("rm alunos.txt");
    system("mv aux.txt alunos.txt");
    char ch;
    in:
    printf("\nMenu inicial? s\\n.");
    scanf("%s",&ch);
    switch(ch){
        case 's':
        case 'S':{
            return 1;
        }
        case 'n':
        case 'N':{
            return 0;
        }
        default:{
            printf("\nOpção Inválida.\n");
            goto in;
        }
    }
}
int menu_editar_livro(void){
    in:
    printf("\nO que deseja editar?\n");
    printf("<1> Nome livro.\n");
    printf("<2> Nome autor.\n");
    printf("<3> Area.\n");
    printf("<4> Codigo livro.\n");
    printf("<5> Qtde livro.\n");
    int op;
    scanf("%d",&op);
    if((op<1)||(op>5)){
        printf("\nOpção Inválida.\n");
        goto in;
    }else{
        return op;
    }
}
int menu_editar_aluno(void){
    in:
    printf("\nO que deseja editar?\n");
    printf("<1> Matricula aluno.\n");
    printf("<2> Nome aluno.\n");
    printf("<3> CPF aluno.\n");
    printf("<4> Menu Inicial.\n");
    int op;
    scanf("%d",&op);
    if((op<1)||(op>4)){
        printf("\nOpção Inválida.\n");
        goto in;
    }else{
        return op;
    }

}
void emprestimo(void){
    int menu_emprestimo(void);
    void novo_emprestimo(void);
    void devolucao(void);
    int listar1_emprestimo(void);
    int a;
    in:
    a=menu_emprestimo();
    switch(a){
        case 1:{
            novo_emprestimo();
            goto in;
            break;
        }
        case 2:{
            devolucao();
            goto in;
            break;
        }
        case 3:{
            system("clear");
            printf("Não entendi essa parte. Cancelar como? Se fá foi emprestado, uma forma de cancelar seria a devolução, enfim, não fiz essa parte por que não entendi.\n ");
            system("sleep 5");
            goto in;
            break;
        }
        case 4:{
            int m;
            m=listar1_emprestimo();
            if(m==1){
                main();
            }else{
                exit (0);
            }
            break;
        }
    }
}
int menu_emprestimo(void){
    int op;
    in:
    system("clear");
    printf("<1> Novo empréstimo.\n");
    printf("<2> Confirmar devolução.\n");
    printf("<3> Cancelar empréstimo.\n");
    printf("<4> Listar empréstimos.\n");
    printf("<5> Voltar.\n");
    scanf("%d",&op);
    if((op<1)||(op>5)){
        printf("\nOpção Invlida.\n");
        goto in;
    }else{
        return op;
    }
}
void novo_emprestimo(void){
    system("clear");
    Al aluno;
    Li livro;
    FILE *file1=fopen("alunos.txt","r+b");
    FILE *file2=fopen("livros.txt","rb");
    printf("Digite o nome do livro: ");
    char nome[20];
    scanf("%s",nome);
    printf("\nDigite o nome do aluno: ");
    char alu[20];
    scanf("%s",alu);
    int op=-1,op1=-1,posicao1=0,achou1=0,posicao2=0,achou2=0;
    while((fread(&aluno,sizeof(Al),1,file1)==1)&&(op!=0)){
        if(strcmp(alu,aluno.nome_aluno)==0){
            if(aluno.qtde_emprestimo<=2){
                aluno.qtde_emprestimo++;
                while((fread(&livro,sizeof(Li),1,file2)==0)&&(op1!=0)){
                    if(strcmp(nome,livro.nome_livro)==0){
                        if(aluno.qtde_emprestimo==1){
                            strcpy(aluno.livro1,livro.nome_livro);
                        }
                        if(aluno.qtde_emprestimo==2){
                            strcpy(aluno.livro2,livro.nome_livro);
                        }
                        fseek(file2,posicao1,SEEK_SET);
                        achou1=fwrite(&livro,sizeof(Li),1,file2)==sizeof(Li);
                        posicao1=posicao1+sizeof(Li);
                        fseek(file2,posicao1,SEEK_SET);
                    }
                }
                fseek(file1,posicao2,SEEK_SET);
                achou2=fwrite(&aluno,sizeof(Al),1,file1)==sizeof(Al);
                posicao2=posicao2+sizeof(Al);
                fseek(file1,posicao2,SEEK_SET);
            }else{
                printf("Aluno %s já realizou os 2 empréstimos.",aluno.nome_aluno);
            }

        }

    }
    op=op1=-1;
    fclose(file1);
    fclose(file2);
}
void devolucao(void){
    system("clear");
    Al aluno;
    Li livro;
    FILE *file1=fopen("alunos.txt","r+b");
    FILE *file2=fopen("livros.txt","rb");
    in:
    printf("Digite o nome do livro: ");
    char nome[20];
    scanf("%s",nome);
    printf("\nDigite o nome do aluno: ");
    char alu[20];
    scanf("%s",alu);
    int op=-1,op1=-1,posicao1=0,achou1=0,posicao2=0,achou2=0;
    while((fread(&aluno,sizeof(Al),1,file1)==1)&&(op!=0)){
        if(strcmp(alu,aluno.nome_aluno)==0){
            if(aluno.qtde_emprestimo>0){
                aluno.qtde_emprestimo--;
                while((fread(&livro,sizeof(Li),1,file2)==0)&&(op1!=0)){
                    if(strcmp(nome,livro.nome_livro)==0){
                        if(strcmp(nome,aluno.livro1)==0){
                            strcpy(aluno.livro1,"");
                        }else if(strcmp(nome,aluno.livro2)==0){
                            strcpy(aluno.livro2,"");
                        }else{
                            printf("Livro não encontrado.\n");
                            goto in;
                        }
                        fseek(file2,posicao1,SEEK_SET);
                        achou1=fwrite(&livro,sizeof(Li),1,file2)==sizeof(Li);
                        posicao1=posicao1+sizeof(Li);
                        fseek(file2,posicao1,SEEK_SET);
                    }
                }
                fseek(file1,posicao2,SEEK_SET);
                achou2=fwrite(&aluno,sizeof(Al),1,file1)==sizeof(Al);
                posicao2=posicao2+sizeof(Al);
                fseek(file1,posicao2,SEEK_SET);
            }else{
                printf("O aluno %s não tem livro emprestado.\n",aluno.nome_aluno);
            }

        }

    }
    op=op1=-1;
    fclose(file1);
    fclose(file2);

}
int listar1_emprestimo(void){
    system("clear");
    Al aluno;
    FILE *arquivo=fopen("alunos.txt","rb");
    int aux=1;
    while(fread(&aluno,sizeof(Al),1,arquivo)==1){
        if(aluno.qtde_emprestimo=1){
            if(!strcmp(aluno.livro1,"")==0){
                printf("Livro %d: %s.\n",aux,aluno.livro1);
            }
            if(!strcmp(aluno.livro2,"")==0){
                printf("Livro %d: %s.\n",aux,aluno.livro2);
            }
        }
        if(aluno.qtde_emprestimo==2){
            printf("Livro %d: %s.\n",aux,aluno.livro1);
            printf("Livro %d: %s.\n",aux,aluno.livro2);
        }
        aux++;
    }
    fclose(arquivo);
    char ch;
    in:
    printf("\nMenu inicial? s\\n.");
    scanf("%s",&ch);
    switch(ch){
        case 's':
        case 'S':{
            return 1;
        }
        case 'n':
        case 'N':{
            return 0;
        }
        default:{
            printf("\nOpção Inválida.\n");
            goto in;
        }
    }
}
