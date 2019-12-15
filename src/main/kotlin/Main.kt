import java.io.*
import java.util.concurrent.TimeUnit


fun main() {
    println("Hello world")
//    val path = "B:\\Coding\\Workspace\\Utility\\msdHelper\\test"
    val path = "R:\\Games\\Default\\Apex"
    val directory = File(path)
//    val command = "R:\\Games\\Default\\Apex\\MSD.exe 123"
    val command = "ls -al"
//    val command = "ping www.google.com"
//    val command = "/bin/bash -c ls"

    executeApp(path, directory)



//    val directory = File(".")

//    command.runCommand(directory)
//    "/bin/bash -c ls".runCommand(directory)

}

fun tryProcess() {
    //    try {
//        val process = Runtime.getRuntime().exec("top -n 1 -d 1")
//        val `in` = BufferedReader(InputStreamReader(process.inputStream))
//    } catch (e: InterruptedException) {
//        e.printStackTrace()
//    }
}

fun getRuntime() {
    //    val proc = Runtime.getRuntime().exec(command)
//    proc.waitFor();
//
//    // Read the output
//    val reader = BufferedReader(InputStreamReader(proc.inputStream))
//
//    var line = ""
//    while (reader.readLine().also { line = it } != null) {
//        print(line + "\n")
//    }
//
//    proc.waitFor()
}


fun executeApp(directory: String, file: File) {
    val process = ProcessBuilder("$directory\\MSD.exe", "123").directory(file).start()
    val `is`: InputStream = process.inputStream
    val isr = InputStreamReader(`is`)
    val br = BufferedReader(isr)
    var line: String?

    while (br.readLine().also { line = it } != null) {
        println(line)
    }
}


fun String.runCommand(workingDir: File): String? {
    return try {
        val parts = this.split("\\s".toRegex())
        val proc = ProcessBuilder(*parts.toTypedArray())
                .directory(workingDir)
                .redirectOutput(ProcessBuilder.Redirect.PIPE)
                .redirectError(ProcessBuilder.Redirect.PIPE)
                .start()

        proc.waitFor(1000, TimeUnit.MILLISECONDS)
        proc.inputStream.bufferedReader().readText()
    } catch(e: IOException) {
        e.printStackTrace()
        null
    }
}