package hackerrank

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class ClimbingLeaderBoardSpec : FreeSpec({
    val tested = ClimbingLeaderBoard()


    "climbing leader board" {
        forAll(
            table(
                headers("leaderBoard", "scoresToRankAscending", "expectedPlaces"),
                row(arrayOf(100, 100, 50, 40, 40, 20, 10), arrayOf(5, 5, 25, 50, 120), arrayOf(6, 6, 4, 2, 1)),
                row(arrayOf(100, 90, 90, 80, 75, 60), arrayOf(50, 65, 77, 90, 102), arrayOf(6, 5, 4, 2, 1)),
                row(arrayOf(1), arrayOf(1, 1), arrayOf(1, 1)),
            )
        ) { leaderBoard, scoresToRankAscending, expectedPlaces ->
            tested.climbingLeaderboard(leaderBoard, scoresToRankAscending) shouldBe expectedPlaces
        }
    }
})