package kr.ac.hallym.dateandclock

import android.content.Intent
import android.os.Bundle
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity

class ManualActivity: AppCompatActivity() {

    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var chapterList: List<String>
    private lateinit var topicList: HashMap<String, List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        activity_manual 과 연결
        setContentView(R.layout.activity_manual)

        //리스트뷰
        showList()

        listViewAdapter = ExpandableListViewAdapter(this, chapterList, topicList)

        val eListView1 = findViewById<ExpandableListView>(R.id.eListView)
        eListView1.setAdapter(listViewAdapter)

        //리스트 뷰 클릭시 실행되는 부분
        eListView1!!.setOnChildClickListener { _, _, i, i2, _ ->

            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "소리설정(미디어)"){
                val intent1 = Intent(this,SoundSettingActivity::class.java)
                startActivity(intent1)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "휴대폰 밝기조절"){
                val intent2 = Intent(this,LightSettingActivity::class.java)
                startActivity(intent2)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "글자 크기조절"){
                val intent3 = Intent(this,FontSettingActivity::class.java)
                startActivity(intent3)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "비행기모드 설정"){
                val intent4 = Intent(this,AirplaneSettingActivity::class.java)
                startActivity(intent4)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "화면 자동꺼짐 시간설정"){
                val intent5 = Intent(this,ScreenoffSettingActivity::class.java)
                startActivity(intent5)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "화면잠금 설정"){
                val intent6 = Intent(this,LockSettingActivity::class.java)
                startActivity(intent6)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "화면잠금 해제방법"){
                val intent7 = Intent(this,OffSettingActivity::class.java)
                startActivity(intent7)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "LTE 설정"){
                val intent8 = Intent(this,LteSettingActivity::class.java)
                startActivity(intent8)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "블루투스 켜기"){
                val intent9 = Intent(this,BluetoothonSettingActivity::class.java)
                startActivity(intent9)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "블루투스 연결"){
                val intent10 = Intent(this,BluetoothSettingActivity::class.java)
                startActivity(intent10)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "와이파이(WIFI)연결"){
                val intent11 = Intent(this,WifiSettingActivity::class.java)
                startActivity(intent11)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "내 전화번호"){
                val intent12 = Intent(this,PhoneSettingActivity::class.java)
                startActivity(intent12)
            }
            //if문들 추가
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "배터리 사용량"){
                val intent13 = Intent(this,BatterySettingActivity::class.java)
                startActivity(intent13)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "벨소리 설정"){
                val intent14 = Intent(this,RingSettingActivity::class.java)
                startActivity(intent14)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "통화볼륨 설정"){
                val intent15 = Intent(this,CallvolumeSettingActivity::class.java)
                startActivity(intent15)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "단축번호 등록"){
                val intent16 = Intent(this,SpeedSettingActivity::class.java)
                startActivity(intent16)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "전화 차단 방법"){
                val intent17 = Intent(this,BlockSettingActivity::class.java)
                startActivity(intent17)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "전화 거는 방법"){
                val intent18 = Intent(this,CallSettingActivity::class.java)
                startActivity(intent18)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "번호 저장 방법"){
                val intent19 = Intent(this,SaveSettingActivity::class.java)
                startActivity(intent19)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "번호 삭제 방법"){
                val intent20 = Intent(this,DeleteSettingActivity::class.java)
                startActivity(intent20)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "문자 보내는 방법"){
                val intent21 = Intent(this,MessagesendSettingActivity::class.java)
                startActivity(intent21)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "글씨 크기 설정"){
                val intent22 = Intent(this,MessagesizeSettingActivity::class.java)
                startActivity(intent22)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "스팸보관함 확인"){
                val intent23 = Intent(this,SpamSettingActivity::class.java)
                startActivity(intent23)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "메세지 보내는 방법"){
                val intent24 = Intent(this,SendSettingActivity::class.java)
                startActivity(intent24)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "사진 보내는 방법"){
                val intent25 = Intent(this,PicSettingActivity::class.java)
                startActivity(intent25)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "동영상 보내는 방법"){
                val intent26 = Intent(this,VidSettingActivity::class.java)
                startActivity(intent26)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "보이스톡 하는 방법"){
                val intent27 = Intent(this,VoiceSettingActivity::class.java)
                startActivity(intent27)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "메세지 전달 하는 방법"){
                val intent28 = Intent(this,PassSettingActivity::class.java)
                startActivity(intent28)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "로그인 방법"){
                val intent29 = Intent(this,LoginSettingActivity::class.java)
                startActivity(intent29)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "회원가입 방법"){
                val intent30 = Intent(this,NewSettingActivity::class.java)
                startActivity(intent30)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "영상 검색하는 방법"){
                val intent31 = Intent(this,SearchSettingActivity::class.java)
                startActivity(intent31)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "영상 크게 보는 방법"){
                val intent32 = Intent(this,BigSettingActivity::class.java)
                startActivity(intent32)
            }
            if(topicList[(chapterList as ArrayList<String>)[i]]!!.get(i2) == "영상 공유하는 방법"){
                val intent33 = Intent(this,ShareSettingActivity::class.java)
                startActivity(intent33)
            }






            false
        }


    } //onCreate 끝나는 부분

    //리스트뷰
    private fun showList(){
        chapterList = ArrayList()
        topicList = HashMap()

        //챕터
        (chapterList as ArrayList<String>).add("휴대폰 설정")
        (chapterList as ArrayList<String>).add("휴대전화 정보")
        (chapterList as ArrayList<String>).add("통화 설정안내")
        (chapterList as ArrayList<String>).add("문자 설정안내")
        (chapterList as ArrayList<String>).add("카카오톡 사용방법")
        (chapterList as ArrayList<String>).add("유튜브 사용방법")

        //세부내용1
        val topic1 : MutableList<String> = ArrayList()
        topic1.add("소리설정(미디어)")
        topic1.add("휴대폰 밝기조절")
        topic1.add("글자 크기조절")
        topic1.add("비행기모드 설정")
        topic1.add("화면 자동꺼짐 시간설정")
        topic1.add("화면잠금 설정")
        topic1.add("화면잠금 해제방법")
        topic1.add("LTE 설정")
        topic1.add("블루투스 켜기")
        topic1.add("블루투스 연결")
        topic1.add("와이파이(WIFI)연결")

        //세부내용2
        val topic2 : MutableList<String> = ArrayList()
        topic2.add("내 전화번호")
        topic2.add("배터리 사용량")

        //세부내용3
        val topic3 : MutableList<String> = ArrayList()
        topic3.add("벨소리 설정")
        topic3.add("통화볼륨 설정")
        topic3.add("단축번호 등록")
        topic3.add("전화 차단 방법")
        topic3.add("전화 거는 방법")
        topic3.add("번호 저장 방법")
        topic3.add("번호 삭제 방법")

        //세부내용4
        val topic4 : MutableList<String> = ArrayList()
        topic4.add("문자 보내는 방법")
        topic4.add("글씨 크기 설정")
        topic4.add("스팸보관함 확인")

        //세부내용5
        val topic5 : MutableList<String> = ArrayList()
        topic5.add("메세지 보내는 방법")
        topic5.add("사진 보내는 방법")
        topic5.add("동영상 보내는 방법")
        topic5.add("보이스톡 하는 방법")
        topic5.add("메세지 전달 하는 방법")

        //세부내용6
        val topic6 : MutableList<String> = ArrayList()
        topic6.add("로그인 방법")
        topic6.add("회원가입 방법")
        topic6.add("영상 검색하는 방법")
        topic6.add("영상 크게 보는 방법")
        topic6.add("영상 공유하는 방법")

        //세부내용 챕터에 연결
        topicList[chapterList[0]] = topic1
        topicList[chapterList[1]] = topic2
        topicList[chapterList[2]] = topic3
        topicList[chapterList[3]] = topic4
        topicList[chapterList[4]] = topic5
        topicList[chapterList[5]] = topic6

    }
}