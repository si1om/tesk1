fun main() {
    fun check(name: String, result: Boolean, correctResult: Boolean) {
        println(if (result == correctResult) "✅ $name" else "❌ $name")
    }

    println("|--- Running Sudoku Validator Tests ---|")

    //valid cases

    check(
        name = "Valid empty 3x3 grid",
        result = isValidSudoku(List(3) { List(3) { '-' } },
            1),
        correctResult = true
    )

    check(
        name = "Valid complete 3x3 grid (mini Sudoku)",
        result = isValidSudoku(
            listOf(
                listOf('3', '1', '2'),
                listOf('1', '2', '3'),
                listOf('2', '3', '1')
            ),
            subgridSize = 1
        ),
        correctResult = true
    )

    check(
        name = "Valid 4x4 grid",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '4', '1', '2'),
                listOf('2', '1', '4', '3'),
                listOf('4', '3', '2', '1')
            ), 2
        ),
        correctResult = true
    )

    check(
        name = "Grid with one filled cell",
        result = isValidSudoku(
            listOf(
                listOf('1', '-', '-', '-'),
                listOf('-', '-', '-', '-'),
                listOf('-', '-', '-', '-'),
                listOf('-', '-', '-', '-')
            ), 2
        ),
        correctResult = true
    )

    check(
        name = "Valid empty 9x9 grid",
        result = isValidSudoku(
            List(9) { List(9) { '-' } },
            3
        ),
        correctResult = true
    )

    check(
        name = "Valid complete 9x9 grid",
        result = isValidSudoku(
            listOf(
                listOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
                listOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                listOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                listOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                listOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                listOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
                listOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                listOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                listOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
            ),
            3
        ),
        correctResult = true
    )

    check(
        name = "Valid complete 16x16 grid",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4', '5', '6', '-', '8', '9', '-', 'B', 'C', '-', 'E', 'F', 'G'),
                listOf('3', '-', '-', '6', '7', '8', '9', 'A', '-', 'C', 'D', '-', 'F', 'G', '1', '2'),
                listOf('2', '1', '4', '3', '6', '5', '-', '7', 'A', '9', '-', 'B', 'E', 'D', 'G', 'F'),
                listOf('-', '6', '7', '-', '9', 'A', 'B', 'C', '-', 'E', 'F', '-', '1', '2', '3', '4'),
                listOf('5', '-', '2', '1', '-', '7', '-', 'E', 'G', 'D', '-', '6', '9', 'A', '-', 'C'),
                listOf('-', '8', '9', '-', 'B', 'C', '-', '1', '2', '-', '4', '5', '6', 'F', 'E', 'G'),
                listOf('6', '5', '1', '2', '3', '4', 'E', 'D', 'C', 'B', '-', '9', '-', '7', 'G', 'F'),
                listOf('-', 'A', 'B', 'C', '-', 'E', '-', 'G', '1', '2', '3', '4', '-', '6', '-', '8'),
                listOf('8', '-', '6', '5', '4', '3', '2', '1', 'E', 'F', 'G', 'D', 'C', 'B', 'A', '9'),
                listOf('-', '9', '8', '7', '-', 'E', 'D', '-', 'B', '-', '1', '2', '3', '4', '5', '6'),
                listOf('-', '-', 'D', 'E', 'G', 'F', '-', '9', '8', '7', '6', '5', '-', '3', '2', '1'),
                listOf('C', '-', 'A', '9', '-', '1', '5', '-', '3', 'D', '-', 'F', 'G', '8', '7', '6'),
                listOf('-', 'E', '-', 'A', '1', '2', '3', 'B', '4', '5', '7', '8', '-', '9', '-', 'C'),
                listOf('-', '-', '3', '-', '-', '8', '6', '-', '5', 'C', '-', 'B', '2', '1', '4', 'D'),
                listOf('-', 'G', '-', 'D', 'A', '-', 'C', '5', '6', '1', '8', '-', 'B', '3', '-', '-'),
                listOf('4', '-', 'C', 'B', 'E', 'D', '2', '-', '7', '8', '-', 'A', '-', '5', '9', '3')
            ), 4
        ),
        correctResult = true
    )

    //invalid cases

    check(
        name = "Invalid 3x3 grid (duplicate in row)",
        result = isValidSudoku(
            listOf(
                listOf('3', '1', '1'),
                listOf('1', '2', '3'),
                listOf('2', '3', '1')
            ),
            subgridSize = 1
        ),
        correctResult = false
    )


    check(
        name = "Invalid grid dimensions",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3'),
                listOf('4', '1', '2'),
                listOf('2', '3', '1')
            ), 2
        ),
        correctResult = false
    )

    check(
        name = "4x4 with row duplicate",
        result = isValidSudoku(
            listOf(
                listOf('1', '1', '3', '4'),
                listOf('3', '4', '1', '2'),
                listOf('2', '1', '4', '3'),
                listOf('4', '3', '2', '1')
            ), 2
        ),
        correctResult = false
    )

    check(
        name = "4x4 with column duplicate",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '4', '2', '1'),
                listOf('2', '4', '1', '3'),
                listOf('4', '3', '2', '1')
            ), 2
        ),
        correctResult = false
    )

    check(
        name = "Grid with invalid characters",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', 'X', '1', '2'),
                listOf('2', '1', '4', '3'),
                listOf('4', '3', '2', '1')
            ), 2
        ),
        correctResult = false
    )

    check(
        name = "4x4 valid rows/columns but invalid subgrid",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('2', '1', '4', '3'),
                listOf('3', '4', '1', '2'),
                listOf('4', '3', '2', '1')
            ), 3
        ),
        correctResult = false
    )

    check(
        name = "5x4 rectangular grid",
        result = isValidSudoku(
            listOf(
                List(4) { '-' },
                List(4) { '-' },
                List(4) { '-' },
                List(4) { '-' },
                List(4) { '-' }
            ), subgridSize = 2
        ),
        correctResult = false
    )

    check(
        name = "4x4 grid with subgridSize=3",
        result = isValidSudoku(
            listOf(
                listOf('1', '2', '3', '4'),
                listOf('3', '4', '1', '2'),
                listOf('2', '1', '4', '3'),
                listOf('4', '3', '2', '1')
            ), subgridSize = 3
        ),
        correctResult = false
    )

    check(
        name = "inValid incomplete 16x16 grid",
        result = isValidSudoku(
            listOf(
                listOf('1', '-', '-', '4', '-', '-', '-', '8', '-', '-', '-', 'C', '-', '-', '-', 'G'),
                listOf('-', '2', '-', '-', '-', '6', '-', '-', '-', 'A', '-', '-', '-', 'E', '-', '-'),
                listOf('-', '-', '-', 'D', '-', '-', '-', '1', '-', '-', '-', '5', '-', '-', '-', '9')
            ), 4
        ),
        correctResult = false
    )

    check(
        name = "16x16 with lowercase 'a'",
        result = isValidSudoku(
            listOf(
                listOf('1', '-', '-', '4', '-', '-', '-', '8', '-', '-', '-', 'C', '-', '-', '-', 'G'),
                listOf('-', '2', '-', '-', '-', '6', '-', '-', '-', 'a', '-', '-', '-', 'E', '-', '-'),
            ) + List(14) { List(16) { '-' } }, 4
        ),
        correctResult = false
    )

    check(
        name = "9x9 with invalid, subgrid 5 duplicated in bottom right ",
        result = isValidSudoku(
            listOf(
                listOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
                listOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                listOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                listOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                listOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                listOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
                listOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                listOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                listOf('3', '4', '5', '2', '8', '6', '1', '7', '5')
            ),
            3
        ),
        correctResult = false
    )



}

fun isValidSudoku(grid: List<List<Char>>, subgridSize: Int): Boolean {
    val n = grid.size

    if (grid.isEmpty() || grid.any { it.size != n }) return false
    if (n != subgridSize * subgridSize && !(n == 3 && subgridSize == 1)) return false

    val validChars = mutableSetOf('-').apply {
        when (n) {
            3 -> addAll('1'..'3')
            4 -> addAll('1'..'4')
            9 -> addAll('1'..'9')
            16 -> { addAll('1'..'9'); addAll('A'..'G') }
            else -> return false
        }
    }

    if (grid.any { row -> row.any { it !in validChars } }) return false

    for (i in 0..<n) {
        val rowSeen = mutableSetOf<Char>()
        val colSeen = mutableSetOf<Char>()
        for (j in 0..<n) {
            val rowCell = grid[i][j]
            if (rowCell != '-' && !rowSeen.add(rowCell)) return false

            val colCell = grid[j][i]
            if (colCell != '-' && !colSeen.add(colCell)) return false
        }
    }

    if (subgridSize > 1) {
        for (boxRow in 0..<n step subgridSize) {
            for (boxCol in 0..<n step subgridSize) {
                val seen = mutableSetOf<Char>()
                for (i in 0..<subgridSize) {
                    for (j in 0..<subgridSize) {
                        val cell = grid[boxRow + i][boxCol + j]
                        if (cell != '-' && !seen.add(cell)) return false
                    }
                }
            }
        }
    }

    return true
}