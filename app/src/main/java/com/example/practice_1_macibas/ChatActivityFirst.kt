package com.example.practice_1_macibas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast

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
                val intent = Intent(this, ChatActivityFirst::class.java).apply {
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

        if (requestCode == DETAIL_REQUEST && resultCode == Activity.RESULT_OK){
            data?.let{
                // saņemti rezultāti, view add textView!!!
            }

        }

    }

}//RealEnd