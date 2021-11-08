package ut02.exercise2_alerts.app

import ut02.exercise2_alerts.domain.AlertModel

interface ApiClient {
    fun getAlerts():List<AlertModel>
}

