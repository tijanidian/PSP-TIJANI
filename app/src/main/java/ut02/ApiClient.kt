package ut02

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Abstracción del cliente que vamos a usar en la actividad.
 */
interface ApiClient {
    fun getUsers(): List<UserApiModel>
    //Al introducir un id nos muestra toda su información
    fun getUser(userId: Int) : UserApiModel?
    fun getUsers(callback: ApiCallback<List<UserApiModel>>)
    fun getPost():List<PostApiModel>
}

class MockApiCliente : ApiClient {
    override fun getUsers(): List<UserApiModel> {
        return mutableListOf(
            UserApiModel(1, "Usuario 1", "Usuario 1", "user@email.es"),
            UserApiModel(2, "Usuario 2", "Usuario2", "user@email.es"),
            UserApiModel(3, "Usuario 3", "Usuario3", "user@email.es"),
            UserApiModel(4, "Usuario 4", "Usuario4", "user@email.es"),
        )

    }

    override fun getUsers(callback: ApiCallback<List<UserApiModel>>) {
        callback.onResponse(
            mutableListOf(
                UserApiModel(1, "Usuario 1", "Usuario 1", "user@email.es"),
                UserApiModel(2, "Usuario 2", "Usuario2", "user@email.es"),
                UserApiModel(3, "Usuario 3", "Usuario3", "user@email.es"),
                UserApiModel(4, "Usuario 4", "Usuario4", "user@email.es"),
            )
        )
    }

    override fun getUser(userId: Int): UserApiModel? {
        return UserApiModel(userId,"Usuario prueba","Usuario pureba1","Correo@prueba")
    }

    override fun getPost(): List<PostApiModel> {
       return  mutableListOf(
           PostApiModel(1,1,"sunt aut facere repellat provident occaecati excepturi optio reprehenderit","quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"),
           PostApiModel(2,2,"sunt aut facere repellat provident occaecati excepturi optio reprehenderit","quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"),
           PostApiModel(3,3,"sunt aut facere repellat provident occaecati excepturi optio reprehenderit","quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"),
       )
    }
}

/**
 * Uso de la librería Retrofit como cliente REST API.
 */
class RetrofitApiClient : ApiClient {

    private val urlEndPoint: String = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoint: ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    /**
     * Creación del cliente con el Endpoint.
     * Definido por la librería Retrofit. Siempre es así.
     */
    private fun buildApiService(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }

    /**
     * Creación y configuración del cliente Retrofit.
     * Siempre es así.
     */
    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Enpoint para obtener un listado de usuarios
     * @return List<UserPaiModel> listado de usuarios
     */
    override fun getUsers(): List<UserApiModel> {
        val call = apiEndPoint.getUsers()
        val response = call.execute()
        if (response.isSuccessful) {
            val users = response.body()
            //Si tiene usuarios los devuelvo, sino, devuelvo un listado vacío.
            return users ?: mutableListOf()
        } else {
            response.errorBody().toString()
            return mutableListOf()
        }
    }

    override fun getUsers(callback: ApiCallback<List<UserApiModel>>) {

        val call = apiEndPoint.getUsers()
        call.enqueue(
            object : Callback<List<UserApiModel>> {
                override fun onResponse(
                    call: Call<List<UserApiModel>>,
                    response: Response<List<UserApiModel>>
                ) {
                    if (response.isSuccessful) {
                        val users = response.body()
                        callback.onResponse(users ?: mutableListOf())
                    } else {
                        callback.onResponse(mutableListOf())
                    }
                }

                override fun onFailure(call: Call<List<UserApiModel>>, t: Throwable) {
                    callback.onFailure(t.message ?: "Error in response")
                }
            }
        )
    }

    override fun getUser(userId: Int): UserApiModel? {
        val call=apiEndPoint.getUser(userId)
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body()?: UserApiModel()
        } else {
            UserApiModel()
        }
    }


    override fun getPost(): List<PostApiModel> {
        val call = apiEndPoint.getPosts()
        val response = call.execute()
        return if (response.isSuccessful) {
            //Si tiene usuarios los devuelvo, sino, devuelvo un listado vacío.
            response.body() ?: mutableListOf()
        } else {
            //Log -> response.errorBody().toString()
            mutableListOf()
        }
    }


}



