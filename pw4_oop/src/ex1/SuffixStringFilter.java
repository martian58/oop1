/**
 * Keeps only the last n characters of a string.
 */
public class SuffixStringFilter implements StringFilter {
    private int n;

    /**
     * Constructor to set how many characters to keep from the end.
     * @param n Number of characters to keep.
     */
    public SuffixStringFilter(int n) {
        this.n = n;
    }

    @Override
    public String filter(String s) {
        if (s.length() <= n) {
            return s;
        }
        return s.substring(s.length() - n);  // Get suffix
    }
}
