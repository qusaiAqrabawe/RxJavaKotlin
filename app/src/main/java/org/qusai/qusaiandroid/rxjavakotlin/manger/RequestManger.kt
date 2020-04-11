package org.qusai.qusaiandroid.rxjavakotlin.manger

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import org.qusai.qusaiandroid.rxjavakotlin.client.RetrofitClient
import org.qusai.qusaiandroid.rxjavakotlin.listener.ServerListener

class RequestManger {

    constructor() {

    }

    fun postRequest(apiName: String, obj: HashMap<String, Any>, serverListener: ServerListener) {

        RetrofitClient.instance.postRequest(apiName, obj).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({


                    var json: JSONObject = JSONObject(it.string())
                    serverListener.onSucess(json)



            }, {
                serverListener.onFailed("general message")
            })

    }
}