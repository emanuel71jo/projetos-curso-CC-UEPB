package emanuel.worldwumpus

import Jogador
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class JogadorDAO(val context: Context){

    var conexao: BancoDados
    var banco: SQLiteDatabase

    init {
        this.conexao = BancoDados(context)
        this.banco = this.conexao.writableDatabase
    }

    fun inserirJogador(jogador: Jogador){
        var values = ContentValues()
        values.put(nome, jogador.nome)
        values.put(pontuacao, jogador.pontuacao)
        values.put(tamanho, jogador.tamanho)
        banco.insert(table, null, values)
    }

    fun obterJogadores(): ArrayList<Jogador>{
        var jogadores = ArrayList<Jogador>()
        var cursor: Cursor = banco.query(table, arrayOf("id", nome, pontuacao, tamanho), null, null, null, null, null)

        while(cursor.moveToNext()){
            var jogador = Jogador(cursor.getString(1), cursor.getInt(3))
            jogador.pontuacao = cursor.getInt(2)
            jogadores.add(jogador)
        }

        return jogadores

    }

}