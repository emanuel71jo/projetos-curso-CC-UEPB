
package laboratorio01;

import java.util.Scanner;

public class Caderneta {
    Scanner teclado = new Scanner(System.in);
    public void verificar(Aluno aluno){
        System.out.println("Nota 1:");
        aluno.setNota1(teclado.nextDouble());
        System.out.println("Nota 2:");
        aluno.setNota2(teclado.nextDouble());
        System.out.println("Frequencia:");
        aluno.setFrequencia(teclado.nextInt());
        
        if(aluno.getFrequencia()<75){
            System.out.println("ALUNO REPROVADO POR FREQUENCIA");
        }else if((aluno.getNota1()+aluno.getNota2())/2 < 3){
            System.out.println("ALUNO REPROVADO POR MEDIA");
        }else if((aluno.getNota1() + aluno.getNota2())/2 >= 7){
            System.out.println("ALUNO APROVADO POR MEDIA");
        }else{
            System.out.println("Aluno na final.");
            System.out.println("Nota final:");
            aluno.setNotafinal(teclado.nextDouble());
            if((aluno.getNota1()+aluno.getNota2()+aluno.getNotafinal())/3 < 5){
                System.out.println("ALUNO REPROVADO NA FINAL");
            }else{
                System.out.println("ALUNO APROVADO NA FINAL");
            }
        }
    }
}
