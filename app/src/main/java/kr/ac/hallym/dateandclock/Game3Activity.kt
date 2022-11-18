package kr.ac.hallym.dateandclock

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class Game3Activity: AppCompatActivity(){
    lateinit var requestText: EditText
    lateinit var lifeCountText: TextView
    lateinit var resultText: TextView
    lateinit var startBtn: Button
    lateinit var answerBtn: Button
    lateinit var resetBtn: Button

    //랜덤값
    private var randomNumber = 0

    //최저값
    var min = 0

    //최대값
    var max = 100

    //기회횟수
    var lifeCount = 10

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game3)

        //텍스트 입력
        requestText = findViewById(R.id.answerText)
        //기회횟수
        lifeCountText = findViewById(R.id.CountText)
        //결과텍스트
        resultText = findViewById(R.id.ResultText)
        //시작버튼
        startBtn = findViewById(R.id.StartBtn)
        //정답버튼
        answerBtn = findViewById(R.id.AnswerBtn)
        //초기화버튼
        resetBtn = findViewById(R.id.ResetBtn)

        //화면설정
        viewMode("end")

        //기회횟수 보여주기
        showLifeCount(lifeCount)

        //시작 버튼 이벤트
        startBtn.setOnClickListener {
            viewMode("start")

            toastMessage("시작")

            //랜덤 숫자 생성
            createRandomNumber()
        }

        //정답 버튼 이벤트
        answerBtn.setOnClickListener {
            var inPutNumber: String = requestText.text.toString()

            //입력값 체크
            if(inPutNumber == ""){
                toastMessage("값을 입력해주세요")
            }
            else{
                //값이 있으면 숫자 비교
                numberCheck(inPutNumber)
            }
        }

        //초기화 버튼 이벤트
        resetBtn.setOnClickListener {
            reset()
            viewMode("end")
        }


    }

    //랜덤 숫자 생성
    private fun createRandomNumber(){
        //랜덤숫자 1 ~ 100 사이 생성
        randomNumber = Random.nextInt(100)+1
    }

    //화면구조 mode: start: 시작, end: 쉬는중
    @RequiresApi(Build.VERSION_CODES.M)
    private fun viewMode(mode: String) {
        if(mode == "start"){
            //활성화 설정
            startBtn.isEnabled = false
            requestText.isEnabled = true
            answerBtn.isEnabled = true
            resetBtn.isEnabled = true

            //색상설정
            startBtn.setBackgroundColor(getColor(android.R.color.darker_gray))
            answerBtn.setBackgroundColor(getColor(android.R.color.holo_green_light))
            resetBtn.setBackgroundColor(getColor(android.R.color.holo_green_light))

        }
        else if(mode == "end"){
            //활성화 설정
            startBtn.isEnabled = true
            requestText.isEnabled = false
            answerBtn.isEnabled = false
            resetBtn.isEnabled = false

            //색상설정
            startBtn.setBackgroundColor(getColor(android.R.color.holo_green_light))
            answerBtn.setBackgroundColor(getColor(android.R.color.darker_gray))
            resetBtn.setBackgroundColor(getColor(android.R.color.darker_gray))
        }
    }

    //초기화
    private fun reset(){
        min = 1
        max = 100
        lifeCount = 10

        //기회횟수
        showLifeCount(lifeCount)

        //결과 텍스트
        resultText.text = ""
    }

    //기회 횟수 보여주기
    private fun showLifeCount(lifeCount: Int) {
        lifeCountText.text = "기회가 $lifeCount 번 남았습니다"
    }

    //숫자 비교
    @RequiresApi(Build.VERSION_CODES.M)
    private fun numberCheck(minPutNumber: String) {
        //기회횟수 감소
        --lifeCount

        //변경된 기회횟수 보여주기
        showLifeCount(lifeCount)

        var inputNumber = minPutNumber.toInt()

        //1.입력값이 정답보다 크다
        if(inputNumber > randomNumber){
            max = inputNumber

            resultText.text = "입력값이 정답보다 큽니다. \n정답범위:$min~$max"
        }
        //2.입력값이 정답보다 작다
        else if(inputNumber < randomNumber){
            min = inputNumber

            resultText.text = "입력값이 정답보다 작습니다. \n정답범위:$min~$max"
        }//3.입력값이 정답이다
        else if(inputNumber == randomNumber){
            toastMessage("정답입니다.")

            resultText.text = "정답: $inputNumber"

            val li3 = findViewById<LinearLayout>(R.id.correct_3)

            li3.visibility = View.VISIBLE
            li3.setOnClickListener {
                li3.visibility = View.INVISIBLE
            }
        }
        //기회횟수 = 0
        if(lifeCount == 0){
            toastMessage("기회를 모두 소진하셨습니다.")
            resultText.text = "기회를 모두 소진하셨습니다."

            reset()

            viewMode("end")
        }
    }
    //메세지 알림
    private fun toastMessage(message: String) {
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }

}