package ut02

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * EndPoints de los servicios que se van a usar.
 * Es requisito de Retrofit crear esta interfaz.
 */
interface ApiEndPoint {

    @GET("users")
    fun getUsers(): Call<List<UserApiModel>>

    @GET("posts")
    fun getPosts(): Call<List<PostApiModel>>


}