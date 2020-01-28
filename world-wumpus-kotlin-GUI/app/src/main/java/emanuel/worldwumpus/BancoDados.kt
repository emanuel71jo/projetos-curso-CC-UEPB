package emanuel.worldwumpus

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val nomeBanco = "banco.db"
const val version = 1
const val table = "tb_jogador"
const val nome = "nome"
const val pontuacao = "pontuacao"
const val tamanho = "tamanho"

class BancoDados(val context: Context): SQLiteOpenHelper(context, nomeBanco, null, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE " + table + "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                nome + " varchar(50), " + pontuacao + " INTEGER, " + tamanho + " INTEGER)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}