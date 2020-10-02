# algoritmogenetico.py

from __future__ import annotations
from typing import TypeVar, Tuple, List, Generic, Callable
from cromossomo import Cromossomo
from random import random, choices
from statistics import mean
from enum import Enum
from heapq import nlargest

import matplotlib.pyplot as plt
import seaborn as sns

sns.set_style('whitegrid')

geracoes = []
melhores = []
medias = []


C = TypeVar('C', bound='Cromossomo')

class AlgoritmoGenetico(Generic[C]):
    TipoSelecao = Enum("TipoSelecao", "ROLETA TORNEIO")

    def __init__(self, pop_inicial: List[C], limiar: float, geracoes_max: int = 100, taxa_mutacao: float = 0.01, taxa_crossover: float = 0.7, tipo_selecao: TipoSelecao = TipoSelecao.TORNEIO) -> None:
        self._populacao: List[C] = pop_inicial
        self._limiar: float = limiar
        self._geracoes_max: int = geracoes_max
        self._taxa_mutacao: float = taxa_mutacao
        self._taxa_crossover: float = taxa_crossover
        self._tipo_selecao: AlgoritmoGenetico.TipoSelecao = tipo_selecao
        self._fitness: Callabe = type(self._populacao[0]).fitness

    def _selecao_roleta(self, roda: List[float]) -> Tuple[C, C]:
        return tuple(choices(self._populacao, weights=roda, k=2))

    def _selecao_torneio(self, num_participantes: int) -> Tuple[C, C]:
        participantes: List[C] = choices(self._populacao, k=num_participantes)
        return tuple(nlargest(2, participantes, key=self._fitness))

    def nova_geracao(self) -> None:
        nova_populacao: List[C] = []

        while len(nova_populacao) < len(self._populacao):
            if self._tipo_selecao == AlgoritmoGenetico.TipoSelecao.ROLETA:
                pais: Tuple[C, C] = self._selecao_roleta([x.fitness() for x in self._populacao])
            else:
                pais = self._selecao_torneio(len(self._populacao) // 2)
            
            if random() < self._taxa_crossover:
                nova_populacao.extend(pais[0].crossover(pais[1]))
            else:
                nova_populacao.extend(pais)
        if len(nova_populacao) > len(self._populacao):
            nova_populacao.pop()
        self._populacao = nova_populacao

    def _mutacao(self) -> None:
        for i in self._populacao:
            if random() < self._taxa_mutacao:
                i.mutacao()
    
    def executa(self) -> C:
        melhor: C = max(self._populacao, key=self._fitness)
        for geracao in range(self._geracoes_max):
            if melhor.fitness() >= self._limiar:
                return melhor
            
            print(f"Geração {geracao}  Melhor {melhor.fitness()}  Média {mean(map(self._fitness, self._populacao))}")
            
            lista_grafico = [geracao, melhor.fitness(), mean(map(self._fitness, self._populacao))]
            geracoes.append(geracao)
            melhores.append(melhor.fitness())
            medias.append(mean(map(self._fitness, self._populacao)))

            
            self.nova_geracao()
            self._mutacao()

            teto: C = max(self._populacao, key=self._fitness)
            if teto.fitness() > melhor.fitness():
                melhor = teto
        
    
            plt.plot(geracoes, melhores, 'or')
            plt.plot(geracoes, medias, '*g')
            plt.legend(title='Resultado', loc='lower right', labels=['Melhor', 'Média'])
            plt.show()
        
        return melhor




# Adaptado de:
# Problemas Clássicos de Ciência da Computação com Python
# Copyright 2018 David Kopec

