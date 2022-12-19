package com.example.finalprep

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref : SharedPreferences = getSharedPreferences("doctor", MODE_PRIVATE)
        val txt = findViewById<TextView>(R.id.textView2)
        txt.text = pref.getString("login","guest")

    }
    fun addPref(view: View){
        val pref : SharedPreferences = getSharedPreferences("doctor", MODE_PRIVATE)
        var editor =pref.edit()
        editor.putString("login","n0oohani")
        editor.commit()
        ;
        var intent : Intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)

    }
}