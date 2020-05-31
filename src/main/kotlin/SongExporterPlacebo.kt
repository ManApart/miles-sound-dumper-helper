import kotlinx.coroutines.delay

class SongExporterPlacebo(id: Int, private val timeOutInSeconds: Long) : SongExporter {
    override val id: String = id.toString()
    override suspend fun export() {
        println("Doing nothing for $id")
        delay(3000)
    }

}