package emanuel.worldwumpus

import Jogador
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_plataforma6x6.*
import kotlinx.android.synthetic.main.activity_plataforma9x9.*

class Plataforma9x9 : AppCompatActivity() {

    private var posHero = 0
    var player: Jogador? = null
    private var imgHero = R.drawable.img_player
    private var imgLocalVisitado = R.drawable.img_localVisitado
    val arrayViews = arrayOf(R.id.i1, R.id.i2, R.id.i3, R.id.i4, R.id.i5, R.id.i6, R.id.i7, R.id.i8, R.id.i9,
        R.id.i10, R.id.i11, R.id.i12, R.id.i13, R.id.i14, R.id.i15, R.id.i16, R.id.i17, R.id.i18,
        R.id.i19, R.id.i20, R.id.i21, R.id.i22, R.id.i23, R.id.i24, R.id.i25, R.id.i26, R.id.i27,
        R.id.i28, R.id.i29, R.id.i30, R.id.i31, R.id.i32, R.id.i33, R.id.i34, R.id.i35, R.id.i36,
        R.id.i37, R.id.i38, R.id.i39, R.id.i40, R.id.i41, R.id.i42, R.id.i43, R.id.i44, R.id.i45,
        R.id.i46, R.id.i47, R.id.i48, R.id.i49, R.id.i50, R.id.i51, R.id.i52, R.id.i53, R.id.i54,
        R.id.i55, R.id.i56, R.id.i57, R.id.i58, R.id.i59, R.id.i60, R.id.i61, R.id.i62, R.id.i63,
        R.id.i64, R.id.i65, R.id.i66, R.id.i67, R.id.i68, R.id.i69, R.id.i70, R.id.i71, R.id.i72,
        R.id.i73, R.id.i74, R.id.i75, R.id.i76, R.id.i77, R.id.i78, R.id.i79, R.id.i80, R.id.i81)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plataforma9x9)
    }


    fun clickSair9(view: View){
        val it = Intent(this, MainActivity::class.java)
        startActivity(it)
    }

    fun clickJogar9(view: View){
        if(edt_jogador9.text.toString().equals("")){
            Toast.makeText(this, "Informe o nome do JOGADOR", Toast.LENGTH_LONG).show()
        }else{
            findViewById<EditText>(R.id.edt_jogador9).visibility = View.INVISIBLE
            findViewById<Button>(R.id.btn_ok9).visibility = View.INVISIBLE
            findViewById<Button>(R.id.btn_up9).visibility = View.VISIBLE
            findViewById<Button>(R.id.btn_down9).visibility = View.VISIBLE
            findViewById<Button>(R.id.btn_left9).visibility = View.VISIBLE
            findViewById<Button>(R.id.btn_right9).visibility = View.VISIBLE
            this.player = Jogador(edt_jogador9.text.toString(), 9)
        }
    }

    fun clickAtirar9(view: View){
        val btn = view as Button
        val msg = when (btn.id) {
            R.id.btn_atirarDown9 -> player?.atirar(DOWN)
            R.id.btn_atirarUp9 -> player?.atirar(UP)
            R.id.btn_atirarLeft9 -> player?.atirar(LEFT)
            R.id.btn_atirarRight9 -> player?.atirar(RIGHT)
            else -> ""
        }
        findViewById<Button>(R.id.btn_atirar9).visibility = View.VISIBLE
        findViewById<Button>(R.id.btn_atirarRight9).visibility = View.INVISIBLE
        findViewById<Button>(R.id.btn_atirarLeft9).visibility = View.INVISIBLE
        findViewById<Button>(R.id.btn_atirarUp9).visibility = View.INVISIBLE
        findViewById<Button>(R.id.btn_atirarDown9).visibility = View.INVISIBLE
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun jogo9x9(view: View){

        val btnClick = view as Button
        findViewById<ImageView>(arrayViews[posHero]).setImageResource(imgLocalVisitado)
        val msg = when(btnClick.id){
            R.id.btn_down9 ->{
                if(posHero <= 71){
                    posHero += 9
                    player?.andar(DOWN)
                }else "Impossível se movimentar"
            }
            R.id.btn_up9 -> {
                if(posHero >= 9){
                    posHero -= 9
                    player?.andar(UP)
                }else "Impossível se movimentar"
            }
            R.id.btn_right9 -> {
                if(listOf(8,17,26,35,44,53,62,71,80).all { it != posHero }){
                    posHero++
                    player?.andar(RIGHT)
                }else "Impossível se movimentar"
            }
            R.id.btn_left9 -> {
                if(listOf(0,9,18,27,36,45,54,63,72).all { it != posHero }){
                    posHero--
                    player?.andar(LEFT)
                }else "Impossível se movimentar"
            }
            R.id.btn_atirar9 ->{
                findViewById<Button>(R.id.btn_atirar9).visibility = View.INVISIBLE
                findViewById<Button>(R.id.btn_atirarRight9).visibility = View.VISIBLE
                findViewById<Button>(R.id.btn_atirarLeft9).visibility = View.VISIBLE
                findViewById<Button>(R.id.btn_atirarUp9).visibility = View.VISIBLE
                findViewById<Button>(R.id.btn_atirarDown9).visibility = View.VISIBLE
                "Selecione a direção para atirar"
            }
            else -> ""
        }
        findViewById<ImageView>(arrayViews[posHero]).setImageResource(imgHero)
        findViewById<TextView>(R.id.txt_pontuacao9).setText("Pontuação: " + player!!.pontuacao)
        findViewById<TextView>(R.id.txt_flexas9).setText("Flexas: " + player!!.flechas)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        if(player!!.morreu){
            val dao = JogadorDAO(this)
            dao.inserirJogador(this.player!!)
            val it = Intent(this, ListarJogadores::class.java)
            startActivity(it)
        }
    }

}
