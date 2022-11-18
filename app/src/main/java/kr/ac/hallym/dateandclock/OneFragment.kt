package kr.ac.hallym.dateandclock

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView

class OneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_one, container, false)

        //phonebook_btn 연결
        val phoneBook:CardView = view.findViewById(R.id.phonebook_btn)
        //light_btn 연결
        val lightBtn:CardView = view.findViewById<CardView>(R.id.light_btn)
        //magnify_btn 연결
        val magnifierBtn:CardView = view.findViewById<CardView>(R.id.magnify_btn)
        //game_btn 연결
        val gamePBtn:CardView = view.findViewById<CardView>(R.id.playing_btn)
        //manual_btn 연결
        val manualBtn:CardView = view.findViewById<CardView>(R.id.manual_btn)

        phoneBook.setOnClickListener{
            val phonebookintent = Intent(activity,PhonebookActivity::class.java)
            startActivity(phonebookintent)
        }

        lightBtn.setOnClickListener{
            val flashintent= Intent(activity, FlashActivity::class.java)
            startActivity(flashintent)
        }

        magnifierBtn.setOnClickListener{
            val magnifierintent= Intent(activity, CameraxActivity::class.java)
            startActivity(magnifierintent)
        }

        gamePBtn.setOnClickListener {
            val gamePintent = Intent(activity, GameActivity::class.java)
            startActivity(gamePintent)
        }

        manualBtn.setOnClickListener{
            val manualintent = Intent(activity,ManualActivity::class.java )
            startActivity(manualintent)
        }

        return view
    }


}