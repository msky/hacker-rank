package hackerrank

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class QueensAttackSpec : FreeSpec({
    val tested = QueensAttack()

    "queens attack" {
        forAll(
            table(
                headers(
                    "boardSize",
                    "numberOfObstacles",
                    "rowWithQueen",
                    "columnWithQueen",
                    "obstacles",
                    "expectedNumberOfAttackedFields"
                ),
                row(100000, 0, 4187, 5068, emptyArray(), 308369),
                row(8, 0, 1, 1, emptyArray(), 21),
                row(4, 0, 4, 4, emptyArray(), 9),
                row(100,100, 48, 81, arrayOf(
                    arrayOf(54, 87),
                    arrayOf(64, 97),
                    arrayOf(42, 75),
                    arrayOf(32, 65),
                    arrayOf(42, 87),
                    arrayOf(32, 97),
                    arrayOf(54, 75),
                    arrayOf(64, 65),
                    arrayOf(48, 87),
                    arrayOf(48, 75),
                    arrayOf(54, 81),
                    arrayOf(42, 81),
                    arrayOf(45, 17),
                    arrayOf(14, 24),
                    arrayOf(35, 15),
                    arrayOf(95, 64),
                    arrayOf(63, 87),
                    arrayOf(25, 72),
                    arrayOf(71, 38),
                    arrayOf(96, 97),
                    arrayOf(16, 30),
                    arrayOf(60, 34),
                    arrayOf(31, 67),
                    arrayOf(26, 82),
                    arrayOf(20, 93),
                    arrayOf(81, 38),
                    arrayOf(51, 94),
                    arrayOf(75, 41),
                    arrayOf(79, 84),
                    arrayOf(79, 65),
                    arrayOf(76, 80),
                    arrayOf(52, 87),
                    arrayOf(81, 54),
                    arrayOf(89, 52),
                    arrayOf(20, 31),
                    arrayOf(10, 41),
                    arrayOf(32, 73),
                    arrayOf(83, 98),
                    arrayOf(87, 61),
                    arrayOf(82, 52),
                    arrayOf(80, 64),
                    arrayOf(82, 46),
                    arrayOf(49, 21),
                    arrayOf(73, 86),
                    arrayOf(37, 70),
                    arrayOf(43, 12),
                    arrayOf(94, 28),
                    arrayOf(10, 93),
                    arrayOf(52, 25),
                    arrayOf(50, 61),
                    arrayOf(52, 68),
                    arrayOf(52, 23),
                    arrayOf(60, 91),
                    arrayOf(79, 17),
                    arrayOf(93, 82),
                    arrayOf(12, 18),
                    arrayOf(75, 64),
                    arrayOf(69, 69),
                    arrayOf(94, 74),
                    arrayOf(61, 61),
                    arrayOf(46, 57),
                    arrayOf(67, 45),
                    arrayOf(96, 64),
                    arrayOf(83, 89),
                    arrayOf(58, 87),
                    arrayOf(76, 53),
                    arrayOf(79, 21),
                    arrayOf(94, 70),
                    arrayOf(16, 10),
                    arrayOf(50, 82),
                    arrayOf(92, 20),
                    arrayOf(40, 51),
                    arrayOf(49, 28),
                    arrayOf(51, 82),
                    arrayOf(35, 16),
                    arrayOf(15, 86),
                    arrayOf(78, 89),
                    arrayOf(41, 98),
                    arrayOf(70, 46),
                    arrayOf(79, 79),
                    arrayOf(24, 40),
                    arrayOf(91, 13),
                    arrayOf(59, 73),
                    arrayOf(35, 32),
                    arrayOf(40, 31),
                    arrayOf(14, 31),
                    arrayOf(71, 35),
                    arrayOf(96, 18),
                    arrayOf(27, 39),
                    arrayOf(28, 38),
                    arrayOf(41, 36),
                    arrayOf(31, 63),
                    arrayOf(52, 48),
                    arrayOf(81, 25),
                    arrayOf(49, 90),
                    arrayOf(32, 65),
                    arrayOf(25, 45),
                    arrayOf(63, 94),
                    arrayOf(89, 50),
                    arrayOf(43, 41))
                , 40),
                row(
                    5, 3, 4, 3, arrayOf(
                        arrayOf(5, 5),
                        arrayOf(4, 2),
                        arrayOf(2, 3)
                    ), 10
                ),
            )
        ) { boardSize,
            numberOfObstacles,
            rowWithQueen,
            columnWithQueen,
            obstacles: Array<Array<Int>>,
            expectedNumberOfAttackedFields ->
            tested.queensAttack(
                boardSize,
                numberOfObstacles,
                rowWithQueen,
                columnWithQueen,
                obstacles
            ) shouldBe expectedNumberOfAttackedFields
        }
    }
})
