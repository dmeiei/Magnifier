package kr.ac.hallym.dateandclock

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val game1Btn = findViewById<CardView>(R.id.game1_Btn)
        val game2Btn = findViewById<CardView>(R.id.game2_Btn)
        val game3Btn = findViewById<CardView>(R.id.game3_Btn)
        val game4Btn = findViewById<CardView>(R.id.game4_Btn)

        game1Btn.setOnClickListener {
            val intent2 = Intent(this, Game1Activity::class.java)
            startActivity(intent2)
        }

        game2Btn.setOnClickListener {
            val intent2 = Intent(this, Game2Activity::class.java)
            startActivity(intent2)
        }

        game3Btn.setOnClickListener {
            val intent2 = Intent(this, Game3Activity::class.java)
            startActivity(intent2)
        }
        game4Btn.setOnClickListener {
            val intent2 = Intent(this, Game4Activity::class.java)
            startActivity(intent2)
        }
    }
}