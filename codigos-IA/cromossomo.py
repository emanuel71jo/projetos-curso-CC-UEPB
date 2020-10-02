# cromossomo.py

from __future__ import annotations
from abc import ABC, abstractmethod
from typing import TypeVar, Tuple, Type

T = TypeVar('T', bound='Cromossomo')

class Cromossomo(ABC):
    @abstractmethod
    def fitness(self) -> float:
        ...

    @classmethod
    @abstractmethod
    def genes_aleatorios(cls: Type[T]) -> T:
        ...

    @abstractmethod
    def mutacao(self) -> None:
        ...

    @abstractmethod
    def crossover(self: T, outro: T) -> Tuple[T, T]:
        ...





# Adaptado de:
# Problemas Clássicos de Ciência da Computação com Python
# Copyright 2018 David Kopec