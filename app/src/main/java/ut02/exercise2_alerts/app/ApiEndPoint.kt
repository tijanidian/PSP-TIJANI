package ut02.exercise2_alerts.app

import retrofit2.Call
import retrofit2.http.GET
import ut02.exercise2_alerts.data.ApiResponse
import ut02.exercise2_alerts.domain.AlertModel

interface ApiEndPoint {
    @GET("alerts")
    fun getAlerts(): Call<ApiResponse<List<AlertModel>>>
}