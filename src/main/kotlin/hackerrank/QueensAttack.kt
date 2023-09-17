package hackerrank

import java.lang.Integer.min
import java.lang.Integer.max
import kotlin.Int.Companion.MAX_VALUE
import kotlin.math.abs

class QueensAttack {

    fun queensAttack(
        boardSize: Int,
        numberOfObstacles: Int,
        rowWithQueen: Int,
        columnWithQueen: Int,
        obstacles: Array<Array<Int>>
    ): Int {
        val directionsWithDistanceOfClosestObstacle = mutableMapOf<AttackDirection, Int>()
        println("Queen row: $rowWithQueen, column: $columnWithQueen")
        obstacles.forEach { (obstacleRow, obstacleColumn) ->
            AttackDirection.entries
                .firstOrNull { it.includesPoint(rowWithQueen, columnWithQueen, obstacleRow, obstacleColumn) }
                ?.let {
                    val currentClosestDistanceToObstacleWithinCurrentDirection =
                        directionsWithDistanceOfClosestObstacle[it] ?: MAX_VALUE
                    val currentObstacleDistance =
                        calculateDistance(rowWithQueen, columnWithQueen, obstacleRow, obstacleColumn)

                    if (currentObstacleDistance < currentClosestDistanceToObstacleWithinCurrentDirection) {
                        directionsWithDistanceOfClosestObstacle[it] = currentObstacleDistance
                        println("Current closest obstacle: row: $obstacleRow, column: $obstacleColumn, direction: $it, distance: $currentObstacleDistance")
                    }
                }
        }

        return AttackDirection.entries.map {
            it to it.calculateMaxNumberOfAttackedFields(rowWithQueen, columnWithQueen, boardSize)
        }.map {
            println("${it.first} - ${it.second}")
            it
        }.sumOf { (direction, maxDistance) ->
            // number of attacking fields is distance to obstacle minus 1
            directionsWithDistanceOfClosestObstacle[direction]?.minus(1)?.let { max(it, 0) } ?: maxDistance
        }
    }

    enum class AttackDirection {
        UP {
            override fun includesPoint(rowWithQueen: Int, columnWithQueen: Int, row: Int, column: Int): Boolean =
                row > rowWithQueen && column == columnWithQueen

            override fun calculateMaxNumberOfAttackedFields(
                rowWithQueen: Int,
                columnWithQueen: Int,
                boardSize: Int
            ): Int =
                boardSize - rowWithQueen
        },
        DOWN {
            override fun includesPoint(rowWithQueen: Int, columnWithQueen: Int, row: Int, column: Int): Boolean =
                row < rowWithQueen && column == columnWithQueen

            override fun calculateMaxNumberOfAttackedFields(
                rowWithQueen: Int,
                columnWithQueen: Int,
                boardSize: Int
            ): Int =
                rowWithQueen - 1
        },
        LEFT {
            override fun includesPoint(rowWithQueen: Int, columnWithQueen: Int, row: Int, column: Int): Boolean =
                row == rowWithQueen && column < columnWithQueen

            override fun calculateMaxNumberOfAttackedFields(rowWithQueen: Int, columnWithQueen: Int, boardSize: Int) =
                columnWithQueen - 1
        },
        RIGHT {
            override fun includesPoint(rowWithQueen: Int, columnWithQueen: Int, row: Int, column: Int): Boolean =
                row == rowWithQueen && column > columnWithQueen

            override fun calculateMaxNumberOfAttackedFields(
                rowWithQueen: Int,
                columnWithQueen: Int,
                boardSize: Int
            ): Int =
                boardSize - columnWithQueen
        },
        LEFT_UP {
            override fun includesPoint(rowWithQueen: Int, columnWithQueen: Int, row: Int, column: Int): Boolean =
                row > rowWithQueen && column < columnWithQueen && abs(rowWithQueen - row) == abs(columnWithQueen - column)

            override fun calculateMaxNumberOfAttackedFields(
                rowWithQueen: Int,
                columnWithQueen: Int,
                boardSize: Int
            ): Int =
                min(columnWithQueen - 1, boardSize - rowWithQueen)
        },
        LEFT_DOWN {
            override fun includesPoint(rowWithQueen: Int, columnWithQueen: Int, row: Int, column: Int): Boolean =
                row < rowWithQueen && column < columnWithQueen && abs(rowWithQueen - row) == abs(columnWithQueen - column)

            override fun calculateMaxNumberOfAttackedFields(
                rowWithQueen: Int,
                columnWithQueen: Int,
                boardSize: Int
            ): Int =
                min(rowWithQueen, columnWithQueen) - 1
        },
        RIGHT_UP {
            override fun includesPoint(rowWithQueen: Int, columnWithQueen: Int, row: Int, column: Int): Boolean =
                row > rowWithQueen && column > columnWithQueen && abs(rowWithQueen - row) == abs(columnWithQueen - column)

            override fun calculateMaxNumberOfAttackedFields(
                rowWithQueen: Int,
                columnWithQueen: Int,
                boardSize: Int
            ): Int =
                min(boardSize - rowWithQueen, boardSize - columnWithQueen)
        },
        RIGHT_DOWN {
            override fun includesPoint(rowWithQueen: Int, columnWithQueen: Int, row: Int, column: Int): Boolean =
                row < rowWithQueen && column > columnWithQueen && abs(rowWithQueen - row) == abs(columnWithQueen - column)

            override fun calculateMaxNumberOfAttackedFields(
                rowWithQueen: Int,
                columnWithQueen: Int,
                boardSize: Int
            ): Int =
                min(rowWithQueen - 1, boardSize - columnWithQueen)
        };

        abstract fun includesPoint(rowWithQueen: Int, columnWithQueen: Int, row: Int, column: Int): Boolean

        abstract fun calculateMaxNumberOfAttackedFields(rowWithQueen: Int, columnWithQueen: Int, boardSize: Int): Int
    }
}

fun calculateDistance(rowWithQueen: Int, columnWithQueen: Int, obstacleRow: Int, obstacleColumn: Int): Int =
    max(abs(columnWithQueen - obstacleColumn), abs(rowWithQueen - obstacleRow))

