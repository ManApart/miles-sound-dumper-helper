fun main() {
    println("Starting")
    val range = 18481..18483
    val timeOut = 1000.toLong() * 60 * 1

    val executor = TimedExecutor(range.map { SongExporter(it) }, timeOut)
    executor.execute()
}