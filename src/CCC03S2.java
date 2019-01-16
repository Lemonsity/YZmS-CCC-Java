import java.io.*;
/***********************************************************************
 * Project Name: CCC03S2
 *
 * Author: YZmS Lemonsity
 *
 * Date: Jan 15, 2019
 *
 * Purpose: Solving 2003 CCC S2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC03S2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int poemNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < poemNum; i++) {
            String[] lastS = new String[4]; // stores the last syllable of the 4 following lines
            for (int j = 0; j < 4; j++) {
                String[] temp = br.readLine().split(" "); // user input line, split into words
                String lastWord = temp[temp.length - 1]; // the last word of the line
                lastS[j] = lastS(lastWord); // the last syllable of the line
            }
            // check every condition, and output what type of rhyme
            if (lastS[0].equalsIgnoreCase(lastS[1]) && lastS[1].equalsIgnoreCase(lastS[2]) && lastS[2].equalsIgnoreCase(lastS[3]))
                System.out.print("perfect\n");
            else if (lastS[0].equalsIgnoreCase(lastS[1]) && lastS[2].equalsIgnoreCase(lastS[3]))
                System.out.print("even\n");
            else if (lastS[0].equalsIgnoreCase(lastS[2]) && lastS[1].equalsIgnoreCase(lastS[3]))
                System.out.print("cross\n");
            else if (lastS[0].equalsIgnoreCase(lastS[3]) && lastS[2].equalsIgnoreCase(lastS[1]))
                System.out.print("shell\n");
            else
                System.out.print("free\n");
        }
    }
    public static String lastS(String word) {
        for (int i = word.length() - 1; i >= 0; i--) { // from the last char of the string
            char character = word.charAt(i);
            // check if the char is a vowel
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u'
                    ||  character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U') {
                return word.substring(i); // return the sub string from that vowel to the end
            }
        }
        return word; // return the original word if there is no vowel
    }
}

