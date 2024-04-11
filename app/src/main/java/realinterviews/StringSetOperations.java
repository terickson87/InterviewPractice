package realinterviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.HashSet;

/*
Cached Out
Programming challenge description:
Build an in-memory string cache that guarantees each entry is unique. This cache requires the following functions:
•	Add
    Adds the supplied string to the cache and returns "True" if it was added or "False" if it already exists

•	Get
    Returns the requested string if it exists in the cache or "NULL" if it does not exist in cache

•	Has
    Returns "True" or "False" to indicate if the string is in the cache or not

•	Remove
    Deletes the requested string from the cache and returns "True" if it was removed or "False" if it did not exist

•	Reset
    Empties the cache of all entries and returns the number of entries

Try to implement this cache in a way that will have high read performance across a potentially large set.

Input:
Each line of input will have two parts separated with a pipe character:
1.	Function Name
2.	String Value

For example:
Add|Dog
Get|Dog
Remove|Dog
Has|Dog

The Reset function is an exception. It will only have the Function Name as input.

Output:
One line of output based on the function called by each line of input. For example:
True
Dog
True
False

-- Test 1 --
Test Input:
Add|Dog
Get|Dog
Remove|Dog
Has|Dog

Expected Output:
True 
Dog 
True 
False

-- Test 2 --
Test Input:
Get|English
Add|English
Add|German
Add|Mandarin
Add|Malay
Get|German
Get|Mandarin
Has|French
Add|French
Has|French
Reset
Has|English
Has|German
Has|Mandarin
Has|Malay
Has|French

Expected Output:
NULL
True
True
True
True
German
Mandarin
False
True
True
5
False
False
False
False
False

-- Test 3 --
Test Input:
Add|A
Add|B
Add|C
Add|D
Get|A
Get|B
Get|1
Get|2
Add|1
Add|2
Get|2
Remove|A
Remove|B
Remove|C
Has|A 
Get|A
Add|A
Has|A
Get|A
Reset
Get|C

Expected Output:
True
True
True
True
A
B
NULL
NULL
True
True
2
True
True
True
False
NULL
True
True
A
4
NULL
 */
class Operation {
    final String funcName;
    final String value;

    public String funcName() {
        return funcName;
    }

    public String value() {
        return value;
    }

    public Operation(String funcName, String value) {
        this.funcName = funcName;
        this.value = value;
    }
}

public class StringSetOperations {
    static Set<String> inMemCache = new HashSet<>();
    static final String ADD_COMMAND = "Add";
    static final String GET_COMMAND = "Get";
    static final String HAS_COMMAND = "Has";
    static final String REMOVE_COMMAND = "Remove";
    static final String RESET_COMMAND = "Reset";

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
        Operation operation = getOperationFromLine(line);
        handleOperation(operation);
        }
    }


    static Operation getOperationFromLine(String line) {
        String[] parts = line.split("\\|");
        if (RESET_COMMAND.equals(parts[0])) {
            return new Operation(parts[0], null);
        } else {
            return new Operation(parts[0], parts[1]);
        }
    }
      
    static void handleOperation(Operation operation) {
        switch (operation.funcName) {
            case ADD_COMMAND: handleAdd(operation.value); break;
            case GET_COMMAND: handleGet(operation.value); break;
            case HAS_COMMAND: handleHas(operation.value); break;
            case REMOVE_COMMAND: handleRemove(operation.value); break;
            case RESET_COMMAND:handleReset(); break;
            default: System.out.println("Not Handled."); break;
        }
    }
    
    static void handleAdd(String string) {
        boolean result = inMemCache.add(string);
        System.out.println(result ? "True" : "False");
    }
    
    static void handleGet(String string) {
        boolean result = inMemCache.contains(string);
        System.out.println(result ? string : "NULL");
    
    }
    
    static void handleHas(String string) {
        boolean result = inMemCache.contains(string);
        System.out.println(result ? "True" : "False");
    }
      
    static void handleRemove(String string) {
        boolean isContained = inMemCache.contains(string);
        if (isContained) {
            inMemCache.remove(string);
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
      
    static void handleReset() {
        System.out.println(inMemCache.size());
        inMemCache.clear();
    }
    

}
