package org.qusai.qusaiandroid.rxjavakotlin.ui.activites

import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import org.qusai.qusaiandroid.rxjavakotlin.R
import org.qusai.qusaiandroid.rxjavakotlin.listener.DataReturnListener
import org.qusai.qusaiandroid.rxjavakotlin.model.BaseResponse
import org.qusai.qusaiandroid.rxjavakotlin.presenters.LoginPresenter
import org.qusai.qusaiandroid.rxjavakotlin.ui.base.BaseActivity

class MainActivity : BaseActivity(),View.OnClickListener {
    override fun onClick(p0: View?) {
        login()
     }

    var loginPresenter:LoginPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       loginPresenter= LoginPresenter(requestManger!!)
        signIn.setOnClickListener(this)


    }
    fun login(){
        loginPresenter!!.login(object: DataReturnListener {
            override fun onDataReturn(obj: JSONObject) {
try{
    var baseResponse :BaseResponse=parseManger!!.getBaseResponse(obj)
                    Toast.makeText(context,baseResponse.message, Toast.LENGTH_LONG).show()


}catch (e:Exception){
 }
            }

            override fun onDataError(message: String) {
                Toast.makeText(context,message, Toast.LENGTH_LONG).show()

            }

        },userName.text.toString()!!,password.text.toString()!!)

    }
}
