package ut02.exercise2_alerts.data.remote

import ut02.exercise2_alerts.domain.AlertModel

data class AlertApiModel(
    val alert_id: String,
    val title: String,
    val summary: String,
    val type: String,
    val date: String,
    val body: String? = "",
    val source: String? = "",
) {
    fun toDomainModel(): AlertModel=AlertModel(
        alert_id,
        title,
        type.toInt(),
        summary,
        date,
        body ?: "",
        source ?: "",
        emptyList()
    )
}