package ut02

import com.tijani.psp_playground.R
import ut02.exercise1.ApiClient
import ut02.exercise1.MockApiClient
import ut02.exercise1.RetrofitApliClient

class ApiClientFactory {
    fun build(actionId: Int): ApiClient =
        when (actionId) {
            R.id.action_mock -> MockApiClient()
            R.id.action_api -> RetrofitApliClient()
            else -> MockApiClient()
        }
}