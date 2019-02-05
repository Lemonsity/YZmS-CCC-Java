import java.io.*;
/***********************************************************************
 * Project Name: CCC05J5
 *
 * Author: YZmS Lemonsity
 *
 * Date: Feb 5, 2019
 *
 * Purpose: Solving 2005 CCC J5
 *
 ***********************************************************************
 *  Status: Completed
 *
 *  Honestly, this question is so confusing, not even I can explain it
 */
public class CCC05J5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // user input
        while (!input.equals("X")) {
            if (monkey(input))
                System.out.print("YES\n");
            else
                System.out.print("NO\n");
            input = br.readLine();
        }
    }
    public static boolean a(String text) { // check if text is an A-word
        if (text.equals("A")) // if the text is only A
            return true;
        if (text.length() == 1 && !text.equals("A")) // if there is only one char left, and is not A
            return false;
        if (text.length() == 2) // if the text is 2 char long
            return false;
        // if the text is longer than 2 char long
        // then the only way for it to still be an A-word is B+monkey+S
        return text.charAt(0) == 'B' && monkey(text.substring(1, text.length() - 1)) && text.charAt(text.length() - 1) == 'S';
    }
    public static boolean monkey(String text) {
        boolean Npresent = false;
        int index = -1;
        boolean answer = false;
        for (int i = 1; i < text.length() - 1; i++) {
            if (text.charAt(i) == 'N') { // for each N int he text
                Npresent = true;
                index = i;
                // check if the entire word is an A-word
                // or if the substring in front is an A-word, and the substring behind is a monkey word
                // if any previous separation already prove the word is an A-word, no need to check the new
                answer =  answer || a(text) || a(text.substring(0, index)) && monkey(text.substring(index + 1));
            }
        }
        if (Npresent)
            return answer;
        // if no N exist in the text, then the word cannot be followed by N and another monkey word
        return a(text);
    }
}
// This question is so confusing I need to take a nice cold shower to calm myself down
