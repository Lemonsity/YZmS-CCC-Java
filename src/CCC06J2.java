import java.io.*;
/**********************************************************************
 * Project Name: CCC06J2
 *
 * Author: YZmS Lemonsity
 *
 * Date: December 5, 2018
 *
 * Purpose: Solving 2006 CCC J2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC06J2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int dice1 = Integer.parseInt(br.readLine()); // first dice
        int dice2 = Integer.parseInt(br.readLine()); // second dice
        int smaller = Math.min(dice1, dice2); // the smaller dice
        int larger = Math.max(dice1, dice2); // the larger dice
        int counter = 0; // amount of possibilities

        // the amount of possibilities depends on the smaller dice
        // it is essentially checking
        //      - For each value of the smaller dice,
        //      - Is there a number on the larger dice that can match to create 10?
        for (int i = 1; i <= smaller; i++) { // start by checking the smallest number on the dice
            if (i > 9) // if the number on the smallest dice exeed 9, then larger dice need to be <= 0, not valid
                break; // break the loop
            if (10 - i <= larger) // If there is a number on the larger dice to match
                counter++; // add one to the counter
        }
        // format the output
        if (counter == 1)
            System.out.print("There is 1 way to get the sum 10.\n");
        else
            System.out.print("There are " + counter + " ways to get the sum 10.\n");
    }
}
