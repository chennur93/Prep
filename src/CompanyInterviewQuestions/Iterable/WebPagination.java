package CompanyInterviewQuestions.Iterable;

import java.util.Arrays;

/**
 * Give a list of items = [[item1, 4, 12], [item2, 34, 56], [item3, 5, 12]] and the sortOrder, sortParameter (column), itemsPerPage and pageNumber.
 * Return the names of the elements present in the given page after the items are sorted in the given order with the given column.
 */

public class WebPagination {

    public static String[] websitePagination(String[][] items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        int startIndex, endIndex;

        if (sortParameter == 0) {
            if (sortOrder == 0) {
                Arrays.sort(items, (a,b) -> a[0].compareTo(b[0]));
            } else {
                Arrays.sort(items, (a,b) -> b[0].compareTo(a[0]));
            }
        } else {
            if (sortOrder == 0) {
                Arrays.sort(items, new java.util.Comparator<String[]>() {
                    public int compare(String[] a, String[] b) {
                        return Integer.compare(Integer.parseInt(a[sortParameter]), Integer.parseInt(b[sortParameter]));
                    }
                });
            } else {
                Arrays.sort(items, new java.util.Comparator<String[]>() {
                    public int compare(String[] a, String[] b) {
                        return Integer.compare(Integer.parseInt(b[sortParameter]), Integer.parseInt(a[sortParameter]));
                    }
                });
            }
        }

        startIndex = (pageNumber * itemsPerPage);
        endIndex = Math.min(((pageNumber * itemsPerPage) + itemsPerPage - 1), items.length -1);
        String[] result = new String[endIndex - startIndex + 1];
        int counter = 0;

        for (int i = startIndex; i <= endIndex; i++) {
            result[counter] = items[i][0];
            counter++;
        }

        return result;
    }
}
