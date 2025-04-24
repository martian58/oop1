/**
 * Converts all characters of a string to lower case.
 */
public class LowerCaseStringFilter implements StringFilter {

    @Override
    public String filter(String s) {
        return s.toLowerCase();  // Convert to lowercase
    }
}
