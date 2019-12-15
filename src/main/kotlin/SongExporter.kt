import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader
import java.util.concurrent.Callable

class SongExporter(override val id: String) : TimedProcess {
    private val path = "R:\\Games\\Default\\Apex"
    private val directory = File(path)

    override fun call() {
        val process = ProcessBuilder("$directory\\MSD.exe", id).directory(directory).start()
        val `is`: InputStream = process.inputStream
        val isr = InputStreamReader(`is`)
        val br = BufferedReader(isr)
        var line: String?

        while (br.readLine().also { line = it } != null) {
            println(line)
        }
    }

}