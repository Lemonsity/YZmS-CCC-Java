import java.io.*;
/***********************************************************************
 * Project Name: CCC10S1
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 18, 2018
 *
 * Purpose: Solving 2010 CCC S1
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC10S1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = null;
        String second = null;
        int firstValue = 0;
        int secondValue = 0;
        int amount = Integer.parseInt(br.readLine());
        for (int i = 0; i < amount; i++) {
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[1]);
            int S = Integer.parseInt(input[2]);
            int D = Integer.parseInt(input[3]);
            if (first == null) { // If user never input anything, add first line of input into data base
                first = input[0];
                firstValue = 2 * R + 3 * S + D;
                continue;
            }
            if (2 * R + 3 * S + D > firstValue) { // if a new value is greater than the greatest, push everything back
                second = first;
                secondValue = firstValue;
                first = input[0];
                firstValue = 2 * R + 3 * S + D;
            }
            else if (2 * R + 3 * S + D == firstValue) { // If a value is equal to the highest value
                // The following lines are for comparing strings
                // Depend on the name, either put the new input at 1st or 2nd place, or drop it
                if (input[0].length() < first.length() || first.compareTo(input[0]) >= 0) {
                    second = first;
                    secondValue = firstValue;
                    first = input[0];
                }
                else if (first.compareTo(input[0]) < 0) {
                    if (input[0].length() < second.length() || second.compareTo(input[0]) >= 0) {
                        second = input[0];
                        secondValue = 2 * R + 3 * S + D;
                    }
                }
            }
            else if (2 * R + 3 * S + D > secondValue) { // If new vlaue is second largest
                second = input[0];
                secondValue = 2 * R + 3 * S + D;
            }
            else if (2 * R + 3 * S + D == secondValue) { // If new value equal to original second value
                // Again, check string
                if (input[0].length() < first.length() || second.compareTo(input[0]) > 0) {
                    second = input[0];
                    secondValue = 2 * R + 3 * S + D;
                }
            }
        }
        // Output
        if (first != null)
            System.out.print(first + "\n");
        if (second != null)
            System.out.print(second + "\n");
    }
}
