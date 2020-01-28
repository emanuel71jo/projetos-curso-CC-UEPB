#include <stdio.h>
#include <string.h>

// Aluno: João Emanuel da Silva Lins
// Emanil: emanuel71jo@gmail.com

void preencherAluno(char nomes[][15]){
    int i;
    char nome[15];
    printf(">>>> ALUNOS\n\n");
    for(i=0;i<4;i++){
        printf("INSIRA O NOME DO ALUNO %d ",i+1);
        gets(nome);
        strupr(nome);
        strcpy(nomes[i],nome);
        fflush(stdin);
        putchar('\n');
    }
    putchar('\n');
}
void preencherNotas(float notas[][3],char nomes[][15]){
    int i,j;
    printf(">>>> NOTAS\n\n");
    for(i=0;i<4;i++){
        for(j=0;j<3;j++){
            printf("INSIRA A NOTA %d DE %s ",j+1,nomes[i]);
            scanf("%f",&notas[i][j]);
            putchar('\n');
        }
        putchar('\n');
    }
    putchar('\n');
}
void mostrar(char nomes[][15],float notas[][3]){
    int i,j;
    float media;
    printf("ALUNO\t\tMEDIA\tSITUACAO\n");
    for(i=0;i<4;i++){
        media=0;
        for(j=0;j<3;j++){
            media+=notas[i][j];
        }
        media/=3;
        printf("%s\t\t%.2f\t%s\n",nomes[i],media,media<7?"REPROVADO":"APROVADO");
    }
    putchar('\n');
}

main(){
    char alunos[4][15];
    float notas[4][3];
    preencherAluno(alunos);
    preencherNotas(notas,alunos);
    mostrar(alunos,notas);
}