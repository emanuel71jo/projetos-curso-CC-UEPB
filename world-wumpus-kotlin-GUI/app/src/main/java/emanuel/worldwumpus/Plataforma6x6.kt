package emanuel.worldwumpus

import Jogador
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_plataforma6x6.*

const val DOWN = 2
const val UP = 8
const val RIGHT = 6
const val LEFT = 4

class Plataforma6x6: AppCompatActivity() {
    private var posHero = 0
    var player: Jogador? = null
    private var imgHero = R.drawable.img_player
    private var imgLocalVisitado = R.drawable.img_localVisitado

    val arrayViews = arrayOf(R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8,
        R.id.img9, R.id.img10, R.id.img11, R.id.img12, R.id.img13, R.id.img14, R.id.img15, R.id.img16, R.id.img17,
        R.id.img18, R.id.img19, R.id.img20, R.id.img21, R.id.img22, R.id.img23, R.id.img24, R.id.img25, R.id.img26,
        R.id.img27, R.id.img28, R.id.img29, R.id.img30, R.id.img31, R.id.img32, R.id.img33, R.id.img34, R.id.img35, R.id.img36)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plataforma6x6)
    }

    fun clickSair(view: View){
        val it = Intent(this, MainActivity::class.java)
        startActivity(it)
    }

    fun clickJogar6(view: View){
        if(edt_jogador.text.toString().equals("")){
            Toast.makeText(this, "Informe o nome do JOGADOR", Toast.LENGTH_LONG).show()
        }else{
            findViewById<EditText>(R.id.edt_jogador).visibility = View.INVISIBLE
            findViewById<Button>(R.id.btn_ok).visibility = View.INVISIBLE
            findViewById<Button>(R.id.btn_up).visibility = View.VISIBLE
            findViewById<Button>(R.id.btn_down).visibility = View.VISIBLE
            findViewById<Button>(R.id.btn_left).visibility = View.VISIBLE
            findViewById<Button>(R.id.btn_right).visibility = View.VISIBLE
            this.player = Jogador(edt_jogador.text.toString(), 6)
        }
    }

    fun clickAtirar(view: View){
        val btn = view as Button
        val msg = when (btn.id) {
            R.id.btn_atirarDown -> player?.atirar(DOWN)
            R.id.btn_atirarUp -> player?.atirar(UP)
            R.id.btn_atirarLeft -> player?.atirar(LEFT)
            R.id.btn_atirarRight -> player?.atirar(RIGHT)
            else -> ""
        }
        findViewById<Button>(R.id.btn_atirar).visibility = View.VISIBLE
        findViewById<Button>(R.id.btn_atirarRight).visibility = View.INVISIBLE
        findViewById<Button>(R.id.btn_atirarLeft).visibility = View.INVISIBLE
        findViewById<Button>(R.id.btn_atirarUp).visibility = View.INVISIBLE
        findViewById<Button>(R.id.btn_atirarDown).visibility = View.INVISIBLE
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun jogo6x6(view: View){

        val btnClick = view as Button
        findViewById<ImageView>(arrayViews[posHero]).setImageResource(imgLocalVisitado)
        val msg = when(btnClick.id){
            R.id.btn_down ->{
                if(posHero <= 29){
                    posHero += 6
                    player?.andar(DOWN)
                }else "Impossível se movimentar"
            }
            R.id.btn_up -> {
                if(posHero >= 6){
                    posHero -= 6
                    player?.andar(UP)
                }else "Impossível se movimentar"
            }
            R.id.btn_right -> {
                if(listOf(5,11,17,23,29,35).all { it != posHero }){
                    posHero++
                    player?.andar(RIGHT)
                }else "Impossível se movimentar"
            }
            R.id.btn_left -> {
                if(listOf(0,6,12,18,24,30).all { it != posHero }){
                    posHero--
                    player?.andar(LEFT)
                }else "Impossível se movimentar"
            }
            R.id.btn_atirar ->{
                findViewById<Button>(R.id.btn_atirar).visibility = View.INVISIBLE
                findViewById<Button>(R.id.btn_atirarRight).visibility = View.VISIBLE
                findViewById<Button>(R.id.btn_atirarLeft).visibility = View.VISIBLE
                findViewById<Button>(R.id.btn_atirarUp).visibility = View.VISIBLE
                findViewById<Button>(R.id.btn_atirarDown).visibility = View.VISIBLE
                "Selecione a direção para atirar"
            }
            else -> ""
        }
        findViewById<ImageView>(arrayViews[posHero]).setImageResource(imgHero)
        findViewById<TextView>(R.id.txt_pontuacao).setText("Pontuação: " + player!!.pontuacao)
        findViewById<TextView>(R.id.txt_flexas).setText("Flexas: " + player!!.flechas)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        if(player!!.morreu){
            val dao = JogadorDAO(this)
            dao.inserirJogador(this.player!!)
            val it = Intent(this, ListarJogadores::class.java)
            startActivity(it)
        }
    }

}
