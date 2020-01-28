#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    char n[30];
    int i;
    while(scanf("%s",n)!=EOF){
        for(i=0;i<strlen(n);i++){
            switch(n[i]){
                case 'A':
                case 'B':
                case 'C':
                    printf("2");
                    break;
                case 'D':
                case 'E':
                case 'F':{
                    printf("3");
                    break;
                }
                case 'G':
                case 'H':
                case 'I':{
                    printf("4");
                    break;
                }
                case 'J':
                case 'K':
                case 'L':{
                    printf("5");
                    break;
                }
                case 'M':
                case 'N':
                case 'O':{
                    printf("6");
                    break;
                }
                case 'P':
                case 'Q':
                case 'R':
                case 'S':{
                    printf("7");
                    break;
                }
                case 'T':
                case 'U':
                case 'V':{
                    printf("8");
                    break;
                }
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':{
                    printf("9");
                    break;
                }
                case '1':{
                    printf("1");
                    break;
                }
                case '0':{
                    printf("0");
                    break;
                }
                default:{
                    printf("-");
                }
            }
        }
        printf("\n");
    }

    return 0;
}
