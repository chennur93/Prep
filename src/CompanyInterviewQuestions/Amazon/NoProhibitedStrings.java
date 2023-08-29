package CompanyInterviewQuestions.Amazon;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Amazon allows customers to add reviews for the products they bought from their store.
 * The review must follow Amazon's community guidelines in order to be published.
 * Suppose that Amazon has marked n strings that are prohibited in reviews.
 * They assign a score to each review that denotes how well it follows the guidelines.
 * The score of a review is defined as the longest contiguous substring of the review which does
 * not contain any string among the list of n prohibited strings. A string contains a prohibited
 * word if it has a contiguous substring that matches a word from the prohibited list, ignoring
 * the case.
 * <p>
 * Example:
 * review = "GoodProductButScrapAfterWash"
 * prohibitedWords = ['crap", "odpro"]
 * Some of the substrings that do not contain a prohibited word are:
 * • ProductBut
 * • rapAfterWash
 * • dProductButScu
 * • Wash
 * The longest substring is "ProductBut Scra", return its length, 15.
 */

public class NoProhibitedStrings {

    public static String getHighestReviewScore(String review, List<String> prohibitedWords) {
        Queue<String> wordMemory = new PriorityQueue<>();
        wordMemory.add(review);

        for (String pWord : prohibitedWords) {
            Queue<String> tempQ = new PriorityQueue<>();
            while (!wordMemory.isEmpty()) {
                String text = wordMemory.poll().toLowerCase();
                while (text.contains(pWord)) {
                    tempQ.add(text.substring(0, text.indexOf(pWord)+pWord.length()-1));
                    if (text.indexOf(pWord) == text.lastIndexOf(pWord)) {
                        text = text.substring(text.indexOf(pWord) + 1);
                        break;
                    } else {
                        text = text.substring(text.indexOf(pWord) + 1);
                    }
                }
                tempQ.add(text);
            }
            wordMemory = tempQ;
        }

        String longestSubString = "";
        int longest = 0;

        for (String s : wordMemory) {
            if (s.length() > longest) {
                longestSubString = s;
                longest = s.length();
            }
        }
        System.out.println(longest);
        return longestSubString;
    }

    public static int findReviewScore(String review, List<String> prohibitedWords) {
        int maxScore = 0;
        int currentScore = 0;

        for (int left = 0, right = 0; right < review.length(); right++) {
            char c = review.charAt(right);
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c); // Convert to lowercase for matching
            }

            if (!Character.isLetter(c)) {
                left = left + 1; // Move the left pointer to the next character   left =0, right= 0
            } else {
                int[] positions = findProhibitedSubstringPosition(review.substring(left, right + 1).toLowerCase(),prohibitedWords);
                if (positions[0] != -1) {
                    left = right + 1; // Move the left pointer to the next character left= 0, right = 0
                } else {
                    currentScore = right - left + 1;  //
                    maxScore = Math.max(maxScore, currentScore); //
//                    System.out.println(review.substring(left,right+1));
                }
            }
        }

        return maxScore;
    }

    public static int[] findProhibitedSubstringPosition(String text, List<String> prohibitedWords) {
        for (String word : prohibitedWords) {
            int index = text.indexOf(word);
            if (index != -1) {
                return new int[]{index, index + word.length() - 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("crap");
        arr.add("odpro");
        Long beginTime = System.nanoTime();
        System.out.println(getHighestReviewScore("GoodProductButScrapAfterWash", arr));
        Long endTime = System.nanoTime();
        System.out.println("New AlgoTime take for execution: " + (endTime - beginTime)/1000);

        Long beginTime1 = System.nanoTime();
        System.out.println(findReviewScore("GoodProductButScrapAfterWash", arr));
        Long endTime1 = System.nanoTime();
        System.out.println("Old AlgoTime take for execution: " + (endTime1 - beginTime1)/1000);

        System.out.println("\n\n");

        List<String> arr1 = new ArrayList<>();
        arr1.add("eryoka");
        arr1.add("yo");
        arr1.add("eli");
        Long beginTime2 = System.nanoTime();
        System.out.println(getHighestReviewScore("FastDeliveryOkayProduct", arr1));
        Long endTime2 = System.nanoTime();
        System.out.println("New AlgoTime take for execution: " + (endTime2 - beginTime2)/1000);

        Long beginTime3 = System.nanoTime();
        System.out.println(findReviewScore("FastDeliveryOkayProduct", arr1));
        Long endTime3 = System.nanoTime();
        System.out.println("Old AlgoTime take for execution: " + (endTime3 - beginTime3)/1000);

        List<String> arr2 = new ArrayList<>();
        arr2.add("tuper");
        arr2.add("douche");
        System.out.println(getHighestReviewScore("ExtremeValueForMoney", arr2));
    }
}
