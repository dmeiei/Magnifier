package kr.ac.hallym.dateandclock

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Game2Activity: AppCompatActivity(), View.OnClickListener{

    //버튼 리스트
    private val numbuttons: Array<Button?> = arrayOfNulls<Button>(16)

    //숫자 리스트
    private lateinit var numList:ArrayList<Int>

    //숫자 저장 리스트
    private lateinit var  numberList: ArrayList<MeMory_num>

    //이전 버튼 위치
    private var preBtnPosition: Int = 0

    private var prePosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.numburing_game)

        //리셋버튼
        val resetBtn: Button = findViewById(R.id.num_reset_button)
        resetBtn.setOnClickListener{
            //셋팅
            reset_num()

        }

        //셋팅
        reset_num()
    }

    //셋팅
    private fun reset_num(){
        //숫자 리스트 초기화
        numList =  ArrayList()

        //숫자 저장리스트 초기화
        numberList = ArrayList()

        //이전클릭변수 초기화
        preBtnPosition = -1

        prePosition = 0

        //리스트 데이터 입력
        numList.add(1)
        numList.add(2)
        numList.add(3)
        numList.add(4)
        numList.add(5)
        numList.add(6)
        numList.add(7)
        numList.add(8)
        numList.add(9)
        numList.add(10)
        numList.add(11)
        numList.add(12)
        numList.add(13)
        numList.add(14)
        numList.add(15)
        numList.add(16)

        //순서섞기
        numList.shuffle()

        for((index, item)in numbuttons.withIndex()){

            //버튼 아이디
            val numbuttonID = "numBtn${index}"

            //리소스 아이디
            val resource: Int = resources.getIdentifier(numbuttonID,"id",packageName)

            //버튼 초기화
            numbuttons[index] = findViewById(resource)

            //숫자 리스트 데이터 담기
            numberList.add(MeMory_num(numList[index],false,false))

            //각 버튼에 클릭 이벤트 적용
            numbuttons[index]?.setOnClickListener(this)

            //버튼에 숫자담기
            numbuttons[index]?.text= numList[index].toString()

            //버튼  alpha값 설정
            numbuttons[index]?.alpha = 1.0f

        }


    }

    override fun onClick(view: View?) {
        //view id 가져오기
        val id: Int? = view?.id

        //위치 변수
        var position: Int = 0

        when(id){
            R.id.numBtn0 -> position =0
            R.id.numBtn1 -> position =1
            R.id.numBtn2 -> position =2
            R.id.numBtn3 -> position =3
            R.id.numBtn4 -> position =4
            R.id.numBtn5 -> position =5
            R.id.numBtn6 -> position =6
            R.id.numBtn7 -> position =7
            R.id.numBtn8 -> position =8
            R.id.numBtn9 -> position =9
            R.id.numBtn10 -> position =10
            R.id.numBtn11 -> position =11
            R.id.numBtn12 -> position =12
            R.id.numBtn13 -> position =13
            R.id.numBtn14 -> position =14
            R.id.numBtn15 -> position =15
        }

        //update
        update_num(position)


    }

    //update
    private fun update_num(position: Int){
        var num: MeMory_num = numberList[position]
        //preBtnPosition = -1
        //처음 누른 버튼이 1인지 체크
        if(numList[position]==1){
            numbuttons[position]?.alpha = 0.1f
            preBtnPosition = position
        }

        else if(numList[position]!=1){
            Log.d("position", position.toString())
            Log.d("preposition", preBtnPosition.toString())
            checkModel(preBtnPosition,position)
        }
    }
    private fun checkModel(preBtnPosition:Int,position:Int){
        if(preBtnPosition==-1){
            reset_num()
        }
        else if((numList[preBtnPosition]+1) == numList[position]){
            numbuttons[position]?.alpha = 0.1f
            this@Game2Activity.preBtnPosition = position
            check_end()
        }
        else{
            reset_num()
        }
    }

    private fun check_end(){
        val li1 = findViewById<LinearLayout>(R.id.num_correct)

        if((numList[preBtnPosition])==16){
            li1.visibility = View.VISIBLE
            li1.setOnClickListener {
                li1.visibility = View.INVISIBLE
            }
        }
    }


}