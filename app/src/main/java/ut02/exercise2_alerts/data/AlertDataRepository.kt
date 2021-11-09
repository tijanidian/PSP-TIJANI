package ut02.exercise2_alerts.data

import ut02.exercise2_alerts.data.remote.AlertRemoteSource
import ut02.exercise2_alerts.domain.AlertModel
import ut02.exercise2_alerts.domain.AlertRepository

class AlertDataRepository(private val alertRemote: AlertRemoteSource):AlertRepository {
    override fun fetchALL(): List<AlertModel> {
        val remoteModel=alertRemote.getAlerts()
        return remoteModel
    }


}