package com.example.toucheventtest

/**
 * Author: fax
 * Email: fxiong1995@gmail.com
 * Date: 19-12-2
 * Description:
 */
object EventUtils {

    fun getEventName(action: Int): String {
        when(action){
            0 -> return "down"
            1 -> return "up"
            2 -> return "move"
            3 -> return "cancel"
            else -> return "unknow"
        }
    }
}