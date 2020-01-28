package emanuel.worldwumpus

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickAction(view: View){
        val btnClick = view as Button
        btn_jogar.visibility = View.VISIBLE
        btn_recorde.visibility = View.VISIBLE
        btn_6x6.visibility = View.INVISIBLE
        btn_9x9.visibility = View.INVISIBLE
        btn_12x12.visibility = View.INVISIBLE
        when(btnClick.id){
            R.id.btn_jogar -> {
                btn_jogar.visibility = View.INVISIBLE
                btn_recorde.visibility = View.INVISIBLE
                btn_6x6.visibility = View.VISIBLE
                btn_9x9.visibility = View.VISIBLE
                btn_12x12.visibility = View.VISIBLE
            }
            R.id.btn_recorde -> {
                val it = Intent(this, ListarJogadores::class.java)
                startActivity(it)
            }
            R.id.btn_6x6 -> {
                val it = Intent(this, Plataforma6x6::class.java)
                startActivity(it)
            }
            R.id.btn_9x9 ->{
                val it = Intent(this, Plataforma9x9::class.java)
                startActivity(it)
            }
            R.id.btn_12x12 ->{
                val it = Intent(this, Plataforma12x12::class.java)
                startActivity(it)
            }
        }
    }
}
