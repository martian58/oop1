/**
 * Interface for filtering and transforming strings.
 */
public interface StringFilter {
    /**
     * Applies a transformation to the input string.
     * 
     * @param s The input string.
     * @return The transformed string.
     */
    String filter(String s);
}
