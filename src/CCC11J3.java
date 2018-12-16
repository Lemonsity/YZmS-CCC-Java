import java.io.*;
/***********************************************************************
 * Project Name: CCC11J3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 16, 2018
 *
 * Purpose: Solving 2011 CCC J3
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC11J3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()); // First number
        int b = Integer.parseInt(br.readLine()); // Second number
        int counter = 2; // With 2 numbers already inputted, there are 2 number in the sequence
        while (a >= b) { // When the 1st number is bigger than or equal to the 2nd number
            int temp = b; // Store 2nd number in temporary variable
            b = a - b; // 2nd number equal the difference of the 2
            a = temp; // 1st number become the former 2nd number
            counter++; // Add one to sequence length
        }
        System.out.print(counter + "\n"); // Output
    }
}
