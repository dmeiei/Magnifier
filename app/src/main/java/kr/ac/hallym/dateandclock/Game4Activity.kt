package kr.ac.hallym.dateandclock

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Game4Activity : AppCompatActivity(){

    //색깔 리스트 생성
    private lateinit var colorList: ArrayList<Int>

    lateinit var qText: TextView

    private var randomcolor = 0
    private var color_count = 0

    lateinit var c_resetBtn: Button
    lateinit var c_startBtn: Button
    lateinit var cBtn1: Button
    lateinit var cBtn2: Button
    lateinit var cBtn3: Button
    lateinit var cBtn4: Button
    lateinit var cBtn5: Button
    lateinit var cBtn6: Button
    lateinit var cBtn7: Button
    lateinit var cBtn8: Button
    lateinit var cBtn9: Button

    var is_correct = true
    var count_answer = 0

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coloring_game)
        //기회횟수
        qText = findViewById(R.id.QuestionText)
        //초기화버튼
        c_resetBtn = findViewById(R.id.c_resetBtn)
        c_startBtn = findViewById(R.id.c_startBtn)

        cBtn1 = findViewById(R.id.c_Btn0)
        cBtn2 = findViewById(R.id.c_Btn1)
        cBtn3 = findViewById(R.id.c_Btn2)
        cBtn4 = findViewById(R.id.c_Btn3)
        cBtn5 = findViewById(R.id.c_Btn4)
        cBtn6 = findViewById(R.id.c_Btn5)
        cBtn7 = findViewById(R.id.c_Btn6)
        cBtn8 = findViewById(R.id.c_Btn7)
        cBtn9 = findViewById(R.id.c_Btn8)

        c_viewMode("end")

        c_startBtn.setOnClickListener {
            c_viewMode("start")
        }
        c_resetBtn.setOnClickListener {
            color_quistion()
            reset_color()
            btn_set()
        }
        cBtn1.setOnClickListener {
            check_answer(0)
            if(is_correct){
                cBtn1.alpha = 1.0f
            }
        }
        cBtn2.setOnClickListener {
            check_answer(1)
        }
        cBtn3.setOnClickListener {
            check_answer(2)
        }
        cBtn4.setOnClickListener {
            check_answer(3)
        }
        cBtn5.setOnClickListener {
            check_answer(4)
        }
        cBtn6.setOnClickListener {
            check_answer(5)
        }
        cBtn7.setOnClickListener {
            check_answer(6)
        }
        cBtn8.setOnClickListener {
            check_answer(7)
        }
        cBtn9.setOnClickListener {
            check_answer(8)
        }

    }


    //문제색깔 리스트 초기화후 순서섞기
    private fun reset_color() {
        //색깔 리스트 초기화
        colorList = ArrayList()

        count_answer = 0

        //리스트 데이터 입력
        colorList.add(1)
        colorList.add(2)
        colorList.add(3)
        colorList.add(4)
        colorList.add(5)
        colorList.add(6)
        colorList.add(7)
        colorList.add(Random.nextInt(7)+1)
        colorList.add(Random.nextInt(7)+1)


        //순서섞기
        colorList.shuffle()
        for(i in 0..8){
            Log.d("list${i}",colorList[i].toString())
        }

    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun btn_set(){
        for (index in 0..8){
            btn_color_set(index)
        }
    }
    //버튼 랜덤색깔지정
    @RequiresApi(Build.VERSION_CODES.M)
    private fun btn_color_set(index: Int){
        //버튼 변수선언
        val cBtn1 = findViewById<Button>(R.id.c_Btn0)
        val cBtn2 = findViewById<Button>(R.id.c_Btn1)
        val cBtn3 = findViewById<Button>(R.id.c_Btn2)
        val cBtn4 = findViewById<Button>(R.id.c_Btn3)
        val cBtn5 = findViewById<Button>(R.id.c_Btn4)
        val cBtn6 = findViewById<Button>(R.id.c_Btn5)
        val cBtn7 = findViewById<Button>(R.id.c_Btn6)
        val cBtn8 = findViewById<Button>(R.id.c_Btn7)
        val cBtn9 = findViewById<Button>(R.id.c_Btn8)

        if(index==0){
            if(colorList[index]==1){
                cBtn1.setBackgroundColor(getColor(android.R.color.holo_red_dark))
            }
            else if(colorList[index]==2){
                cBtn1.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
            }
            else if(colorList[index]==3){
                cBtn1.setBackgroundColor(getColor(android.R.color.holo_green_light))
            }
            else if(colorList[index]==4){
                cBtn1.setBackgroundColor(getColor(android.R.color.holo_orange_dark))
            }
            else if(colorList[index]==5){
                cBtn1.setBackgroundColor(getColor(android.R.color.holo_purple))
            }
            else if(colorList[index]==6){
                cBtn1.setBackgroundColor(getColor(android.R.color.darker_gray))
            }
            else if(colorList[index]==7){
                cBtn1.setBackgroundColor(getColor(android.R.color.black))
            }
        }
        else if(index==1) {
            if (colorList[index] == 1) {
                cBtn2.setBackgroundColor(getColor(android.R.color.holo_red_dark))
            } else if (colorList[index] == 2) {
                cBtn2.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
            } else if (colorList[index] == 3) {
                cBtn2.setBackgroundColor(getColor(android.R.color.holo_green_light))
            } else if (colorList[index] == 4) {
                cBtn2.setBackgroundColor(getColor(android.R.color.holo_orange_dark))
            } else if (colorList[index] == 5) {
                cBtn2.setBackgroundColor(getColor(android.R.color.holo_purple))
            } else if (colorList[index] == 6) {
                cBtn2.setBackgroundColor(getColor(android.R.color.darker_gray))
            } else if (colorList[index] == 7) {
                cBtn2.setBackgroundColor(getColor(android.R.color.black))
            }
        }
        else if(index==2) {
            if (colorList[index] == 1) {
                cBtn3.setBackgroundColor(getColor(android.R.color.holo_red_dark))
            } else if (colorList[index] == 2) {
                cBtn3.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
            } else if (colorList[index] == 3) {
                cBtn3.setBackgroundColor(getColor(android.R.color.holo_green_light))
            } else if (colorList[index] == 4) {
                cBtn3.setBackgroundColor(getColor(android.R.color.holo_orange_dark))
            } else if (colorList[index] == 5) {
                cBtn3.setBackgroundColor(getColor(android.R.color.holo_purple))
            } else if (colorList[index] == 6) {
                cBtn3.setBackgroundColor(getColor(android.R.color.darker_gray))
            } else if (colorList[index] == 7) {
                cBtn3.setBackgroundColor(getColor(android.R.color.black))
            }
        }
        else if(index==3) {
            if (colorList[index] == 1) {
                cBtn4.setBackgroundColor(getColor(android.R.color.holo_red_dark))
            } else if (colorList[index] == 2) {
                cBtn4.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
            } else if (colorList[index] == 3) {
                cBtn4.setBackgroundColor(getColor(android.R.color.holo_green_light))
            } else if (colorList[index] == 4) {
                cBtn4.setBackgroundColor(getColor(android.R.color.holo_orange_dark))
            } else if (colorList[index] == 5) {
                cBtn4.setBackgroundColor(getColor(android.R.color.holo_purple))
            } else if (colorList[index] == 6) {
                cBtn4.setBackgroundColor(getColor(android.R.color.darker_gray))
            } else if (colorList[index] == 7) {
                cBtn4.setBackgroundColor(getColor(android.R.color.black))
            }
        }
        else if(index==4) {
            if (colorList[index] == 1) {
                cBtn5.setBackgroundColor(getColor(android.R.color.holo_red_dark))
            } else if (colorList[index] == 2) {
                cBtn5.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
            } else if (colorList[index] == 3) {
                cBtn5.setBackgroundColor(getColor(android.R.color.holo_green_light))
            } else if (colorList[index] == 4) {
                cBtn5.setBackgroundColor(getColor(android.R.color.holo_orange_dark))
            } else if (colorList[index] == 5) {
                cBtn5.setBackgroundColor(getColor(android.R.color.holo_purple))
            } else if (colorList[index] == 6) {
                cBtn5.setBackgroundColor(getColor(android.R.color.darker_gray))
            } else if (colorList[index] == 7) {
                cBtn5.setBackgroundColor(getColor(android.R.color.black))
            }
        }
        else if(index==5) {
            if (colorList[index] == 1) {
                cBtn6.setBackgroundColor(getColor(android.R.color.holo_red_dark))
            } else if (colorList[index] == 2) {
                cBtn6.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
            } else if (colorList[index] == 3) {
                cBtn6.setBackgroundColor(getColor(android.R.color.holo_green_light))
            } else if (colorList[index] == 4) {
                cBtn6.setBackgroundColor(getColor(android.R.color.holo_orange_dark))
            } else if (colorList[index] == 5) {
                cBtn6.setBackgroundColor(getColor(android.R.color.holo_purple))
            } else if (colorList[index] == 6) {
                cBtn6.setBackgroundColor(getColor(android.R.color.darker_gray))
            } else if (colorList[index] == 7) {
                cBtn6.setBackgroundColor(getColor(android.R.color.black))
            }
        }
        else if(index==6) {
            if (colorList[index] == 1) {
                cBtn7.setBackgroundColor(getColor(android.R.color.holo_red_dark))
            } else if (colorList[index] == 2) {
                cBtn7.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
            } else if (colorList[index] == 3) {
                cBtn7.setBackgroundColor(getColor(android.R.color.holo_green_light))
            } else if (colorList[index] == 4) {
                cBtn7.setBackgroundColor(getColor(android.R.color.holo_orange_dark))
            } else if (colorList[index] == 5) {
                cBtn7.setBackgroundColor(getColor(android.R.color.holo_purple))
            } else if (colorList[index] == 6) {
                cBtn7.setBackgroundColor(getColor(android.R.color.darker_gray))
            } else if (colorList[index] == 7) {
                cBtn7.setBackgroundColor(getColor(android.R.color.black))
            }
        }
        else if(index==7) {
            if (colorList[index] == 1) {
                cBtn8.setBackgroundColor(getColor(android.R.color.holo_red_dark))
            } else if (colorList[index] == 2) {
                cBtn8.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
            } else if (colorList[index] == 3) {
                cBtn8.setBackgroundColor(getColor(android.R.color.holo_green_light))
            } else if (colorList[index] == 4) {
                cBtn8.setBackgroundColor(getColor(android.R.color.holo_orange_dark))
            } else if (colorList[index] == 5) {
                cBtn8.setBackgroundColor(getColor(android.R.color.holo_purple))
            } else if (colorList[index] == 6) {
                cBtn8.setBackgroundColor(getColor(android.R.color.darker_gray))
            } else if (colorList[index] == 7) {
                cBtn8.setBackgroundColor(getColor(android.R.color.black))
            }
        }
        else if(index==8){
            if(colorList[index]==1){
                cBtn9.setBackgroundColor(getColor(android.R.color.holo_red_dark))
            }
            else if(colorList[index]==2){
                cBtn9.setBackgroundColor(getColor(android.R.color.holo_blue_dark))
            }
            else if(colorList[index]==3){
                cBtn9.setBackgroundColor(getColor(android.R.color.holo_green_light))
            }else if(colorList[index]==4){
                cBtn9.setBackgroundColor(getColor(android.R.color.holo_orange_dark))
            }
            else if(colorList[index]==5){
                cBtn9.setBackgroundColor(getColor(android.R.color.holo_purple))
            }
            else if(colorList[index]==6){
                cBtn9.setBackgroundColor(getColor(android.R.color.darker_gray))
            }
            else if(colorList[index]==7){
                cBtn9.setBackgroundColor(getColor(android.R.color.black))
            }
        }
    }

    //문제 함수
    private fun color_quistion(){
        randomcolor = Random.nextInt(7)+1
        if(randomcolor == 1){
            qText.text = "빨강"
        }
        else if(randomcolor == 2){
            qText.text = "파랑"
        }
        else if(randomcolor == 3){
            qText.text = "초록"
        }
        else if(randomcolor == 4){
            qText.text = "주황"
        }
        else if(randomcolor == 5){
            qText.text = "보라"
        }
        else if(randomcolor == 6){
            qText.text = "회색"
        }
        else if(randomcolor == 7){
            qText.text = "검정"
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun check_answer(index: Int) {
        if (colorList[index]==randomcolor){
            is_correct = true
            count_answer +=1
            check_end()
        }
        else if (colorList[index]!=randomcolor){
            is_correct = false
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun check_end(){
        val c_li = findViewById<LinearLayout>(R.id.c_correct)
        color_count = 0
        for (i in 0..8){
            if(colorList[i]==randomcolor){
                color_count++
            }
        }
        Log.d("color_count",color_count.toString())
        if(count_answer==color_count){
            c_viewMode("end")
            c_li.visibility = View.VISIBLE
            c_li.setOnClickListener {
                c_li.visibility = View.INVISIBLE
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    private fun c_viewMode(mode: String) {
        if(mode == "start"){
            c_startBtn.isEnabled = false
            c_resetBtn.isEnabled = true
            color_quistion()
            reset_color()
            btn_set()
        }
        else if(mode == "end"){
            c_startBtn.isEnabled = true
            c_resetBtn.isEnabled = false
            qText.text = ""
            cBtn1.setBackgroundColor(R.color.bottom_background_color)
            cBtn2.setBackgroundColor(R.color.bottom_background_color)
            cBtn3.setBackgroundColor(R.color.bottom_background_color)
            cBtn4.setBackgroundColor(R.color.bottom_background_color)
            cBtn5.setBackgroundColor(R.color.bottom_background_color)
            cBtn6.setBackgroundColor(R.color.bottom_background_color)
            cBtn7.setBackgroundColor(R.color.bottom_background_color)
            cBtn8.setBackgroundColor(R.color.bottom_background_color)
            cBtn9.setBackgroundColor(R.color.bottom_background_color)
        }
    }
}