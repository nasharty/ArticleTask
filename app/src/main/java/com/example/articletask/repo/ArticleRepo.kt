package com.example.articletask.repo

import android.arch.lifecycle.MutableLiveData
import com.example.articletask.connection.ApiClient
import com.example.articletask.connection.ApiInterface
import com.example.articletask.model.DataResponse
import com.example.articletask.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleRepo {
    val results = MutableLiveData<List<Result>>()
    fun callDataApi() {
        val apiInterface: ApiInterface = ApiClient.apiClient.create(ApiInterface::class.java)
        val call = apiInterface.data
        call.enqueue(object : Callback<DataResponse> {
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                results.value = response.body()!!.results
            }
            override fun onFailure(call: Call<DataResponse>, t: Throwable) {

            }
        })
    }
}
