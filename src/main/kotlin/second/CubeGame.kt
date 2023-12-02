package second

fun main() {
    fun grabNumber(line: String, index: Int): Int {
        return "${line[index - 3]}${line[index - 2]}".replace(" ", "").toInt()
    }

    fun checkLine(line: String): Int {
        var red = 0
        var green = 0
        var blue = 0
        line.forEachIndexed { index, c ->
            if (index > 1 && line[index - 1] != ' ') return@forEachIndexed
            if (c == 'b') {
                val n = grabNumber(line, index)
                if (n > blue) blue = n
            }
            if (c == 'r') {
                val n = grabNumber(line, index)
                if (n > red) {
                    red = n
                }
            }
            if (c == 'g') {
                val n = grabNumber(line, index)
                if (n > green) green = n
            }
        }
        println("$line -> (r:$red b:$blue g:$green)")
        return red * blue * green
    }

    val lines = Unit::class.java.getResourceAsStream("/2a.txt")?.readAllBytes()?.decodeToString()?.lines() ?: emptyList()
    var amount = 0
    lines.forEachIndexed { _, line ->
        if (line.isBlank()) return@forEachIndexed
        amount += checkLine(line)
    }
    println(amount)
}