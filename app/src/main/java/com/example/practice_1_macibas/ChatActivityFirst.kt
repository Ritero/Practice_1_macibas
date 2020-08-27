package com.example.practice_1_macibas

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginBottom


const val EXTRA_MESSAGE = "MESSAGEFORRESULT"
const val DETAIL_REQUEST = 1234



class ChatActivityFirst : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_first)



        val chatFirstEditTextEnterMessage: EditText = findViewById(R.id.chatFirstEditTextMessage)
        val chatFirstButtonSend: Button = findViewById(R.id.chatFirstButtonSend)
        val chatFirstLayout: LinearLayout = findViewById(R.id.chatFirstLayout)




        chatFirstButtonSend.setOnClickListener{

            if (!chatFirstEditTextEnterMessage.text.toString().isEmpty()){

                val message = chatFirstEditTextEnterMessage.text.toString()
                //uzliek toxtviewSent
                val textViewMessageSent = TextView(this)
                textViewMessageSent.textSize = 20f

                textViewMessageSent.setTextColor(Color.BLUE)
                val params: LinearLayout.LayoutParams =
                    LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                params.setMargins(10, 10, 10, 0)
                textViewMessageSent.setLayoutParams(params)
                // uzliek toxtviewSent end
                val textViewMessageSentText = TextView(this)
                textViewMessageSentText.textSize = 20f
                params.setMargins(50, 5, 10, 0)
                textViewMessageSentText.setLayoutParams(params)

                textViewMessageSent.text = resources.getString(R.string.chatFirstTextViewMessageSent)
                chatFirstLayout.addView(textViewMessageSent)
                textViewMessageSentText.text = message
                chatFirstLayout.addView(textViewMessageSentText)

                val intent = Intent(this, ChatActivitySecond::class.java).apply {
                    putExtra(EXTRA_MESSAGE,message )
                }
                startActivityForResult(intent, DETAIL_REQUEST)



            }else{

                Toast.makeText(this,R.string.toastFirst, Toast.LENGTH_SHORT).show()

            }


        }//chatFirstButtonSend.setonclick end



    }//onCreate End

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val chatFirstLayout: LinearLayout = findViewById(R.id.chatFirstLayout)
        if (requestCode == DETAIL_REQUEST && resultCode == Activity.RESULT_OK){
            data?.let{
                // saņemti rezultāti, view add textView!!!
                val textViewMessageRecieve = TextView(this)
                textViewMessageRecieve.textSize = 20f
                textViewMessageRecieve.text = resources.getString(R.string.chatTextViewMessageRecieved)
                textViewMessageRecieve.setTextColor(Color.BLUE)
                val params: LinearLayout.LayoutParams =
                    LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                params.setMargins(10, 10, 10, 0)
                textViewMessageRecieve.setLayoutParams(params)

                val textViewMessageRecieveText = TextView(this)
                textViewMessageRecieveText.textSize = 20f
                params.setMargins(50, 5, 10, 0)
                textViewMessageRecieveText.setLayoutParams(params)
                textViewMessageRecieveText.text = data.getStringExtra(EXTRA_REPLAY)
                chatFirstLayout.addView(textViewMessageRecieve)
                chatFirstLayout.addView(textViewMessageRecieveText)
            }

        }

    }

}//RealEnd