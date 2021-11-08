package ut02.exercise2_alerts.app

import ut02.exercise2_alerts.domain.AlertModel

class MockApiClient : ApiClient {
    override fun getAlerts(): List<AlertModel> {
        return mutableListOf(
            AlertModel("1", "summary", "summary", "08/11/21","3213"),

            )
    }


}