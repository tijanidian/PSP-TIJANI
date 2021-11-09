package ut02.exercise2_alerts.app

import ut02.exercise2_alerts.data.remote.AlertApiModel
import ut02.exercise2_alerts.domain.AlertModel

class MockApiClient : ApiClient {
    override fun getAlerts(): List<AlertApiModel> {
        return mutableListOf(
            AlertApiModel("1", "Titulo 1", "Resumen alerta 1", "1", "2021-01-10", "", ""),
            AlertApiModel("2", "Titulo 2", "Resumen alerta 2", "1", "2021-01-09", "", ""),

            )
    }


}