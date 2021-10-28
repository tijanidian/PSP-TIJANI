package ut02.exercise1

interface ApiClient {
    fun getUser(userId: Int): UserApiModel?
    fun getUsers(): List<UserApiModel>
}