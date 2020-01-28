package netflixdeLivros;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UNIVERSIDADE ESTADUAL DA PARAIBA CURSO: CIENCIA DA COMPUTACAO PROJETO DE
 * LABORATORIO DE PROGRAMACAO II
 * 
 * NETFLIX DE LIVROS
 * 
 * @author Dijay, Joao e Pedro.
 */
public class EntradaSaidaDados {

	Pacote pacote;
	Scanner tc = new Scanner(System.in);
	ManutencaoLivros ml = new ManutencaoLivros();
	ManutencaoLeitor mleitor = new ManutencaoLeitor();
	GerenciandoArquivosLeitor arqleitores = new GerenciandoArquivosLeitor();
	ArrayList<Leitor> leitores = arqleitores.Lendo_Array();
	GerenciandoArquivosLivros arqlivros = new GerenciandoArquivosLivros();
	ArrayList<Livros> listBook = arqlivros.Lendo_Array();

	/***
	 * METODO ENTRADA DE DADOS LIVRO
	 * 
	 * Esse método cria recebe os dados para o cadastro de um livro.
	 * 
	 * Entrada de dados para o cadastro de um novo livro.
	 */
	public void entradaDadosLivro() {

		System.out.println("CADASTRO DE UM NOVO LIVRO");
		String titulo, editora, idioma, assunto, descricao, edicao, autor, ISBN;
		int qtdautor, ano;
		ArrayList<String> autores = new ArrayList<String>();
		ArrayList<String> comentario = new ArrayList<String>();
		ArrayList<String> justificativa = new ArrayList<String>();

		tc.nextLine();
		System.out.println("TITULO: ");
		titulo = tc.nextLine();
		System.out.println("EDITORA: ");
		editora = tc.nextLine();
		System.out.println("IDIOMA: ");
		idioma = tc.nextLine();
		System.out.println("ASSUNTO: ");
		assunto = tc.nextLine();
		System.out.println("DESCRICAO: ");
		descricao = tc.nextLine();
		System.out.println("EDICAO: ");
		edicao = tc.nextLine();

		while (true) {

			System.out.println("CODIGO DO LIVRO: ");
			ISBN = tc.nextLine();

			if (ml.seachBook(ISBN, listBook, 0)) {
				System.out
						.println("CODIGO JA EXISTE! \nDIGITE UM NOVO CODIGO!!");
				continue;
			} else {
				break;
			}

		}

		while (true) {

			try {

				System.out.println("ANO: ");
				ano = tc.nextInt();

				break;

			} catch (InputMismatchException e) {
				System.out.println("Formato inválido!");
				tc.next();
				continue;
			} catch (ArithmeticException e) {
				System.out.println("Formato inválido!");
				continue;
			}
		}

		while (true) {

			try {

				System.out.println("DIGITE O NUMERO DE AUTORES: ");
				qtdautor = tc.nextInt();

				break;

			} catch (InputMismatchException e) {
				System.out.println("Formato inválido!");
				tc.next();
				continue;
			} catch (ArithmeticException e) {
				System.out.println("Formato inválido!");
				continue;
			}
		}

		for (int i = 0; i < qtdautor; i++) {
			System.out.println("AUTOR: ");
			autor = tc.next();
			autores.add(autor);
		}
		Livros l = new Livros(autores, comentario, justificativa, titulo,
				editora, idioma, assunto, descricao, edicao, ISBN, ano);
		ml.create(l, listBook);

		arqlivros.Gravar_Array(listBook);
	}

	/***
	 * METODO SAIDA DADOS LIVRO
	 * 
	 * Lista os livros que estao cadastrados no sistema.
	 */
	public void saidaDadosLivro() {

		ml.read(listBook);

	}

	/***
	 * METODO REMOVE LIVRO
	 * 
	 * Recebe dados para remover um livro.
	 */
	public void removeLivro() {
		String cod;
		while (true) {
			System.out.println("CODIGO(ISBN) DO LIVRO A SER REMOVIDO: ");
			cod = tc.next();

			if (ml.seachBook(cod, listBook, 0)) {
				break;
			} else {
				System.out
						.println("LIVRO NÃO CADASTRADO! \nDIGITE UM NOVO CODIGO!!");
				continue;
			}
		}

		if (ml.delete(cod, listBook)) {
			System.out.println("LIVRO REMOVIDO COM SUCESSO!!!");
		} else {
			System.out.println("FALHA AO REMOVER.");
		}

		arqlivros.Gravar_Array(listBook);
	}

	/***
	 * METODO ATUALIZA LIVRO
	 * 
	 * Recebe dados para a atualizacao de um livro.
	 */
	public void atualizaLivro() {

		String cod;
		while (true) {
			tc.nextLine();
			System.out
					.println("DIGITE O CODIGO(ISBN) DO LIVRO QUE DESEJA ATUALIZAR: ");
			cod = tc.nextLine();

			if (ml.seachBook(cod, listBook, 0)) {
				break;
			} else {

				System.out
						.println("LIVRO NÃO CADASTRADO! \nDIGITE UM NOVO CODIGO!!");
				continue;
			}
		}

		int op = 0;
		while (op != 1 && op != 2 && op != 3 && op != 4 && op != 5 && op != 6
				&& op != 7 && op != 8) {

			while (true) {

				try {

					System.out.println("ESCOLHA QUAL CAMPO DESEJA ATUALIZAR: ");
					System.out
							.println("1 - TITULO\t\t2 - EDITORA\t\t3 - IDIOMA\t\t4 - ASSUNTO\n\n"
									+ "5 - DESCRICAO\t\t6 - EDICAO\t\t7 - CODIGO\t\t8 - ANO\n\n");
					op = tc.nextInt();

					break;

				} catch (InputMismatchException e) {
					System.out.println("Formato inválido!");
					tc.next();
					continue;
				} catch (ArithmeticException e) {
					System.out.println("Formato inválido!");
					continue;
				}
			}

		}

		if (op == 1) {
			System.out.println("DIGITE O NOVO TITULO DO LIVRO: ");
			tc.nextLine();
			String titulo = tc.nextLine();
			ml.updateLivroTitulo(cod, titulo, listBook);
			System.out.println("TITULO ALTERADO COM SUCESSO!!!");

		} else if (op == 2) {
			System.out.println("DIGITE A NOVA EDITORA DO LIVRO: ");
			tc.nextLine();
			String ed = tc.nextLine();
			ml.updateLivroEditora(cod, ed, listBook);
			System.out.println("EDITORA ALTERADA COM SUCESSO!!!");

		} else if (op == 3) {
			System.out.println("DIGITE O NOVO IDIOMA DO LIVRO: ");
			tc.nextLine();
			String id = tc.nextLine();
			ml.updateLivroIdioma(cod, id, listBook);
			System.out.println("IDIOMA ALTERADO COM SUCESSO!!!");

		} else if (op == 4) {
			System.out.println("DIGITE O NOVO ASSUNTO DO LIVRO: ");
			tc.nextLine();
			String as = tc.nextLine();
			ml.updateLivroAssunto(cod, as, listBook);
			System.out.println("ASSUNTO ALTERADO COM SUCESSO!!!");

		} else if (op == 5) {
			System.out.println("DIGITE A NOVA DESCRICAO DO LIVRO: ");
			tc.nextLine();
			String ds = tc.nextLine();
			ml.updateLivroDescricao(cod, ds, listBook);
			System.out.println("DESCRICAO ALTERADA COM SUCESSO!!!");

		} else if (op == 6) {
			System.out.println("DIGITE A NOVA EDICAO DO LIVRO: ");
			tc.nextLine();
			String edc = tc.nextLine();
			ml.updateLivroEdicao(cod, edc, listBook);
			System.out.println("EDICAO ALTERADA COM SUCESSO!!!");

		} else if (op == 7) {
			String isbn;
			while (true) {
				System.out.println("DIGITE O NOVO CODIGO(ISBN) DO LIVRO: ");
				tc.nextLine();
				isbn = tc.nextLine();

				if (ml.seachBook(cod, listBook, 0)) {
					break;
				} else {
					System.out
							.println("CODIGO JA EXISTE! \nDIGITE UM NOVO CODIGO!!");
					continue;
				}
			}
			ml.updateLivroCodigo(cod, isbn, listBook);
			System.out.println("CODIGO ALTERADO COM SUCESSO!!!");

		} else if (op == 8) {
			tc.nextLine();
			int ano;
			while (true) {
				try {
					System.out.println("DIGITE O NOVO ANO DO LIVRO: ");
					ano = tc.nextInt();

					break;

				} catch (InputMismatchException e) {
					System.out.println("Formato inválido!");
					tc.next();
					continue;
				} catch (ArithmeticException e) {
					System.out.println("Formato inválido!");
					continue;
				}
			}

			ml.updateLivroAno(cod, ano, listBook);
			System.out.println("ANO ALTERADO COM SUCESSO!!!");

		}

		arqlivros.Gravar_Array(listBook);

	}

	/***
	 * METODO PRINT LIVRO
	 * 
	 * Imprime os dados de um livro.
	 * 
	 * @param l
	 *            Livro que sera impressos seus dados.
	 * @param i
	 *            Inteiro para o controle da quantidade de livros.
	 */
	public static void printLivro(Livros l, int i) {

		System.out.println("DADOS DO LIVRO " + i);

		System.out.println("TITULO: " + l.getTitulo());
		System.out.println("EDITORA: " + l.getEditora());
		System.out.println("IDIOMA: " + l.getIdioma());
		System.out.println("ASSUNTO: " + l.getAssunto());
		System.out.println("DESCRICAO: " + l.getDescricao());
		System.out.println("EDICAO: " + l.getEdicao());
		System.out.println("CODIGO DO LIVRO: " + l.getISBN());
		System.out.println("ANO: " + l.getAno());
		System.out.println("AUTORES: ");
		for (int j = 0; j < l.autores.size(); j++) {
			System.out.println("       " + (j + 1) + "º " + l.autores.get(j));
		}
		System.out.println("\n-----------------------------------\n");
	}
	
	/***
	 * METODO ENTRADA DE DADOS LEITOR
	 * 
	 * Recebe os dados necessários para o cadastro de um novo leitor.
	 */
	public void entradaDadosLeitor() {

		Leitor l;
		System.out.println("CADASTRO DE UM NOVO LEITOR");
		String cpf, nome, datanascimento, email, senha;
		int pacote;
		Pacote basic = new PacoteBasic(0);
		Pacote core = new PacoteCore(0);
		Pacote premium = new PacotePremiun(0);
		System.out.println("NOME: ");
		nome = tc.nextLine();

		while (true) {

			System.out.println("CPF: ");
			cpf = tc.nextLine();

			if (mleitor.findLeitor(cpf, leitores)) {
				System.out
						.println("CODIGO JA EXISTE! \nDIGITE UM NOVO CODIGO!!");
				continue;
			} else {
				break;
			}

		}

		System.out.println("EMAIL: ");
		email = tc.nextLine();
		System.out.println("DATA DE NASCIMENTO(dd/mm/aaaa): ");
		datanascimento = tc.nextLine();
		System.out.println("DEFINA UMA SENHA PARA SEU PERFIL: ");
		senha = tc.nextLine();

		while (true) {

			while (true) {

				try {
					System.out
							.println("ESCOLHA QUAL TIPO DE PACOTE VOCE DESEJA ADQUIRIR:");
					System.out
							.println("\t1 - BASIC\n\t2 - CORE\n\t3 - PREMIUM\n");
					System.out.println("PACOTE: ");
					pacote = tc.nextInt();

					break;

				} catch (InputMismatchException e) {
					System.out.println("Formato inválido!");
					tc.next();
					continue;
				} catch (ArithmeticException e) {
					System.out.println("Formato inválido!");
					continue;
				}
			}

			if (pacote == 1) {
				l = new Leitor(basic, cpf, email, nome, datanascimento, senha);
				mleitor.create(l, leitores);
				break;
			} else if (pacote == 2) {
				l = new Leitor(core, cpf, email, nome, datanascimento, senha);
				mleitor.create(l, leitores);
				break;
			} else if (pacote == 3) {
				l = new Leitor(premium, cpf, email, nome, datanascimento, senha);
				mleitor.create(l, leitores);
				break;
			} else {
				System.out.println("OPCAO INVALIDA!!!!");
			}

		}

		arqleitores.Gravar_Array(leitores);
	}
	
	/***
	 * METODO SAIDA DADOS LEITOR
	 * 
	 * Exibe todos os dados que um leitor contem.
	 */
	public void saidaDadosLeitor() {

		mleitor.read(leitores);

	}

	/***
	 * METODO REMOVE LEITOR
	 * 
	 * Realiza a remocao de um leitor.
	 */
	public void removeLeitor() {
		String cpf;
		while (true) {

			System.out.println("CODIGO(CPF) DO LEITOR A SER REMOVIDO");
			cpf = tc.next();

			if (mleitor.findLeitor(cpf, leitores)) {
				break;
			} else {
				System.out
						.println("LEITOR NÃO CADASTRADO! \nDIGITE UM NOVO CPF!!");
				continue;
			}
		}

		if (mleitor.delete(cpf, leitores)) {
			System.out.println("LEITOR REMOVIDO COM SUCESSO!!!");
		} else {
			System.out.println("FALHA AO REMOVER.");
		}

		arqleitores.Gravar_Array(leitores);
	}

	/***
	 * METODO ATUALIZA LEITOR
	 * 
	 * Esse metodo possibilita a atualizacao dos dados de um determinado leitor.
	 */
	public void atualizaLeitor() {

		String cpf;

		while (true) {
			tc.nextLine();
			System.out
					.println("DIGITE O CODIGO(CPF) DO LEITOR QUE DESEJA ATUALIZAR: ");
			cpf = tc.next();

			if (mleitor.findLeitor(cpf, leitores)) {
				break;
			} else {

				System.out
						.println("LEITOR NÃO CADASTRADO! \nDIGITE UM NOVO CODIGO!!");
				continue;
			}
		}

		int op = 0;
		while (op != 1 && op != 2 && op != 3 && op != 4 && op != 5 && op != 6
				&& op != 7 && op != 8) {

			while (true) {

				try {

					System.out.println("ESCOLHA QUAL CAMPO DESEJA ATUALIZAR: ");
					System.out
							.println("1 - NOME\t\t2 - CPF\n\n3 - DATA DE NASCIMENTO\t\t4 - EMAIL\n\n");
					op = tc.nextInt();

					break;

				} catch (InputMismatchException e) {
					System.out.println("Formato inválido!");
					tc.next();
					continue;
				} catch (ArithmeticException e) {
					System.out.println("Formato inválido!");
					continue;
				}
			}

		}

		if (op == 1) {
			System.out.println("DIGITE O NOVO NOME DO LEITOR: ");
			tc.nextLine();
			String nome = tc.nextLine();
			mleitor.updateLeitorNome(cpf, nome, leitores);
			System.out.println("NOME ALTERADO COM SUCESSO!!!");

		} else if (op == 2) {
			String newcpf;
			while (true) {
				System.out.println("DIGITE O NOVO CPF DO LEITOR: ");
				tc.nextLine();
				newcpf = tc.nextLine();

				if (mleitor.findLeitor(newcpf, leitores)) {
					System.out
							.println("CODIGO JA EXISTE! \nDIGITE UM NOVO CODIGO!!");
					continue;
				} else {
					break;
				}
			}

			mleitor.updateLeitorCPF(cpf, newcpf, leitores);
			System.out.println("CPF ALTERADO COM SUCESSO!!!");

		} else if (op == 3) {
			System.out
					.println("DIGITE A NOVA DATA DE NASCIMENTO (dd/mm/aaaa) DO LEITOR: ");
			tc.nextLine();
			String dn = tc.nextLine();
			mleitor.updateLeitorDataNascimento(cpf, dn, leitores);
			System.out.println("DATA DE NASCIMENTO ALTERADA COM SUCESSO!!!");

		} else if (op == 4) {
			System.out.println("DIGITE O NOVO EMAIL DO LEITOR: ");
			tc.nextLine();
			String em = tc.nextLine();
			mleitor.updateLeitorEmail(cpf, em, leitores);
			System.out.println("EMAIL ALTERADO COM SUCESSO!!!");

		}

		arqleitores.Gravar_Array(leitores);
	}

	/***
	 * METODO PRINT LEITOR
	 * 
	 * Exibe todos os dados que um leitor contém, recebendo dois parametros um objeto leitor e um inteiro.
	 * 
	 * @param l 
	 * 			O parametro l consiste em um objeto do tipo leitor contendo os dados que serao impressos.
	 * @param i
	 * 			Esse inteiro i serve para controle no momento da impressão dos dados.
	 */
	public static void printLeitor(Leitor l, int i) {

		String pacot;

		System.out.println("DADOS DO LEITOR " + i);

		System.out.println("NOME: " + l.getNome());
		System.out.println("CPF: " + l.getCpf());
		System.out.println("EMAIL: " + l.getEmail());
		System.out.println("DATA DE NASCIMENTO: " + l.getDataNascimento());

		if (l.getPacote().getQuantidadeLivros() == 3)
			pacot = "BASIC";
		else if (l.getPacote().getQuantidadeLivros() == 5)
			pacot = "CORE";
		else
			pacot = "PREMIUM";

		System.out.println("PACOTE: " + pacot);
		System.out.println("\n-----------------------------------\n");
	}

	/***
	 * METODO PRINT LEITOR
	 * 
	 * Assim como no metodo print leitor esse consiste em uma sobrescrita que, 
	 * esse na verdade nao recebe um inteiro para controle de exibicao.
	 *
	 * @param l 
	 * 			Um leitor com os dados que serao impressos.
	 */
	public static void printLeitor(Leitor l) {

		String pacot;

		System.out.println("NOME: " + l.getNome());
		System.out.println("CPF: " + l.getCpf());
		System.out.println("EMAIL: " + l.getEmail());
		System.out.println("DATA DE NASCIMENTO: " + l.getDataNascimento());

		if (l.getPacote().getQuantidadeLivros() == 3)
			pacot = "BASIC";
		else if (l.getPacote().getQuantidadeLivros() == 5)
			pacot = "CORE";
		else
			pacot = "PREMIUM";

		System.out.println("PACOTE: " + pacot);
		System.out.println("\n-----------------------------------\n");
	}

	/***
	 * METODO ADDBOOK PREFERIDO LEITOR
	 * 
	 * Esse método adiciona um livro a lista de livros prefridos de um usuario.
	 * 
	 * @param l 
	 * 			Um leitor que consiste naquele a qual sera adicionado um livro.
	 */
	public void addBookPreferidoLeitor(Leitor l) {

		System.out.println("VERIFIQUE A LISTA DE LIVROS E INSIRA O "
				+ "CODIGO DO QUE VOCE DESEJA ADICIONAR A SUA LISTA:\n\n");
		tc.nextLine();

		ml.read(listBook);

		String ISBN;
		while (true) {

			System.out
					.println("DIGITE O CODIGO (ISBN) DO LIVRO QUE DESEJA ADICIONAR A LISTA DE PREFERIDOS: ");
			ISBN = tc.nextLine();

			if (ml.seachBook(ISBN, listBook, 0)) {
				break;
			} else {
				System.out
						.println("CODIGO INVALIDO! \nDIGITE UM NOVO CODIGO!!");
				continue;
			}

		}

		mleitor.addBookLeitor(ISBN, l, leitores, listBook);

		arqleitores.Gravar_Array(leitores);
	}

	/***
	 * METODO FAZER LOGIN LEITOR
	 * 
	 * Um metodo que permite que o usuario utilize o sistema Nrtflix.
	 */ 
	public void fazerLoginLeitor() {

		String cpf;
		while (true) {

			tc.nextLine();
			System.out.println("\n\nINSIRA O CPF DO LEITOR:");
			cpf = tc.nextLine();

			if (mleitor.findLeitor(cpf, leitores)) {
				break;
			} else {
				System.out
						.println("CODIGO INVALIDO! \nDIGITE UM NOVO CODIGO!!");
				continue;
			}
		}

		String senha;
		while (true) {
			System.out.println("DIGITE A SENHA DO USUARIO:");
			senha = tc.nextLine();
			if (mleitor.findLeitorSenha(senha, leitores, cpf)) {
				opcoesPerfilLeitor(cpf);
				break;
			} else {
				System.out.println("SENHA INCORRETA!!!");
			}
		}
	}

	/***
	 * METODO OPCOES PERFIL LEITOR
	 * 
	 * Metodo que faz um controle sobre todas as operacoes, no perfil de um usuario.
	 *  
	 * @param cpf
	 * 				CPF do cliente que seramanipulado.
	 */
	public void opcoesPerfilLeitor(String cpf) {

		int opcao;
		while (true) {

			while (true) {
				try {

					System.out
							.println("\n\n\n++++++++++NETFLIX DE LIVROS+++++++++");
					System.out
							.println("+++++++BEM VINDO AO SEU PERFIL++++++\n");
					EntradaSaidaDados.printLeitor(mleitor.findOneLeitor(cpf,
							leitores));
					System.out
							.println("========     MENU PERFIL      ========");
					System.out
							.println("=                                    =");
					System.out
							.println("= 1 - ADICIONAR LIVROS A LISTA       =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 2 - LER UM LIVRO                   =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 3 - ACESSO AO ACERVO               =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 4 - FINALIZAR LEITURA DE LIVRO     =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 5 - ABANDONAR LIVRO                =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 6 - LISTA DE LIVROS                =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 0 - SAIR                           =");
					System.out
							.println("======================================");

					opcao = tc.nextInt();

					break;

				} catch (InputMismatchException e) {
					System.out.println("Formato inválido!");
					tc.next();
					continue;
				} catch (ArithmeticException e) {
					System.out.println("Formato inválido!");
					continue;
				}
			}

			if (opcao == 1) {
				addBookPreferidoLeitor(mleitor.findOneLeitor(cpf, leitores));
			} else if (opcao == 2) {
				lerLivro(cpf);
			} else if (opcao == 3) {
				menuVisualizarLivros(cpf);
			} else if (opcao == 4) {
				if (mleitor.findOneLeitor(cpf, leitores).livrosLendo.size() > 0) {
					finalizarLeitura(cpf);
				} else {
					System.out.println("NAO HA LIVROS ABERTOS!");
				}

			} else if (opcao == 5) {
				if (mleitor.findOneLeitor(cpf, leitores).livrosLendo.size() > 0) {
					abandonarLivro(cpf);
				} else {
					System.out.println("NAO HA LIVROS ABERTOS!");
				}

			} else if (opcao == 6) {
				menuListaLivros(cpf);
			} else if (opcao == 0) {
				arqleitores.Gravar_Array(leitores);
				arqlivros.Gravar_Array(listBook);
				break;
			} else {
				System.out.println("OPCAO INVALIDA!!!");
			}
		}

	}

	/***
	 * MEETO MENU LISTA LIVROS
	 * 
	 * Permite a listagem de livros abertos, fechados e abandonados.
	 * 
	 * @param cpf
	 * 				CPF do cliente que seramanipulado.
	 */
	public void menuListaLivros(String cpf) {
		int opcao;

		while (true) {

			while (true) {
				try {

					System.out
							.println("========   LISTA DE LIVROS    ========");
					System.out
							.println("=                                    =");
					System.out
							.println("= 1 - LIVROS ABERTOS                 =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 2 - LIVROS FINALIZADOS             =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 3 - LIVROS ABANDONADOS             =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 0 - SAIR                           =");
					System.out
							.println("======================================");

					opcao = tc.nextInt();

					break;

				} catch (InputMismatchException e) {
					System.out.println("Formato inválido!");
					tc.next();
					continue;
				} catch (ArithmeticException e) {
					System.out.println("Formato inválido!");
					continue;
				}
			}
			if (opcao == 1) {
				listaLivrosLendo(cpf);
			} else if (opcao == 2) {
				listaLivrosFinalizados(cpf);
			} else if (opcao == 3) {
				listaLivrosAbandonados(cpf);
			} else if (opcao == 0) {
				break;
			} else {
				System.out.println("OPCAO INVALIDA!!!");
			}
		}
	}

	/***
	 * METODO MENU VISUALIZAR LIVROS
	 * 
	 * Menu que controla o acesso da visualizacao dos livros no acervo.
	 * 
	 * @param cpf
	 * 				CPF do cliente que seramanipulado.
	 */
	public void menuVisualizarLivros(String cpf) {
		int opcao;
		while (true) {

			while (true) {
				try {

					System.out
							.println("========   ACESSO AO ACERVO   ========");
					System.out
							.println("=                                    =");
					System.out
							.println("= 1 - VISUALIZAR TODOS               =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 2 - PESQUISAR                      =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 3 - VISUALIZAR MINHA LISTA         =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 0 - SAIR                           =");
					System.out
							.println("======================================");
					opcao = tc.nextInt();

					break;

				} catch (InputMismatchException e) {
					System.out.println("Formato inválido!");
					tc.next();
					continue;
				} catch (ArithmeticException e) {
					System.out.println("Formato inválido!");
					continue;
				}
			}

			if (opcao == 1) {
				printTodosLivros(listBook);
			} else if (opcao == 2) {
				menuPesquisar();
			} else if (opcao == 3) {
				for (Livros livro : mleitor.findOneLeitor(cpf, leitores).livros) {
					printLeitor(livro);
				}
			} else if (opcao == 0) {
				break;
			} else {
				System.out.println("OPCAO INVALIDA!!!");
			}
		}
	}

	/***
	 * METODO MENU PESQUISAR
	 * 
	 * Menu de Pesquisa de todos os livros.
	 * 
	 */
	public void menuPesquisar() {
		int opcao;
		while (true) {

			while (true) {
				try {

					System.out
							.println("========  PESQUISAR LIVROS    ========");
					System.out
							.println("=                                    =");
					System.out
							.println("= 1 - POR AUTOR                      =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 2 - POR TITULO                     =");
					System.out
							.println("=                                    =");
					System.out
							.println("= 0 - SAIR                           =");
					System.out
							.println("======================================");
					opcao = tc.nextInt();

					break;

				} catch (InputMismatchException e) {
					System.out.println("Formato inválido!");
					tc.next();
					continue;
				} catch (ArithmeticException e) {
					System.out.println("Formato inválido!");
					continue;
				}
			}

			if (opcao == 1) {
				pesquisarAutor();
			} else if (opcao == 2) {
				pesquisarTitulo();
			} else if (opcao == 0) {
				break;
			} else {
				System.out.println("OPCAO INVALIDA!!!");
			}
		}
	}

	/***
	 * METODO PESQUISAR AUTOR
	 * 
	 * Metodo que pesquisa autores através de uma espressao regular passada pelo usuario.
	 * 
	 */
	public void pesquisarAutor() {

		String autor;
		tc.nextLine();
		System.out.println("DIGITE O NOME DO AUTOR QUE DESEJA PESQUISAR: ");
		autor = tc.nextLine();

		String regex = autor.concat("+([A-Za-z]|\\s|$)");
		Pattern pattern = Pattern.compile(regex);

		for (Livros livro : listBook) {
			for (String aut : livro.autores) {
				Matcher matcher = pattern.matcher(aut);
				while (matcher.find()) {
					System.out.println(matcher.group());
					printLivrosLeitor(livro);
				}
			}
		}
	}

	/***
	 * METODO PESQUISAR TITULO
	 * 
	 * Metodo que pesquisa os titulos dos livros através de uma espressao regular passada pelo usuario.
	 * 
	 */
	public void pesquisarTitulo() {

		String titulo;
		tc.nextLine();
		System.out.println("DIGITE O TITULO DO LIVRO QUE DESEJA PESQUISAR: ");
		titulo = tc.nextLine();

		String regex = titulo.concat("+([A-Za-z]|\\s|$)");
		Pattern pattern = Pattern.compile(regex);

		for (Livros livro : listBook) {

			Matcher matcher = pattern.matcher(livro.getTitulo());
			while (matcher.find()) {
				System.out.println(matcher.group());
				printLivrosLeitor(livro);
			}

		}
	}

	/***
	 * METODO LER LIVRO
	 * 
	 * Metodo que permite ao usuario ler um livro em seu perfil.
	 * 
	 * @param cpf
	 * 				CPF do cliente que seramanipulado.
	 */
	public void lerLivro(String cpf) {

		Leitor leitor = mleitor.findOneLeitor(cpf, leitores);

		if (leitor.livrosLendo.size() < leitor.getPacote()
				.getQuantidadeLivros()) {

			System.out.println("LIVROS DISPONIVEIS: ");

			ml.read(leitor.getLivros());

			String cod;

			while (true) {

				System.out.println("DIGITE O CODIGO (ISBN) DO LIVRO: ");
				cod = tc.next();

				if (ml.seachBook(cod,
						mleitor.findOneLeitor(cpf, leitores).livros, 0)) {
					if (!(ml.seachBook(cod,
							mleitor.findOneLeitor(cpf, leitores).livrosLendo, 0))) {
						break;
					}
					System.out.println("LIVRO ABERTO!!!");
				} else {
					System.out
							.println("CODIGO INVALIDO, LIVRO NAO ESTA EM SUA LISTA"
									+ "! \nDIGITE UM NOVO CODIGO!!");
					continue;
				}

			}

			leitor.livrosLendo.add(ml.seachBook(cod, leitor.livros));

			leitor.setQtdLivrosLios(mleitor.findOneLeitor(cpf, leitores)
					.getQtdLivrosLios() + 1);

		} else {
			System.out
					.println("NUMERO DE LIVROS POSSIVEIS  PARA LEITURA DESTE PACOTE EXCEDEU!!");
		}

		arqleitores.Gravar_Array(leitores);

	}
	
	/***
	 * METODO PRINT LIVROS LEITOR
	 * 
	 * Metodo que exibe os livros com comentario e justificativas de todos os leitores do sistema.
	 * 
	 * @param l
	 * 			Livro para que os dados sejam listados.
	 */
	public void printLivrosLeitor(Livros l) {

		System.out.println("\nDADOS DO LIVRO ");

		System.out.println("TITULO: " + l.getTitulo());
		System.out.println("EDITORA: " + l.getEditora());
		System.out.println("IDIOMA: " + l.getIdioma());
		System.out.println("ASSUNTO: " + l.getAssunto());
		System.out.println("DESCRICAO: " + l.getDescricao());
		System.out.println("EDICAO: " + l.getEdicao());
		System.out.println("CODIGO DO LIVRO: " + l.getISBN());
		System.out.println("ANO: " + l.getAno());
		System.out.println("AUTORES: ");
		for (int j = 0; j < l.autores.size(); j++) {
			System.out.println("       " + (j + 1) + "º " + l.autores.get(j));
		}
		System.out.println("\n-----------------------------------\n");

		System.out.println("COMENTARIOS: ");
		for (Leitor leitor : leitores) {
			for (Livros livro : leitor.livros) {
				if (livro.getISBN().equals(l.getISBN())) {
					for (String just : livro.justificativa) {
						System.out.println(leitor.getNome() + ": " + just
								+ "\n");
					}

				}
			}
		}

		System.out.println("\n-----------------------------------\n");

	}

	/***
	 * METODO PRINT LEITOR
	 * 
	 * Metodo que mostra os dados de um livro, e ainda apenas com comentarios e justificativa
	 * .
	 * @param l
	 * 			Livro com seus dados para serem impressos.
	 */
	public void printLeitor(Livros l) {
		System.out.println("\nDADOS DO LIVRO ");

		System.out.println("TITULO: " + l.getTitulo());
		System.out.println("EDITORA: " + l.getEditora());
		System.out.println("IDIOMA: " + l.getIdioma());
		System.out.println("ASSUNTO: " + l.getAssunto());
		System.out.println("DESCRICAO: " + l.getDescricao());
		System.out.println("EDICAO: " + l.getEdicao());
		System.out.println("CODIGO DO LIVRO: " + l.getISBN());
		System.out.println("ANO: " + l.getAno());
		System.out.println("AUTORES: ");
		for (int j = 0; j < l.autores.size(); j++) {
			System.out.println("       " + (j + 1) + "º " + l.autores.get(j));
		}
		System.out.println("\n-----------------------------------\n");

		System.out.println("COMENTARIOS: ");
		for (String just : l.justificativa) {
			System.out.println(just + "\n");
		}

		System.out.println("\n-----------------------------------\n");

	}

	/***
	 * METODO FINALIZA LEITURA
	 * 
	 * Consiste em um método que simplesmente finaliza a leitura retira o livro do array lendoe adiciona em lidos.
	 * 
	 * @param cpf
	 * 				CPF do cliente que seramanipulado.
	 */
	public void finalizarLeitura(String cpf) {

		Leitor leitor = mleitor.findOneLeitor(cpf, leitores);

		String cod, comentario;
		tc.nextLine();

		while (true) {

			System.out
					.println("DIGITE O CODIGO (ISBN) DO LIVRO QUE DESEJA FINALIZAR: ");
			cod = tc.nextLine();

			if (ml.seachBook(cod, listBook, 0)) {
				break;
			} else {
				System.out
						.println("CODIGO INVALIDO! \nDIGITE UM NOVO CODIGO!!");
				continue;
			}

		}

		Livros livro = ml.seachBook(cod, listBook);

		// tc.nextLine();
		System.out.println("FACA UM COMENTARIO SOBRE O LIVRO: ");
		comentario = tc.nextLine();

		livro.justificativa.add(comentario);

		leitor.setQtdLivrosLios(leitor.getQtdLivrosLios() - 1);
		leitor.livrosLidos.add(livro);
		ml.delete(cod, leitor.livrosLendo);

		if (leitor.livrosLendo.remove(livro))
			System.out.println("LIVRO REMOVIDO SUCESSO!");
		

		arqleitores.Gravar_Array(leitores);

	}

	/***
	 * METODO ABANDONAR LIVRO
	 * 
	 * Esse metodo simplesmente abandona um livro retirando o livro do array lendo e colocando no array abandonados.
	 * 
	 * @param cpf
	 * 				CPF do cliente que seramanipulado.
	 */
	public void abandonarLivro(String cpf) {

		Leitor leitor = mleitor.findOneLeitor(cpf, leitores);
		int opcao;

		while (true) {
			try {

				System.out
						.println("TEM CERTEZA QUE DESEJA ABANDONAR O LIVRO??");
				System.out.println("1 - SIM \n2 - NAO\nOPCAO: ");
				opcao = tc.nextInt();

				break;

			} catch (InputMismatchException e) {
				System.out.println("Formato inválido!");
				tc.next();
				continue;
			} catch (ArithmeticException e) {
				System.out.println("Formato inválido!");
				continue;
			}
		}

		if (opcao == 1) {

			String cod, justificativa;
			tc.nextLine();

			while (true) {

				System.out
						.println("DIGITE O CODIGO (ISBN) DO LIVRO QUE DESEJA ABANDONAR: ");
				cod = tc.next();

				if (ml.seachBook(cod,
						mleitor.findOneLeitor(cpf, leitores).livrosLendo, 0)) {
					break;
				} else {
					System.out
							.println("CODIGO INVALIDO LIVRO NAO ESTA ABERTO! \nDIGITE UM NOVO CODIGO!!");
					continue;
				}

			}

			Livros livro = ml.seachBook(cod, leitor.livrosLendo);
			tc.nextLine();

			System.out.println("ESCREVA UM COMENTARIO SOBRE O LIVRO: ");
			justificativa = tc.nextLine();

			livro.justificativa.add(justificativa);

			leitor.livrosLendo.remove(livro);
			leitor.livrosAbandonados.add(livro);
			leitor.setQtdLivrosLios(leitor.getQtdLivrosLios() - 1);
			if (leitor.livrosLendo.remove(livro))
				System.out.println("LIVRO REMOVIDO SUCESSO!");

		} else {
			System.out.println("LIVRO NAO FOI ABANDONADO!");
		}

		arqleitores.Gravar_Array(leitores);

	}
	
	/***
	 * METODO PRINT TODOS LIVROS
	 * 
	 * Esse método imprime todos os os livros passados pelo Array.
	 * 
	 * @param livros
	 * 					Array de livros para serem impressos.
	 */
	public void printTodosLivros(ArrayList<Livros> livros) {
		for (Livros livro : livros) {
			printLivrosLeitor(livro);
		}
	}

	/***
	 * METODO LISTA LIVROS LENDO
	 * 
	 * Lista aqueles livros que estao sendo lidos naquele momento.
	 * 
	 * @param cpf 
	 * 				CPF do cliente que seramanipulado.
	 */
	public void listaLivrosLendo(String cpf) {
		Leitor leitor = mleitor.findOneLeitor(cpf, leitores);

		ml.read(leitor.livrosLendo);
	}

	/***
	 * METODO LISTA LIVROS FINALIZADOS
	 * 
	 * Lista aqueles livros que ja foram finalizado naquele momento.
	 * 
	 * @param cpf
	 * 				CPF do cliente que seramanipulado.
	 * 				
	 */
	public void listaLivrosFinalizados(String cpf) {
		Leitor leitor = mleitor.findOneLeitor(cpf, leitores);

		ml.read(leitor.livrosLidos);
	}

	/***
	 * METODO LISTA LIVROS ABANDONADOS
	 * 
	 * Lista aqueles livros que ja foram abandonados naquele momento.
	 * @param cpf
	 * 				CPF do cliente que seramanipulado.
	 */
	public void listaLivrosAbandonados(String cpf) {
		Leitor leitor = mleitor.findOneLeitor(cpf, leitores);

		ml.read(leitor.livrosAbandonados);
	}

}