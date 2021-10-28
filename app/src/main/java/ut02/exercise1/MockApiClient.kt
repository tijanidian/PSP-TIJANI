package ut02.exercise1

class MockApiClient:ApiClient {
    override fun getUser(userId: Int): UserApiModel? {
       return UserApiModel(userId ,"Tijani","Dian","tijani@email.com")
    }

    override fun getUsers(): List<UserApiModel> {
        return mutableListOf(
            UserApiModel(1,"Tijani 1","Dian 1","tijani1@email.com"),
            UserApiModel(2,"Tijani 2","Dian 2","tijani2@email.com"),
            UserApiModel(3,"Tijani 3","Dian 3","tijani3@email.com"),
            UserApiModel(4,"Tijani 4","Dian 4","tijani4@email.com"),
            UserApiModel(5,"Tijani 5","Dian 5","tijani5@email.com"),
        )
    }
}