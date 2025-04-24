/**
 * Applies a series of StringFilters to a string in sequence.
 */
public class CompositeStringFilter implements StringFilter {

    private StringFilter[] filters;

    /**
     * Constructor to set the filters to apply in order.
     * @param filters Array of filters to apply.
     */
    public CompositeStringFilter(StringFilter[] filters) {
        this.filters = filters;
    }

    @Override
    public String filter(String s) {
        String result = s;
        for (StringFilter filter : filters) {
            result = filter.filter(result);  // Apply each filter
        }
        return result;
    }
}
