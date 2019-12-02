package com.example.toucheventtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.example.toucheventtest.EventUtils.getEventName

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("test_event:","activity:dispatchTouchEvent->"+getEventName(ev!!.action))
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i("test_event:","activity:onTouchEvent->"+getEventName(event!!.action))
        return super.onTouchEvent(event)
    }

}
/**
 * view不可点击
 * clickable = false
 */
//2019-12-02 16:22:26.527 31912-31912/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->down
//2019-12-02 16:22:26.532 31912-31912/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->down
//2019-12-02 16:22:26.532 31912-31912/com.example.toucheventtest I/test_event:: ViewGroup:onInterceptTouchEvent->down
//2019-12-02 16:22:26.533 31912-31912/com.example.toucheventtest I/test_event:: view:dispatchTouchEvent->down
//2019-12-02 16:22:26.533 31912-31912/com.example.toucheventtest I/test_event:: view:onTouchEvent->down
//2019-12-02 16:22:26.533 31912-31912/com.example.toucheventtest I/test_event:: ViewGroup:onTouchEvent->down
//2019-12-02 16:22:26.539 31912-31912/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->move
//2019-12-02 16:22:26.542 31912-31912/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->up


/**
 * view可点击
 * clickable = true
 * view的onTouchEvent默认都会消耗事件(返回true)，除非它是不可点击的(clickable和longClickable同时为false)
 * view的longClickable属性默认都为false，clickable属性要分情况，比如button的clickab属性默认为true，
 * 而TextView的clickable属性默认为false
 */
//2019-12-02 16:24:58.254 32445-32445/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->down
//2019-12-02 16:24:58.256 32445-32445/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->down
//2019-12-02 16:24:58.257 32445-32445/com.example.toucheventtest I/test_event:: ViewGroup:onInterceptTouchEvent->down
//2019-12-02 16:24:58.257 32445-32445/com.example.toucheventtest I/test_event:: view:dispatchTouchEvent->down
//2019-12-02 16:24:58.258 32445-32445/com.example.toucheventtest I/test_event:: view:onTouchEvent->down
//2019-12-02 16:24:58.261 32445-32445/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->up
//2019-12-02 16:24:58.262 32445-32445/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->up
//2019-12-02 16:24:58.262 32445-32445/com.example.toucheventtest I/test_event:: ViewGroup:onInterceptTouchEvent->up
//2019-12-02 16:24:58.263 32445-32445/com.example.toucheventtest I/test_event:: view:dispatchTouchEvent->up
//2019-12-02 16:24:58.263 32445-32445/com.example.toucheventtest I/test_event:: view:onTouchEvent->up


/**
 * view可点击
 * view的onTouchEvent不消耗除down以为的其他事件，这个点击事件就会消失，此时父元素的onTouchEvent并会不调用
 * 并且当前的view可持续收到后续事件，最终这些消失的点击事件会传递给activity来处理
 */
//2019-12-02 16:33:25.084 2931-2931/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->down
//2019-12-02 16:33:25.087 2931-2931/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->down
//2019-12-02 16:33:25.087 2931-2931/com.example.toucheventtest I/test_event:: ViewGroup:onInterceptTouchEvent->down
//2019-12-02 16:33:25.088 2931-2931/com.example.toucheventtest I/test_event:: view:dispatchTouchEvent->down
//2019-12-02 16:33:25.089 2931-2931/com.example.toucheventtest I/test_event:: view:onTouchEvent->down
//2019-12-02 16:33:25.090 2931-2931/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->move
//2019-12-02 16:33:25.091 2931-2931/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->move
//2019-12-02 16:33:25.091 2931-2931/com.example.toucheventtest I/test_event:: ViewGroup:onInterceptTouchEvent->move
//2019-12-02 16:33:25.091 2931-2931/com.example.toucheventtest I/test_event:: view:dispatchTouchEvent->move
//2019-12-02 16:33:25.091 2931-2931/com.example.toucheventtest I/test_event:: view:onTouchEvent->move
//2019-12-02 16:33:25.091 2931-2931/com.example.toucheventtest I/test_event:: activity:onTouchEvent->move
//2019-12-02 16:33:25.091 2931-2931/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->up
//2019-12-02 16:33:25.092 2931-2931/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->up
//2019-12-02 16:33:25.092 2931-2931/com.example.toucheventtest I/test_event:: ViewGroup:onInterceptTouchEvent->up
//2019-12-02 16:33:25.092 2931-2931/com.example.toucheventtest I/test_event:: view:dispatchTouchEvent->up
//2019-12-02 16:33:25.092 2931-2931/com.example.toucheventtest I/test_event:: view:onTouchEvent->up
//2019-12-02 16:33:25.092 2931-2931/com.example.toucheventtest I/test_event:: activity:onTouchEvent->up


/**
 * view可点击
 * 某个view一旦开始处理事件，如果他消耗down事件(onTouchEvent返回false),那么同一事件序列中的其他事件都不会再交给它处理，并且事件将交由它的父元素去处理，
 * 即父元素的onTouchEvent会被调用。意思就是事件一旦交给一个view处理，那么他就必须消耗掉，否则同一事件序列剩下的事件就不再交由它来处理了。
 */
//2019-12-02 16:36:57.646 4113-4113/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->down
//2019-12-02 16:36:57.648 4113-4113/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->down
//2019-12-02 16:36:57.648 4113-4113/com.example.toucheventtest I/test_event:: ViewGroup:onInterceptTouchEvent->down
//2019-12-02 16:36:57.649 4113-4113/com.example.toucheventtest I/test_event:: view:dispatchTouchEvent->down
//2019-12-02 16:36:57.650 4113-4113/com.example.toucheventtest I/test_event:: view:onTouchEvent->down
//2019-12-02 16:36:57.650 4113-4113/com.example.toucheventtest I/test_event:: ViewGroup:onTouchEvent->down
//2019-12-02 16:36:57.652 4113-4113/com.example.toucheventtest I/test_event:: activity:onTouchEvent->down
//2019-12-02 16:36:57.657 4113-4113/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->move
//2019-12-02 16:36:57.657 4113-4113/com.example.toucheventtest I/test_event:: activity:onTouchEvent->move
//2019-12-02 16:36:57.659 4113-4113/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->up
//2019-12-02 16:36:57.660 4113-4113/com.example.toucheventtest I/test_event:: activity:onTouchEvent->up


/**
 * view可点击
 * ViewGroup不可点击
 * ViewGroup拦截move事件和up事件
 */
//2019-12-02 17:19:09.336 11680-11680/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->down
//2019-12-02 17:19:09.337 11680-11680/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->down
//2019-12-02 17:19:09.337 11680-11680/com.example.toucheventtest I/test_event:: ViewGroup:onInterceptTouchEvent->down
//2019-12-02 17:19:09.337 11680-11680/com.example.toucheventtest I/test_event:: view:dispatchTouchEvent->down
//2019-12-02 17:19:09.338 11680-11680/com.example.toucheventtest I/test_event:: view:onTouchEvent->down
//2019-12-02 17:19:09.346 11680-11680/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->move
//2019-12-02 17:19:09.347 11680-11680/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->move
//2019-12-02 17:19:09.347 11680-11680/com.example.toucheventtest I/test_event:: ViewGroup:onInterceptTouchEvent->move
//2019-12-02 17:19:09.347 11680-11680/com.example.toucheventtest I/test_event:: view:dispatchTouchEvent->cancel
//2019-12-02 17:19:09.347 11680-11680/com.example.toucheventtest I/test_event:: view:onTouchEvent->cancel
//2019-12-02 17:19:09.355 11680-11680/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->move
//2019-12-02 17:19:09.355 11680-11680/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->move
//2019-12-02 17:19:09.355 11680-11680/com.example.toucheventtest I/test_event:: ViewGroup:onTouchEvent->move
//2019-12-02 17:19:09.356 11680-11680/com.example.toucheventtest I/test_event:: activity:onTouchEvent->move
//2019-12-02 17:19:09.584 11680-11680/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->up
//2019-12-02 17:19:09.584 11680-11680/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->up
//2019-12-02 17:19:09.584 11680-11680/com.example.toucheventtest I/test_event:: ViewGroup:onTouchEvent->up
//2019-12-02 17:19:09.584 11680-11680/com.example.toucheventtest I/test_event:: activity:onTouchEvent->up

/**
 * view可点击
 * ViewGroup可点击
 * ViewGroup拦截move事件和up事件
 */
//2019-12-02 17:28:54.064 12632-12632/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->down
//2019-12-02 17:28:54.065 12632-12632/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->down
//2019-12-02 17:28:54.065 12632-12632/com.example.toucheventtest I/test_event:: ViewGroup:onInterceptTouchEvent->down
//2019-12-02 17:28:54.065 12632-12632/com.example.toucheventtest I/test_event:: view:dispatchTouchEvent->down
//2019-12-02 17:28:54.065 12632-12632/com.example.toucheventtest I/test_event:: view:onTouchEvent->down
//2019-12-02 17:28:54.074 12632-12632/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->move
//2019-12-02 17:28:54.074 12632-12632/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->move
//2019-12-02 17:28:54.074 12632-12632/com.example.toucheventtest I/test_event:: ViewGroup:onInterceptTouchEvent->move
//2019-12-02 17:28:54.074 12632-12632/com.example.toucheventtest I/test_event:: view:dispatchTouchEvent->cancel
//2019-12-02 17:28:54.074 12632-12632/com.example.toucheventtest I/test_event:: view:onTouchEvent->cancel
//2019-12-02 17:28:54.081 12632-12632/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->move
//2019-12-02 17:28:54.081 12632-12632/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->move
//2019-12-02 17:28:54.081 12632-12632/com.example.toucheventtest I/test_event:: ViewGroup:onTouchEvent->move
//2019-12-02 17:28:54.150 12632-12632/com.example.toucheventtest I/test_event:: activity:dispatchTouchEvent->up
//2019-12-02 17:28:54.151 12632-12632/com.example.toucheventtest I/test_event:: ViewGroup:dispatchTouchEvent->up
//2019-12-02 17:28:54.151 12632-12632/com.example.toucheventtest I/test_event:: ViewGroup:onTouchEvent->up