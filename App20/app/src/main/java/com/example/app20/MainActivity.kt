package com.example.app20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var lis : ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var contacts_listview : ListView= findViewById<ListView>(R.id.contactsList)

        var cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME),
            null,null,null
        )

        lis = ArrayList()
        cursor!!.moveToFirst()
        do {
            lis.add(cursor.getString(0))
        }
            while (cursor.moveToNext())

            val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lis)
            contacts_listview.adapter = adapter






    }
/*
    Android COntent Provider
    application that share data beyond one application
    private data to public

    having two modules
    1. for retrieving - content resolver
        - Read, Write and update data from already created modules from other apps
        URI - for accessing link
            uri have three parts
                scheme - content
                authorities - name of provider
                path - path to table of database
            projection - columns
            selection clause - where clause
            selection arguments - conditions for getting selection
            sort order -


    2. for creation - content provider
        create content provider
            com.example.app20 > new > other > contentProvider
            put com.example.app20 in authorities


 */

}