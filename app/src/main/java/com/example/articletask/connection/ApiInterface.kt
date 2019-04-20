package com.example.articletask.connection


import com.example.articletask.model.DataResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by ahmed on 3/30/2018.
 */

interface ApiInterface {

    @get:GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=Agt7ULY8ERYXOWMhWcC7fJ8b4m5iifjx")
    val data: Call<DataResponse>
}
