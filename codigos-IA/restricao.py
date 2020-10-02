# restricao.py

from abc import ABC, abstractmethod
from typing import Generic, TypeVar, Dict, List, Optional

# V: tipo para variável
V = TypeVar('V')

# D: tipo para domínio
D = TypeVar('D')

# classe-base para restrições
class Restricao(Generic[V, D], ABC):
    # Variáveis sujeitas às restrições
    def __init__(self, variaveis: List[V]) -> None:
        self.variaveis = variaveis

    # Deve ser sobrescrito pela subclasse
    @abstractmethod
    def satisfeita(self, atribuicao: Dict[V, D]) -> bool:
        ...
    
# Um PSR consiste de variáveis (V) com intervalos de valores conhecidos
# como domínios (D) e restrições que determinam se a escolha de
# domínio de uma variável particular é válida
class PSR(Generic[V, D]):
    def __init__(self, variaveis: List[V], dominios: Dict[V, List[D]]) -> None:
        # Variáveis a restringir
        self.variaveis: List[V] = variaveis
        # Domínio de cada variável
        self.dominios: Dict[V, List[D]] = dominios
        
        self.restricoes: Dict[V, List[Restricao[V, D]]] = {}

        for variavel in self.variaveis:
            self.restricoes[variavel] = []
            if variavel not in self.dominios:
                raise LookupError('Cada variável deve ter um domínio atribuído.')

    def adiciona_restricao(self, restricao: Restricao[V, D]) -> None:
        for variavel in restricao.variaveis:
            if variavel not in self.variaveis:
                raise LookupError('Restrição imposta a uma variável inexistente.')
            else:
                self.restricoes[variavel].append(restricao)
    
    # Verifica se o valor atribuído é consistente consultando todas
    # as restrições para a dada variável em relação a essa atribuição
    def consistente(self, variavel: V, atribuicao: Dict[V, D]) -> bool:
        for restricao in self.restricoes[variavel]:
            if not restricao.satisfeita(atribuicao):
                return False
        return True  # fora do for

    def busca_backtracking(self, atribuicao: Dict[V, D] = {}) -> Optional[Dict[V, D]]:
        # Se todas as variáveis receberem uma atribuição, ela (atribuição) está completa.
        if len(atribuicao) == len(self.variaveis):
            return atribuicao

        # Obtém todas as variáveis que estão em PSR mas não em 'atribuicao'
        nao_atribuida: List[V] = [v for v in self.variaveis if v not in atribuicao]

        # Obtém todos os valores possíveis no domínio da primeira variável sem atribuição
        primeira: V = nao_atribuida[0]
        for valor in self.dominios[primeira]:
            atribuicao_local = atribuicao.copy()
            atribuicao_local[primeira] = valor

            # Se ainda consistente, realizar a recursão (continua a executar)
            if self.consistente(primeira, atribuicao_local):
                resultado: Optional[Dict[V, D]] = self.busca_backtracking(atribuicao_local)
                
                # Se não encontrar o resultado, realizar o backtracking
                if resultado is not None:
                    return resultado
        
        return None




# Adaptado de:
# Problemas Clássicos de Ciência da Computação com Python
# Copyright 2018 David Kopec