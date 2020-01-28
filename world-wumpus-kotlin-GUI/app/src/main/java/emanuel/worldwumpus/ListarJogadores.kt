package emanuel.worldwumpus

import Jogador
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_listar_jogadores.*

class ListarJogadores : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var dao: JogadorDAO
    lateinit var jogadores: ArrayList<Jogador>
    var player = ArrayList<Jogador>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_jogadores)

        listView = findViewById(R.id.list_jogador)
        dao = JogadorDAO(this)
        jogadores = dao.obterJogadores()
        this.jogadores.sortBy { it.pontuacao }
        this.player = this.jogadores

        val adaptador = ArrayAdapter<Jogador>(this, android.R.layout.simple_list_item_1, player)
        listView.adapter = adaptador

    }

    fun actionVoltar(view: View){

        val it = Intent(this, MainActivity::class.java)
        startActivity(it)

    }

    override fun onResume() {
        super.onResume()
        jogadores = dao.obterJogadores()
        this.jogadores.sortBy { it.pontuacao }
        player.clear()
        player.addAll(jogadores)
        listView.invalidateViews()
    }
}
