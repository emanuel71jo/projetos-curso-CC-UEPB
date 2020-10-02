# coloracao_mapa.py

from restricao import Restricao, PSR
from typing import Dict, List, Optional

# Subclasse parametrizada RestricaoColoracao herda de Restricao
# Construtor recebe duas variáveis: duas regiões de fronteira
class RestricaoColoracao(Restricao[str, str]):
    def __init__(self, regiao1: str, regiao2: str) -> None:
        super().__init__([regiao1, regiao2])
        self.regiao1: str = regiao1
        self.regiao2: str = regiao2

    def satisfeita(self, atribuicao: Dict[str, str]) -> bool:
        # Se uma das regiões não está na atribuição, ainda não é
        # possível que suas cores estejam conflitantes
        if self.regiao1 not in atribuicao or self.regiao2 not in atribuicao:
            return True

        # Verifica se a cor atribuída a regiao1 não é igual à
        # cor atribuída a regiao2
        return atribuicao[self.regiao1] != atribuicao[self.regiao2]


# main testa as funcionalidades do aplicativo
if __name__ == "__main__":
    variaveis: List[str] = ["Austrália Ocidental", "Território do Norte", "Austrália Meridional",
                            "Queensland", "Nova Gales do Sul", "Vitória", "Tasmânia"]
    dominios: Dict[str, List[str]] = {}
    for variavel in variaveis:
        dominios[variavel] = ["VERMELHO", "VERDE", "AZUL"]
    problema: PSR[str, str] = PSR(variaveis, dominios)
    problema.adiciona_restricao(RestricaoColoracao("Austrália Ocidental", "Território do Norte"))
    problema.adiciona_restricao(RestricaoColoracao("Austrália Ocidental", "Austrália Meridional"))
    problema.adiciona_restricao(RestricaoColoracao("Austrália Meridional", "Território do Norte"))
    problema.adiciona_restricao(RestricaoColoracao("Queensland", "Território do Norte"))
    problema.adiciona_restricao(RestricaoColoracao("Queensland", "Austrália Meridional"))
    problema.adiciona_restricao(RestricaoColoracao("Queensland", "Nova Gales do Sul"))
    problema.adiciona_restricao(RestricaoColoracao("Nova Gales do Sul", "Austrália Meridional"))
    problema.adiciona_restricao(RestricaoColoracao("Vitória", "Austrália Meridional"))
    problema.adiciona_restricao(RestricaoColoracao("Vitória", "Nova Gales do Sul"))
    # Opcional
    problema.adiciona_restricao(RestricaoColoracao("Vitória", "Tasmânia"))
    
    # Exibir a solução, se existir.
    solucao: Optional[Dict[str, str]] = problema.busca_backtracking()
    if solucao is None:
        print("Solução não encontrada!")
    else:
        print(solucao)




# Adaptado de:
# Problemas Clássicos de Ciência da Computação com Python
# Copyright 2018 David Kopec
