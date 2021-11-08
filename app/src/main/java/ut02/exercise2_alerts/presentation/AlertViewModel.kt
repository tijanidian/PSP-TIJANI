package ut02.exercise2_alerts.presentation

import androidx.lifecycle.ViewModel
import ut02.exercise2_alerts.domain.GetAlertUseCase

class AlertViewModel(private val getAlertUseCase: GetAlertUseCase) : ViewModel() {

    fun getAlerts() = getAlertUseCase.execute()
}