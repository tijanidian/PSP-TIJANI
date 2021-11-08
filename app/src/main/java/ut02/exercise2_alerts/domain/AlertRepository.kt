package ut02.exercise2_alerts.domain

interface AlertRepository {
    fun getAlerts(): List<AlertModel>
}