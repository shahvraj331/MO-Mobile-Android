package com.example.restaurantmanagement.APICalling

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

// Base Url
private val BASE_URL = ""

interface ApiInterface {

    @POST("")
    fun login(): Call<Login>

    companion object {
        fun getRetrofitObject(): Retrofit {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClientBuilder = OkHttpClient.Builder().addInterceptor(interceptor)
                .addInterceptor(
                    Interceptor {
                        val builder = it.request().newBuilder()
                        builder.header("Content-Type", "application/json")
                        return@Interceptor it.proceed(builder.build())
                    }
                )
            val okHttpClient = okHttpClientBuilder.build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    private fun <T: Any> request(retrofitCall: Call<T>, apiCallbackListener: ApiCallbackListener) {
        retrofitCall.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                response.body()?.let {
                    apiCallbackListener.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) { }
        })
    }
}