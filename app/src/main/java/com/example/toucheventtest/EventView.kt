package com.example.toucheventtest

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class EventView : View {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}


    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        Log.i("test_event:","view:dispatchTouchEvent->"+EventUtils.getEventName(event.action))

        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        Log.i("test_event:","view:onTouchEvent->"+EventUtils.getEventName(event.action))
//            return false
        return super.onTouchEvent(event)
    }
}
