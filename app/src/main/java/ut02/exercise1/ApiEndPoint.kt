package ut02.exercise1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint{
    @GET("users")
    fun getUsers(): Call<List<UserApiModel>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: Int): Call<UserApiModel>
}
