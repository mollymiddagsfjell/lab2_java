//package lab2;

public class Word {

    private String theWord;
    private int counts;
    private static int outputFormat;

    public Word(String inString) {
        theWord = inString;
        counts = 1; outputFormat = 0;
    }

    public String getWord() {
        return theWord;
    }

    public int getCounts() {
        return counts;
    }

    public void increaseCounts() {
        counts = counts + 1;
    }

    public static void changeOutputFormat(int in) {
        if (in == 0 || in == 1) outputFormat = in;
    }

    public String toString() {
        String result;
        if (outputFormat == 0) {
            result = "The word is : " + theWord;
        }else {
            result = "The word " + theWord + " has occured " + counts + " times.";
        }
        return result;
    }
}