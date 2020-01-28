#include <stdio.h>
#include <stdlib.h>

//Aluno: João Emanuel 2016.2
//Email: emanuel71jo@gmail.com

int qtdUm(char* string);
int main(){
    char *codigo[20];
    printf("Digite o codigo binario:");
    scanf("%s",codigo);
    printf("Total %d",qtdUm(codigo));
    return 0;
}
int qtdUm(char* string){
    int i,cont=0;
    for(i=0;string[i]!='\0';i++){
        if(string[i]=='1'){
            cont++;
        }
    }
    return cont;
}
