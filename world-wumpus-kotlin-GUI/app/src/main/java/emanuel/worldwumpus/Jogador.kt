import java.io.Serializable

class Jogador(var nome: String, var tamanho: Int): Serializable{

    var posx = 0
    var posy = 0
    var flechas = 3 // flechas restantes
    var morreu = false
    var mapa: Mapa
    var pontuacao = 1000

    init {
        this.mapa = Mapa(tamanho)
        mapa.player = this
    }

    override fun equals(other: Any?): Boolean {
        other as Jogador
        return other.pontuacao < this.pontuacao
    }

    override fun toString(): String {
        return "Nome: " + this.nome + " Pontuação: " + this.pontuacao + " Tamanho: " + this.tamanho
    }

    private fun sentirPresenca() {
        if (mapa!!.getItem(posx, posy) != " ") {
            if (mapa!!.getItem(posx, posy).equals("W") || mapa!!.getItem(posx, posy).equals("B")) {
                mapa!!.setMapa(posx, posy, mapa!!.getItem(posx, posy))
                // Morreu
                morreu = true
                mapa.mensagem = "MORREU"
                this.pontuacao = 0
                return
            }
            if (mapa!!.getItem(posx, posy).equals("*")) {
                mapa!!.setMapa(posx, posy, mapa!!.getItem(posx, posy))
                // Vitória
                morreu = true
                mapa.mensagem = "VITORIA"
                this.pontuacao += 1000
                return
            }
        }
        if (posx > 0) {
            ativarSentido(posx - 1, posy)
        }
        if (posx < mapa!!.tamanho - 1) {
            ativarSentido(posx + 1, posy)
        }
        if (posy > 0) {
            ativarSentido(posx, posy - 1)
        }
        if (posy < mapa!!.tamanho - 1) {
            ativarSentido(posx, posy + 1)
        }
    }

    private fun ativarSentido(x: Int, y: Int) {

        if (mapa!!.getItem(x, y) != " ") {
            if (mapa!!.getItem(x, y).equals("W")) {
                mapa!!.setMapa(posx, posy, "%")
                mapa.mensagem = "MAU CHEIRO"
                return
            }
            if (mapa!!.getItem(x, y).equals("B")) {
                mapa!!.setMapa(posx, posy, "~")
                mapa.mensagem = "BRISA"
                return
            }
        }
    }

    fun andar(direcao: Int): String {
        mapa.mensagem = ""
        this.pontuacao -= 10
        when (direcao) {
            8 -> if (posx > 0) {
                posx--
                sentirPresenca()
            }
            2 -> if (posx < mapa!!.tamanho - 1) {
                posx++
                sentirPresenca()
            }
            4 -> if (posy > 0) {
                posy--
                sentirPresenca()
            }
            6 -> if (posy < mapa!!.tamanho - 1) {
                posy++
                sentirPresenca()
            }
        }
        return mapa.mensagem
    }

    fun atirar(direcao: Int): String {
        if (flechas <= 0) {
            mapa.mensagem = "Sem Flexas"
            this.pontuacao -= 200
        } else {
            flechas--
            when (direcao) {
                8 -> if (posx > 0) {
                    atirarFlexa(posx - 1, posy)
                }
                2 -> if (posx < mapa!!.tamanho - 1) {
                    atirarFlexa(posx + 1, posy)
                }
                4 -> if (posy > 0) {
                    atirarFlexa(posx, posy - 1)
                }
                6 -> if (posy < mapa!!.tamanho - 1) {
                    atirarFlexa(posx, posy + 1)
                }
                else -> {
                }
            }
        }
        return mapa.mensagem
    }

    fun atirarFlexa(x: Int, y: Int) {
        if (mapa!!.getItem(x, y) != null && mapa!!.getItem(x, y).equals("W")) {
            //Wumpus morto
            mapa!!.setItemNull(x, y)
            this.pontuacao += 800
            mapa.mensagem = "WUMPUS MORTO"
        } else {
            // Errou o alvo
            this.pontuacao -= 200
            mapa.mensagem = "ERROU O ALVO"
        }
    }

    fun estaNaPosicao(x: Int, y: Int): Boolean {
        if (posx == x && posy == y) {
            return true
        }
        return false
    }

}