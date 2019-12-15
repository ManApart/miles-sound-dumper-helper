import java.util.concurrent.Callable

interface TimedProcess : Callable<Any> {
    val id: String
}