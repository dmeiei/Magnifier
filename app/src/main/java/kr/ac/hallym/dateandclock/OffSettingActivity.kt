package kr.ac.hallym.dateandclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton

class OffSettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_off_setting)

        //여기서부터 끝까지 복사해서 다른 설명서 코틀린 파일에 붙여넣기 (복붙할때 변수랑 id수정, 페이지 넘기는 부분 수정)
        //변수에 버튼 아이디 연결
        val next_page = findViewById<AppCompatButton>(R.id.next)
        val back_page = findViewById<AppCompatButton>(R.id.back)
        //변수에 이미지 아이디 연결
        val off1 = findViewById<ImageView>(R.id.off1)
        val off2 = findViewById<ImageView>(R.id.off2)
        val off3 = findViewById<ImageView>(R.id.off3)

        //다음 페이지 넘기기
        //페이지 넘기기 버튼 클릭시 실행되는 부분Q
        next_page.setOnClickListener {
            //off1이 보일때 off1,3 안보이게하고 2보이게
            if(off1.visibility == View.VISIBLE){
                off1.visibility = View.INVISIBLE
                off2.visibility = View.VISIBLE
                off3.visibility = View.INVISIBLE
            }
            //off2가 보일 때 1,2 안보이게하고 3보이게
            else if(off2.visibility == View.VISIBLE){
                off1.visibility = View.INVISIBLE
                off2.visibility = View.INVISIBLE
                off3.visibility = View.VISIBLE
            }

        } //onCreate 끝나는 부분 주의

        //전 페이지로 돌아가기
        back_page.setOnClickListener {
            if(off2.visibility == View.VISIBLE){
                off2.visibility = View.INVISIBLE
                off1.visibility = View.VISIBLE
                off3.visibility = View.INVISIBLE
            }
            else if(off3.visibility == View.VISIBLE){
                off3.visibility = View.INVISIBLE
                off1.visibility = View.INVISIBLE
                off2.visibility = View.VISIBLE
            }
        }
    }
}