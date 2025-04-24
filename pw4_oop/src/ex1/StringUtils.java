/**
 * Utility class for filtering string arrays using a StringFilter.
 */
public class StringUtils {

    /**
     * Applies a filter to each string in the array and returns a new array with transformed strings.
     *
     * @param strings Array of strings to transform.
     * @param filter  The filter to apply.
     * @return Transformed array of strings.
     */
    public static String[] filter(String[] strings, StringFilter filter) {
        String[] result = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            result[i] = filter.filter(strings[i]);  // Apply filter
        }
        return result;
    }
}
