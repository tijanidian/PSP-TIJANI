package ut03.ex01.app

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {

    @GET("users")
    suspend fun getUsers(): Response<List<UserApiModel>>

    @GET("posts")
    fun getPosts(): Call<List<PostApiModel>>

    @GET("users/{user_id}")
    fun getUser(@Path("user_id") id: Int): Call<UserApiModel>

}