import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader

class MSDSongExporter(id: Int, private val timeOutInSeconds: Long) : SongExporter {
    override val id: String = id.toString()
    private val directory = File(path)

    override fun call() {
        println("Exporting $id")
        val process = ProcessBuilder("$directory\\MSD.exe", id, "-m", "--start=2000").directory(directory).start()
        val `is`: InputStream = process.inputStream
        val isr = InputStreamReader(`is`)
        val br = BufferedReader(isr)
        var line: String? = ""

        val endTime = System.currentTimeMillis() + timeOutInSeconds * 1000

        while (System.currentTimeMillis() < endTime && br.readLine().also { line = it } != null) {
            if (detailedDebug) {
                println(line)
            }
        }
    }

}