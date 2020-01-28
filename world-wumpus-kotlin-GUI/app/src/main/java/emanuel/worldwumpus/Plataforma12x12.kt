package emanuel.worldwumpus


import Jogador
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_plataforma12x12.*

class Plataforma12x12 : AppCompatActivity() {

    val DOWN = 2
    val UP = 8
    val RIGHT = 6
    val LEFT = 4

    private var posHero = 0
    var player: Jogador? = null
    private var imgHero = R.drawable.img_player
    private var imgLocalVisitado = R.drawable.img_localVisitado
    val arrayViews = arrayOf(R.id.m1, R.id.m2, R.id.m3, R.id.m4, R.id.m5, R.id.m6, R.id.m7, R.id.m8, R.id.m9, R.id.m10, R.id.m11, R.id.m12,
        R.id.m13,R.id.m14, R.id.m15, R.id.m16, R.id.m17, R.id.m18, R.id.m19, R.id.m20, R.id.m21, R.id.m22, R.id.m23, R.id.m24,
        R.id.m25, R.id.m26, R.id.m27, R.id.m28, R.id.m29, R.id.m30, R.id.m31, R.id.m32, R.id.m33, R.id.m34, R.id.m35, R.id.m36,
        R.id.m37, R.id.m38, R.id.m39, R.id.m40, R.id.m41, R.id.m42, R.id.m43, R.id.m44, R.id.m45, R.id.m46, R.id.m47, R.id.m48,
        R.id.m49, R.id.m50, R.id.m51, R.id.m52, R.id.m53, R.id.m54, R.id.m55, R.id.m56, R.id.m57, R.id.m58, R.id.m59, R.id.m60,
        R.id.m61, R.id.m62, R.id.m63, R.id.m64, R.id.m65, R.id.m66, R.id.m67, R.id.m68, R.id.m69, R.id.m70, R.id.m71, R.id.m72,
        R.id.m73, R.id.m74, R.id.m75, R.id.m76, R.id.m77, R.id.m78, R.id.m79, R.id.m80, R.id.m81, R.id.m82, R.id.m83, R.id.m84,
        R.id.m85, R.id.m86, R.id.m87, R.id.m88, R.id.m89, R.id.m90, R.id.m91, R.id.m92, R.id.m93, R.id.m94, R.id.m95, R.id.m96,
        R.id.m97, R.id.m98, R.id.m99, R.id.m100, R.id.m101, R.id.m102, R.id.m103, R.id.m104, R.id.m105, R.id.m106, R.id.m107, R.id.m108,
        R.id.m109, R.id.m110, R.id.m111, R.id.m112, R.id.m113, R.id.m114, R.id.m115, R.id.m116, R.id.m117, R.id.m118, R.id.m119, R.id.m120,
        R.id.m121, R.id.m122, R.id.m123, R.id.m124, R.id.m125, R.id.m126, R.id.m127, R.id.m128, R.id.m129, R.id.m130, R.id.m131, R.id.m132,
        R.id.m133, R.id.m134, R.id.m135, R.id.m136, R.id.m137, R.id.m138, R.id.m139, R.id.m140, R.id.m141, R.id.m142, R.id.m143, R.id.m144)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plataforma12x12)
    }

    fun clickSair12(view: View){
        val it = Intent(this, MainActivity::class.java)
        startActivity(it)
    }

    fun clickJogar12(view: View){
        if(edt_jogador12.text.toString().equals("")){
            Toast.makeText(this, "Informe o nome do JOGADOR", Toast.LENGTH_LONG).show()
        }else{
            findViewById<EditText>(R.id.edt_jogador12).visibility = View.INVISIBLE
            findViewById<Button>(R.id.btn_ok12).visibility = View.INVISIBLE
            findViewById<Button>(R.id.btn_up12).visibility = View.VISIBLE
            findViewById<Button>(R.id.btn_down12).visibility = View.VISIBLE
            findViewById<Button>(R.id.btn_left12).visibility = View.VISIBLE
            findViewById<Button>(R.id.btn_right12).visibility = View.VISIBLE
            this.player = Jogador(edt_jogador12.text.toString(), 12)
        }
    }

    fun clickAtirar12(view: View){
        val btn = view as Button
        val msg = when (btn.id) {
            R.id.btn_atirarDown12 -> player?.atirar(DOWN)
            R.id.btn_atirarUp12 -> player?.atirar(UP)
            R.id.btn_atirarLeft12 -> player?.atirar(LEFT)
            R.id.btn_atirarRight12 -> player?.atirar(RIGHT)
            else -> ""
        }
        findViewById<Button>(R.id.btn_atirar12).visibility = View.VISIBLE
        findViewById<Button>(R.id.btn_atirarRight12).visibility = View.INVISIBLE
        findViewById<Button>(R.id.btn_atirarLeft12).visibility = View.INVISIBLE
        findViewById<Button>(R.id.btn_atirarUp12).visibility = View.INVISIBLE
        findViewById<Button>(R.id.btn_atirarDown12).visibility = View.INVISIBLE
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun jogo12x12(view: View){

        val btnClick = view as Button
        findViewById<ImageView>(arrayViews[posHero]).setImageResource(imgLocalVisitado)
        val msg = when(btnClick.id){
            R.id.btn_down12 ->{
                if(posHero <= 131){
                    posHero += 12
                    player?.andar(DOWN)
                }else "Impossível se movimentar"
            }
            R.id.btn_up12 -> {
                if(posHero >= 12){
                    posHero -= 12
                    player?.andar(UP)
                }else "Impossível se movimentar"
            }
            R.id.btn_right12 -> {
                if(listOf(11, 23, 35, 47, 59, 71, 83, 95, 107, 119, 131, 143).all { it != posHero }){
                    posHero++
                    player?.andar(RIGHT)
                }else "Impossível se movimentar"
            }
            R.id.btn_left12 -> {
                if(listOf(0, 12, 24, 36, 48, 60, 72, 84, 96, 108, 120, 132).all { it != posHero }){
                    posHero--
                    player?.andar(LEFT)
                }else "Impossível se movimentar"
            }
            R.id.btn_atirar12 ->{
                findViewById<Button>(R.id.btn_atirar12).visibility = View.INVISIBLE
                findViewById<Button>(R.id.btn_atirarRight12).visibility = View.VISIBLE
                findViewById<Button>(R.id.btn_atirarLeft12).visibility = View.VISIBLE
                findViewById<Button>(R.id.btn_atirarUp12).visibility = View.VISIBLE
                findViewById<Button>(R.id.btn_atirarDown12).visibility = View.VISIBLE
                "Selecione a direção para atirar"
            }
            else -> ""
        }
        findViewById<ImageView>(arrayViews[posHero]).setImageResource(imgHero)
        findViewById<TextView>(R.id.txt_pontuacao12).setText("Pontuação: " + player!!.pontuacao)
        findViewById<TextView>(R.id.txt_flexas12).setText("Flexas: " + player!!.flechas)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        if(player!!.morreu){
            val dao = JogadorDAO(this)
            dao.inserirJogador(this.player!!)
            val it = Intent(this, ListarJogadores::class.java)
            startActivity(it)
        }
    }
}
