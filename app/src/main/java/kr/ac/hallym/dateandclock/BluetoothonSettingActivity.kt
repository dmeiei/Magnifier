package kr.ac.hallym.dateandclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton

class BluetoothonSettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetoothon_setting)

        //여기서부터 끝까지 복사해서 다른 설명서 코틀린 파일에 붙여넣기 (복붙할때 변수랑 id수정, 페이지 넘기는 부분 수정)
        //변수에 버튼 아이디 연결
        val next_page = findViewById<AppCompatButton>(R.id.next)
        val back_page = findViewById<AppCompatButton>(R.id.back)
        //변수에 이미지 아이디 연결
        val bluetoothon1 = findViewById<ImageView>(R.id.bluetoothon1)
        val bluetoothon2 = findViewById<ImageView>(R.id.bluetoothon2)
        val bluetoothon3 = findViewById<ImageView>(R.id.bluetoothon3)

        //다음 페이지 넘기기
        //페이지 넘기기 버튼 클릭시 실행되는 부분Q
        next_page.setOnClickListener {
            //bluetoothon1이 보일때 bluetoothon1,3 안보이게하고 2보이게
            if(bluetoothon1.visibility == View.VISIBLE){
                bluetoothon1.visibility = View.INVISIBLE
                bluetoothon2.visibility = View.VISIBLE
                bluetoothon3.visibility = View.INVISIBLE
            }
            //bluetoothon2가 보일 때 1,2 안보이게하고 3보이게
            else if(bluetoothon2.visibility == View.VISIBLE){
                bluetoothon1.visibility = View.INVISIBLE
                bluetoothon2.visibility = View.INVISIBLE
                bluetoothon3.visibility = View.VISIBLE
            }

        } //onCreate 끝나는 부분 주의

        //전 페이지로 돌아가기
        back_page.setOnClickListener {
            if(bluetoothon2.visibility == View.VISIBLE){
                bluetoothon2.visibility = View.INVISIBLE
                bluetoothon1.visibility = View.VISIBLE
                bluetoothon3.visibility = View.INVISIBLE
            }
            else if(bluetoothon3.visibility == View.VISIBLE){
                bluetoothon3.visibility = View.INVISIBLE
                bluetoothon1.visibility = View.INVISIBLE
                bluetoothon2.visibility = View.VISIBLE
            }
        }
    }
}