package hackerrank

import java.math.BigInteger

class ExtraLongFactorials {
    fun extraLongFactorials(n: Int): BigInteger =
        (n downTo 1L)
            .map { BigInteger.valueOf(it) }
            .fold(BigInteger.valueOf(1)) { x, y -> x.multiply(y) }

}