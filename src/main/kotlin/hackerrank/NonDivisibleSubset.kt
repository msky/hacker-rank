package hackerrank

class NonDivisibleSubset {
    fun nonDivisibleSubset(k: Int, s: Array<Int>): Int {
        val remindersWithOccurrencesCount =
            s.map { it % k }
                .groupingBy { it }
                .eachCount()

        val remindersOfNonDivisibleSubsetWithOccurrencesCount = mutableMapOf<Int, Int>()

        remindersWithOccurrencesCount.forEach {
            val isThereAnyNumberDividableByK = it.key == 0
            val isThereAnyNumberWithReminderBeingHalfOfK = k % 2 == 0 && it.key == k / 2
            val isReminderMoreFrequentThatOtherReminderSummingToK =
                it.value >= remindersWithOccurrencesCount.getOrDefault(k - it.key, 0)
            val wasReminderSummingToKAlreadyConsidered =
                !remindersOfNonDivisibleSubsetWithOccurrencesCount.containsKey(k - it.key)

            if (isThereAnyNumberDividableByK) {
                remindersOfNonDivisibleSubsetWithOccurrencesCount[it.key] = 1
            } else if (isThereAnyNumberWithReminderBeingHalfOfK) {
                remindersOfNonDivisibleSubsetWithOccurrencesCount[it.key] = 1
            } else if (isReminderMoreFrequentThatOtherReminderSummingToK && wasReminderSummingToKAlreadyConsidered) {
                remindersOfNonDivisibleSubsetWithOccurrencesCount[it.key] = it.value
            }
        }

        return remindersOfNonDivisibleSubsetWithOccurrencesCount.values.sum()
    }
}
