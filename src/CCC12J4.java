import java.io.*;
/***********************************************************************
 * Project Name: CCC12J4
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 16, 2018
 *
 * Purpose: Solving 2012 CCC J4
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC12J4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine()); // The amount shift
        char[] text = br.readLine().toCharArray(); // Turn text into an array
        for (int i = 0; i < text.length; i++) { // For each character in the text
            int shift = 3 * (i + 1) + s; // Calculate amount need to be shifted back
            text[i] = shifting(text[i], shift); // Call shifting method to replace cyphered text
        }
        // Output
        for(char a : text)
            System.out.print(a);
        System.out.print("\n");
    }
    public static char shifting(char a, int shift) { // Parameters are the cyphered text and the amount to shift
        for (int i = 0; i < shift; i++) { // For each shift
            a--;
            if (a == 64) // Check if we went lower than 'A'
                a = 90; // If so, the character is 'Z'
        }
        return a; // return the final character after undoing the cypher
    }
}
