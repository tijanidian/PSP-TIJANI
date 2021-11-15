package ut03.ex01.app

interface ApiCallback<T> {
    fun onResponse(apiModel: T)
    fun onFailure(error: String)
}

/**
 * Otra alternativa a la funciónes anónimas es crear el detalle de la interfaz.
 * El problema aquí, es si tienes varias llamadas a usuario con funcionalidades distintas,
 * deberías crear una clase específica por cada funcionalidad distinta que tengas.
 *
 */
class UserApiCallback : ApiCallback<UserApiModel> {

    override fun onResponse(apiModel: UserApiModel) {
        TODO("Not yet implemented")
    }

    override fun onFailure(error: String) {
        TODO("Not yet implemented")
    }

}