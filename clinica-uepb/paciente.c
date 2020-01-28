#include "bibliotecas.h"

int menuPaciente(){
    char op;
    system("cls");
    SetConsoleTitle("MENU DO PACIENTE");
    cabecalho();
    printf("                                             PACIENTE\n");
    printf("                                    <Tecle a opcao desejada>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    printf("\n\t************************  <1> Cadastrar Paciente. ************************************");
    printf("\n\t************************  <2> Editar Paciente.  **************************************");
    printf("\n\t************************  <3> Remover Paciente. **************************************");
    printf("\n\t************************  <4> Listar Paciente Cadastrados  ***************************");
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
            opcaoPaciente(menuPaciente());
        }
    }
}

void opcaoPaciente(int op){
    switch(op){
        case 1:{cadastroPaciente();break;}
        case 2:{editarPaciente();break;}
        case 3:{removerPaciente();break;}
        case 4:{listarPaciente();break;}
    }
}

void cadastroPaciente(){
    Paciente p;int i;char nome[30];
    FILE *arquivo=fopen("paciente.dat","a+b");
    system("title CADASTRO DE PACIENTE");
    system("cls");
    cabecalho();
    printf("                                        Cadastro do Paciente\n");
    printf("                                    <Preencha com os dados corretos>\n");
    printf("\n\t**************************************************************************************");
    printf("\n\t**************************************************************************************");
    fflush(stdin);
    printf("\n\t\t\t<1> Informe o nome do paciente: ");gets(nome);fflush(stdin);
    while(fread(&p,sizeof(Paciente),1,arquivo)==1){
        if(!strcmp(nome,p.nomePaciente)){
            system("cls");
            cabecalho();
            printf("\n\t\t\t\tO Paciente %s já está cadastrado.",p.nomePaciente);
            printf("\n\t\t\t\t<Precione [ENTER] para voltar>");
            system("pause > NULL");
            fclose(arquivo);
            opcaoPaciente(menuPaciente());
        }
    }
    strcpy(p.nomePaciente,nome);
    printf("\n\t\t\t<2> Informe o CPF do paciente: ");
    for(i=0;i<14;i++){
        if((i==3)||(i==7)||(i==11)){
            if(i==11){
                p.cpfPaciente[i]='-';
            }else{
                p.cpfPaciente[i]='.';
            }
            putchar(p.cpfPaciente[i]);
            i++;
        }
        p.cpfPaciente[i]=getch();
        putchar(p.cpfPaciente[i]);
    }
    p.cpfPaciente[i]='\0';
    getch();
    putchar('\n');
    printf("\n\t\t\t<3> Informe o endereço do paciente: ");gets(p.enderecoPaciente);fflush(stdin);
    printf("\n\t\t\t<4> Informe a data de nascimento: ");
    for(i=0;i<10;i++){
		if((i==2)||(i==5)){
            p.nascimentoPaciente[i]='/';
            putchar(p.nascimentoPaciente[i]);
            i++;
		}
		p.nascimentoPaciente[i]=getch();
		putchar(p.nascimentoPaciente[i]);
	}
	p.nascimentoPaciente[i]='\0';
	getch();
	int test=1,cod;
    while(test==1){
        test=0;
        cod=gerandoCodigo();
        while(fread(&p,sizeof(Paciente),1,arquivo)==1){
            if(p.codigoPaciente==cod){
                test=1;
            }
        }
    }
    p.codigoPaciente=cod;
    printf("\n\n\t\t\t<5> Seu código é: %d ",p.codigoPaciente);
    strupr(p.enderecoPaciente);strupr(p.nomePaciente);
    fwrite(&p,sizeof(Paciente),1,arquivo);
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t<Precione [ENTER] para voltar>");
    system("pause > NULL");
    opcaoPaciente(menuPaciente());
}

void listarPaciente(){
    system("cls");
    Paciente p;int i=1;
    system("title LISTA DE PACIENTE");
    FILE *arquivo=fopen("paciente.dat","r+b");
    while(fread(&p,sizeof(Paciente),1,arquivo)==1){
        if(i%2!=0){if(i!=1){puts("\n\n\n\t                                 Tecle [ENTER] para exibir.");getch();system("cls");}}
        printf("\n\t**************************************************************************************");
        printf("\n\t                                 Paciente %d\n",i);
        printf("\n\t                                 Código: %d",p.codigoPaciente);
        printf("\n\t                                 Nome: %s",p.nomePaciente);
        printf("\n\t                                 CPF: %s",p.cpfPaciente);
        printf("\n\t                                 Endereço: %s",p.enderecoPaciente);
        printf("\n\t                                 Nascimento: %s",p.nascimentoPaciente);
        i++;
    }
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t      <Precione [ENTER] para voltar>");
    system("pause > NULL");
    system("cls");
    opcaoPaciente(menuPaciente());
}

void editarPaciente(){
    system("cls");
    int posicao=0,achou=0,i;char cpf[15];Paciente p;char op1;
    cabecalho();
    printf("\n\t**************************************************************************************");
    printf("\n\t                         Informe o CPF do paciente: ");
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
    fflush(stdin);
    system("cls");
    FILE *arquivo=fopen("paciente.dat","r+b");
    while(fread(&p,sizeof(Paciente),1,arquivo)==1){
        if(!strcmp(cpf,p.cpfPaciente)){
            printf("\n\t**************************************************************************************");
            printf("\n\t                                 Nome do Paciente: %s\n",p.nomePaciente);
            printf("\t                                 Deseja manter o mesmo? [s/n]");op1=getch();
            switch(op1){
                case 's':case 'S':break;
                case 'n':case 'N':{
                    printf("\n\t                                 Novo nome do Paciente: ");gets(p.nomePaciente);fflush(stdin);
                    strupr(p.nomePaciente);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&p,sizeof(Paciente),1,arquivo)==sizeof(Paciente);
                    break;
                }
            }
            printf("\n\t**************************************************************************************");
            printf("\n\t                                 Data de Nascimento do Paciente: %s\n",p.nascimentoPaciente);
            printf("\t                                 Deseja manter o mesmo? [s/n]");op1=getch();fflush(stdin);
            switch(op1){
                case 's':case 'S':break;
                case 'n':case 'N':{
                    int i;char aux[11];
                    printf("\n\t                                 Nova data de Nascimento do Paciente: ");
                    for(i=0;i<10;i++){
                        if((i==2)||(i==5)){
                            aux[i]='/';
                            putchar(aux[i]);
                            i++;
                        }
                        aux[i]=getch();
                        putchar(aux[i]);
                    }
                    aux[i]='\0';
                    strcpy(p.nascimentoPaciente,aux);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&p,sizeof(Paciente),1,arquivo)==sizeof(Paciente);
                    break;
                }
            }
            printf("\n\t**************************************************************************************");
            printf("\n\t                                 CPF do Paciente: %s\n",p.cpfPaciente);
            printf("\t                                 Deseja manter o mesmo? [s/n]");op1=getch();fflush(stdin);
            switch(op1){
                case 's':case 'S':break;
                case 'n':case 'N':{
                    int i;char aux1[15];
                    printf("\n\t                                 Novo CPF do Paciente: ");
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
                    strcpy(p.cpfPaciente,aux1);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&p,sizeof(Paciente),1,arquivo)==sizeof(Paciente);
                    break;
                }
            }
            printf("\n\t**************************************************************************************");
            printf("\n\t                                 Endereço do Paciente: %s\n",p.enderecoPaciente);
            printf("\t                                 Deseja manter o mesmo? [s/n]");op1=getch();fflush(stdin);
            switch(op1){
                case 's':case 'S':break;
                case 'n':case 'N':{
                    printf("\n\t                                 Novo endereço do Paciente: ");gets(p.enderecoPaciente);fflush(stdin);
                    strupr(p.enderecoPaciente);
                    fseek(arquivo,posicao,SEEK_SET);
                    achou=fwrite(&p,sizeof(Paciente),1,arquivo)==sizeof(Paciente);
                    break;
                }
            }
            posicao=posicao+sizeof(Paciente);
            fseek(arquivo,posicao,SEEK_SET);
        }
    }
    fclose(arquivo);
    printf("\n\n\n\t\t\t\t         <Precione [ENTER] para voltar>");
    system("pause > NULL");
    system("cls");
    opcaoPaciente(menuPaciente());
}

void removerPaciente(){
    system("cls");
    Paciente  p;int codigo,i;
    system("title REMOVER PACIENTE");
    cabecalho();
    FILE *arquivo=fopen("paciente.dat","r+b");
    FILE *arquivo1=fopen("auxiliar.dat","a+b");
    printf("\n\t**************************************************************************************");
    printf("\n\t                         Informe o Código o paciente: ");
    scanf("%d",&codigo);
    rewind(arquivo);
    while(fread(&p,sizeof(Paciente),1,arquivo)==1){
        if(codigo!=p.codigoPaciente){
            fwrite(&p,sizeof(Paciente),1,arquivo1);
        }
    }
    fclose(arquivo1);
    fclose(arquivo);
    system("del paciente.dat");
    system("ren auxiliar.dat paciente.dat");
    printf("\n\n\t**************************************************************************************");
    printf("\n\t                         Paciente excluido com sucesso");
    printf("\n\t                         Tecle [ENTER] para voltar ao menu");
    system("pause > NULL");
    system("cls");
    opcaoPaciente(menuPaciente());


}
