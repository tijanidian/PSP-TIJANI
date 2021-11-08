package ut02.exercise2_alerts.domain

class GetAlertUseCase (private val alertRepository: AlertRepository){
    fun execute(): List<AlertModel> {
        return alertRepository.getAlerts()
    }
}