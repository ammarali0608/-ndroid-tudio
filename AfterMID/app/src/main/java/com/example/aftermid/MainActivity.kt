package com.example.aftermid

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var txt = findViewById<TextView>(R.id.txt1)
//        if(intent.getStringExtra("key1").toString() == "true"){
//            txt.text = "ammar ali"
//        }

        alarmCall()
    }
    fun alarmCall(){
//        intent.putExtra("key1","true")
        var  alarmmanager = getSystemService(ALARM_SERVICE) as AlarmManager;
        var pendingIntent = Intent(this,MainActivity::class.java)
        var i = PendingIntent.getActivity(this,0,pendingIntent,0)
        alarmmanager.set(AlarmManager.RTC,System.currentTimeMillis()+11*1000,i)
    }
}

/*
    Class-1
    Background task types
        imediate (threads)
        Exact (executed at specific time)
            asscociated with alarm manager
            alarm manager is api
            trigger future event
            two reasons
                dealing with time
                event based application

            Usage
                after android 12>
                    add permission in menifest
            four ways for managing alarm
                RTC (real time clock)
                RTC_WAKEUP (wake up device when alarm occured)
                Elapsed_REALTIME (time after restarting)
                ELAPSED_REALTIME_WAKEUP


        Expedited
        deffered

 */