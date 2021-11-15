package ut03.ex01.app

data class UserApiModel(val id: Int, val name: String, val username: String, val email: String)

/**
 * Modelo de datos para los post que escriben los usuarios desde la API
 */
data class PostApiModel(val userId: Int, val id: Int, val title: String, val body: String)