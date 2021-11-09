package ut02.exercise2_alerts.app

import ut02.exercise2_alerts.data.remote.AlertApiModel


interface ApiClient {
    fun getAlerts(): List<AlertApiModel>
}

