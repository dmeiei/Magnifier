package kr.ac.hallym.dateandclock

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView

class TwoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view2 =  inflater.inflate(R.layout.fragment_two, container, false)

        //하단 바로가기 버튼
        //전화
        val intentDial = Intent(Intent.ACTION_DIAL)
        val CallBtn:CardView = view2.findViewById<CardView>(R.id.callBtn)
        CallBtn.setOnClickListener {
            startActivity(intentDial)
        }

        //문자
        val messagePackage = "com.samsung.android.messaging"
        val intentmessage = activity?.packageManager?.getLaunchIntentForPackage(messagePackage)
        val messageBtn:CardView = view2.findViewById<CardView>(R.id.messageBtn)

        messageBtn.setOnClickListener {
            startActivity(intentmessage)
        }

        //카메라
        val cameraPackage = "com.sec.android.app.camera"
        val intentcamera = activity?.packageManager?.getLaunchIntentForPackage(cameraPackage)
        val cameraBtn:CardView = view2.findViewById<CardView>(R.id.cameraBtn)

        cameraBtn.setOnClickListener {
            startActivity(intentcamera)
        }

        //갤러리
        val galleryPackage = "com.sec.android.gallery3d"
        val intentgallery = activity?.packageManager?.getLaunchIntentForPackage(galleryPackage)
        val galleryBtn:CardView = view2.findViewById<CardView>(R.id.photoBtn)

        galleryBtn.setOnClickListener {
            startActivity(intentgallery)
        }

        return view2
    }

}