import java.util.*

fun main(args: Array<String>){

    val `in` = Scanner(System.`in`)
    var direcao = -1
    var player: Jogador = Jogador()
    var mapa: Mapa = Mapa()
    player.mapa = mapa
    mapa.player = player

    player.mapa.imprimirMapa(mapa.mapa)
    // 0 - Sair  8 - Cima  2 -  Baixo  4 - Esquerda  6 - Direita  5 - Atirar
    while (direcao != 0 && !player.estaVivo()) {
        print("\nFaça o seu movimento: ")
        direcao = `in`.nextInt()
        if (direcao == 5) {
            println("Atirar em qual direção?")
            direcao = `in`.nextInt()
            player.atirar(direcao)
        } else {
            player.andar(direcao)
        }
        player.mapa.imprimirMapa(mapa.mapa)
    }
    println("")
}