fun main() {
    fun check(name: String, result: Boolean, correctResult: Boolean) {
        println(if (result == correctResult) "✅ $name" else "❌ $name")
        }


        println("|--- Running IPv4 Validator Tests ---|")

    check(
        name = "single zero should be valid",
        result = IPv4("155.138.8.66"),
        correctResult = true
    )

    check(
        name = "valid mixed value IPv4 address",
        result = IPv4("9.1.233.4"),
        correctResult = true
    )

    check(
        name = "valid maximum value IPv4 address",
        result = IPv4("255.255.255.255"),
        correctResult = true
    )


    check(
        name = "valid minimum value IPv4 address",
        result = IPv4("0.0.0.0"),
        correctResult = true
    )


    check(
        name = "valid simple IPv4 address",
        result = IPv4("142.118.8.5"),
        correctResult = true
    )

    check(
        name = "negative segment value should be invalid",
        result = IPv4("160.-7.110.21"),
        correctResult = false
    )



    check(
        name = "extra segments should be invalid",
        result = IPv4("191.178.0.0.10"),
        correctResult = false
    )

    check(
        name = "the segment value more than 255 should be invalid",
        result = IPv4("256.1.8.6"),
        correctResult = false
    )


    check(
        name = "begin with zero should be invalid",
        result = IPv4("091.069.004"),
        correctResult = false
    )
    check(
        name = "leading zeros should be invalid",
        result =IPv4("193.169.08.1"),
        correctResult = false
    )
    check(
        name = "contains letters and numbers should be invalid",
        result = IPv4("192.2f.2.1"),
        correctResult = false
    )

    check(
        name = "triple zeros should be invalid",
        result = IPv4("192.168.000.1"),
        correctResult = false
    )
    check(
        name = "contains letters and numbers should be invalid",
        result = IPv4("192.1b.2$.1"),
        correctResult = false
    )

    check(
        name = "contains spaces should be invalid",
        result = IPv4("192. 168.1.1"),
        correctResult = false
    )

    check(
        name = "contains spaces should be invalid",
        result = IPv4("192. 168.1.1 "),
        correctResult = false
    )

    check(
        name = "contains spaces should be invalid",
        result = IPv4("192 . 16 8.1.1"),
        correctResult = false
    )

    check(
        name = "missing dots should be invalid",
        result =IPv4("19.216811"),
        correctResult = false
    )

    check(
        name = "missing dots should be invalid",
        result = IPv4("19217711"),
        correctResult = false
    )

    check(
        name = "extra dots should be invalid",
        result = IPv4("192..168.1..1"),
        correctResult = false
    )

    check(
        name = "extra dots should be invalid",
        result = IPv4("192.168.1..1"),
        correctResult = false
    )

    check(
        name = "leading dot should be invalid",
        result = IPv4(".192.168.1.1"),
        correctResult = false
    )

    check(
        name = "trailing dot should be invalid",
        result =IPv4(".192.168.1.1."),
        correctResult = false
    )

    check(
        name = "trailing dot should be invalid",
        result = IPv4("192@168#1.1."),
        correctResult = false
    )
}

fun IPv4( IP: String): Boolean {
    val segments = IP.split('.')

    // There should be exactly 4 segments.
    if (segments.size != 4) return false

    // Verify that each section follows the rules.
    for (segment in segments) {
        // Verify that the section is not empty.
        if (segment.isEmpty()) return false

        // Check for trailing zeros (eg 01 or 001)
        if (segment.length > 1 && segment[0] == '0') return false

        // Verify that the section contains only numbers.
        if (!segment.matches(Regex("\\d+"))) return false

        val num = segment.toInt()
        // Check that the value is between 0 and 255.
        if (num !in 0..255) return false
    }

    return true
}
