package org.qusai.qusaiandroid.rxjavakotlin.listener

import org.json.JSONObject

interface DataReturnListener {
    fun onDataReturn(obj:JSONObject)
    fun onDataError(message:String)
}