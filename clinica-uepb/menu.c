#include "bibliotecas.h"

void cabecalho(){
	printf("\n\t**************************************************************************************");
	printf("\n\t************************ UNIVERSIDADE ESTADUAL DA PARAIBA ****************************");
	printf("\n\t**************************** CIENCIA DA COMPUTACAO ***********************************");
	printf("\n\t************************** JOAO EMANUEL DA SILVA LINS ********************************");
	printf("\n\t***************************** %s %s ***********************************",__DATE__,__TIME__);
	printf("\n\t********************************* Versao 1.0 *****************************************");
	printf("\n\t**************************************************************************************");
	printf("\n\n");
}
int opcaoMenu(){
    system("cls");
    char op;
    SetConsoleTitle("MENU INICIAL");
    cabecalho();
    printf("                                               MENU\n");
    printf("                                    <Tecle a opcao desejada>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t*******  <1> Paciente.   *****************************  <4> Agendamento.  ************");
    printf("\n\t*******  <2> Aluno.      *****************************  <5> Atendimento.  ************");
    printf("\n\t*******  <3> Supervisor. *****************************  <6> Encerrar Programa  *******");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************\n");
    op=getch();
    fflush(stdin);
    switch(op){
        case '1':return 1;
        case '2':return 2;
        case '3':return 3;
        case '4':return 4;
        case '5':return 5;
        case '6':{
            system("cls");
            int i;
            system("title ENCERRANDO");
            puts("\n\n\tAGUARDE O PROGRAMA ESTÁ SENDO ENCERRADO\n\t");
            for(i=0;i<60;i++){
                Sleep(150);
                printf("|");
            }
            system("cls");
            exit(0);
        }
        default:{
            system("cls");
            cabecalho();
            printf("\n\t\t\t\t       Opcao Invalida");
            printf("\n\t\t\t\t<Precione [ENTER] para continuar>");
            system("pause > NULL");
            system("cls");
            opcoes(opcaoMenu());
        }
    }
}
void opcoes(int op){
    switch(op){
        case 1:{
            opcaoPaciente(menuPaciente());
            break;
        }
        case 2:{
            opcaoAluno(menuAluno());
            break;
        }
        case 3:{
            opcaoSupervisor(menuSupervisor());
            break;
        }
        case 4:{
            opcaoAgendamento(menuAgendamento());
            break;
        }
        case 5:{
            opcaoAtendimento(menuAtendimento());
            break;
        }
    }
}
int gerandoCodigo(){
    srand((unsigned)time(NULL));
    return rand();
}
