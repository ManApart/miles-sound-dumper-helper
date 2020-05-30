class SongExporterPlacebo(id: Int, private val timeOutInSeconds: Long) : SongExporter {
    override val id: String = id.toString()
    override fun call() {
        println("Doing nothing for $id")
        Thread.sleep(3000)
    }

}