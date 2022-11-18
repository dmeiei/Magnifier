package kr.ac.hallym.dateandclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton

class SendSettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_setting)

        //여기서부터 끝까지 복사해서 다른 설명서 코틀린 파일에 붙여넣기 (복붙할때 변수랑 id수정, 페이지 넘기는 부분 수정)
        //변수에 버튼 아이디 연결
        val next_page = findViewById<AppCompatButton>(R.id.next)
        val back_page = findViewById<AppCompatButton>(R.id.back)
        //변수에 이미지 아이디 연결
        val send1 = findViewById<ImageView>(R.id.send1)
        val send2 = findViewById<ImageView>(R.id.send2)

        //다음 페이지 넘기기
        //페이지 넘기기 버튼 클릭시 실행되는 부분Q
        next_page.setOnClickListener {
            //send1이 보일때 send2 안보이게
            if(send1.visibility == View.VISIBLE){
                send1.visibility = View.INVISIBLE
                send2.visibility = View.VISIBLE
            }

        } //onCreate 끝나는 부분 주의

        //전 페이지로 돌아가기
        back_page.setOnClickListener {
            if(send2.visibility == View.VISIBLE){
                send2.visibility = View.INVISIBLE
                send1.visibility = View.VISIBLE

            }

        }
    }
}