package ut02.exercise2_alerts.data.remote

import ut02.exercise2_alerts.app.ApiClient
import ut02.exercise2_alerts.domain.AlertModel


class AlertRemoteSource(private val apiClient: ApiClient) {

  fun getAlerts():List<AlertModel>{
      val alertApiModel=apiClient.getAlerts()
      return alertApiModel.map { apiModel ->apiModel.toDomainModel() }
  }



}