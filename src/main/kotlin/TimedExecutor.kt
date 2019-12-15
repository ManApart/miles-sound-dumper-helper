import java.util.concurrent.*


class TimedExecutor(private val task: TimedProcess, private val timeOut: Long) {
    private val executor = Executors.newSingleThreadScheduledExecutor()

    fun execute() {
        val future: Future<Any> = executor.submit(task)
        try {
            val result = future[timeOut, TimeUnit.MILLISECONDS]
            println("Exported ${task.id}")
        } catch (ex: TimeoutException) {
            println("Stopping ${task.id}")
        } catch (e: InterruptedException) {
            println("${task.id} Interrupted $e")
        } catch (e: ExecutionException) {
            println("${task.id} experienced an execution exception $e")
        } finally {
            executor.shutdown()
        }
    }
}