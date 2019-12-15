val range = 25823..25848
const val timeOut = 1000.toLong() * 60 * 1
const val path = "R:\\Games\\Default\\Apex"

fun main() {
    println("Starting")

    range.chunked(10).map {
        val executor = TimedExecutor(range.map { SongExporter(it) }, timeOut)
        executor.execute()
    }

}