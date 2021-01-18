package com.example.useractoinsandapplifecycle

import android.content.Context
import android.widget.Toast

class Cat {
    interface Listener {
        fun onMewSay()
    }

    var listener: Listener? = null

    fun sayMew(context: Context) {
        Toast.makeText(context, "Мяу!", Toast.LENGTH_SHORT).show()
        listener?.onMewSay()
    }
}