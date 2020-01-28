class Jogador {
    var posx = 0
    var posy = 0
    var flechas = 3 // flechas restantes
    var morreu = false
    lateinit var mapa: Mapa

    fun estaVivo(): Boolean {
        return morreu
    }

    fun sentirPresenca() {
        mapa!!.mensagem = ""
        if (mapa!!.getItem(posx, posy) != " ") {
            if (mapa!!.getItem(posx, posy).equals("W") || mapa!!.getItem(posx, posy).equals("B")) {
                mapa!!.setMapa(posx, posy, mapa!!.getItem(posx, posy))
                mapa!!.mensagem = "MORREU"
                morreu = true
                return
            }
            if (mapa!!.getItem(posx, posy).equals("*")) {
                mapa!!.mensagem = "VITÓRIA"
                mapa!!.setMapa(posx, posy, mapa!!.getItem(posx, posy))
                morreu = true
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

    fun ativarSentido(x: Int, y: Int) {

        if (mapa!!.getItem(x, y) != " ") {
            if (mapa!!.getItem(x, y).equals("W")) {
                mapa!!.setMapa(posx, posy, "%")
                mapa!!.mensagem = "Cheiro de carne podre"
                return
            }
            if (mapa!!.getItem(x, y).equals("B")) {
                mapa!!.setMapa(posx, posy, "~")
                mapa!!.mensagem = "Sinto frio"
                return
            }
        }
    }

    fun andar(direcao: Int) {
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
            else -> {
            }
        }
    }

    fun atirar(direcao: Int) {
        if (flechas <= 0) {
            mapa!!.mensagem = "Estou sem flechas!"
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
    }

    fun atirarFlexa(x: Int, y: Int) {
        if (mapa!!.getItem(x, y) != null && mapa!!.getItem(x, y).equals("W")) {
            mapa!!.mensagem = "E o WUMPUS está morto"
            mapa!!.setItemNull(x, y)
        } else {
            mapa!!.mensagem = "Errei o alvo"
        }
    }

    fun estaNaPosicao(x: Int, y: Int): Boolean {
        if (posx == x && posy == y) {
            return true
        }
        return false
    }

    fun posAtual(): String {
        return posx.toString() + "," + posy
    }
}