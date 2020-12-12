package com.daangnmarket.Main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.daangnmarket.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

//        val intent = Intent(this@HomeActivity, LoginActivity::class.java)
//        startActivity(intent)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        when(item.itemId){
            R.id.menu_item_home ->{
                val homeFragement = HomeFragement()
                transaction.replace(R.id.frame_layout , homeFragement , "home")
            }
            R.id.menu_item_chatting ->{
                val chattingFragement = ChattingFragement()
                transaction.replace(R.id.frame_layout , chattingFragement , "chatting")
            }
            R.id.menu_item_life ->{
                val arroundFragement = ArroundFragement()
                transaction.replace(R.id.frame_layout , arroundFragement , "arround")
            }
            R.id.menu_item_my_daangn ->{
                val mymenuFragement = MyMenuFragement()
                transaction.replace(R.id.frame_layout , mymenuFragement , "mymenu")
            }
            R.id.menu_item_search_near ->{
                val nearlifeFragement = NearLifeFragement()
                transaction.replace(R.id.frame_layout , nearlifeFragement , "near_life")
            }
        }

        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
        return true
    }
}