package com.example.alee

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.util.Scanner


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fileChooser = FileChooser()

// Show the file chooser and wait for the user to select a file
        val file: File = fileChooser.showOpenDialog(primaryStage)

// Add the selected file to a list
        val files: MutableList<File> = mutableListOf()
        files.add(file)

        setContentView(R.layout.activity_main)
        mypref()
    }
    fun mypref()
    {
        val pref : SharedPreferences = getSharedPreferences("ali", MODE_PRIVATE)
            var editor =pref.edit()
            editor.putString("ammar","n0oohani")
             editor.commit()

    }
    fun button(view:View)
    {
        val prefs = getSharedPreferences("ali", MODE_PRIVATE)
        findViewById<TextView>(R.id.txt1).text = prefs.getString("ammar","ali")
        var intent = Intent(this,MainActivity2::class.java)
        intent.putExtra("siba","iba")
        startActivityForResult(intent,1234)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Toast.makeText(this, data?.getStringExtra("return"), Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {

        super.onStart()
        fileread()
    }
    fun fileread()
    {
        try {
            var read = Scanner(openFileInput("jameel.txt"))
            var a = ""
            while (read.hasNext()) {
                a = a + read.nextLine() + "\n"
            }
//            findViewById<TextView>(R.id.txt3).text=a
        }
        catch (e:Exception)
        {
        }
    }

    fun butn(view: View)
    {
        startActivity(Intent(this,MainActivity4::class.java))

    }

}