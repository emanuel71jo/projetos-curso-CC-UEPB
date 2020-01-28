#include "bibliotecas.h"

int menuAtendimento(){
    char op;
    system("cls");
    SetConsoleTitle("MENU DO ATENDIMENTO");
    cabecalho();
    printf("                                             ATENDIMENTO\n");
    printf("                                    <Tecle a opcao desejada>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t************************  <1> Criar Atendimento. *************************************");
    printf("\n\t************************  <2> Cancelar Atendimento.  *********************************");
    printf("\n\t************************  <3> Listar Atendimento. ************************************");
    printf("\n\t************************  <4> Voltar.  ***********************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************\n");
    op=getch();
    switch(op){
        case '1':return 1;
        case '2':return 2;
        case '3':return 3;
        case '4':opcoes(opcaoMenu());
        default:{
            system("cls");
            fflush(stdin);
            cabecalho();
            printf("\n\t\t\t\t       Opcao Invalida");
            printf("\n\t\t\t\t<Precione [ENTER] para continuar>");
            system("pause > NULL");
            system("cls");
            opcaoAtendimento(menuAtendimento());
        }
    }
}

void opcaoAtendimento(int op){
    switch(op){
        case 1:{criarAtendimento();break;}
        case 2:{cancelarAtendimento();break;}
        case 3:{opcaoListarAtendimento(menuListarAtendimento());break;}
    }
}

void criarAtendimento(){
    Atendimento a;Agendamento b;Paciente c;Aluno d;Supervisor e;
    int i,teste=0;
    FILE *arquivo=fopen("atendimento.dat","a+b");
    system("title CRIAR ATENDIMENTO");
    system("cls");
    cabecalho();
    printf("                                        Criar Atendimento\n");
    printf("                                    <Preencha com os dados corretos>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t\t\t<1> Informe o código do agendamento: ");scanf("%d",&a.codigiAgen);fflush(stdin);
    FILE *arq=fopen("agendamento.dat","rb");rewind(arq);
    while(fread(&b,sizeof(Agendamento),1,arq)==1){
        if(a.codigiAgen==b.codigoAgendamento){
            teste=1;
            strcpy(a.dataAgendado,b.dataConsulta);
            strcpy(a.nomePaci,b.nomePacienteAgendado);
            strcpy(a.areaAten,b.areaAgendamento);
            strcpy(a.dataAtendi,__DATE__);
            fclose(arq);
        }
    }
    if(teste==0){
        printf("\n\n\t\t\t\tAtendimento não pode ser feito se não estiver agendado.");
        printf("\n\n\t\t\t\t<Precione [ENTER] para voltar>");
        system("pause > NULL");
        fclose(arq);fclose(arquivo);
        opcaoAtendimento(menuAtendimento());
    }
    teste=0;
    while(teste!=1){
        printf("\n\t\t\t<2> Informe a matrícula do Aluno: ");scanf("%d",&a.matriculaAl);fflush(stdin);
        FILE *arq=fopen("aluno.dat","rb");rewind(arq);
        while(fread(&d,sizeof(Aluno),1,arq)==1){
            if(a.matriculaAl==d.matriculaAluno){
                strcpy(a.nomeAlu,d.nomeAluno);
                fclose(arq);
                teste=1;
            }
        }
        if(teste!=1){
            printf("\n\t\t\t\tALUNO NÃO ENCONTRADO");
            printf("\n\t\t\t\t<Precione [ENTER] para tentar novamente>");
            system("pause > NULL");
            system("cls");
            cabecalho();
            printf("                                        Criar Atendimento\n");
            printf("                                    <Preencha com os dados corretos>\n");
            printf("\n\t**************************************************************************************");
            printf("\n\t**************************************************************************************");
            printf("\n\t\t\t<1> Informe o código do agendamento: %d",a.codigiAgen);
        }
    }
    teste=0;
    while(teste!=1){
        printf("\n\t\t\t<3> Informe o código do Supervisor: ");scanf("%d",&a.codigoSuper);fflush(stdin);
        FILE *arq=fopen("supervisor.dat","rb");rewind(arq);
        while(fread(&e,sizeof(Supervisor),1,arq)==1){
            if(a.codigoSuper==e.codigoSupervisor){
                strcpy(a.nomeSuper,e.nomeSupervisor);
                fclose(arq);
                teste=1;
            }
        }
        if(teste!=1){
            printf("\n\t\t\t\SUPERVISOR NÃO ENCONTRADO");
            printf("\n\t\t\t\t<Precione [ENTER] para tentar novamente>");
            system("pause > NULL");
            system("cls");
            cabecalho();
            printf("                                        Criar Atendimento\n");
            printf("                                    <Preencha com os dados corretos>\n");
            printf("\n\t**************************************************************************************");
            printf("\n\t**************************************************************************************");
            printf("\n\t\t\t<1> Informe o código do agendamento: %d",a.codigiAgen);
            printf("\n\t\t\t<2> Informe a matrícula do aluno: %d",a.matriculaAl);
        }
    }
    int test=1,cod;
    while(test==1){
        test=0;
        cod=gerandoCodigo();
        while(fread(&a,sizeof(Atendimento),1,arquivo)==1){
            if(a.codigoAtendimento==cod){
                test=1;
            }
        }
    }
    a.codigoAtendimento=cod;
    printf("\n\t\t\t<4> Seu código de Atendimento é: %d",a.codigoAtendimento);
    strupr(a.areaAten);strupr(a.nomeAlu);strupr(a.nomePaci);strupr(a.nomeSuper);
    fwrite(&a,sizeof(Atendimento),1,arquivo);
    fclose(arquivo);
    FILE *arquivo1=fopen("agendamento.dat","r+b");rewind(arquivo1);
    FILE *arquivo2=fopen("auxiliar.dat","w+b");
    while(fread(&b,sizeof(Agendamento),1,arquivo1)==1){
        if(strcmp(a.nomePaci,b.nomePacienteAgendado)){
            fwrite(&b,sizeof(Agendamento),1,arquivo2);
        }
    }
    fclose(arquivo1);fclose(arquivo2);
    system("del agendamento.dat");
    system("ren auxiliar.dat agendamento.dat");
    printf("\n\n\n\t\t\t\t<Precione [ENTER] para voltar>");
    system("pause > NULL");
    opcaoAtendimento(menuAtendimento());
}

void cancelarAtendimento(){
    system("cls");
    Atendimento a;int codigo,i,aux;Agendamento b;
    system("title CANCELAR ATENDIMENTO");
    cabecalho();
    FILE *arquivo=fopen("atendimento.dat","r+b");
    FILE *arq=fopen("agendamento.dat","r+b");
    FILE *arquivo1=fopen("auxiliar.dat","a+b");
    FILE *arq1=fopen("auxiliar1.dat","a+b");
    printf("\n\t**************************************************************************************");
    printf("\n\t                         Informe o código do Atendimentoo: ");
    scanf("%d",&codigo);
    rewind(arquivo);
    while(fread(&a,sizeof(Atendimento),1,arquivo)==1){
        if(codigo!=a.codigoAtendimento){
            aux=a.codigiAgen;
            fwrite(&a,sizeof(Atendimento),1,arquivo1);
        }
    }
    while(fread(&b,sizeof(Agendamento),1,arq)==1){
        if(aux!=b.codigoAgendamento){
            fwrite(&b,sizeof(Agendamento),1,arq1);
        }
    }
    fclose(arq);
    fclose(arq1);
    fclose(arquivo1);
    fclose(arquivo);
    system("del atendimento.dat");
    system("del agendamento.dat");
    system("ren auxiliar.dat atendimento.dat");
    system("ren auxiliar1.dat agendamento.dat");
    printf("\n\n\t**************************************************************************************");
    printf("\n\t                         Atendimento cancelado com sucesso");
    printf("\n\t                         Tecle [ENTER] para voltar ao menu");
    system("pause > NULL");
    system("cls");
    opcaoAgendamento(menuAgendamento());
}

int menuListarAtendimento(){
    char op;
    system("cls");
    SetConsoleTitle("MENU DE LISTAR PACIENTE");
    cabecalho();
    printf("                                         LISTAR PACIENTE\n");
    printf("                                    <Tecle a opcao desejada>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t************************  <1> Listar todos Atendimentos. *****************************");
    printf("\n\t************************  <2> Listar por area especifica.  ***************************");
    printf("\n\t************************  <3> Listar por aluno especifico. ***************************");
    printf("\n\t************************  <4> Listar por paciente especifico.  ***********************");
    printf("\n\t************************  <5> Voltar. ************************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************\n");
    op=getch();
    switch(op){
        case '1':return 1;
        case '2':return 2;
        case '3':return 3;
        case '4':return 4;
        case '5':opcaoAtendimento(menuAtendimento());
        default:{
            system("cls");
            fflush(stdin);
            cabecalho();
            printf("\n\t\t\t\t       Opcao Invalida");
            printf("\n\t\t\t\t<Precione [ENTER] para continuar>");
            system("pause > NULL");
            system("cls");
            opcaoListarAtendimento(menuListarAtendimento());
        }
    }
}

void opcaoListarAtendimento(int op){
    switch(op){
        case 1:{listarTodosAtendimentos();break;}
        case 2:{listarAreaAtendimento();break;}
        case 3:{listarAlunoAtendimento();break;}
        case 4:{listarPacienteAtendimento();break;}
    }
}

void listarTodosAtendimentos(){
    system("cls");
    Atendimento a;int i=1;
    system("title LISTAR TODOS ATENDIMENTOS");
    FILE *arquivo=fopen("atendimento.dat","r+b");
    while(fread(&a,sizeof(Atendimento),1,arquivo)==1){
        if(i%2!=0){if(i!=1){puts("\n\n\n\t                                 Tecle [ENTER] para exibir.");getch();system("cls");}}
        printf("\n\t**************************************************************************************");
        printf("\n\t                                   ATENDIMENTO %d\n",i);
        printf("\n\t                                 Codigo Atendimento %d",a.codigoAtendimento);
        printf("\n\t                                 Código Agendamento: %d",a.codigiAgen);
        printf("\n\t                                 Data do Agendamento: %s",a.dataAgendado);
        printf("\n\t                                 Nome do Aluno: %s",a.nomeAlu);
        printf("\n\t                                 Nome do Paciente: %s",a.nomePaci);
        printf("\n\t                                 Data do Atendimento: %s",a.dataAtendi);
        printf("\n\t                                 Nome do Supervisor: %s",a.nomeSuper);
        i++;
    }
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t      <Precione [ENTER] para voltar>");
    system("pause > NULL");
    system("cls");
    opcaoListarAtendimento(menuListarAtendimento());
}

void listarAreaAtendimento(){
    system("cls");
    Atendimento a;int i=1;char area[30],op;
    system("title LISTAR AREA ATENDIMENTOS");
    cabecalho();
    printf("\n\t                                 Informe a Area");
    printf("\n\t\t\t\t<1> Cirurgia");
    printf("\n\t\t\t\t<2> Oftalmologia");
    printf("\n\t\t\t\t<3> Neurologia");
    printf("\n\t\t\t\t<4> Pediatria");
    printf("\n\t\t\t\t<5> Anestesiologia");
    printf("\n\t\t\t\t<6> Cardiologia");
    op=getch();fflush(stdin);strupr(area);
    switch(op){
        case '1':{
            strcpy(area,"CIRURGIA");
            break;
        }
        case '2':{
            strcpy(area,"OFTALMOLOGIA");
            break;
        }
        case '3':{
            strcpy(area,"NEUROLOGIA");
            break;
        }
        case '4':{
            strcpy(area,"PEDIATRIA");
            break;
        }
        case '5':{
            strcpy(area,"ANESTESIOLOGIA");
            break;
        }
        case '6':{
            strcpy(area,"CARDIOLOGIA");
            break;
        }default:{
            system("cls");
            cabecalho();
            printf("\n\t\t\t\tOPCAO INVALIDA");
            printf("\n\t\t\t\t<Tecle [ENTER] para voltar>");
            system("pause > NULL");
            listarAreaAtendimento();
        }

    }
    system("cls");
    FILE *arquivo=fopen("atendimento.dat","r+b");
    while(fread(&a,sizeof(Atendimento),1,arquivo)==1){
        if(!strcmp(area,a.areaAten)){
            if(i%2!=0){if(i!=1){puts("\n\n\n\t                                 Tecle [ENTER] para exibir.");getch();system("cls");}}
            printf("\n\t**************************************************************************************");
            printf("\n\t                                   ATENDIMENTO %d\n",i);
            printf("\n\t                                 Codigo Atendimento %d",a.codigoAtendimento);
            printf("\n\t                                 Código Agendamento: %d",a.codigiAgen);
            printf("\n\t                                 Data do Agendamento: %s",a.dataAgendado);
            printf("\n\t                                 Nome do Aluno: %s",a.nomeAlu);
            printf("\n\t                                 Nome do Paciente: %s",a.nomePaci);
            printf("\n\t                                 Data do Atendimento: %s",a.dataAtendi);
            printf("\n\t                                 Nome do Supervisor: %s",a.nomeSuper);
            i++;
        }
    }
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t      <Precione [ENTER] para voltar>");
    system("pause > NULL");
    system("cls");
    opcaoListarAtendimento(menuListarAtendimento());
}

void listarAlunoAtendimento(){
    system("cls");
    Atendimento a;int i=1,j,k;char aluno[30];
    system("title LISTAR ALUNO ATENDIMENTOS");
    cabecalho();
    printf("\n\t                                 Informe o nome do Aluno:");
    gets(aluno);fflush(stdin);strupr(aluno);system("cls");cabecalho();
    FILE *arquivo=fopen("atendimento.dat","r+b");
    while(fread(&a,sizeof(Atendimento),1,arquivo)==1){
        if(strstr(a.nomeAlu,aluno)==NULL){
            if(i%2!=0){if(i!=1){puts("\n\n\n\t                                 Tecle [ENTER] para exibir.");getch();system("cls");}}
            printf("\n\t**************************************************************************************");
            printf("\n\t                                   ATENDIMENTO %d\n",i);
            printf("\n\t                                 Codigo Atendimento %d",a.codigoAtendimento);
            printf("\n\t                                 Código Agendamento: %d",a.codigiAgen);
            printf("\n\t                                 Data do Agendamento: %s",a.dataAgendado);
            printf("\n\t                                 Nome do Aluno: %s",a.nomeAlu);
            printf("\n\t                                 Nome do Paciente: %s",a.nomePaci);
            printf("\n\t                                 Data do Atendimento: %s",a.dataAtendi);
            printf("\n\t                                 Nome do Supervisor: %s",a.nomeSuper);
            i++;
        }
    }
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t      <Precione [ENTER] para voltar>");
    system("pause > NULL");
    system("cls");
    opcaoListarAtendimento(menuListarAtendimento());
}

void listarPacienteAtendimento(){
    system("cls");
    Atendimento a;int i=1;char paciente[30];
    system("title LISTAR PACIENTE ATENDIMENTOS");
    cabecalho();
    printf("\n\t                                 Informe o nome do Paciente:");
    gets(paciente);fflush(stdin);
    FILE *arquivo=fopen("atendimento.dat","r+b");
    while(fread(&a,sizeof(Atendimento),1,arquivo)==1){
        if(strstr(a.nomePaci,paciente)==NULL){
            if(i%2!=0){if(i!=1){puts("\n\n\n\t                                 Tecle [ENTER] para exibir.");getch();system("cls");}}
            printf("\n\t**************************************************************************************");
            printf("\n\t                                   ATENDIMENTO %d\n",i);
            printf("\n\t                                 Codigo Atendimento %d",a.codigoAtendimento);
            printf("\n\t                                 Código Agendamento: %d",a.codigiAgen);
            printf("\n\t                                 Data do Agendamento: %s",a.dataAgendado);
            printf("\n\t                                 Nome do Aluno: %s",a.nomeAlu);
            printf("\n\t                                 Nome do Paciente: %s",a.nomePaci);
            printf("\n\t                                 Data do Atendimento: %s",a.dataAtendi);
            printf("\n\t                                 Nome do Supervisor: %s",a.nomeSuper);
            i++;
        }
    }
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t      <Precione [ENTER] para voltar>");
    system("pause > NULL");
    system("cls");
    opcaoListarAtendimento(menuListarAtendimento());
}
