package com.example.alee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.io.PrintStream

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        aly()
    }
    fun aly()
    {
        val pref = getSharedPreferences("ali",MODE_PRIVATE)
        Toast.makeText(this,pref.getString("ammar","ali"),Toast.LENGTH_SHORT).show()
    }
    fun button(view:View)
    {
        var it = getIntent()
        Toast.makeText(this, it.getStringExtra("siba"), Toast.LENGTH_SHORT).show()
        var intent = Intent()
        intent.putExtra("return","CameBack")
        setResult(RESULT_OK,intent)
        finish()
    }
    fun btn(view: View)
    {
        var a = PrintStream(openFileOutput("jameel.txt",MODE_APPEND))
        a.println(findViewById<TextView>(R.id.tx).text)
        a.close()


    }


}