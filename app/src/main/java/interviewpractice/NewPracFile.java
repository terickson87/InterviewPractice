package interviewpractice;

public class NewPracFile {
    private final static int DEFAULT_ADD_TO = 5;

    private final int addTo;

    public NewPracFile() {
        this(DEFAULT_ADD_TO);
    }

    public NewPracFile(int addTo) {
        this.addTo = addTo;
    }

    public int run(int input) {
        final int sum = input + addTo;
        return sum;
    }
}
