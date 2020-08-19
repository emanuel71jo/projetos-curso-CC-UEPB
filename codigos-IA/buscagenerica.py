from __future__ import annotations
from typing import Any, Sequence, Generic, Optional, Callable, TypeVar, Iterable, Deque
from typing_extensions import Protocol

'''
Classes que resolvem buscas: dfs, bfs e ucs
'''

# Trabalhando com type hints (PEP 484)

T = TypeVar('T')
C = TypeVar('C', bound='Comparable')

def busca_linear(iterador: Iterable[T], chave: T) -> bool:
    for item in iterador:
        if item == chave:
            return True
    return False

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
        if(sequencia[meio] < chave):
            inicio = meio + 1
        elif sequencia[meio] > chave:
            fim = meio - 1
        else:
            return True
    return False

class Pilha(Generic[T]):
    def __init__(self) -> None:
        self._container: List[T] = []
    
    @property
    def vazia(self) -> bool:
        return not self._container
    
    def push(self, item: T) -> None:
        self._container.append(item)
        
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
    
    explorados: Set[T] = { inicial }
        
    while not fronteira.vazia:
        noh_atual: Noh[T] = fronteira.pop()
        estado_atual: Noh[T] = noh_atual.estado
        
        if teste_objetivo(estado_atual):
            return noh_atual
        
        for filho in sucessores(estado_atual):
            if filho in explorados:
                continue
            
            explorados.add(filho)
            fronteira.push(Noh(filho, noh_atual))
    return None

def largura(inicial: T, teste_objetivo: Callable[[T], bool], sucessores: Callable[[T], List[T]]) -> Optional[Noh[T]]:
    fronteira: Fila[Noh[T]] = Fila()
    fronteira.push(Noh(inicial, None))
    
    explorados: Set[T] = { inicial }
        
    while not fronteira.vazia:
        noh_atual: Noh[T] = fronteira.pop()
        estado_atual: Noh[T] = noh_atual.estado
        
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


class Fila(Generic[T]):
    def __init__(self) -> None:
        self._container: Deque[T] = Deque()
    
    @property
    def vazia(self) -> bool:
        return not self._container
    
    def push(self, item: T) -> None:
        self._container.append(item)
        
    def pop(self) -> T:
        return self._container.popleft()
    
    def __repr__(self) -> str:
        return repr(self._container)


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
