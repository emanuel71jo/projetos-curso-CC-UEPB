class Mapa(var tamanho: Int) {
    var mapa = Array(tamanho) {Array<String>(tamanho) {" "} }
    var itens = Array(tamanho) {Array<String>(tamanho) {" "} }
    lateinit var player: Jogador
    var mensagem: String = ""

    private fun setPosMapa(x: Int, y: Int, caracter: String?) {
        if (caracter != null) {
            mapa[x][y] = caracter
        }
    }

    init {

        val objetos: Array<String>

        if(this.tamanho == 6)
            objetos = arrayOf("W", "*", "B", "B", "B", "B", "B", "B")
        else if(this.tamanho == 9)
            objetos = arrayOf("W", "W", "*", "B", "B", "B", "B", "B", "B", "B", "B", "B")
        else
            objetos = arrayOf("W", "W", "W", "*", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B")

        var x = 0
        var y = 0
        var erro = 0
        for (objeto in objetos) {
            while (erro == 0) {
                x = gerarNumero()
                y = gerarNumero()
                if (getItem(x, y) == " " && x != 0 && y != 0) {
                    setItem(x, y, objeto)
                    erro = 1
                }
            }
            erro = 0
        }
    }

    private fun gerarNumero(): Int {
        return (Math.random() * 100).toInt() % tamanho
    }

    fun getItem(x: Int, y: Int): String? {
        return itens[x][y]
    }

    fun setItem(x: Int, y: Int, valor: String) {
        itens[x][y] = valor
    }

    fun setMapa(x: Int, y: Int, valor: String?) {
        mapa[x][y] = valor!!
    }

    fun setItemNull(x: Int, y: Int) {
        itens[x][y] = " "
    }
}