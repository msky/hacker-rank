package hackerrank

//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
class ClimbingLeaderBoard {

    fun climbingLeaderboard(leaderBoard: Array<Int>, playersScoresAscending: Array<Int>): Array<Int> {
        var alreadyCheckedIndex = 0
        var currentPlaceToAssign = 1
        var scoreWithinLeaderboard = alreadyCheckedIndex < leaderBoard.size

        val newlyRanked = ArrayDeque<Int>()
        val alreadyCheckedScores = mutableSetOf<Int>()

        for (scoreToRankIndex in (playersScoresAscending.indices.reversed())) {
            val highestScoreToRank = playersScoresAscending[scoreToRankIndex]

            println("Ranking $highestScoreToRank ...")
            println("Currently assigning place $currentPlaceToAssign")

            if (scoreWithinLeaderboard) {
                var scoreFromLeaderboard = leaderBoard[alreadyCheckedIndex]
                println("... against $scoreFromLeaderboard")

                while (scoreWithinLeaderboard && highestScoreToRank < scoreFromLeaderboard) {

                    if (scoreFromLeaderboard !in alreadyCheckedScores) {
                        println("$scoreFromLeaderboard was checked for the first time")
                        currentPlaceToAssign++
                        println("Increasing place to assign to $currentPlaceToAssign")
                    }
                    alreadyCheckedIndex++
                    scoreWithinLeaderboard = alreadyCheckedIndex < leaderBoard.size

                    if (scoreWithinLeaderboard) {
                        println("Moving to next score with index $alreadyCheckedIndex and value ${leaderBoard[alreadyCheckedIndex]}")

                        alreadyCheckedScores.add(scoreFromLeaderboard)
                        scoreFromLeaderboard = leaderBoard[alreadyCheckedIndex]
                        println("... against $scoreFromLeaderboard")
                    }
                }

                if (highestScoreToRank == scoreFromLeaderboard) {
                    newlyRanked.addFirst(currentPlaceToAssign)
                }
                if (highestScoreToRank > scoreFromLeaderboard) {
                    newlyRanked.addFirst(currentPlaceToAssign)
                }
            }
            if (!scoreWithinLeaderboard) {
                println("Checking score outside of leaderboard: $highestScoreToRank")

                newlyRanked.addFirst(currentPlaceToAssign)
                alreadyCheckedScores.add(highestScoreToRank)

                if (highestScoreToRank !in alreadyCheckedScores) {
                    println("$highestScoreToRank checking for the first time")
                    currentPlaceToAssign++
                }
            }
            println("Currently ranked scores: ${newlyRanked.joinToString()}")
        }
        return newlyRanked.toTypedArray()
    }
}

