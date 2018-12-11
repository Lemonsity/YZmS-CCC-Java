import java.io.*;
/***********************************************************************
 * Project Name: CCC06J3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 11, 2018
 *
 * Purpose: Solving 2006 CCC J3
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC06J3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while(!input.equals("halt")) {
            char[] chars = input.toCharArray(); // turn word into char[]
            int seconds = 0;
            seconds += secondCal(chars[0]); // The first letter doesn't require pause before
            for (int i = 1; i < chars.length; i++) {
                if (sameKey(chars[i], chars[i - 1])) // If need to use same key
                    seconds += 2; // pause
                seconds += secondCal(chars[i]); // add time require to enter the letter
            }
            System.out.print(seconds + "\n"); // Output
            input = br.readLine();
        }
    }

    // This program only need condition, but some ASCII knowledge would be useful
    // ASCII value of 'a' is 97, 'b' = 98...
    // You can transfer all characters to number, and use mod operation to figure out how many time require to click a key
    // Be careful 7 and 9 have 4 letters

    public static boolean sameKey(char a, char b) { // determine if there need to be pause
        if ((a == 'z' || a == 'w' || a == 'x' || a == 'y') && (b == 'z' || b == 'w' || b == 'x' || b == 'y'))
            return true;
        if ((a == 'p' || a == 'q' || a == 'r' || a == 's') && (b == 'p' || b == 'q' || b == 'r' || b == 's'))
            return true;
        if (a < 's' && b < 's')
            return ((int)a - 97) / 3 == ((int)b - 97) / 3;
        return ((int)a - 98) / 3 == ((int)b - 98) / 3;
    }
    public static int secondCal(char c){ // determine the number need to enter a letter
        if (c == 'z' || c == 's')
            return 4;
        if (c < 's')
            return ((int)c - 97) % 3 + 1;
        return ((int)c - 98) % 3 + 1;
    }
}
