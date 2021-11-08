package ut02.exercise2_alerts.data

import ut02.exercise2_alerts.domain.AlertModel
import ut02.exercise2_alerts.domain.AlertRepository

class AlertDataRepository:AlertRepository {
    override fun getAlerts(): List<AlertModel> = mutableListOf(
        AlertModel("alert_id","summary","s","date","dad")
    )
}