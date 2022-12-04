import java.io.File
import java.nio.charset.Charset

fun getInputFilePath(path: String): String? =
    object {}.javaClass.getResource(path)?.file

fun getLinesOfFile(path: String): List<String>? =
    String(File(getInputFilePath(path)).readBytes(), Charset.defaultCharset()).split("\n")

