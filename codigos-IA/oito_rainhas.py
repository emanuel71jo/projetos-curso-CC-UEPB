# problema das 8 rainhas

from restricao import Restricao, PSR
from typing import Dict, List, Optional

class RestricaoOitoRainhas(Restricao[int, int]):
    def __init__(self, colunas: List[int]) -> None:
        super().__init__(colunas)
        self.colunas: List[int] = colunas

    def satisfeita(self, atribuicao: Dict[int, int]) -> bool:
        # coluna_rainha1 = coluna da rainha 1, linha_rainha1 = linha da rainha 1
        for coluna_rainha1, linha_rainha1 in atribuicao.items():
            # coluna_rainha2 = coluna da rainha 2
            for coluna_rainha2 in range(coluna_rainha1 + 1, len(self.colunas) + 1):
                if coluna_rainha2 in atribuicao:
                    linha_rainha2 = atribuicao[coluna_rainha2]  # linha_rainha2 = linha da rainha 2
                    if linha_rainha1 == linha_rainha2:  # verificar se são a mesma linha
                        return False
                    # Verificar diagonal
                    if abs(linha_rainha1 - linha_rainha2) == abs(coluna_rainha1 - coluna_rainha2):
                        return False
        return True  # não teve conflito

if __name__ == "__main__":

    colunas: List[int] = [1, 2, 3, 4, 5, 6, 7, 8]
    linhas: Dict[int, List[int]] = {}
    for coluna in colunas:
        linhas[coluna] = [1, 2, 3, 4, 5, 6, 7, 8]
    problema: PSR[int, int] = PSR(colunas, linhas)
    
    # Adicionar a restrição e executar a busca
    problema.adiciona_restricao(RestricaoOitoRainhas(colunas))
    solucao: Optional[Dict[int, int]] = problema.busca_backtracking()
    if solucao is None:
        print("Sem solução!")
    else:
        print(solucao)
    
    # Uma solução correta atribuirá uma coluna e uma linha para cada rainha
    posicoes = list(solucao.values())
    
    for i in range(1, 9):
        for j in range(1, 9):
            if i == posicoes[j - 1]:
                print('R', end=' ')
            else:
                print('+', end=' ')
        print(' ')




# Adaptado de:
# Problemas Clássicos de Ciência da Computação com Python
# Copyright 2018 David Kopec
