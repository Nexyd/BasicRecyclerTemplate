package dani.kotlin.template.basicrecycler.data

import dani.kotlin.template.basicrecycler.model.BasicModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("employees")
    fun getEmployees(): Call<BasicModel>
}