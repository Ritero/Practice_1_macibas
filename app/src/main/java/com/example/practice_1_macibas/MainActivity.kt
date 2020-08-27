package com.example.practice_1_macibas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainButonClicker: Button = findViewById(R.id.mainButonClicker)
        val mainButtonChat: Button = findViewById(R.id.mainButtonChat)


        mainButtonChat.setOnClickListener{

            val intent = Intent(this, ChatActivityFirst::class.java)
            startActivity(intent)

        }



    }
}
