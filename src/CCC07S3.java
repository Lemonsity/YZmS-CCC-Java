import java.io.*;
import java.util.HashMap;
/***********************************************************************
 * Project Name: CCC07S3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 10, 2018
 *
 * Purpose: Solving 2007 CCC S3
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC07S3 {
    // This Hashmap stores the friend of each student
    public static HashMap<Integer, Integer> friends = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Amount of student
        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            String[] inputString = br.readLine().split(" ");
            // Add the student and the friend the student is assigned with
            friends.put(Integer.parseInt(inputString[0]), Integer.parseInt(inputString[1]));
        }
        String input = br.readLine();
        while (!input.equals("0 0")) {

            // Because every student is for sure assigned with a "friend"
            // If we were to graph the relationship of the students,
            // It will be made up of >= 1 circle/s
            // Because there is no node with no child
            //
            // Thus, no matter where we start, there is no way to reach dead end
            //
            // Follow the circle, and when we came to where we started, one loop is completed
            //
            // If we didn't find a match before returning to the origin,
            // the target is not within the loop
            // Otherwise, we exit the loop, and count how many steps to takes to reach target

            String[] inputString = input.split(" "); // user input
            int friend = friends.get(Integer.parseInt(inputString[0])); // The friend of the starting student
            int target = Integer.parseInt(inputString[1]); // The student we want to reach
            int counter = 0; // start the counter at 0, the distance between the starting student and his/her friend
            int startPoint = Integer.parseInt(inputString[0]); // The starting student, if we end up back here, we completed one loop

            // If:
            // The current friend we are on isn't the starting student      (friend != startPoint)
            //              AND
            // The current friend isn't the target                          (friend != target)
            //
            // Then it means we have not yet find the target, nor have we completed one circle

            while (friend != startPoint && friend != target) {
                friend = friends.get(friend); // Move on to the next friend
                counter++; // add one to distance
            }

            // Notice,
            // Because we build the break condition into the while loop condition
            // When the target is found, it will automatically exit
            // Thus no need for (break;)

            if (startPoint == friend) // If we exited because we completed a full loop
                System.out.print("No\n"); // no match is found
            else // Otherwise it means we exited the loop because we found the match
                System.out.print("Yes " + counter + "\n"); // display distance
            input = br.readLine();
        }
    }
}