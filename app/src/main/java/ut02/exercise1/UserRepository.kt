package ut02.exercise1

class UserRepository(private val apiClient: ApiClient) {
    fun getUsers(): List<UserApiModel> = apiClient.getUsers()

    fun getUser(id: Int): UserApiModel? = apiClient.getUser(id)
}