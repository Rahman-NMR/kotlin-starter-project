package fizzbuzz

fun main() {
    val range = 100 downTo 1

    val result = range
        .mapNotNull {
            generateFizzBuzzValue(it)
        }.joinToString(", ")

    print(result)
}

fun generateFizzBuzzValue(number: Int): String? {
    return when {
        number % 15 == 0 -> "FooBar"
        number % 3 == 0 -> "Foo"
        number % 5 == 0 -> "Bar"
        else -> number.toString()
    }
}