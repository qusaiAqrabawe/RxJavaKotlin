package org.qusai.qusaiandroid.rxjavakotlin.ui.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.qusai.qusaiandroid.rxjavakotlin.manger.ParseManger
import org.qusai.qusaiandroid.rxjavakotlin.manger.RequestManger

open class BaseActivity : AppCompatActivity() {
   public    var context:Context?=null
    public  var parseManger: ParseManger?=null
    public  var requestManger: RequestManger?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context=this
        parseManger= ParseManger()
        requestManger= RequestManger()





    }
}