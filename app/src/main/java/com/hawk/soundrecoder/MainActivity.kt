package com.hawk.soundrecoder

import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottom_navigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation = findViewById(R.id.bottom_navigation)
        NavigationUI.setupWithNavController(bottom_navigation, Navigation.findNavController(this,R.id.nav_host_fragment_container))
    }

    fun isServiceRunning() : Boolean{
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if("com.hawk.soundrecoder.recoder.RecordService" == service.service.className){
                return true
            }
        }
        return false
    }





}