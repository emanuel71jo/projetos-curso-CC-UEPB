#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

typedef struct{
    char rua[30],bairro[30],cidade[30],estado[30];
    int cep;
}ENDERECO;
typedef struct{
    ENDERECO endereco;
    char nome[30],estadoCivil[15],sexo[15];
    float salario;
    int idade,telefone,cpf,identidade;
}CADASTRO;
void preencherEstrutura(CADASTRO *cadastro){
    system("cls");
    printf("\tCADASTRO");
    printf("\n<1> Informe seu nome: ");gets(cadastro->nome);fflush(stdin);
    printf("\n<2> Informe sua identidade: ");scanf("%d",&cadastro->identidade);fflush(stdin);
    printf("\n<3> Informe seu salario: ");scanf("%f",&cadastro->salario);fflush(stdin);
    printf("\n<4> Informe seu CPF: ");scanf("%d",&cadastro->cpf);fflush(stdin);
    printf("\n<5> Informe seu estado civil: ");gets(cadastro->estadoCivil);fflush(stdin);
    printf("\n<6> Informe seu telefone: ");scanf("%d",&cadastro->telefone);fflush(stdin);
    printf("\n<7> Informe sua idade: ");scanf("%d",&cadastro->idade);fflush(stdin);
    printf("\n<8> Informe seu sexo: ");gets(cadastro->sexo);fflush(stdin);
    printf("\n<9> Informe o nome de sua rua: ");gets(cadastro->endereco.rua);fflush(stdin);
    printf("\n<10> Informe seu bairro: ");gets(cadastro->endereco.bairro);fflush(stdin);
    printf("\n<11> Informe sua cidade: ");gets(cadastro->endereco.cidade);fflush(stdin);
    printf("\n<12> Informe seu Estado: ");gets(cadastro->endereco.estado);fflush(stdin);
    printf("\n<13> Informe seu CEP: ");scanf("%d",&cadastro->endereco.cep);
}
void imprimirEstrutura(CADASTRO cadastro){
    system("cls");
    printf("\IMPRIMIR");
    printf("\n<1> NOME: %s",cadastro.nome);
    printf("\n<2> IDENTIDADE: %d",cadastro.identidade);
    printf("\n<3> SALARIO: %f",cadastro.salario);
    printf("\n<4> CPF: %d",cadastro.cpf);
    printf("\n<5> ESTADO CIVIL: %s",cadastro.estadoCivil);
    printf("\n<6> TELEFONE: %d",cadastro.telefone);
    printf("\n<7> IDADE: %d",cadastro.idade);
    printf("\n<8> SEXO: %s",cadastro.sexo);
    printf("\n<9> RUA: %s",cadastro.endereco.rua);
    printf("\n<10> BAIRRO: %s",cadastro.endereco.bairro);
    printf("\n<11> CIDADE: %s",cadastro.endereco.cidade);
    printf("\n<12> ESTADO: %s",cadastro.endereco.estado);
    printf("\n<13> CEP: %d",cadastro.endereco.cep);
    printf("\nTecle [ENTER] para voltar");
    system("pause > NULL");
}
void main(){
    CADASTRO cadastro;
    in:
    system("cls");
    printf("\tMENU");
    printf("\n<1> Cadastrar.");
    printf("\n<2> Imprimir.");
    printf("\n<3> Encerrar.");
    switch(getch()){
        case '1':{preencherEstrutura(&cadastro);goto in;break;}
        case '2':{imprimirEstrutura(cadastro);goto in;break;}
        case '3':{exit (0);}
        default:goto in;
    }
}