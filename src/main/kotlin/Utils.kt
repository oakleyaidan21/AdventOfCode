
fun getInputFilePath(path: String): String? =
    object {}.javaClass.getResource(path)?.file
