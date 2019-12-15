import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MainTest {

    @Test
    fun taskCompletesBeforeTimeout() {
        val task = MockTimedProcess(10)
        val executor = TimedExecutor(task, 100)
        executor.execute()
        assertTrue(task.complete)
    }

    @Test
    fun taskIsStoppedByTimeout() {
        val task = MockTimedProcess(100)
        val executor = TimedExecutor(task, 10)
        executor.execute()
        assertFalse(task.complete)
    }

}