var countSolution = 0;

/** Imprime o tabuleiro */
function showBoard(board, n) {
  for (var i = 0; i < n; i++) {
    var line = "";
    for (var j = 0; j < n; j++) {
      if (board[i][j] === 1) {
        line += "R\t";
      } else {
        line += "-\t";
      }
    }
    console.log(line, "\n\n");
  }
  console.log("\n");
}

/** Verifica se é seguro colocar a rainha na coluna */
function isSafety(board, n, row, column) {
  // Verifica se acontece conflito na linha
  for (var i = 0; i < n; i++) {
    if (board[row][i] === 1) {
      return false;
    }
  }

  // Verifica se acontece conflito na columa
  for (var i = 0; i < n; i++) {
    if (board[i][column] === 1) {
      return false;
    }
  }

  var i = row;
  var j = column;

  // Verifica se acontece conflito na diagonal principal
  while (true) {
    if (board[i][j] === 1) {
      return false;
    }
    i--;
    j--;

    if (i < 0 || j < 0) {
      break;
    }
  }

  i = row;
  j = column;

  while (true) {
    if (board[i][j] === 1) {
      return false;
    }
    i++;
    j++;

    if (i >= n || j >= n) {
      break;
    }
  }

  i = row;
  j = column;

  // Verifica se acontece conflito na diagonal secundária
  while (true) {
    if (board[i][j] === 1) {
      return false;
    }
    i--;
    j++;

    if (i < 0 || j >= n) {
      break;
    }
  }

  i = row;
  j = column;

  while (true) {
    if (board[i][j] === 1) {
      return false;
    }
    i++;
    j--;

    if (i >= n || j < 0) {
      break;
    }
  }

  // Não houve conflito
  return true;
}

// Função de resolução do problema
function execute(board, n, column) {
  if (column === n) {
    // console.log(`Solução ${countSolution + 1}:\n\n`);
    // showBoard(board, n);
    countSolution++;
    return;
  }

  for (var i = 0; i < n; i++) {
    // Verifica se é seguro colocar a rainha naquela coluna
    if (isSafety(board, n, i, column)) {
      // Insere a rainha e marca como 1
      board[i][column] = 1;

      execute(board, n, column + 1); // Chamada recursiva

      // Remove a rainha (Backtracking)
      board[i][column] = 0;
    }
  }
}

/** Caso queira imprimir o tabuleiro tire o comentário das linhas 104 e 105
 *  Mas se fizer isso, recomendo que tire o loop da linha 130, para que seja
 *  mais claro a compreensão do que está acontecendo
 */
function main() {
  var n = 4; // Número de rainhas

  for (var k = n; k <= 25; k++) {
    var board = []; // tabuleiro

    // Preencher o tabuleiro
    for (var i = 0; i < k; i++) {
      board.push([]);
      board[i].forEach((b) => b.push(""));
    }

    // Mostrando todas as soluções
    execute(board, k, 0);

    // Quantidade de soluções
    console.log(`Para ${k} rainhas foi encontrado ${countSolution}`);
    countSolution = 0;
  }
}

main();
