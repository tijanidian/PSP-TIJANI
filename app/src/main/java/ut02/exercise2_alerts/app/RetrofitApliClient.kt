package ut02.exercise2_alerts.app

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ut02.exercise2_alerts.data.remote.AlertApiModel
import java.util.concurrent.TimeUnit


class RetrofitApliClient: ApiClient {
    private val urlEndPoint: String = "https://plagricola.sitehub.es/api/public/"
    private var apiEndPoint: ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    private fun buildApiService(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }


    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .client(buildHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun buildHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

    override fun getAlerts(): List<AlertApiModel> {
       val call=apiEndPoint.getAlerts()
        val response=call.execute()
        return if (response.isSuccessful){
            response.body()?.data?: mutableListOf()
        }else{
            mutableListOf()
        }

    }


}