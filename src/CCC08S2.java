import java.io.*;
/***********************************************************************
 * Project Name: CCC08S2
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 12, 2018
 *
 * Purpose: Solving 2008 CCC S2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC08S2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        while (input != 0) {
            System.out.print(calc(input) + "\n");
            input = Integer.parseInt(br.readLine());
        }
    }

    /* Here is the basic logic behind my calculation
       Pretend the following graph is the coins can be fit into a circle of radius 2

               *
              ***
             *****
              ***
               *

       We divide the circle into 4 areas and the centre, each represented with different symbol

               ^
              #^^
             ##+&&
              $$&
               $

       Because the nature of circle, the 4 areas have the same area, thus same amount of coins

       The coins can only be placed at integer coordinate.
       Thus, we can count how many "rows" there are for each area, and how many coins there are for each row
       Using Pythagorean theorem and flooring, we can find the maximum integer value that can fit into the circle
       Add one to the value because coins can also be placed on the axis

       Implementation down below \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/
     */
    public static int calc(int radius) {
        int counter = 0;
        for (int i = 1; i <= radius; i++) {
            counter += (int)(Math.sqrt(Math.pow(radius, 2) - Math.pow(i, 2))) + 1;
        }
        // Multiple by 4, 4 sections
        // Add 1, the centre
        return counter * 4 + 1;
    }
}
