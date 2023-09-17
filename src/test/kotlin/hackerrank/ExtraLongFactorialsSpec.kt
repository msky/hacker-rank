package hackerrank

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import java.math.BigInteger

class ExtraLongFactorialsSpec : FreeSpec({
    val tested = ExtraLongFactorials()

    "should calculate fatorial" {
        forAll(
            table(
                headers("n", "expectedFactorial"),
                row(10, BigInteger("3628800")),
                row(30, BigInteger("265252859812191058636308480000000")),
                row(100, BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"))
            )
        ) { n, expectedFactorial ->
            tested.extraLongFactorials(n) shouldBe expectedFactorial
        }
    }
})
