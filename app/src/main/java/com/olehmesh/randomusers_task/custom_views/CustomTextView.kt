package com.olehmesh.randomusers_task.custom_views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import java.util.*

class CustomTextView(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {

    override fun setText(c: CharSequence, type: BufferType) {
        var cap = c

        try {
            cap =
                cap[0].toString().toUpperCase(Locale.getDefault()) + cap.subSequence(1, cap.length)
                    .toString().toLowerCase()
            for (i in cap.indices) {
                if (cap[i].toString().contains(" ")) {
                    cap = cap.subSequence(0, i + 1).toString() + cap[i + 1].toString().toUpperCase() + cap.subSequence(
                        i + 2,
                        cap.length
                    ).toString().toLowerCase(Locale.getDefault())
                }
            }
        } catch (e: Exception) {
            // Log.d(Constants.TAG, "UpperCase CustomTextView Exception")
        }

        super.setText(cap, type)
    }

}