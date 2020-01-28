#include "bibliotecas.h"

int menuAgendamento(){
    char op;
    system("cls");
    SetConsoleTitle("MENU DO AGENDAMENTO");
    cabecalho();
    printf("                                             AGENDAMENTO\n");
    printf("                                    <Tecle a opcao desejada>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t************************  <1> Fazer Agendamento. *************************************");
    printf("\n\t************************  <2> Cancelar Agendamento.  *********************************");
    printf("\n\t************************  <3> Listar Agendamento. ************************************");
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
            opcaoAgendamento(menuAgendamento());
        }
    }
}

void opcaoAgendamento(int op){
    switch(op){
        case 1:{fazerAgendamento();break;}
        case 2:{cancelarAgendamento();break;}
        case 3:{listarAgendamento();break;}
    }
}

void fazerAgendamento(){
    Agendamento a;int i,j,teste=0;Paciente p;char nome[30],data[9];
    FILE *arquivo=fopen("agendamento.dat","a+b");
    system("title FAZER AGENDAMENTO");
    system("cls");
    cabecalho();
    printf("                                        Fazer Agendamento\n");
    printf("                                    <Preencha com os dados corretos>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t\t\t<1> Informe o nome do Paciente: ");gets(nome);fflush(stdin);strupr(nome);
    while(fread(&a,sizeof(Agendamento),1,arquivo)==1){
        if(!strcmp(nome,a.nomePacienteAgendado)){
            system("cls");
            cabecalho();
            printf("\n\t\t\t\tO Paciente %s já tem um agendamento.",a.nomePacienteAgendado);
            printf("\n\t\t\t\t<Precione [ENTER] para voltar>");
            system("pause > NULL");
            fclose(arquivo);
            opcaoAgendamento(menuAgendamento());
        }
    }
    FILE *arq=fopen("paciente.dat","rb");
    rewind(arq);
    while(fread(&p,sizeof(Paciente),1,arq)==1){
        if(!strcmp(p.nomePaciente,nome)){
            teste=1;
            a.codigoPacienteAgen=p.cpfPaciente;
            strcpy(a.nomePacienteAgendado,p.nomePaciente);
            fclose(arq);
        }
    }
    if(teste==0){
        printf("\n\n\t\t\t\tPACIENTE NÃO ENCONTRADO");
        printf("\n\n\t\t\t\t<Precione [ENTER] para voltar>");
        system("pause > NULL");
        fclose(arq);fclose(arquivo);
        opcaoAgendamento(menuAgendamento());
    }

    printf("\n\t\t\t<2> Informe a area do Atendimento: ");
    printf("\n\t\t\t\t<1> Cirurgia");
    printf("\n\t\t\t\t<2> Oftalmologia");
    printf("\n\t\t\t\t<3> Neurologia");
    printf("\n\t\t\t\t<4> Pediatria");
    printf("\n\t\t\t\t<5> Anestesiologia");
    printf("\n\t\t\t\t<6> Cardiologia");
    int op=getch();
    switch(op){
        case '1':{
            strcpy(a.areaAgendamento,"CIRURGIA");
            a.op1=1;
            break;
            }
        case '2':{
            strcpy(a.areaAgendamento,"OFTALMOLOGIA");
            a.op2=1;
            break;
            }
        case '3':{
            strcpy(a.areaAgendamento,"NEUROLOGIA");
            a.op3;
            break;
            }
        case '4':{
            strcpy(a.areaAgendamento,"PEDIATRIA");
            a.op4;
            break;
            }
        case '5':{
            strcpy(a.areaAgendamento,"ANESTESIOLOGIA");
            a.op5;
            break;
            }
        case '6':{
            strcpy(a.areaAgendamento,"CARDIOLOGIA");
            a.op6;
            break;
            }
        default:{
            system("cls");
            cabecalho();
            printf("\n\n                                        Opcao Invalida\n");
            printf("                                    <Tecle [ENTER] para voltar>\n");
            fclose(arquivo);
            opcaoAgendamento(menuAgendamento());

        }
    }
    printf("\n\t\t\t<3> Informe a data da Consulta: ");
    for(i=0;i<10;i++){
		if((i==2)||(i==5)){
            a.dataConsulta[i]='/';
            putchar(a.dataConsulta[i]);
            i++;
		}
		a.dataConsulta[i]=getch();
		putchar(a.dataConsulta[i]);
	}
	a.dataConsulta[i]='\0';
	fflush(stdin);
	getch();fflush(stdin);
	int tes=1,cod;
    while(tes==1){
        tes=0;
        cod=gerandoCodigo();
        while(fread(&a,sizeof(Agendamento),1,arquivo)==1){
            if(a.codigoAgendamento==cod){
                tes=1;
            }
        }
    }
    a.codigoAgendamento=cod;
    printf("\n\t\t\t<4> O codigo do agendamento é: %d\n",a.codigoAgendamento);
	strupr(a.areaAgendamento);strupr(a.nomePacienteAgendado);
    fwrite(&a,sizeof(Agendamento),1,arquivo);
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t<Precione [ENTER] para voltar>");
    system("pause > NULL");
    opcaoAgendamento(menuAgendamento());
}

void cancelarAgendamento(){
    system("cls");
    Agendamento a;int codigo,i;
    system("title CANCELAR AGENDAMENTO");
    cabecalho();
    FILE *arquivo=fopen("agendamento.dat","r+b");
    FILE *arquivo1=fopen("auxiliar.dat","a+b");
    printf("\n\t**************************************************************************************");
    printf("\n\t                         Informe o código do Agendamento: ");
    scanf("%d",&codigo);
    rewind(arquivo);
    while(fread(&a,sizeof(Agendamento),1,arquivo)==1){
        if(codigo!=a.codigoAgendamento){
            fwrite(&a,sizeof(Agendamento),1,arquivo1);
        }
    }
    fclose(arquivo1);
    fclose(arquivo);
    system("del agendamento.dat");
    system("ren auxiliar.dat agendamento.dat");
    printf("\n\n\t**************************************************************************************");
    printf("\n\t                         Agendamento cancelado com sucesso");
    printf("\n\t                         Tecle [ENTER] para voltar ao menu");
    system("pause > NULL");
    system("cls");
    opcaoAgendamento(menuAgendamento());
}

void listarAgendamento(){
    system("cls");
    Agendamento a;int i=1;
    system("title LISTA DE AGENDAMENTOS");
    FILE *arquivo=fopen("agendamento.dat","r+b");
    while(fread(&a,sizeof(Agendamento),1,arquivo)==1){
        if(i%2!=0){if(i!=1){puts("\n\n\n\t                                 Tecle [ENTER] para exibir.");getch();system("cls");}}
        printf("\n\t**************************************************************************************");
        printf("\n\t                                 Agendamento %d\n",i);
        printf("\n\t                                 Código: %d",a.codigoAgendamento);
        printf("\n\t                                 Nome: %s",a.nomePacienteAgendado);
        printf("\n\t                                 Área: %s",a.areaAgendamento);
        printf("\n\t                                 Consulta: %s",a.dataConsulta);
        i++;
    }
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t      <Precione [ENTER] para voltar>");
    system("pause > NULL");
    system("cls");
    opcaoAgendamento(menuAgendamento());
}
