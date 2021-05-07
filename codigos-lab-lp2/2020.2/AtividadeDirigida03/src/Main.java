
public class Main {
	
	static int countSolution = 0; // Quantidade de soluções encontradas.
	static boolean hasSolution = false; // Teve solução
	static int countQueen = 8; // Quantidade de rainhas e dimensões do tabuleiro

	public static void main(String[] args) {
		/***
		 * OBS: Professor, caso ache familiar o algoritmo, quero lembrar que
		 * período passado eu paguei IA com o senhor e fiz esse mesmo algoritmo
		 * em JavaScript em uma das atividades, apenas com algumas modificações,
		 * pois lá o senhor queria saber a quantidade de soluções para n rainhas.
		 * Aqui fiz apenas a tradução do algoritmo em JS pra Java.
		 */
		
		System.out.println("Interação | Teve solução | Quantidade de interações");
		for(int i = 0; i < 10 ; i++) {
			run(i + 1);
		}
		
	}
	
	/**
	 * Função que roda o algoritmo para 1 caso
	 */
	public static void run(int index) {
		/**
		 * Posição com 0 = sem rainha
		 * Posição com 1 = com rainha
		 */
		
		int[][] board = new int[countQueen][countQueen]; // Tabuleiro
		
		// Preenchendo o tabuleiro sem rainhas
		for(int i = 0; i < countQueen; i++) {
			for(int j = 0; j < countQueen; j++) {
				board[i][j] = 0;
			}
		}
		countSolution = 0;
		hasSolution = false;
		execute(board, 0);
		
		System.out.println(index + " | " + hasSolution + " | " + countSolution);
	}
	
	/**
	 * Função de resolução do problema
	 */
	public static void execute(int[][] board, int column) {
		if(column == countQueen) {
			countSolution++;
			hasSolution = true;
		}
		for(int i = 0; i < countQueen; i++) {
			// Verifica se é seguro colocar a rainha naquela coluna
			if(isSafety(board, i, column)) {
				// Insere a rainha e marca como 1
				board[i][column] = 1;
				
				execute(board, column + 1);
				
				// Remove a rainha (Backtracking)
				board[i][column] = 0;
			}
		}
	}
	
	/**
	 * Verifica se é seguro colocar a rainha na coluna
	 */
	public static boolean isSafety(int[][] board, int row, int column) {
		// Verifica se acontece conflito na linha
		for(int i = 0; i < countQueen; i++) {
			if(board[row][i] == 1) {
				return false;
			}
		}
		
		// Verifica se acontece conflito na coluna
		for(int i = 0; i < countQueen; i++) {
			if(board[i][column] == 1) {
				return false;
			}
		}
		
		int i = row;
		int j = column;
		
		// Verifica se acontece conflito na diagonal principal
		while(true) {
			if(board[i][j] == 1) {
				return false;
			}
			i--;
			j--;
			if(i < 0 || j < 0) {
				break;
			}
		}
		
		i = row;
		j = column;
		
		while(true) {
			if(board[i][j] == 1) {
				return false;
			}
			i++;
			j++;
			if(i >= countQueen || j >= countQueen) {
				break;
			}
		}
		
		i = row;
		j = column;
		
		// Verifica se acontece conflito na diagonal secundária
		while(true) {
			if(board[i][j] == 1) {
				return false;
			}
			i--;
			j++;
			if(i < 0 || j >= countQueen) {
				break;
			}
		}
		
		i = row;
		j = column;
		
		while(true) {
			if(board[i][j] == 1) {
				return false;
			}
			i++;
			j--;
			if(i >= countQueen || j < 0) {
				break;
			}
		}
		
		// Não houve conflito
		return true;
	}

}






