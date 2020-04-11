package org.qusai.qusaiandroid.rxjavakotlin.listener

import org.json.JSONObject

interface ServerListener
{
    fun onSucess(data:JSONObject)
    fun onFailed(message:String)
    fun onNoInterNetConnection(message:String)
}