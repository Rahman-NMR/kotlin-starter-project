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
    if (isPrime(number)) return null

    return when {
        number % 15 == 0 -> "FooBar"
        number % 3 == 0 -> "Foo"
        number % 5 == 0 -> "Bar"
        else -> number.toString()
    }
}

fun isPrime(number: Int): Boolean {
    if (number <= 1) return false
    if (number <= 3) return true
    if (number % 2 == 0 || number % 3 == 0) return false

    var divisor = 5
    while (divisor <= number / divisor) {
        if (number % divisor == 0 || number % (divisor + 2) == 0) return false
        divisor += 6
    }

    return true
}
