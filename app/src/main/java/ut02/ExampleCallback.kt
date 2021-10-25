package ut02

import android.util.Log

class ExampleCallback {
    //Hago referencia a otra clase para ver mejor los ejemplos.
    private val TAG = NetworkActivity::class.java.canonicalName


    /**
     * No podemos devolver un dato desde un hilo ya que el proceso principal, el que crea el hilo
     * no espera a que termine de ejecutarse el código.
     */
    fun getUsers(): List<UserApiModel> {
        Thread(Runnable {
            //Simulo con un sleep a 5s el tiempo de demora a una llamada a API
            Thread.sleep(5000)

            //Creo un modelo de datos para pruebas. Datos inventados.
            val user = UserApiModel(1, "Usuario 1", "Usuario1", "user@email.es")

            //La siguiente línea está comentada porque da un error. No se puede hacer así.
            //return mutableListOf(user)

            //Lo sustituyo por un log para ver el resultado
            Log.i(TAG, "$user")
        }).start()
        return mutableListOf()
    }

    /**
     * Aquí devolvemos lo que se crea en el thread a través del callback.
     */
    fun getUsers(apiCallback: ApiCallback<List<UserApiModel>>) {
        Thread(Runnable {
            //Simulo con un sleep a 5s el tiempo de demora a una llamada a API
            Thread.sleep(5000)

            //Creo un modelo de datos para pruebas. Datos inventados.
            val user = UserApiModel(1, "Usuario 1", "Usuario1", "user@email.es")

            //Devulve un listado de usuarios a través del callback.
            apiCallback.onResponse(mutableListOf(user))

        }).start()
    }
}