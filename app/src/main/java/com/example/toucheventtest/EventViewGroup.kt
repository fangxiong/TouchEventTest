package com.example.toucheventtest

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.RelativeLayout



/**
 * Author: fax
 * Email: fxiong1995@gmail.com
 * Date: 19-9-5
 * Description:
 */
class EventViewGroup @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    RelativeLayout(context, attrs, defStyleAttr) {


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("test_event:","ViewGroup:dispatchTouchEvent->"+ EventUtils.getEventName(ev!!.action))
        return super.dispatchTouchEvent(ev)
    }
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        Log.i("test_event:","ViewGroup:onInterceptTouchEvent->"+ EventUtils.getEventName(ev.action))
        if(ev.action == 2 || ev.action == 1){
            return true
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        Log.i("test_event:","ViewGroup:onTouchEvent->"+ EventUtils.getEventName(event.action))
        return super.onTouchEvent(event)
    }
}
