package ut02.exercise1

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApliClient:ApiClient {
    private val urlEndPoint: String = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoint:ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    private fun buildApiService(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }


    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    override fun getUsers(): List<UserApiModel> {
        val call = apiEndPoint.getUsers()
        val response = call.execute()
        if (response.isSuccessful) {
            val users = response.body()
            //Si tiene usuarios los devuelvo, sino, devuelvo un listado vacío.
            return users ?: mutableListOf()
        } else {
            return mutableListOf()
        }
    }


    override fun getUser(userId: Int): UserApiModel? {
        val call = apiEndPoint.getUser(userId)
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }



}
