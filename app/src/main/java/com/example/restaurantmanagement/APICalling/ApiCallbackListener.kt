package com.example.restaurantmanagement.APICalling

interface ApiCallbackListener {
    fun<T: Any> onSuccess(data: T)
    fun onFailure()

}