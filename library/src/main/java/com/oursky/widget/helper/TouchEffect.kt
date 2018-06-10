package com.oursky.widget.helper

import android.view.MotionEvent
import android.view.View

internal object TouchEffect {
    fun dimmed(view: View) {
        view.setOnTouchListener { v, ev ->
            when (ev.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (v.isEnabled) {
                        v.animate().cancel()
                        v.animate().alpha(0.2f).duration = 150
                        return@setOnTouchListener true
                    }
                }
                MotionEvent.ACTION_CANCEL -> {
                    if (v.isEnabled) {
                        v.animate().cancel()
                        v.animate().alpha(1.0f).duration = 150
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (v.isEnabled) {
                        v.animate().cancel()
                        v.animate().alpha(1.0f).duration = 150
                        v.performClick()
                    }
                }
            }
            false
        }
    }
}
