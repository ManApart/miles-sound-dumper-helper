import kotlinx.coroutines.*

val range = 16500..16600

//val range = 25912..25913
//const val timeOutInSeconds = 6.toLong()
const val timeOutInSeconds = 60.toLong() * 6
const val path = "R:\\Games\\Default\\Apex"
const val detailedDebug = false

fun main() {
    println("Starting")

    range.chunked(10).map {
        processChunk(it)
        println("Chunk processed")
    }

}

private fun processChunk(ids: List<Int>) {
    runBlocking {
        val tasks = ids.map { MSDSongExporter(it, timeOutInSeconds) }
//        val tasks = ids.map { SongExporterPlacebo(it, timeOutInSeconds) }
        val executer = TimedExecutor(tasks)
            launch {
                executer.execute()
            }
    }
}