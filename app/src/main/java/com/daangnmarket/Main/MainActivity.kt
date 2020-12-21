package com.daangnmarket.Main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentTransaction
import com.daangnmarket.R
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.layout_home_bottom_navigation.*

class MainActivity : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        //val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        onNavigationItemSelected(bottomNavigationView.menu.getItem(0))

        Fresco.initialize(this)
//        val intent = Intent(this@HomeActivity, LoginActivity::class.java)
//        startActivity(intent)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        when(item.itemId){
            R.id.menu_item_home -> {
                val homeFragement = HomeFragment()
                transaction.replace(R.id.frame_layout, homeFragement, "home")
            }
            R.id.menu_item_chatting -> {
                val chattingFragement = ChattingFragment()
                transaction.replace(R.id.frame_layout, chattingFragement, "chatting")
            }
            R.id.menu_item_life -> {
                val arroundFragement = ArroundFragment()
                transaction.replace(R.id.frame_layout, arroundFragement, "arround")
            }
            R.id.menu_item_my_daangn -> {
                val mymenuFragement = MyMenuFragment()
                transaction.replace(R.id.frame_layout, mymenuFragement, "mymenu")
            }
            R.id.menu_item_search_near -> {
                val nearlifeFragement = TownLifeFragment()
                transaction.replace(R.id.frame_layout, nearlifeFragement, "near_life")
            }
        }

        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
        return true
    }
}