package realinterviews;

public class CountStringInstances {
    public int countInstances(String pattern, String findIn) {

        int count = 0;
        int findInEndIndex = findIn.length() - 1;
        int patternEndIndex = pattern.length() - 1;

        for (int i = 0; i < findIn.length(); i++) {
            int thisI = i;
            for (int j = 0; j < pattern.length(); j++) {
                if (findIn.charAt(thisI) != pattern.charAt(j)) {
                    break;
                } else if (findIn.charAt(thisI) == pattern.charAt(j) && j < patternEndIndex) {
                    thisI++;
                    if (thisI <= findInEndIndex) {
                        continue;
                    } else {
                        break;
                    }
                    
                } else { // findIn.charAt(thisI) == pattern.charAt(j) && j == patternEndIndex
                    count += 1;
                }
            }
            
        }

        return count;
    }
    
}
