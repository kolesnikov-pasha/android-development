package com.example.useractoinsandapplifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var sendButton: View
    private lateinit var editText: EditText
    private lateinit var rootView: ViewGroup
    private val formatter = SimpleDateFormat()
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendButton = findViewById(R.id.send_button)
        editText = findViewById(R.id.edit_text)
        rootView = findViewById(R.id.base_layout)
        sendButton.setOnClickListener {
            onSendClick()
        }
        sendButton.setOnLongClickListener {
            onSendLongClick()
            true
        }
    }

    private fun getCurrentText(): CharSequence {
        return editText.text.toString()
    }

    private fun getCurrentTime(): CharSequence {
        val time = System.currentTimeMillis()
        calendar.timeInMillis = time
        return formatter.format(calendar.time)
    }

    private fun onSendLongClick() {
        LayoutInflater.from(this).inflate(R.layout.message_layout, rootView, true)
        val messageView = rootView.getChildAt(rootView.childCount - 1)
        val messageDate = messageView.findViewById<TextView>(R.id.time_text)
        messageDate.text = getCurrentTime()
        editText.text.clear()
    }

    private fun onSendClick() {
        val currentText = getCurrentText()
        if (currentText.isEmpty()) {
            return
        }
        LayoutInflater.from(this).inflate(R.layout.message_layout, rootView, true)
        val messageView = rootView.getChildAt(rootView.childCount - 1)
        val messageText = messageView.findViewById<TextView>(R.id.message_text)
        val messageDate = messageView.findViewById<TextView>(R.id.time_text)
        messageText.text = getCurrentText()
        messageDate.text = getCurrentTime()
        editText.text.clear()
    }
}