import java.util.concurrent.Callable

class MockTimedProcess(private val sleepTime: Long = 10, override val id: String = "123") : TimedProcess {
    var complete = false
    override fun call() {
        Thread.sleep(sleepTime)
        complete = true
    }
}