package com.juniperphoton.myersplash.utils

import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.juniperphoton.myersplash.App
import com.juniperphoton.myersplash.R

object ToastService {
    var handler = Handler(Looper.getMainLooper())

    fun sendShortToast(str: String?) {
        if (str == null) {
            return
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            handler.post { sendToastInternal(str) }
        } else {
            handler.post { sendToastInternal(str) }
        }
    }

    private fun sendToastInternal(str: String?) {
        var view = LayoutInflater.from(App.instance).inflate(R.layout.toast_layout, null)

        var textView = view.findViewById(R.id.toast_textView) as TextView
        textView.text = str

        var toast = Toast(App.instance)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = view
        toast.setGravity(Gravity.BOTTOM, 0, 100)
        toast.show()
    }
}