package realinterviews;

public class NewFile {
    private final static int DEFAULT_ADD_TO = 5;

    private final int addTo;

    public NewFile() {
        this(DEFAULT_ADD_TO);
    }

    public NewFile(int addTo) {
        this.addTo = addTo;
    }

    public int run(int input) {
        final int sum = input + addTo;
        return sum;
    }
}
