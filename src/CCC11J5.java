import java.io.*;
/***********************************************************************
 * Project Name: CCC11J5
 *
 * Author: YZmS Lemonsity
 *
 * Date: Feb 5, 2019
 *
 * Purpose: Solving 2011 CCC J5
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC11J5 {
    private static int[] relationship;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        relationship = new int[num];
        for (int i = 1; i < num; i++) {
            relationship[i] = Integer.parseInt(br.readLine()); // for each person, add who added the person
        }
        System.out.print(r(num) - 1);
    }
    public static int r(int friend) {
        int counter = 1;
        boolean check = false;
        for (int i = 1; i < relationship.length; i++) {
            if (relationship[i] == friend) {
                counter *= r(i);
                check = true;
            }
        }
        if (!check) // if the person didn't invite anyone
            return 2; // there are 2 options, keeping, or removing the person
        // if the person on have invited more people
        // the possibility is the amount of possibilities can be chosen ont he lower level + 1
        return counter + 1;
    }
}
