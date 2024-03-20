package interviewpractice;

public class CountStringInstances {
    fun countStringInstances(pattern: String, findIn: String): Int {
        var count = 0
        val findInEndIndex = findIn.length - 1
        val patternEndIndex = pattern.length - 1

        for (i in findIn.indices) {
            var thisI = i
            for (j in pattern.indices) {
                when {
                    findIn.get(thisI) != pattern.get(j) -> break
                    findIn.get(thisI) == pattern.get(j) && j < patternEndIndex -> {
                        thisI += 1
                        when (thisI <= findInEndIndex) {
                            true -> continue
                            false -> break
                        }
                    }
                    else -> count += 1
                }
            }
        }

        return count;
    }
}