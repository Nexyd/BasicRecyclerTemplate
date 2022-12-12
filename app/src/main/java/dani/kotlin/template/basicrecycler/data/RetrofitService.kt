package dani.kotlin.template.basicrecycler.data

import dani.kotlin.template.basicrecycler.MainActivity
import dani.kotlin.template.basicrecycler.model.BasicModel
import dani.kotlin.template.basicrecycler.model.BasicModelData

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private val instance =
        Retrofit.Builder()
            .baseUrl("https://dummy.restapiexample.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitAPI::class.java)

    fun getEmployees() {
        instance.getEmployees().enqueue(
            object : Callback<BasicModel> {
                override fun onResponse(
                    call: Call<BasicModel>,
                    response: Response<BasicModel>
                ) {
                    response.body()?.let {
                        MainActivity.employeeList.postValue(
                            it.data
                        )
                    }
                }

                override fun onFailure(
                    call: Call<BasicModel>,
                    throwable: Throwable
                ) {
                    println("### retrofit onFailure ###")
                    throwable.printStackTrace()
                }
            }
        )
    }
}