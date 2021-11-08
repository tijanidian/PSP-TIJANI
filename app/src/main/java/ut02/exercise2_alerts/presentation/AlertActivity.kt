package ut02.exercise2_alerts.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tijani.psp_playground.R
import ut02.exercise2_alerts.data.AlertDataRepository
import ut02.exercise2_alerts.app.ApiClient
import ut02.exercise2_alerts.domain.GetAlertUseCase
import ut02.exercise2_alerts.app.RetrofitApliClient

class AlertActivity : AppCompatActivity() {
    private val apiClient: ApiClient = RetrofitApliClient()
    private val viewModel: AlertViewModel = AlertViewModel(GetAlertUseCase(AlertDataRepository()))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)
        render()
    }

    private fun render(){
        val thread= Thread(Runnable {
            val alerts = apiClient.getAlerts()
            if (alerts.isNotEmpty()) {
                alerts.forEach {
                    Log.i("@tijani", "$it")
                }
            } else {
                Log.i("@tijani", "vacio")
            }
        })
        thread.start()

    }


}