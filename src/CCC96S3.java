import java.io.*;
import java.util.StringTokenizer;
/***********************************************************************
 * Project Name: CCC96S3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Feb 5, 2019
 *
 * Purpose: Solving 1996 CCC S3
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC96S3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());
        for (int i = 0; i < amount; i++) {
            System.out.print("The bit patterns are\n");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            r("", k, n);
            System.out.print("\n");
        }
    }
    public static void r(String text, int left, int digitOn) {
        if (digitOn == 0) { // when the number generated is same length as required
            if (left == 0) { // if there are no more 1 left
                System.out.print(text + "\n"); // print the pattern
                return;
            }
            else // if there are still 1 left
                return; // invalid pattern
        }
        // if there are still more digit
        if (left > 0) { // if there are still 1 left
            r(text + "1", left - 1, digitOn - 1); // add a 1 to the end
            r(text + "0", left, digitOn - 1); // add 0 to the end
            // this ensures that the larger pattern will print first, because 1 > 0
        }
        else { // if no more 1 left
            r(text + "0", left, digitOn - 1); // we can only add 0 to the end
        }
    }
}
