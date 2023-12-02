package first

fun main() {
    val numbers = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    fun leftToRight(line: String): String {
        var first: Char? = null
        var last = '0'
        for (i in line.indices) {
            val stripped = line.drop(i)
            if (stripped[0].isDigit()) {
                if (first == null) first = stripped[0]
                last = stripped[0]
            }
            numbers.forEachIndexed { index, number ->
                if (stripped.startsWith(number, true)) {
                    if (first == null) first = index.digitToChar()
                    last = index.digitToChar()
                }
            }
        }
        return "$first$last"
    }


    val lines = Unit::class.java.getResourceAsStream("/1a.txt")?.readAllBytes()?.decodeToString()?.lines() ?: emptyList()
    var amount = 0
    lines.forEach {
        val stringInt = leftToRight(it)
        val number = stringInt.toIntOrNull() ?: 0
        amount += number
    }
    println(amount)
}