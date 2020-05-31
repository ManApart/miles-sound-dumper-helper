import kotlinx.coroutines.*

val range = toRange(6000, 6100 )
const val chunkSize = 20

const val timeOutInSeconds = 60.toLong() * 6
const val path = "R:\\Games\\Default\\Apex"
const val detailedDebug = false

fun main() {
    println("Starting to process ${range.size} ids")
    range.chunked(chunkSize).map {
        processChunk(it)
    }
}

private fun processChunk(ids: List<Int>) {
    println("Processing $ids")
    runBlocking {
        ids.forEach {
            async {
//                SongExporterPlacebo(it, timeOutInSeconds).export()
                MSDSongExporter(it, timeOutInSeconds).export()
            }
        }
    }
}

private fun toRange(start: Int, stop: Int, step: Int = 1): List<Int> {
    val steps = (stop - start) / step
    return (0..steps).map { start + it * step }
}