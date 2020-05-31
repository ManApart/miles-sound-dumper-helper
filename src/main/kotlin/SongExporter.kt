interface SongExporter {
    val id: String
    suspend fun export()
}