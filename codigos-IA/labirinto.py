"""Classes que simulam o ambiente do agente."""

from buscagenerica import aestrela, largura, profundidade, percurso, Noh
from typing import List, Callable, Optional, NamedTuple
from enum import Enum
import random

class Celula(str, Enum):
    INICIAL = 'S'
    OBJETIVO = 'G'
    CAMINHO = '*'
    VAZIA = ' '
    BLOQUEADA = 'X'

class Coordenadas(NamedTuple):
    linha: int
    coluna: int

class Labirinto:
    def __init__(self, linhas: int = 10, colunas: int = 10,
                 disperso: float = 0.20,
                 inicial: Coordenadas = Coordenadas(0, 0),
                 objetivo: Coordenadas = Coordenadas(9, 9)) -> None:

                 self._linhas: int = linhas
                 self._colunas: int = colunas
                 self.inicial: Coordenadas = inicial
                 self.objetivo: Coordenadas = objetivo

                 self._grade = [ [Celula.VAZIA for c in range(colunas)] for l in range(linhas)]
                 self.preenche_aleatoriamente(linhas, colunas, disperso)
                 self._grade[inicial.linha][inicial.coluna] = Celula.INICIAL
                 self._grade[objetivo.linha][objetivo.coluna] = Celula.OBJETIVO

    def preenche_aleatoriamente(self, linhas: int, colunas: int, disperso: float):
        for linha in range(linhas):
            for coluna in range(colunas):
                if random.uniform(0, 1.0) < disperso:
                    self._grade[linha][coluna] = Celula.BLOQUEADA

    def teste_objetivo(self, posicao: Coordenadas) -> bool:
        return posicao == self.objetivo
    
    def sucessores(self, posicao: Coordenadas) -> List[Coordenadas]:
        posicoes: List[Coordenadas] = []

        if posicao.linha + 1 < self._linhas and self._grade[posicao.linha + 1][posicao.coluna] != Celula.BLOQUEADA:
            posicoes.append(Coordenadas(posicao.linha + 1, posicao.coluna))
        if posicao.linha - 1 >= 0 and self._grade[posicao.linha - 1][posicao.coluna] != Celula.BLOQUEADA:
            posicoes.append(Coordenadas(posicao.linha - 1, posicao.coluna))
        if posicao.coluna + 1 < self._colunas and self._grade[posicao.linha][posicao.coluna + 1] != Celula.BLOQUEADA:
            posicoes.append(Coordenadas(posicao.linha, posicao.coluna + 1))
        if posicao.coluna - 1 >= self._colunas and self._grade[posicao.linha][posicao.coluna - 1] != Celula.BLOQUEADA:
            posicoes.append(Coordenadas(posicao.linha, posicao.coluna - 1))

        return posicoes


    # Marcar o labirinto com o caminho com sucesso, estado inicial e objetivo
    def demarcar(self, caminho: List[Coordenadas]):
        for pos_labirinto in caminho:
            self._grade[pos_labirinto.linha][pos_labirinto.coluna] = Celula.CAMINHO
        self._grade[self.inicial.linha][self.inicial.coluna] = Celula.INICIAL
        self._grade[self.objetivo.linha][self.objetivo.coluna] = Celula.OBJETIVO
    
    # Remover um caminho para testar algoritmos diferentes no mesmo labirinto
    def remover(self, caminho: List[Coordenadas]):
        for pos_labirinto in caminho:
            self._grade[pos_labirinto.linha][pos_labirinto.coluna] = Celula.VAZIA
        self._grade[self.inicial.linha][self.inicial.coluna] = Celula.INICIAL
        self._grade[self.objetivo.linha][self.objetivo.coluna] = Celula.OBJETIVO

    def __str__(self) -> str:
        saida: str = ""
        for i in self._grade:
            saida += "".join([c.value for c in i]) + "\n"
        
        return saida

from math import sqrt

def distancia_euclidiana(objetivo):
    def distancia(localizacao):
        x = localizacao.coluna - objetivo.coluna
        y = localizacao.linha - objetivo.linha
        return sqrt((x * x) + (y * y))
    return distancia

def distancia_manhattan(objetivo):
    def distancia(localizacao):
        x = abs(localizacao.coluna - objetivo.coluna)
        y = abs(localizacao.linha - objetivo.linha)
        return (x + y)
    return distancia

if __name__ == "__main__":
    # Teste profundidade
    testeLabirinto: Labirinto = Labirinto()
    print(testeLabirinto)

    buscaProfundidade: Optional[Noh[Coordenadas]] = profundidade(testeLabirinto.inicial, testeLabirinto.teste_objetivo,
                        testeLabirinto.sucessores)
    if buscaProfundidade is None:
        print('----------')
        print('Sem solução usando busca em profundidade!')
    else:
        print('----------')
        caminhoDFS: List[Coordenadas] = percurso(buscaProfundidade)
        testeLabirinto.demarcar(caminhoDFS)
        print(testeLabirinto)
        testeLabirinto.remover(caminhoDFS)

    # Teste largura
    solucaoLargura: Optional[Noh[Coordenadas]] = largura(testeLabirinto.inicial, testeLabirinto.teste_objetivo,
                        testeLabirinto.sucessores)
    if solucaoLargura is None:
        print("Sem solução usando busca em largura!")
    else:
        caminhoLargura: List[Coordenadas] = percurso(solucaoLargura)
        testeLabirinto.demarcar(caminhoLargura)
        print(testeLabirinto)
        testeLabirinto.remover(caminhoLargura)
    
    # continua
    distancia = distancia_manhattan(testeLabirinto.objetivo)
    distanciaE = distancia_euclidiana(testeLabirinto.objetivo)
    
    solucaoA = aestrela(testeLabirinto.inicial, testeLabirinto.teste_objetivo, testeLabirinto.sucessores, distancia)

    if solucaoA is None:
        print("Sem solução com A*!")
    else:
        caminhoA = percurso(solucaoA)
        testeLabirinto.demarcar(caminhoA)
        print(testeLabirinto)




# Adaptado de:
# Problemas Clássicos de Ciência da Computação com Python
# Copyright 2018 David Kopec