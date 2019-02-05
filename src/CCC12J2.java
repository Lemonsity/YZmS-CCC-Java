import java.io.*;
/***********************************************************************
 * Project Name: CCC12J2
 *
 * Author: YZmS Lemonsity
 *
 * Date: Feb 5, 2019
 *
 * Purpose: Solving 2012 CCC J2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC12J2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        // just 3 conditions, hope no need for explanation
        if (a < b && b < c && c < d)
            System.out.print("Fish Rising\n");
        else if (a > b && b > c && c > d)
            System.out.print("Fish Diving\n");
        else if (a == b && b == c && c == d)
            System.out.print("Fish At Constant Depth\n");
        else
            System.out.print("No Fish\n");
    }
}
