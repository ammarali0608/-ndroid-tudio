package com.example.lab7

import android.content.ContentUris
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Environment
import android.os.Environment.*
import android.provider.MediaStore
import android.provider.MediaStore.Audio
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import java.io.File
import kotlin.coroutines.jvm.internal.CompletedContinuation.context


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val audioUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DISPLAY_NAME)
        val selection = null
        val selectionArgs = null
        val sortOrder = MediaStore.Audio.Media.DISPLAY_NAME

        val cursor = contentResolver.query(audioUri, projection, selection, selectionArgs, sortOrder)

// Iterate through the list of audio files and play them
        val mediaPlayer = MediaPlayer()
        while (cursor!!.moveToNext()) {
            val audioId = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID))
            val audioUri = ContentUris.withAppendedId(audioUri, audioId)

//            mediaPlayer.reset()
//            mediaPlayer.setDataSource(this, audioUri)
//            mediaPlayer.prepare()
//            mediaPlayer.start()
        }
  }