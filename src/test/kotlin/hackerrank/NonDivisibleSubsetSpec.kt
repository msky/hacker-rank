package hackerrank

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class NonDivisibleSubsetSpec : FreeSpec({
    val tested = NonDivisibleSubset()

    "should find non divisible subset with highest sum" {
        forAll(
            table(
                headers("k", "set", "expectedSubset"),
                row(3, arrayOf(1, 7, 2, 4), 3),
                row(4, arrayOf(19, 10, 12, 24, 25, 22), 3),
                row(7, arrayOf(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436), 11),
                row(11, arrayOf(582740017, 954896345, 590538156, 298333230, 859747706, 155195851, 331503493, 799588305, 164222042, 563356693, 80522822, 432354938, 652248359), 11)
            )
        ) { k, set, expectedNumberOfElementsThatSumOf2IsNotDivisibleByK ->
            tested.nonDivisibleSubset(k, set) shouldBe expectedNumberOfElementsThatSumOf2IsNotDivisibleByK
        }
    }

})
