package ut02.exercise2_alerts.domain

data class AlertModel(
    val id: String,
    val title: String,
    val type: Int,
    val summary: String,
    val datePublished: String,
    val body: String,
    val source: String,
    val files: List<FileModel>

)

data class FileModel(val name: String, val url: String)

