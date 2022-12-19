package com.example.alee

import android.content.ContentValues
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    lateinit  var media : MediaPlayer
    var songs = mutableListOf<String>()
    var songsPath = mutableListOf<String>()

    var list1 = mutableListOf<String>()
    lateinit var adp : ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        list1.add("Ammar")
        list1.add("Ali")
        adp = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list1)
        findViewById<ListView>(R.id.ln).adapter = adp

        adp.notifyDataSetChanged()
        media  = MediaPlayer.create(this,R.raw.abc)
        media.start()


    }
    fun butn(view: View){
      var t =  findViewById<TextView>(R.id.editTextTextPersonName).text.toString()
        list1.add(t)
        adp.notifyDataSetChanged()


    }
    fun btn3(view: View){
        if(media.isPlaying){
            media.pause()
        }
        else{
            media.start()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.itm1){
            Toast.makeText(this,"ali",Toast.LENGTH_SHORT).show()

        }
        return super.onOptionsItemSelected(item)

    }

    fun createDB(){
        var db = openOrCreateDatabase("Users", MODE_PRIVATE,null)
        var q ="create table if not exists bscs(id INTEGER PRIMARY KEY,name TEXT)"
        db.execSQL(q)
        db.close()



    }
    fun dbbtn(view: View){


        createDB()
        var id = findViewById<TextView>(R.id.editTextTextPersonName).text.toString()

        var name = findViewById<TextView>(R.id.editTextTextPersonName2).text.toString()
        var db = openOrCreateDatabase("Users", MODE_PRIVATE,null)
        var cv = ContentValues()

//        cv.put("id",Integer.parseInt(id))
        cv.put("name",name)
        db.insert("bscs",null,cv)

        showValues()


    }

    private fun showValues() {
        var db = openOrCreateDatabase("Users", MODE_PRIVATE,null)
        var q = "Select * from bscs"
        var res= db.rawQuery(q,null)
        while (res.moveToNext()){
            Log.i("chichi","${res.getInt(0)} : ${res.getString(1)}")
        }
        res.close()
    }


}