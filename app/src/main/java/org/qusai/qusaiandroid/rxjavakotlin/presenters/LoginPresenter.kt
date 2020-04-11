package org.qusai.qusaiandroid.rxjavakotlin.presenters

import android.util.Log
import org.json.JSONObject
import org.qusai.qusaiandroid.rxjavakotlin.listener.DataReturnListener
import org.qusai.qusaiandroid.rxjavakotlin.listener.ServerListener
import org.qusai.qusaiandroid.rxjavakotlin.manger.RequestManger

class LoginPresenter
{
var manger:RequestManger?=null

    constructor(manger:RequestManger)
    {
        this.manger=manger
    }
    fun login(dataReturn:DataReturnListener,userName:String,password:String){
        var body=HashMap<String,Any>()
        body.put("userName","qusai")
        body.put("password","123")
        manger!!.postRequest("login.php",body,object:
            ServerListener {
            override fun onSucess(data: JSONObject) {
                Log.d("sucess","sucess")
                dataReturn.onDataReturn(data)
            }

            override fun onFailed(message: String) {
                Log.d("failed","failed")
                dataReturn.onDataError(message)

            }

            override fun onNoInterNetConnection(message: String) {
            }
        })
    }
}