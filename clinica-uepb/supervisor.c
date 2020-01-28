#include "bibliotecas.h"

int menuSupervisor(){
    char op;
    system("cls");
    SetConsoleTitle("MENU DO SUPERVISOR");
    cabecalho();
    printf("                                             SUPERVISOR\n");
    printf("                                    <Tecle a opcao desejada>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t************************  <1> Cadastrar Supervisor. **********************************");
    printf("\n\t************************  <2> Editar Supervisor.  ************************************");
    printf("\n\t************************  <3> Remover Supervisor. ************************************");
    printf("\n\t************************  <4> Listar Supervisores Cadastrados.  **********************");
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
            opcaoSupervisor(menuSupervisor());
        }
    }
}

void opcaoSupervisor(int op){
    switch(op){
        case 1:{cadastroSupervisor();break;}
        case 2:{editarSupervisor();break;}
        case 3:{removerSupervisor();break;}
        case 4:{listarSupervisor();break;}
    }
}

void cadastroSupervisor(){
    Supervisor s;int i;char nome[30];
    FILE *arquivo=fopen("supervisor.dat","a+b");
    system("title CADASTRO DE SUPERVISOR");
    system("cls");
    cabecalho();
    printf("                                        Cadastro do Supervisor\n");
    printf("                                    <Preencha com os dados corretos>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t\t\t<1> Informe o nome do Supervisor: ");gets(nome);fflush(stdin);
    while(fread(&s,sizeof(Supervisor),1,arquivo)==1){
        if(!strcmp(nome,s.nomeSupervisor)){
            system("cls");
            cabecalho();
            printf("\n\t\t\t\tO Supervisor %s já está cadastrado.",s.nomeSupervisor);
            printf("\n\t\t\t\t<Precione [ENTER] para voltar>");
            system("pause > NULL");
            fclose(arquivo);
            opcaoSupervisor(menuSupervisor());
        }
    }
    strcpy(s.nomeSupervisor,nome);
    printf("\n\t\t\t<2> Informe o curso do Supervisor: ");gets(s.cursoSupervisor);fflush(stdin);
    int test=1,cod;
    while(test==1){
        test=0;
        cod=gerandoCodigo();
        while(fread(&s,sizeof(Supervisor),1,arquivo)==1){
            if(s.codigoSupervisor==cod){
                test=1;
            }
        }
    }
    s.codigoSupervisor=cod;
    printf("\n\t\t\t<3> Seu código é %d: ",s.codigoSupervisor);
    strupr(s.cursoSupervisor);strupr(s.nomeSupervisor);
    fwrite(&s,sizeof(Supervisor),1,arquivo);
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t<Precione [ENTER] para voltar>");
    system("pause > NULL");
    opcaoSupervisor(menuSupervisor());
}

void listarSupervisor(){
    system("cls");
    Supervisor s;int i=1;
    system("title LISTA DE SUPERVISOR");
    FILE *arquivo=fopen("supervisor.dat","r+b");
    while(fread(&s,sizeof(Supervisor),1,arquivo)==1){
        if(i%2!=0){if(i!=1){puts("\n\n\n\t                                 Tecle [ENTER] para exibir.");getch();system("cls");}}
        printf("\n\t**************************************************************************************");
        printf("\n\t                                 Supervisor %d\n",i);
        printf("\n\t                                 Código: %d",s.codigoSupervisor);
        printf("\n\t                                 Nome: %s",s.nomeSupervisor);
        printf("\n\t                                 Curso: %s",s.cursoSupervisor);
        i++;
    }
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t      <Precione [ENTER] para voltar>");
    system("pause > NULL");
    system("cls");
    opcaoSupervisor(menuSupervisor());
}

void editarSupervisor(){
    system("cls");
    int posicao=0,achou=0,i,codigo;;Supervisor s;char op1;
    cabecalho();
    printf("\n\t**************************************************************************************");
    printf("\n\t                         Informe o Código do Supervisor: ");
    scanf("%d",&codigo);
    system("cls");
    FILE *arquivo=fopen("supervisor.dat","r+b");
    while(fread(&s,sizeof(Supervisor),1,arquivo)==1){
        if(codigo==s.codigoSupervisor){
            printf("\n\t**************************************************************************************");
            printf("\n\t                                 Nome do Supervisor: %s\n",s.nomeSupervisor);
            printf("\t                                 Deseja manter o mesmo? [s/n]");op1=getch();
            switch(op1){
                case 's':case 'S':break;
                case 'n':case 'N':{
                    printf("\n\t                                 Novo nome do Supervisor: ");gets(s.nomeSupervisor);fflush(stdin);
                    strupr(s.nomeSupervisor);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&s,sizeof(Supervisor),1,arquivo)==sizeof(Supervisor);
                    break;
                }
            }
            printf("\n\t**************************************************************************************");
            printf("\n\t                                 Curso do Supervisor: %s\n",s.cursoSupervisor);
            printf("\t                                 Deseja manter o mesmo? [s/n]");op1=getch();fflush(stdin);
            switch(op1){
                case 's':case 'S':break;
                case 'n':case 'N':{
                    printf("\n\t                                 Novo curso do Supervisor: ");gets(s.cursoSupervisor);fflush(stdin);
                    strupr(s.cursoSupervisor);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&s,sizeof(Supervisor),1,arquivo)==sizeof(Supervisor);
                    break;
                }
            }
            posicao=posicao+sizeof(Supervisor);
            fseek(arquivo,posicao,SEEK_SET);
        }
    }
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t         <Precione [ENTER] para voltar>");
    system("pause > NULL");
    system("cls");
    opcaoSupervisor(menuSupervisor());
}

void removerSupervisor(){
    system("cls");
    Supervisor s;int codigo,i;
    system("title REMOVER SUPERVISOR");
    cabecalho();
    FILE *arquivo=fopen("supervisor.dat","r+b");
    FILE *arquivo1=fopen("auxiliar.dat","a+b");
    printf("\n\t**************************************************************************************");
    printf("\n\t                         Informe o código do Supervisor: ");
    scanf("%d",&codigo);
    rewind(arquivo);
    while(fread(&s,sizeof(Supervisor),1,arquivo)==1){
        if(codigo!=s.codigoSupervisor){
            fwrite(&s,sizeof(Supervisor),1,arquivo1);
        }
    }
    fclose(arquivo1);
    fclose(arquivo);
    system("del supervisor.dat");
    system("ren auxiliar.dat supervisor.dat");
    printf("\n\n\t**************************************************************************************");
    printf("\n\t                         Supervisor excluido com sucesso");
    printf("\n\t                         Tecle [ENTER] para voltar ao menu");
    system("pause > NULL");
    system("cls");
    opcaoSupervisor(menuSupervisor());
}
