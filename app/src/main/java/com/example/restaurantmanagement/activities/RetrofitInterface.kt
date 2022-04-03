package com.example.restaurantmanagement.activities

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/** Retrofit Interface */
interface RetrofitInterface {

    @FormUrlEncoded
    @POST("login")
    fun loginApi(@Field("email") email: String, @Field("password") password: String): Call<Unit>

    companion object {
        const val BASE_URL = "https://restaurant-codefest.herokuapp.com/home/"
    }

}

/** Singleton object */
class APIClient {
    companion object {
        val retrofitBuilder: RetrofitInterface by lazy {
            val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor())
            return@lazy Retrofit.Builder().baseUrl(RetrofitInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
                .create(RetrofitInterface::class.java)
        }
    }
}

/** Dataclass for request */
data class PostData(
    val email: String,
    val password: String
)

/** Dataclass for response */
data class PostResponseData(
    val email: String
)