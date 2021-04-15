package lab07;

import java.util.Scanner;
import java.util.ArrayList;

public class MeuSistemaSimplesDeTributacao {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Contribuinte> contribuintes = new ArrayList<Contribuinte>();
		int op;

		do {
			op = menu();

			switch (op) {

			case 1:
				limpaTela();
				contribuintes.add(cadastraContribuinte());
				break;

			case 2:
				limpaTela();
				mostraImpostoContribuinte(contribuintes);
				break;

			case 3:
				limpaTela();
				listaContribuintes(contribuintes);
				break;

			case 4:
				System.out.println("FIM DO PROGRAMA");
				break;

			default:
				limpaTela();
				System.out.println("      Op��o inv�lida!");
				break;
			}

		} while (op != 4);

	}

	public static void limpaTela() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}

	public static void mostraImpostoContribuinte(ArrayList<Contribuinte> contribuintes) {
		int num, i;
		double valor = 0.0;
		boolean achou = false;

		System.out.print("Digite o n�mero do contribuinte: ");
		num = sc.nextInt();

		for (i = 0; i < contribuintes.size(); i++) {
			if (num == contribuintes.get(i).getNumero()) {
				achou = true;
				valor = contribuintes.get(i).calculaImposto();
				if (valor < 0)
					valor = 0;
				break;
			}
		}

		if (achou)
			System.out.println("\n --- RESUMO ---\n\nNome: " + contribuintes.get(i).getNome()
					+ "\nValor a ser pago em impostos: R$" + valor);

		else
			System.out.println("Contribuinte n�o encontrado!");

	}

	public static Contribuinte cadastraContribuinte() {
		Contribuinte contribuinte = null;
		int op, numero, numPassageiros, atendimentos;
		String nome;
		Casa casa = null;
		Carro carro = null;
		double valor, despesas, kmRodados;

		System.out.print("\n1. Taxista\n" + "2. Caminhoneiro(a)\n" + "3. Professor(a)\n" + "4. M�dico(a)\n"
				+ "\nEntre com sua profiss�o: ");
		op = sc.nextInt();
		sc.nextLine();

		System.out.print("Digite seu nome: ");
		nome = sc.nextLine();

		System.out.print("Digite o seu n�mero de contribuinte: ");
		numero = sc.nextInt();

		System.out.print("Digite o valor do seu carro(0 se n�o tiver): ");
		valor = sc.nextDouble();

		if (valor != 0)
			carro = new Carro(valor);

		System.out.print("Digite o valor da sua casa(0 se n�o tiver): ");
		valor = sc.nextDouble();

		if (valor != 0)
			casa = new Casa(valor);

		switch (op) {

		case 1: // taxista
			System.out.print("Digite o n�mero de passageiros: ");
			numPassageiros = sc.nextInt();

			System.out.print("Digite os KM rodados: ");
			kmRodados = sc.nextDouble();

			contribuinte = new Taxista(nome, numero, casa, carro, numPassageiros, kmRodados);
			break;

		case 2: // caminhoneiro
			System.out.print("Digite a quantidade de toneladas: ");
			valor = sc.nextInt();

			System.out.print("Digite os KM rodados: ");
			kmRodados = sc.nextDouble();

			contribuinte = new Caminhoneiro(nome, numero, casa, carro, valor, kmRodados);
			break;

		case 3: // professor
			System.out.print("Digite seu sal�rio: ");
			valor = sc.nextInt();

			System.out.print("Digite os gastos com material: ");
			despesas = sc.nextDouble();

			contribuinte = new Professor(nome, numero, casa, carro, valor, despesas);
			break;

		case 4: // medico
			System.out.print("Digite o n�mero de atendimentos: ");
			atendimentos = sc.nextInt();

			System.out.print("Digite as despesas com congressos: ");
			despesas = sc.nextDouble();

			contribuinte = new Medico(nome, numero, casa, carro, atendimentos, despesas);
			break;

		}

		System.out.println("\nCadastrado com sucesso!\n");

		return contribuinte;
	}

	public static void listaContribuintes(ArrayList<Contribuinte> contribuintes) {
		double medias[] = new double[4]; // 0 = T, 1 = C, 2 = P, 3 = M
		int i;
		double valor = 0.0;
		String excessivo;

		medias = calculaMediaRiquezas(contribuintes);

		System.out.println("\n === LISTA ===\n");

		for (i = 0; i < contribuintes.size(); i++) {
			excessivo = "Excessivo: ";

			if (contribuintes.get(i) instanceof Taxista)
				valor = medias[0] + (medias[0] * 0.5);

			else if (contribuintes.get(i) instanceof Caminhoneiro)
				valor = medias[1] + (medias[1] * 0.5);

			else if (contribuintes.get(i) instanceof Professor)
				valor = medias[2] + (medias[2] * 0.5);

			else if (contribuintes.get(i) instanceof Medico)
				valor = medias[3] + (medias[3] * 0.5);

			if (contribuintes.get(i).calculaRiqueza() > valor)
				excessivo += "SIM\n\n";

			else
				excessivo += "N�O\n\n";

			System.out.println("Nome: " + contribuintes.get(i).getNome() + "\nValor dos bens: R$"
					+ contribuintes.get(i).calculaRiqueza() + "\n" + excessivo);

		}

	}

	private static double[] calculaMediaRiquezas(ArrayList<Contribuinte> contribuintes) {
		int i, qtdTaxistas = 0, qtdCaminhoneiros = 0, qtdProfessores = 0, qtdMedicos = 0;
		double valorT = 0.0, valorC = 0.0, valorP = 0.0, valorM = 0.0;
		double[] valores = new double[4];

		for (i = 0; i < contribuintes.size(); i++) {
			if (contribuintes.get(i) instanceof Taxista) {
				qtdTaxistas++;
				valorT += contribuintes.get(i).calculaRiqueza();

			} else if (contribuintes.get(i) instanceof Caminhoneiro) {
				qtdCaminhoneiros++;
				valorC += contribuintes.get(i).calculaRiqueza();

			} else if (contribuintes.get(i) instanceof Professor) {
				qtdProfessores++;
				valorP += contribuintes.get(i).calculaRiqueza();

			} else if (contribuintes.get(i) instanceof Medico) {
				qtdMedicos++;
				valorM += contribuintes.get(i).calculaRiqueza();
			}
		}

		if (qtdTaxistas != 0)
			valores[0] = valorT / qtdTaxistas;

		if (qtdCaminhoneiros != 0)
			valores[1] = valorC / qtdCaminhoneiros;

		if (qtdProfessores != 0)
			valores[2] = valorP / qtdProfessores;

		if (qtdMedicos != 0)
			valores[3] = valorM / qtdMedicos;

		return valores;

	}

	public static int menu() {
		System.out.print("\n    MENU\n1. Cadastrar " + "\n2. Calcular e mostrar impostos de um contribuinte "
				+ "\n3. Listar contribuintes" + "\n4. Sair" + "\n\n  -> Digite uma op��o: ");

		return sc.nextInt();

	}
}
