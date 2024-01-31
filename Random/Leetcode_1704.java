import java.util.ArrayList;

public class Leetcode_1704 {
    public static boolean halvesAreAlike(String s) {
        String a = s.substring(0, s.length()/2);
        String b = s.substring(s.length()/2, s.length());

        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');

        int c1=0, c2=0;

        for(int i = 0; i<a.length(); i++) {
            if(list.contains(a.charAt(i)))
                c1++;
            if(list.contains(b.charAt(i)))
                c2++;
        }

        if(c1 == c2)
            return true;
        return false;
    }
    public static void main(String[] args) {
        String s = "textbook";
        System.out.println(halvesAreAlike(s));
    }
}