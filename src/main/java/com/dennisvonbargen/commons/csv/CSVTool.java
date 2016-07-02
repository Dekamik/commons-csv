package com.dennisvonbargen.commons.csv;

/**
 * CSVTool is a utility for making creations of CSVs smooth and easy.
 *
 * Created by Dennis von Bargen on 2016-07-02.
 */
public final class CSVTool {

    private CSVTool() {}

    /**
     * Creates a line of CSV.
     * Primitive values can also be used in the list of values.
     *
     * @param values the values to insert into the line
     * @return a String representing the values separated by the delimiter
     */
    public static String getLine(Object... values) {
        return getLine('\n', ',', values);
    }

    /**
     * Creates a line of CSV.
     * Primitive values can also be used in the list of values.
     *
     * @param delimiter the char that separates the values
     * @param values the values to insert into the line
     * @return a String representing the values separated by the delimiter
     */
    private static String getLine(char delimiter, Object... values) {
        return getLine('\n', delimiter, values);
    }

    /**
     * Creates a line of CSV.
     * Primitive values can also be used in the list of values.
     *
     * @param lineEnding the char that ends the line
     * @param delimiter the char that separates the values
     * @param values the values to insert into the line
     * @return a String representing the values separated by the delimiter
     */
    private static String getLine(char lineEnding, char delimiter, Object... values) {
        // StringBuilders are mutable, which means they don't create a new object per concatenation, thus saving memory.
        StringBuilder line = new StringBuilder();
        boolean first = true;
        for (Object value : values) {
            // Add delimiter if not first
            if (!first) line.append(delimiter);
            else        first = false;
            // Add the value
            if (value != null) {
                if (value instanceof String)    line.append('\"').append(value.toString()).append('\"');
                else                            line.append(value.toString());
            }
            else {
                line.append("\"\"");
            }
        }
        return line.append(lineEnding).toString();
    }
}
