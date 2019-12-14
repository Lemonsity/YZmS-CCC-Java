import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
/***********************************************************************
 * Project Name: CCC02S1
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 13, 2019
 *
 * Purpose: Solving 2002 CCC S1
 *
 ***********************************************************************
 *  Status: Completed
 *
 *  Hard code mostly
 *
 */
public class CCC02S1 {
    public static ArrayList<Integer> amount = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int[] prices = new int[4];
        int total;
        for (int i = 0; i < 4; i++)
            prices[i] = Integer.parseInt(br.readLine());
        total = Integer.parseInt(br.readLine());
        for (int pinkCounter = 0; pinkCounter * prices[0] <= total; pinkCounter++) { // for each pink ticket you can add
            int leftAfterPink = total - pinkCounter * prices[0];
            for (int greenCounter = 0; greenCounter * prices[1] <= leftAfterPink; greenCounter++) { // for each green ticket you can add after pink
                int leftAfterGreen = leftAfterPink - greenCounter * prices[1];
                for (int redCounter = 0; redCounter * prices[2] <= leftAfterGreen; redCounter++) { // for each red ticket can add after pink and green
                    int leftAfterRed = leftAfterGreen - redCounter * prices[2];
                    if (leftAfterRed % prices[3] == 0){ // if the remaining amount can be evenly divided by the price of orange.
                        System.out.printf("# of PINK is %d # of GREEN is %d # of RED is %d # of ORANGE is %d\n",
                                            pinkCounter, greenCounter, redCounter, leftAfterRed / prices[3]); // print the config
                        amount.add(pinkCounter + greenCounter + redCounter + (leftAfterRed / prices[3])); // add the total amount of ticket of the config to a database
                    }//end of calculate the amount of orange
                }//end of red ticket
            }// end of green ticket
        }// end of pink ticket
        Collections.sort(amount); // sort the database in ascending order
        System.out.printf("Total combinations is %d.\n", amount.size());
        System.out.printf("Minimum number of tickets to print is %d.", amount.get(0));
    }
}
