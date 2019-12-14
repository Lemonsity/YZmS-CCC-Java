import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
/***********************************************************************
 * Project Name: CCC00S4
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 24, 2018
 *
 * Purpose: Solving 2000 CCC S4
 *
 ***********************************************************************
 *  Status: Completed
 *
 *  The first S4 I solved, one of my most noticeable achievement
 *
 */
public class CCC00S4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int distance = Integer.parseInt(br.readLine()); // distance need to reach
        int amount = Integer.parseInt(br.readLine()); // amount of clubs
        int[] clubs = new int[amount];
        for (int i = 0; i < amount; i++)
            clubs[i] = Integer.parseInt(br.readLine()); // input distance of each club
        int[] distanceDP = new int[distance + 1]; // distanceDP[i] represents the least amount of steps needed to reach a distance of i
        for (int i = 1; i <= distance; i++) { // for each distance
            distanceDP[i] = Integer.MAX_VALUE; // assume the place is unreachable, with is represented by Integer.MAX_VALUE
            for (int club : clubs) { // for each club in the bag
                // let the hitting distance of the specific club be C
                // if it is possible to reach the position that is C distance before the current distance, and that position is valid
                if (i - club >= 0 && distanceDP[i - club] != Integer.MAX_VALUE)
                    distanceDP[i] = Math.min(distanceDP[i], distanceDP[i - club] + 1); // update distanceDP[i] to the lowest amount of hit needed
            }
        }
        if (distanceDP[distance] != Integer.MAX_VALUE) // if the final distance is reachable
            System.out.printf("Roberta wins in %d strokes.\n", distanceDP[distance]);
        else
            System.out.print("Roberta acknowledges defeat.\n");
    }
}
