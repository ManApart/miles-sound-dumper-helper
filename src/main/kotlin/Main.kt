import kotlinx.coroutines.*

//val range = 17000.rangeTo(10) upTo 45000 step 100)
val range = toRange(17000, 45000, 100)

//val range = 25912..25913
//const val timeOutInSeconds = 6.toLong()
const val timeOutInSeconds = 60.toLong() * 6
const val path = "R:\\Games\\Default\\Apex"
const val detailedDebug = false

fun main() {
    println("Starting to process ${range.size} ids")
    range.chunked(10).map {
        processChunk(it)
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

private fun toRange(start: Int, stop: Int, step: Int = 1): List<Int> {
    val steps = (stop - start) / step
    return (0..steps).map { start + it * step }
}