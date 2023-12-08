package com.example.gameslist.api

import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

interface Endpoint {
    @GET("/produtos")
    suspend fun getCurrencies(): Response<JsonObject>
}

class ApiManager(private val coroutineScope: CoroutineScope) {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val endpoint: Endpoint = retrofit.create(Endpoint::class.java)

    fun fetchCurrencies(onResult: (Result<JsonObject>) -> Unit) {
        coroutineScope.launch {
            try {
                val response = endpoint.getCurrencies()
                if (response.isSuccessful) {
                    onResult(Result.Success(response.body()!!))
                } else {
                    onResult(Result.Error(Exception("Falha na requisição: ${response.code()}")))
                }
            } catch (e: Exception) {
                onResult(Result.Error(e))
            }
        }
    }
}


