package netflixdeLivros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Logica {

	Scanner sc = new Scanner(System.in);
	EntradaSaidaDados eds = new EntradaSaidaDados();

	/***
	 * Menu principal
	 */
	public void menu() {

		int op = 5;
		while (op != 0) {
			
			while (true) {
				try {
					System.out.println("========    MENU GERAL    ========");
					System.out.println("=                                =");
					System.out.println("= 1 - GERENCIAMENTO LEITOR       =");
					System.out.println("=                                =");
					System.out.println("= 2 - GERENCIAMENTO LIVROS       =");
					System.out.println("=                                =");
					System.out.println("= 3 - SISTEMA NETFLIX LIVROS     =");
					System.out.println("=                                =");
					System.out.println("= 0 - SAIR                       =");
					System.out.println("=                                =");
					System.out.println("==================================");
					op = sc.nextInt();
					
					break;
				} catch (InputMismatchException e) {
					System.out.println("Formato inválido!");
					sc.next();
					continue;
				} catch (ArithmeticException e) {
					System.out.println("Formato inválido!");
					continue;
				}
			}
			

			if (op == 1) {
				while(true){
					int opcao;
					while (true) {
						try {
							System.out.println("========   MENU LEITOR    ========");
							System.out.println("=                                =");
							System.out.println("= 1 - CADASTRAR     2 - MOSTRAR  =");
							System.out.println("=                                =");
							System.out.println("= 3 - REMOVER       4 - EDITAR   =");
							System.out.println("=                                =");
							System.out.println("= 0 - SAIR                       =");
							System.out.println("=                                =");
							System.out.println("==================================");
							
							opcao = sc.nextInt();
							
							break;
						} catch (InputMismatchException e) {
							System.out.println("Formato inválido!");
							sc.next();
							continue;
						} catch (ArithmeticException e) {
							System.out.println("Formato inválido!");
							continue;
						}
					}
					
					if (opcao == 1) {
						eds.entradaDadosLeitor();

					} else if (opcao == 2) {
						eds.saidaDadosLeitor();
 
					} else if (opcao == 3) {
						eds.removeLeitor();

					} else if (opcao == 4) {
						eds.atualizaLeitor();

					} else if (opcao == 0){
						break;
					} else {
						System.out.println("OPCAO INVALIDA!!!");
					}
				}
				
			} else if (op == 2) {
				while(true){
					int opcao;
					
					while (true) {
						try {
							System.out.println("========   MENU LIVROS    ========");
							System.out.println("=                                =");
							System.out.println("= 1 - CADASTRAR     2 - MOSTRAR  =");
							System.out.println("=                                =");
							System.out.println("= 3 - REMOVER       4 - EDITAR   =");
							System.out.println("=                                =");
							System.out.println("= 0 - SAIR                       =");
							System.out.println("=                                =");
							System.out.println("==================================");
							opcao = sc.nextInt();
							
							break;
						} catch (InputMismatchException e) {
							System.out.println("Formato inválido!");
							sc.next();
							continue;
						} catch (ArithmeticException e) {
							System.out.println("Formato inválido!");
							continue;
						}
					}
					
					if (opcao == 1) {
						eds.entradaDadosLivro();
						
					} else if (opcao == 2) {
						eds.saidaDadosLivro();
						
					} else if (opcao == 3) {
						eds.removeLivro();
						
					} else if (opcao == 4) {
						eds.atualizaLivro();
					} else if (opcao == 0) {
						break;
					} else {
						System.out.println("OPCAO INVALIDA!!!");
					}
				}
			} else if (op == 3) {
				eds.fazerLoginLeitor();
			}
		}

		sc.close();
	}

}
