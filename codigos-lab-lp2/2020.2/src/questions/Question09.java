package questions;

import java.util.Scanner;

public class Question09 {
	private int numberInputUser;
	private Scanner input = new Scanner(System.in);
	
	public void render() {
		System.out.println("Escreva um aplicativo que insira um número consistindo em cinco dígitos a partir do\n" + 
				"usuário, separe o número em seus dígitos individuais e imprima os dígitos\n" + 
				"separados uns dos outros por três espaços. Por exemplo, se o usuário digitar o\n" + 
				"número 42339, o programa deve imprimir: 4 2 3 3 9");
		System.out.println("Resposta:");
		System.out.println("Insira um número com cinco dígitos");
		this.numberInputUser = input.nextInt();
		this.handleSeparateNumber();
	}
	
	public void handleSeparateNumber() {
		int unity = this.numberInputUser / 10000;
		this.numberInputUser = this.numberInputUser - (unity * 10000);
		
		int ten = this.numberInputUser / 1000;
		this.numberInputUser = this.numberInputUser - (ten * 1000);
		
		int hundred = this.numberInputUser / 100;
		this.numberInputUser = this.numberInputUser - (hundred * 100);
		
		int thousand = this.numberInputUser / 10;
		this.numberInputUser = this.numberInputUser - (thousand * 10);
		
		int tenThousand = this.numberInputUser;
		
		System.out.println("Resposta: " + unity + " " + ten + " " + hundred + " " + thousand + " " + tenThousand);
	}
}
