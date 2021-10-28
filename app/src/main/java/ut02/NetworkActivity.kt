package ut02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tijani.psp_playground.R
import retrofit2.Retrofit

class NetworkActivity : AppCompatActivity() {

    //Etiqueta para los Logs.
    private val TAG = NetworkActivity::class.java.canonicalName

    //Se crea el cliente que vamos a usar. Esto debería ser hecho con un Inyector de dependencias.
    private val apiClient: ApiClient = RetrofitApiClient()

    /**
     * Ciclo de vida de la actividad. Primer método que se ejecuta en el ciclo de vida.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_netwotk)
        testAsyncApiUser(2)

    }

    /**
     * Función que ejecuta el cliente en modo síncrono: Crash cuando accedemos a API.
     */
    private fun testSyncApi() {
        val users = apiClient.getUsers()
        if (users.isNotEmpty()) {
            users.forEach {
                Log.i(TAG, "$it")
            }
        } else {
            Log.i(TAG, "User list is empty")
        }
    }

    /**
     * Función que ejecuta el cliente en modo asíncrono, en un hilo diferente a la UI.
     */

    //Probamos con users

    private fun testAsyncApi() {
        val threadNetwotk = Thread(Runnable {
            val users = apiClient.getUsers()
            if (users.isNotEmpty()) {
                users.forEach {
                    Log.i(TAG, "$it")
                }
            } else {
                Log.i(TAG, "User list is empty")
            }
        })
        threadNetwotk.start()
    }
    //Probamos con Posts
    private fun testAsyncApiPost() {
        val threadNetwotk = Thread(Runnable {
            val users = apiClient.getPost()
            if (users.isNotEmpty()) {
                users.forEach {
                    Log.i(TAG, "$it")
                }
            } else {
                Log.i(TAG, "User list is empty")
            }
        })
        threadNetwotk.start()
    }


    //Probamos con un id especifico
    private fun testAsyncApiUser(userId:Int) {
        val threadNetwork= Thread(Runnable {
            val user=apiClient.getUser(userId)
            if (user!=null){
                Log.i(TAG,"$user")
            }else{
                Log.i(TAG, "User list is empty")
            }
        })
        threadNetwork.start()
    }


    private fun exampleCallback() {
        val exampleCallback = ExampleCallback()
        val users = exampleCallback.getUsers()
        //Log.i(TAG, "$users")

        //Uso del callback
        exampleCallback.getUsers(object : ApiCallback<List<UserApiModel>> {
            override fun onResponse(apiModel: List<UserApiModel>) {
                users.forEach {
                    Log.i(TAG, "$it")
                }
            }

            override fun onFailure(error: String) {
                Log.i(TAG, error)
            }
        })
        Log.i(TAG, "I'm not waiting")
    }

    /**
     * Función para practicar una llamada con callback al cliente (asíncrona).
     */
    private fun testCallbackApi() {
        apiClient.getUsers(object : ApiCallback<List<UserApiModel>> {
            override fun onResponse(apiModel: List<UserApiModel>) {
                apiModel.forEach {
                    Log.i(TAG, "$it")
                }
            }

            override fun onFailure(error: String) {
                Log.e(TAG, error)
            }
        })
    }
}
