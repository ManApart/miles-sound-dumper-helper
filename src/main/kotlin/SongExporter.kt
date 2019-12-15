import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader

class SongExporter(id: Int) : TimedProcess {
    override val id: String = id.toString()
    private val directory = File(path)

    override fun call() {
        val process = ProcessBuilder("$directory\\MSD.exe", id, "-m", "--start=2000").directory(directory).start()
        val `is`: InputStream = process.inputStream
        val isr = InputStreamReader(`is`)
        val br = BufferedReader(isr)
        var line: String?

        while (br.readLine().also { line = it } != null) {
            if (detailedDebug) {
                println(line)
            }
        }
    }

}