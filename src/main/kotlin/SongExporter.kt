import java.util.concurrent.Callable

interface SongExporter : Callable<Any>{
    val id: String
}