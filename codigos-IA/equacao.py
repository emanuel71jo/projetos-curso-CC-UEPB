#equacao.py

from __future__  import annotations
from cromossomo import Cromossomo
from algoritmogenetico import AlgoritmoGenetico
from random import random, randrange
from typing import Tuple, List
from copy import deepcopy


class Equacao(Cromossomo):
    def __init__(self, x: int, y: int) -> None:
        self.x: int = x
        self.y: int = y
    
    def fitness(self) -> float:
        #return 15 * self.x - self.x * self.x + self.y
        return 6 * self.x - self.x * self.x + 4 * self.y - self.y * self.y

    @classmethod
    def genes_aleatorios(cls) -> Equacao:
        return Equacao(randrange(80), randrange(80))

    def crossover(self, outro: Equacao) -> Tuple[Equacao, Equacao]:
        filho1: Equacao = deepcopy(self)
        filho2: Equacao = deepcopy(outro)

        filho1.y = outro.y
        filho2.y = self.y

        return filho1, filho2

    def mutacao(self) -> None:
        
        if random() > 0.5:
            # mutação para elemento x
            if random() > 0.5:
                self.x += 1
            else:
                self.x -= 1
        else:
            # mutação para elemento y
            if random() > 0.5:
                self.y += 1
            else:
                self.y -= 1

    def __str__(self) -> str:
        return f"X: {self.x} Y: {self.y} Fitness {self.fitness()}"
        

if __name__ == "__main__":
    pop_inicial: List[Equacao] = [Equacao.genes_aleatorios() for _ in range(20)]
    ga: AlgoritmoGenetico[Equacao] = AlgoritmoGenetico(pop_inicial=pop_inicial, limiar = 13.0, geracoes_max=50, taxa_mutacao=0.1, taxa_crossover=0.7)
    resultado: Equacao = ga.executa()
    print(resultado)




# Adaptado de:
# Problemas Clássicos de Ciência da Computação com Python
# Copyright 2018 David Kopec