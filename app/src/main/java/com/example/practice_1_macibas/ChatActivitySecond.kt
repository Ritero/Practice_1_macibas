package com.example.practice_1_macibas

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

const val EXTRA_REPLAY = "extraReplay"
class ChatActivitySecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_second)

        val chatSecondEditText: EditText = findViewById(R.id.chatSecondEditText)
        val chatSecondButtonReplay: Button = findViewById(R.id.chatSecondButtonReplay)
        val chatSecondTextViewMessageRecievedText: TextView = findViewById(R.id.chatSecondTextViewMessageRecievedText)


        chatSecondTextViewMessageRecievedText.text = intent.getStringExtra(EXTRA_MESSAGE)

        chatSecondButtonReplay.setOnClickListener{

            if (!chatSecondEditText.text.toString().isEmpty()){

                val message = chatSecondEditText.text.toString()
                val result = Intent().apply {
                    putExtra(EXTRA_REPLAY, message)
                }
                setResult(Activity.RESULT_OK, result)
                finish()

            }else{
                Toast.makeText(this,R.string.toastsecond, Toast.LENGTH_SHORT).show()
            }


        }

    }
}