/*
 *  273. Integer to English Words
        Convert a non-negative integer num to its English words representation.

    Example 1:
        Input: num = 123
        Output: "One Hundred Twenty Three"
        
    Example 2:
        Input: num = 12345
        Output: "Twelve Thousand Three Hundred Forty Five"
        
    Example 3:
        Input: num = 1234567
        Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
        
    Constraints:
        0 <= num <= 231 - 1
 */
public class _07_08_24_leetcode_273 {
    static String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    static String[] TENS = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    static String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };
    
    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String words = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        return words.trim();
    }

    public static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
    public static void main(String[] args) {
        System.out.println(numberToWords(1234567890));
    }
}