import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.regex.*;

public class ReoderLogDataRunner {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        ReoderLogData reoderLogData = new ReoderLogData();
        String[] output = reoderLogData.reorderLogFiles(logs);
        for (String log : output) {
            System.out.println(log);
        }
     }
}

class ReoderLogData {
    
    public String[] reorderLogFiles(String[] logs) {
        List<Log> letterLogs = new ArrayList<>();
        List<Log> digitLogs = new ArrayList<>();
        
        for (String log : logs) {
            Log thisLog = new Log(log);
            if(thisLog.getType() == LogType.LETTER) {
                letterLogs.add(thisLog);
            } else {
                digitLogs.add(thisLog);
            }
        }
        
        Collections.sort(letterLogs, Comparator.comparing(Log::getLog).thenComparing(Log::getIdentifier));
        
        String [] output = new String[logs.length];
        int i = 0;
        for (Log log : letterLogs) {
            output[i] = log.getFullLog();
            i++;
        }
        for (Log log : digitLogs) {
            output[i] = log.getFullLog();
            i++;
        }
        return output;
    }
    
    public enum LogType {LETTER, DIGIT};
    
    class Log {
        private final String mIdentifier;
        private final String mLog;
        private final LogType mType;
        
        public Log(String fullLog) {
            Pattern fullLogPattern = Pattern.compile("([a-z0-9]+)[ ](.+)");
            Matcher fullLogMatcher = fullLogPattern.matcher(fullLog);
            fullLogMatcher.matches();
            mIdentifier = fullLogMatcher.group(1);
            mLog = fullLogMatcher.group(2);
            boolean isDigit = mLog.matches("([0-9]+){1}([ ][0-9]+)*");
            mType = isDigit ? LogType.DIGIT : LogType.LETTER;
        }
        
        public String getFullLog() {
            return mIdentifier + " " + mLog;
        }
        
        public String getIdentifier() {
            return mIdentifier;
        }
        
        public String getLog() {
            return mLog;
        }
        
        public LogType getType() {
           return mType;
        }

        public void print() {
            System.out.println("Identifier: " + mIdentifier);
            System.out.println("Log: " + mLog);
            System.out.println("FullLog: " + this.getFullLog());
        }
    }
}