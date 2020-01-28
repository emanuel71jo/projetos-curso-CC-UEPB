class Mapa {
    val tamanho = 6

    var mapa = Array(tamanho) {Array<String>(tamanho) {" "} }
    var itens = Array(tamanho) {Array<String>(tamanho) {" "} }
    lateinit var player: Jogador
    var mensagem = ""

    fun setPosMapa(x: Int, y: Int, caracter: String?) {
        if (caracter != null) {
            mapa[x][y] = caracter
        }
    }

    init {
        val objetos = arrayOf("W", "*", "B", "B", "B", "B", "B")
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

    fun gerarNumero(): Int {
        return (Math.random() * 100).toInt() % tamanho
    }

    fun imprimirMapa(map: Array<Array<String>>) {
        println("========================== \n       Caça ao Wumpus\n========================== ")
        var caractere: String? = " "
        println("  +---+---+---+---+---+---+")
        println("  | 0 | 1 | 2 | 3 | 4 | 5 |")
        println("  +---+---+---+---+---+---+")
        for (x in 0..(tamanho - 1)) {
            print("$x |")
            for (y in 0..(tamanho - 1)) {
                caractere = if (map[x][y] == " ") {
                    " "
                } else {
                    map[x][y]
                }
                if (player!!.estaNaPosicao(x, y) && caractere == " ") {
                    caractere = "&"
                }
                print(" $caractere |")
            }
            println("\n  +---+---+---+---+---+---+")
        }
        println("+--- Inventário -------------")
        System.out.println("| Flechas: " + player!!.flechas)
        System.out.println("| Posição Atual: (x,y) (" + player!!.posAtual().toString() + ")")
        println("| MENSAGEM: $mensagem")
        print("+----------------------------+")
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