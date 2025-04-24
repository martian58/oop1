/**
 * Keeps only the first n characters of a string.
 */
public class PrefixStringFilter implements StringFilter {
    private int n;

    /**
     * Constructor to set how many characters to keep from the start.
     * @param n Number of characters to keep.
     */
    public PrefixStringFilter(int n) {
        this.n = n;
    }

    @Override
    public String filter(String s) {
        if (s.length() <= n) {
            return s;
        }
        return s.substring(0, n);  // Get prefix
    }
}
