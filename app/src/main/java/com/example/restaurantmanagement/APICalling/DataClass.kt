package com.example.restaurantmanagement.APICalling

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("")
    var email: String? = null,
    @SerializedName("")
    var password: String?= null
)