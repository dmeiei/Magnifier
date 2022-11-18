package kr.ac.hallym.dateandclock

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Game1Activity : AppCompatActivity(), View.OnClickListener{
    //버튼 리스트
    private val buttons: Array<ImageButton?> = arrayOfNulls<ImageButton>(16)

    //카드 리스트
    private lateinit var cards: ArrayList<MemoryCard>

    //이미지 리스트
    private lateinit var imageList:ArrayList<Int>

    //이전 카드 위치
    private var preCardPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game1)

        //초기화
        val resetBtn: Button = findViewById(R.id.reset_button)
        resetBtn.setOnClickListener{
            //셋팅
            init()

        }
        //셋팅
        init()
    }

    //셋팅 함수
    private fun init(){
        //이미지 리스트 초기화
        imageList =  ArrayList()

        //카드 리스트 초기화
        cards = ArrayList()

        //리스트 데이터 입력
        imageList.add(R.drawable.animal)
        imageList.add(R.drawable.apple)
        imageList.add(R.drawable.ball)
        imageList.add(R.drawable.snowball)
        imageList.add(R.drawable.heart)
        imageList.add(R.drawable.pencil)
        imageList.add(R.drawable.bell)
        imageList.add(R.drawable.sun)
        //
        imageList.add(R.drawable.animal)
        imageList.add(R.drawable.apple)
        imageList.add(R.drawable.ball)
        imageList.add(R.drawable.snowball)
        imageList.add(R.drawable.heart)
        imageList.add(R.drawable.pencil)
        imageList.add(R.drawable.bell)
        imageList.add(R.drawable.sun)

        //순서섞기
        imageList.shuffle()

        for((index, item)in buttons.withIndex()){

            //버튼 아이디
            val buttonID = "imageBtn${index}"

            //리소스 아이디
            val resource: Int = resources.getIdentifier(buttonID,"id",packageName)

            //버튼 초기화
            buttons[index] = findViewById(resource)

            //각 버튼에 클릭 이벤트 적용
            buttons[index]?.setOnClickListener(this)

            //카드 리스트에 데이터 담기
            cards.add(MemoryCard(imageList[index],false,false))

            //버튼에 기본 이미지 변경
            buttons[index]?.setImageResource(R.drawable.question)
        }

    }

    //    클릭 이벤트
    override fun onClick(view: View?) {

        //view id 가져오기
        val id: Int? = view?.id

        //위치 변수
        var position: Int = 0

        when(id){
            R.id.imageBtn0 -> position =0
            R.id.imageBtn1 -> position =1
            R.id.imageBtn2 -> position =2
            R.id.imageBtn3 -> position =3
            R.id.imageBtn4 -> position =4
            R.id.imageBtn5 -> position =5
            R.id.imageBtn6 -> position =6
            R.id.imageBtn7 -> position =7
            R.id.imageBtn8 -> position =8
            R.id.imageBtn9 -> position =9
            R.id.imageBtn10 -> position =10
            R.id.imageBtn11 -> position =11
            R.id.imageBtn12 -> position =12
            R.id.imageBtn13 -> position =13
            R.id.imageBtn14 -> position =14
            R.id.imageBtn15 -> position =15
        }

        //업데이트 모델
        updateModel(position)
        //업데이트 뷰
        updateView(position)

    }
    //업데이트 모델
    private fun updateModel(position : Int){
        var card: MemoryCard = cards[position]

        //나중에 카드비교할때 뒤집고 다시 클릭하는거 방지
        if(card.isFaceUp){
            return
        }
        //뒤집힌 카드: 이전에 뒤집힌 카드 0또는 2개일때
        if(preCardPosition==-1){

            //카드 초기화
            restoreCard()

            //위치 저장
            preCardPosition = position
        }
        //이전에 뒤집힌 카드 1개일떄
        else{
            checkForMatch(preCardPosition,position)
            preCardPosition = -1
        }

        //반대의 값을 넣는다 앞면-> 뒷면, 뒷면-> 앞면
        cards[position].isFaceUp = !card.isFaceUp
    }
    //업데이트 뷰
    private fun updateView(position : Int){
        var card: MemoryCard = cards[position]

        //뒤집었다면 랜덤이미지 보여줌
        if(card.isFaceUp){
            buttons[position]?.setImageResource(card.imageId)
        }
        else{
            //기본이미지
            buttons[position]?.setImageResource(R.drawable.question)
        }
    }
    //카드 초기화
    private fun restoreCard(){
        for((index,item) in cards.withIndex()){
            //매치되지 않은거
            if(!cards[index].isMatched){
                //이미지 앞으로
                buttons[index]?.setImageResource(R.drawable.question)

                //데이터 수정
                cards[index].isFaceUp = false
            }
        }

    }

    //카드 이미지 비교 prePosition = 이전 카드위치 position = 현재 카드위치
    private fun checkForMatch(prePostion: Int, position: Int){
        if(cards[prePostion].imageId == cards[position].imageId){
            //맞았을때 그림 보이기

            //매치 변경
            cards[prePostion].isMatched = true
            cards[position].isMatched = true

            //완료체크
            checkCompletion()
        }
        else{
        }

    }

    //완료체크
    private fun checkCompletion(){
        val li1 = findViewById<LinearLayout>(R.id.correct)
        var count: Int = 0

        for((index,item)in cards.withIndex()){
            if(cards[index].isMatched){
                count++
            }
        }
        //매치갯수가 카드갯수가 같다면 완료
        if(count==cards.size){
            //완료 그림 보이기
            li1.visibility = View.VISIBLE
            li1.setOnClickListener {
                li1.visibility = View.INVISIBLE
            }
        }
    }
}