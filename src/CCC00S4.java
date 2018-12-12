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
        int[] clubs; // The clubs robot can choose
        int distance = Integer.parseInt(br.readLine()); // distance need to reach
        int amount = Integer.parseInt(br.readLine()); // amount of clubs
        clubs = new int[amount];
        for (int i = 0; i < amount; i++) {
            clubs[i] = Integer.parseInt(br.readLine()); // distance of each club
        }
        int least = ways(distance, clubs); // Find the amount of hits to reach the distance

        // Because we used array
        // If the distance is unreachable, it will return 0

        // Output
        if (least == 0) // if unreachable
            System.out.print("Roberta acknowledges defeat.");
        else
            System.out.printf("Roberta wins in %d strokes.", least);
    }

    // A simple dynamic programming that calculate amount of hits
    // We go from distance 0 to distance distance
    // When we are at 0, we reach destination in 0 hit
    // From distance 1 to distance distance, we ask:
    // What is the least amount of hit to reach that distance

    public static int ways(int distance, int[] clubs) {
        if (distance == 0) // if the distance is 0, we reach destination in 0 hit
            return 0;

        // This array stores the least amount of hits to reach any distance (0 - distance inclusive)
        int[] distances = new int[distance + 1];

        ArrayList<Integer> possibilities = new ArrayList<>(); // This will contain all the possible
        for (int i = 1; i <= distance; i++) { // For each distance
            for (int club : clubs) { // For each club

                // Notice, because the distances array is automatically initialized with 0s
                // Thus if distances[i - club] == 0, it means there is no way tor each that distance

                if ((i - club >= 0 && distances[i - club] > 0) // If we can reach a previous reachable distance
                        || i - club == 0) // Or if the distance we are on right now is the exact distance of one club
                    possibilities.add(distances[i - club]); // Then we add the least amount of hits tot reach that previous distance
            }

            // If the possibilities array have a size of > 0, that means at least 1 previous distances are unreachable
            if (possibilities.size() != 0)
                distances[i] = Collections.min(possibilities) + 1; // Find the least hits out of the possible distances
            possibilities.clear(); // clear the array to save memory
        }
        return distances[distance]; // return the least amount if hits to reach distance distance
    }
}