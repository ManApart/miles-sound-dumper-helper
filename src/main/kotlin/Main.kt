val range = 25823..25848
const val timeOutInSeconds = 60.toLong() * 6
const val path = "R:\\Games\\Default\\Apex"
const val detailedDebug = false

fun main() {
    println("Starting")

    range.chunked(10).map {
        val executor = TimedExecutor(range.map { SongExporter(it) }, timeOutInSeconds)
        executor.execute()
    }

}