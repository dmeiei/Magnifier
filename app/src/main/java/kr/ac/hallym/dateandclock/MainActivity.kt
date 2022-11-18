package kr.ac.hallym.dateandclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.dateandclock.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val tabTitleArray = arrayOf("홈","바로가기")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout = binding.tabs
        val viewPager = binding.viewpager
        viewPager.adapter = MyFragmentPagerAdapter(this)

        TabLayoutMediator(tabLayout,viewPager){ tab,position ->
            tab.text = tabTitleArray[position]
            val transaction = supportFragmentManager.beginTransaction()
            when(position){
                0 -> transaction.replace(R.id.viewpager,OneFragment())
                1 -> transaction.replace(R.id.viewpager,TwoFragment())
            }
        }.attach()


    }
}

class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
    val fragments: List<Fragment>
    init{
        fragments = listOf(OneFragment(),TwoFragment())
    }
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}