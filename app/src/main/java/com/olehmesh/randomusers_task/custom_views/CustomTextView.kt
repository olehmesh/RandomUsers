package com.olehmesh.randomusers_task.custom_views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomTextView(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {

    override fun setText(c: CharSequence, type: BufferType) {
        var cap = c

        try {
            cap = cap[0].toString().toUpperCase() + cap.subSequence(1, cap.length).toString().toLowerCase()
            for (i in 0 until cap.length) {
                if (cap[i].toString().contains(" ")) {
                    cap = cap.subSequence(0, i + 1).toString() + cap[i + 1].toString().toUpperCase() + cap.subSequence(
                        i + 2,
                        cap.length
                    ).toString().toLowerCase()
                }
            }
        } catch (e: Exception) {
            // String did not have more than + 2 characters after space.
        }

        super.setText(cap, type)
    }

}