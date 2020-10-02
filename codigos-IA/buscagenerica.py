from __future__ import annotations

"""
Classes que resolvem buscas: a*, dfs e bfs.
"""

# trabalhamos com type hints (PEP 484)

from typing_extensions import Protocol
from typing import TypeVar, Iterable, Optional

T = TypeVar('T')

def busca_linear(iterador: Iterable[T], chave: T) -> bool:
    for item in iterador:
        if item == chave:
            return True
    return False

from typing import Any, Sequence

C = TypeVar('C', bound='Comparable')

class Comparable(Protocol):
    def __eq__(self, other: Any) -> bool:
        ...

    def __lt__(self: C, other: C) -> bool:
        ...

    def __gt__(self: C, other: C) -> bool:
        return (not self < other) and self != other

    def __le__(self: C, other: C) -> bool:
        return self < other or self == other

    def __ge__(self: C, other: C) -> bool:
        return not self < other

def busca_binaria(sequencia: Sequence[C], chave: C) -> bool:
    inicio: int = 0
    fim: int = len(sequencia) - 1
    while inicio <= fim:
        meio: int = (inicio + fim) // 2
        if sequencia[meio] < chave:
            inicio = meio + 1
        elif sequencia[meio] > chave:
            fim = meio - 1
        else:
            return True
    return False


from typing import Generic

class Pilha(Generic[T]):
    def __init__(self) -> None:
        self._container: List[T] = []

    @property
    def vazia(self) -> bool:
        return not self._container
    
    def push(self, item: T) -> None:
        return self._container.append(item)

    def pop(self) -> T:
        return self._container.pop()

    def __repr__(self) -> str:
        return repr(self._container)
    

class Noh(Generic[T]):
    def __init__(self, estado: T, pai: Optional[Noh], custo: float = 0.0, heuristica: float = 0.0) -> None:
        self.estado: T = estado
        self.pai: Optional[Noh] = pai
        self.custo: float = custo
        self.heuristica: float = heuristica
    
    def __lt__(self, other: Noh) -> bool:
        return (self.custo + self.heuristica) < (other.custo + other.heuristica)

def profundidade(inicial: T, teste_objetivo: Callable[[T], bool], sucessores: Callable[[T], List[T]]) -> Optional[Noh[T]]:
    fronteira: Pilha[Noh[T]] = Pilha()
    fronteira.push(Noh(inicial, None))

    explorados: Set[T] = {inicial}

    while not fronteira.vazia:
        noh_atual: Noh[T] = fronteira.pop()
        estado_atual: T = noh_atual.estado

        if teste_objetivo(estado_atual):
            return noh_atual
        
        for filho in sucessores(estado_atual):
            if filho in explorados:
                continue

            explorados.add(filho)
            fronteira.push(Noh(filho, noh_atual))
    
    return None

def percurso(noh_: Noh[T]) -> List[T]:
    caminho: List[T] = [noh_.estado]
    while noh_.pai is not None:
        noh_ = noh_.pai
        caminho.append(noh_.estado)
    caminho.reverse()

    return caminho

from typing import Deque

class Fila(Generic[T]):
    def __init__(self) -> None:
        self._container: Deque[T] = Deque()

    @property
    def vazia(self) -> bool:
        return not self._container
    
    def push(self, item: T) -> None:
        return self._container.append(item)

    def pop(self) -> T:
        return self._container.popleft()

    def __repr__(self) -> str:
        return repr(self._container)


def largura(inicial: T, teste_objetivo: Callable[[T], bool], sucessores: Callable[[T], List[T]]) -> Optional[Noh[T]]:
    fronteira: Fila[Noh[T]] = Fila()
    fronteira.push(Noh(inicial, None))

    explorados: Set[T] = {inicial}

    while not fronteira.vazia:
        noh_atual: Noh[T] = fronteira.pop()
        estado_atual: T = noh_atual.estado

        if teste_objetivo(estado_atual):
            return noh_atual
        
        for filho in sucessores(estado_atual):
            if filho in explorados:
                continue

            explorados.add(filho)
            fronteira.push(Noh(filho, noh_atual))
    
    return None

from heapq import heappop, heappush

class FilaDePrioridade(Generic[T]):
    def __init__(self) -> None:
        self._container: List[T] = []

    @property
    def vazia(self) -> bool:
        return not self._container
    
    def push(self, item: T) -> None:
        heappush(self._container, item)

    def pop(self) -> T:
        return heappop(self._container)

    def __repr__(self) -> str:
        return repr(self._container)
    
from typing import Dict

def aestrela(inicial: T, teste_objetivo: Callable[[T], bool], sucessores: Callable[[T], List[T]], heuristica: Callable[[T, float]] ) -> Optional[Noh[T]]:
    fronteira: FilaDePrioridade[Noh[T]] = FilaDePrioridade()
    fronteira.push(Noh(inicial, None, 0.0, heuristica(inicial)))

    explorados: Dict[T, float] = {inicial: 0.0}

    while not fronteira.vazia:
        noh_atual: Noh[T] = fronteira.pop()
        estado_atual: T = noh_atual.estado

        if teste_objetivo(estado_atual):
            return noh_atual
        
        for filho in sucessores(estado_atual):
            novo_custo = noh_atual.custo + 1

            if filho not in explorados or explorados[filho] > novo_custo:
                explorados[filho] = novo_custo
                fronteira.push(Noh(filho, noh_atual, novo_custo, heuristica(filho)))

    return None


if __name__ == "__main__":
    #print(busca_linear([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], -1))
    #print(busca_linear(['s', 'ss'], 's'))

    print(busca_binaria([1, 2, 3, 4, 5], 5))
    print(busca_binaria(['s', 'ss'], 's'))




# Adaptado de:
# Problemas Clássicos de Ciência da Computação com Python
# Copyright 2018 David Kopec