package kr.ac.hallym.dateandclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton

class PicSettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pic_setting)

        //여기서부터 끝까지 복사해서 다른 설명서 코틀린 파일에 붙여넣기 (복붙할때 변수랑 id수정, 페이지 넘기는 부분 수정)
        //변수에 버튼 아이디 연결
        val next_page = findViewById<AppCompatButton>(R.id.next)
        val back_page = findViewById<AppCompatButton>(R.id.back)
        //변수에 이미지 아이디 연결
        val pic1 = findViewById<ImageView>(R.id.pic1)
        val pic2 = findViewById<ImageView>(R.id.pic2)
        val pic3 = findViewById<ImageView>(R.id.pic3)

        //다음 페이지 넘기기
        //페이지 넘기기 버튼 클릭시 실행되는 부분Q
        next_page.setOnClickListener {
            //lock1이 보일때 lock1,3 안보이게하고 2보이게
            if(pic1.visibility == View.VISIBLE){
                pic1.visibility = View.INVISIBLE
                pic2.visibility = View.VISIBLE
                pic3.visibility = View.INVISIBLE
            }
            //lock2가 보일 때 1,2 안보이게하고 3보이게
            else if(pic2.visibility == View.VISIBLE){
                pic1.visibility = View.INVISIBLE
                pic2.visibility = View.INVISIBLE
                pic3.visibility = View.VISIBLE
            }

        } //onCreate 끝나는 부분 주의

        //전 페이지로 돌아가기
        back_page.setOnClickListener {
            if(pic2.visibility == View.VISIBLE){
                pic2.visibility = View.INVISIBLE
                pic1.visibility = View.VISIBLE
                pic3.visibility = View.INVISIBLE
            }
            else if(pic3.visibility == View.VISIBLE){
                pic3.visibility = View.INVISIBLE
                pic1.visibility = View.INVISIBLE
                pic2.visibility = View.VISIBLE
            }
        }
    }
}