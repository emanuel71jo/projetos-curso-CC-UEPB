#include "bibliotecas.h"

int menuAluno(){
    char op;
    system("cls");
    SetConsoleTitle("MENU DO ALUNO");
    cabecalho();
    printf("                                             ALUNO\n");
    printf("                                    <Tecle a opcao desejada>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t************************  <1> Cadastrar Aluno. ***************************************");
    printf("\n\t************************  <2> Editar Aluno.  *****************************************");
    printf("\n\t************************  <3> Remover Aluno. *****************************************");
    printf("\n\t************************  <4> Listar Alunos Cadastrados.  ****************************");
    printf("\n\t************************  <5> Voltar.  ***********************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************\n");
    op=getch();
    switch(op){
        case '1':return 1;
        case '2':return 2;
        case '3':return 3;
        case '4':return 4;
        case '5':opcoes(opcaoMenu());
        default:{
            system("cls");
            fflush(stdin);
            cabecalho();
            printf("\n\t\t\t\t       Opcao Invalida");
            printf("\n\t\t\t\t<Precione [ENTER] para continuar>");
            system("pause > NULL");
            system("cls");
            opcaoAluno(menuAluno());
        }
    }
}

void opcaoAluno(int op){
    switch(op){
        case 1:{cadastroAluno();break;}
        case 2:{editarAluno();break;}
        case 3:{removerAluno();break;}
        case 4:{listarAluno();break;}
    }
}

void cadastroAluno(){
    Aluno a;int i,mat;
    FILE *arquivo=fopen("aluno.dat","a+b");
    system("title CADASTRO DE ALUNO");
    system("cls");
    cabecalho();
    printf("                                        Cadastro do Aluno\n");
    printf("                                    <Preencha com os dados corretos>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    fflush(stdin);
    printf("\n\t\t\t<1> Informe a matrícula do aluno: ");scanf("%d",&mat);fflush(stdin);
    while(fread(&a,sizeof(Aluno),1,arquivo)==1){
        if(mat==a.matriculaAluno){
            system("cls");
            cabecalho();
            printf("\n\t\t\t\tO Aluno %s já está cadastrado.",a.nomeAluno);
            printf("\n\t\t\t\t<Precione [ENTER] para voltar>");
            system("pause > NULL");
            fclose(arquivo);
            opcaoAluno(menuAluno());
        }
    }
    a.matriculaAluno=mat;
    printf("\n\t\t\t<2> Informe o nome do aluno: ");gets(a.nomeAluno);fflush(stdin);
    printf("\n\t\t\t<3> Informe o CPF do aluno: ");
    for(i=0;i<14;i++){
        if((i==3)||(i==7)||(i==11)){
            if(i==11){
                a.cpfAluno[i]='-';
            }else{
                a.cpfAluno[i]='.';
            }
            putchar(a.cpfAluno[i]);
            i++;
        }
        a.cpfAluno[i]=getch();
        putchar(a.cpfAluno[i]);
    }
    a.cpfAluno[i]='\0';
    getch();
    putchar('\n');
    printf("\n\t\t\t<4> Informe o curso do aluno: ");gets(a.cursoAluno);fflush(stdin);
    strupr(a.cursoAluno);strupr(a.nomeAluno);
    fwrite(&a,sizeof(Aluno),1,arquivo);
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t<Precione [ENTER] para voltar>");
    system("pause > NULL");
    opcaoAluno(menuAluno());
}

void listarAluno(){
    system("cls");
    Aluno a;int i=1;
    system("title LISTA DE ALUNO");
    FILE *arquivo=fopen("aluno.dat","r+b");
    while(fread(&a,sizeof(Aluno),1,arquivo)==1){
        if(i%2!=0){if(i!=1){puts("\n\n\n\t                                 Tecle [ENTER] para exibir.");getch();system("cls");}}
        printf("\n\t**************************************************************************************");
        printf("\n\t                                 Aluno %d\n",i);
        printf("\n\t                                 Matrícula: %d",a.matriculaAluno);
        printf("\n\t                                 Nome: %s",a.nomeAluno);
        printf("\n\t                                 CPF: %s",a.cpfAluno);
        printf("\n\t                                 Curso: %s",a.cursoAluno);
        i++;
    }
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t      <Precione [ENTER] para voltar>");
    system("pause > NULL");
    system("cls");
    opcaoAluno(menuAluno());
}

void editarAluno(){
    system("cls");
    int posicao=0,achou=0,i,teste=0;char cpf[15];Aluno a;char op1;
    cabecalho();
    printf("\n\t**************************************************************************************");
    printf("\n\t                         Informe o CPF do Aluno: ");
    for(i=0;i<14;i++){
        if((i==3)||(i==7)||(i==11)){
            if(i==11){
                cpf[i]='-';
            }else{
                cpf[i]='.';
            }
            putchar(cpf[i]);
            i++;
        }
        cpf[i]=getch();
        putchar(cpf[i]);
    }
    cpf[i]='\0';
    fflush(stdin);
    system("cls");
    FILE *arquivo=fopen("aluno.dat","r+b");
    while(fread(&a,sizeof(Aluno),1,arquivo)==1){
        if(!strcmp(cpf,a.cpfAluno)){
            teste=1;
            printf("\n\t**************************************************************************************");
            printf("\n\t                                 Nome do Aluno: %s\n",a.nomeAluno);
            printf("\t                                 Deseja manter o mesmo? [s/n]");op1=getch();
            switch(op1){
                case 's':case 'S':break;
                case 'n':case 'N':{
                    printf("\n\t                                 Novo nome do Aluno: ");gets(a.nomeAluno);fflush(stdin);
                    strupr(a.nomeAluno);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&a,sizeof(Aluno),1,arquivo)==sizeof(Aluno);
                    break;
                }
            }
            printf("\n\t**************************************************************************************");
            printf("\n\t                                 Matrícula do Aluno: %d\n",a.matriculaAluno);
            printf("\t                                 Deseja manter o mesmo? [s/n]");op1=getch();fflush(stdin);
            switch(op1){
                case 's':case 'S':break;
                case 'n':case 'N':{
                    printf("\n\t                                 Nova Matrícula do Aluno: ");scanf("%d",&a.matriculaAluno);fflush(stdin);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&a,sizeof(Aluno),1,arquivo)==sizeof(Aluno);
                    break;
                }
            }
            printf("\n\t**************************************************************************************");
            printf("\n\t                                 CPF do Aluno: %s\n",a.cpfAluno);
            printf("\t                                 Deseja manter o mesmo? [s/n]");op1=getch();fflush(stdin);
            switch(op1){
                case 's':case 'S':break;
                case 'n':case 'N':{
                    int i;char aux1[15];
                    printf("\n\t                                 Novo CPF do Aluno: ");
                    for(i=0;i<14;i++){
                        if((i==3)||(i==7)||(i==11)){
                            if(i==11){
                                aux1[i]='-';
                            }else{
                                aux1[i]='.';
                            }
                            putchar(aux1[i]);
                            i++;
                        }
                        aux1[i]=getch();
                        putchar(aux1[i]);
                    }
                    aux1[i]='\0';
                    strcpy(a.cpfAluno,aux1);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&a,sizeof(Aluno),1,arquivo)==sizeof(Aluno);
                    break;
                }
            }
            printf("\n\t**************************************************************************************");
            printf("\n\t                                 Curso do Aluno: %s\n",a.cursoAluno);
            printf("\t                                 Deseja manter o mesmo? [s/n]");op1=getch();fflush(stdin);
            switch(op1){
                case 's':case 'S':break;
                case 'n':case 'N':{
                    printf("\n\t                                 Novo curso do Aluno: ");gets(a.cursoAluno);fflush(stdin);
                    strupr(a.cursoAluno);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&a,sizeof(Aluno),1,arquivo)==sizeof(Aluno);
                    break;
                }
            }
            posicao=posicao+sizeof(Aluno);
            fseek(arquivo,posicao,SEEK_SET);
        }
    }
    fclose(arquivo);
    if(teste==0){
        system("cls");
        cabecalho();
        printf("\n\t\t\t\t        Aluno não encontrado");
        printf("\n\t\t\t\t   <Precione [ENTER] para voltar>");
        system("pause > NULL");
        opcaoAluno(menuAluno());
    }
    printf("\n\n\n\t\t\t\t         <Precione [ENTER] para voltar>");
    system("pause > NULL");
    system("cls");
    opcaoAluno(menuAluno());
}

void removerAluno(){
    system("cls");
    Aluno a;int codigo,i;
    system("title REMOVER ALUNO");
    cabecalho();
    FILE *arquivo=fopen("aluno.dat","r+b");
    FILE *arquivo1=fopen("auxiliar.dat","a+b");
    printf("\n\t**************************************************************************************");
    printf("\n\t                         Informe a matrícula do Aluno: ");
    scanf("%d",&codigo);
    rewind(arquivo);
    while(fread(&a,sizeof(Aluno),1,arquivo)==1){
        if(codigo!=a.matriculaAluno){
            fwrite(&a,sizeof(Aluno),1,arquivo1);
        }
    }
    fclose(arquivo1);
    fclose(arquivo);
    system("del aluno.dat");
    system("ren auxiliar.dat aluno.dat");
    printf("\n\n\t**************************************************************************************");
    printf("\n\t                         Aluno excluido com sucesso");
    printf("\n\t                         Tecle [ENTER] para voltar ao menu");
    system("pause > NULL");
    system("cls");
    opcaoAluno(menuAluno());


}
