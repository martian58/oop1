/**
 * Converts all characters of a string to upper case.
 */
public class UpperCaseStringFilter implements StringFilter {

    @Override
    public String filter(String s) {
        return s.toUpperCase();  // Convert to uppercase
    }
}
