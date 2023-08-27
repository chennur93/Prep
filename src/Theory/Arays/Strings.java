package Theory.Arays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Strings {

  public static void main(String[] args) {

    String a = "bad";
    String b = "dab";

//    //Test reverse string
//    System.out.println("Reverse a String:");
//    System.out.println("Expected Pass: " +
//        (reverse("meghashyam").equals("mayhsahgem") ? "Pass" : "Fail"));
//
//    // Check Anagrams
//    System.out.println("\nCheck Anagrams:");
//    System.out.println("Expected Fail: " +
//        (checkAnagrams("water", "waiter") ? "Pass" : "Fail"));
//    System.out.println("Expected Pass: " +
//        (checkAnagrams("Dormitory","Dirtyroom") ? "Pass" : "Fail"));
//    System.out.println("Expected Fail: " +
//        (areAnagram("water".toCharArray(),"waiter".toCharArray()) ? "Pass" : "Fail"));
//    System.out.println("Expected Fail: " +
//        (areAnagram("Dormitory".toCharArray(),"Dirty room".toCharArray()) ? "Pass" : "Fail"));
//
//    System.out.println("Expected Pass: " +
//        (checkAnagrams("geeksforgeeks","forgeeksgeeks") ? "Pass" : "Fail"));
//    System.out.println("Expected Pass: " +
//        (areAnagram("geeksforgeeks".toCharArray(),"forgeeksgeeks".toCharArray()) ? "Pass" : "Fail"));
//
//    System.out.println("Expected Pass: " +
//        (areAnagramsBits("geeksforgeeks","forgeeksgeeks") ? "Pass" : "Fail"));
//    System.out.println("Expected Fail: " +
//        (areAnagramsBits("water","waiter") ? "Pass" : "Fail"));
//
//    // Reverse Word in a sentence
//    System.out.println("\n Reverse Words:");
//    System.out.println("Expected Pass: " +
//        (sentenceWordFlipper("water").equals("retaw") ? "Pass" : "Fail"));
//    System.out.println("Expected Pass: " +
//        (sentenceWordFlipper("This is an example").equals("sihT si na elpmaxe") ? "Pass" : "Fail"));
//    System.out.println("Expected Pass: " +
//        (sentenceWordFlipper("This is one small step for ...")
//            .equals("sihT si eno llams pets rof ...") ? "Pass" : "Fail"));
//
//    // Hammin Distance
//    System.out.println("\n Hamming Distance");
//    System.out.println(hammingDistance("A gentleman","Elegant men") == 9 ? "Pass" : "Fail");

    areAnagramsBits(a,b);
  }


  /*
  * REVERSE A STRING
  * */

  public static String reverse(String s){
    char[] stringArray = s.toCharArray();
    char temp;
    int l = s.length();

    for(int i=0; i<l/2;i++){
      temp = stringArray[i];
      stringArray[i] = stringArray[l-1-i];
      stringArray[l-1-i] = temp;
    }

    // If we use Arrays.toString() it will return a string representation of the char array.
    // the toString() method also use a string builder to construct this.
    StringBuilder str = new StringBuilder();
    for(int i=0; i<l; i++){
      str.append(stringArray[i]);
    }
    // We can also create a new string object by passing it a character array
    return new String(stringArray);
  }

  /*
  *  CHECK ANAGRAMS
  * */

  // Using hashmap
  // Time Complexity : O(n) Space : O(n)
  public static Boolean checkAnagrams(String str1, String str2){

    if(str1.length() != str2.length() || str1.length() == 0 || str2.length() == 0)
      return false;

    HashMap<Character, Integer> h1 = getFrequency(str1);
    HashMap<Character, Integer> h2 = getFrequency(str2);

    for (Map.Entry<Character,Integer> entry : h1.entrySet()){
      if(h2.containsKey(entry.getKey()) && h1.get(entry.getKey()).equals(h2.get(entry.getKey()))){
        continue;
      }else {
        return false;
      }
    }
    return true;
  }

  private static HashMap<Character, Integer> getFrequency(String str){
    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        continue;
      }
      if (map.containsKey(str.charAt(i))) {
        int count = map.get(str.charAt(i));
        map.put(str.charAt(i), count++);
      } else {
        map.put(str.charAt(i), 1);
      }
    }
    return map;
  }

  // Checking anagrams using frequency with array.
  // Time Complexity : O(n) Space : O(n)
  private static boolean areAnagram(char str1[], char str2[])
  {
    // Create 2 count arrays and initialize
    // all values as 0
    int NO_OF_CHARS = 256;
    int[] count1 = new int[NO_OF_CHARS];
    Arrays.fill(count1, 0);
    int[] count2 = new int[NO_OF_CHARS];
    Arrays.fill(count2, 0);
    int i;

    // For each character in input strings,
    // increment count in the corresponding
    // count array
    for (i = 0; i < str1.length && i < str2.length;
         i++) {
      count1[str1[i]]++;
      count2[str2[i]]++;
    }

    // If both strings are of different length.
    // Removing this condition will make the program
    // fail for strings like "aaca" and "aca"
    if (str1.length != str2.length)
      return false;

    // Compare count arrays
    for (i = 0; i < NO_OF_CHARS; i++)
      if (count1[i] != count2[i])
        return false;

    return true;
  }

  // Using bit manipulation
  // Time Complexity : O(n) Space : O(1)
  private static Boolean areAnagramsBits(String str1, String str2){

    if(str1.length() != str2.length() || str1.length() == 0 || str2.length() == 0)
      return false;

    int value = 0;

    for (int i=0; i<str1.length(); i++){
      value = value ^ str1.charAt(i);
      System.out.println("Value : "+value);
      value = value ^ str2.charAt(i);
      System.out.println("Value : "+value);
    }

    return value == 0;
  }

  /*
  * Reverse words in a string
  *
  * Time Complexity: O(n) Space: O(n)
  * */
  private static String sentenceWordFlipper(String str) {
    if (str.length() == 0)
      return "";

    str = str.trim();
    str = str.replaceAll("\\s+", " ");
    int start=0;
    StringBuilder output = new StringBuilder();

    for (int i=0; i<str.length(); i++) {
      if (str.charAt(i) == ' ') {
        output.append(wordReverse(str.substring(start, i)));
        output.append(" ");
        start = i+1;
      }else if (i == str.length()-1) {
        output.append(wordReverse(str.substring(start, i+1)));
      }
    }
    return output.toString();
  }

  private static String wordReverse(String str) {
    char[] charArr = str.toCharArray();
    int length = charArr.length;

    for (int i=0; i<length/2; i++) {
      char temp = charArr[i];
      charArr[i] = charArr[length - 1 - i];
      charArr[length - 1 - i] = temp;
    }
    return new String(charArr);
  }

  /*
  * HAMMING DISTANCE
  *
  * In information theory, the Hamming distance between two strings of equal length is the
  * number of positions at which the corresponding symbols are different. Calculate the Hamming
  * distance for the following test cases.
  *
  * Time Complexity:  Space:
  * */

  static int hammingDistance(String s, String t) {
    char one, two;
    int hammingDist = 0;

    if(s.length() != t.length())
      return 0;

    for(int i = 0; i<s.length(); i++){
      if (s.charAt(i) != t.charAt(i)) {
        hammingDist++;
      }
    }
    return hammingDist;
  }


}
