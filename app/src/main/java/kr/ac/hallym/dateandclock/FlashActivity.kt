package kr.ac.hallym.dateandclock

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class FlashActivity:AppCompatActivity() {
    var isFlash = false


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashlight)

        val torch = Torch(this)

        val flashBtn = findViewById<ImageButton>(R.id.flash_btn)
        flashBtn.setOnClickListener {
            if(!isFlash){
                torch.flashOn()
                isFlash = true
            }else{
                torch.flashoff()
                isFlash = false
            }
        }
    }
}