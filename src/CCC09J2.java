import java.io.*;
/***********************************************************************
 * Project Name: CCC09J2
 *
 * Author: YZmS Lemonsity
 *
 * Date: Feb 5, 2019
 *
 * Purpose: Solving 2009 CCC J2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC09J2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int trout = Integer.parseInt(br.readLine());
        int pike = Integer.parseInt(br.readLine());
        int yellow = Integer.parseInt(br.readLine());
        int need = Integer.parseInt(br.readLine());
        int counter = 0;
        for (int i = 0; i <= need / trout; i++) {
            for (int j = 0; j <= need / pike; j++) {
                for (int k = 0; k <= need / yellow; k++) {
                    if (!(i == 0 && j == 0 && k == 0) // if there is at least one fish
                            && i * trout + j * pike + k * yellow <= need) { // and the total point haven't exceed limit
                        System.out.printf("%d Brown Trout, %d Northern Pike, %d Yellow Pickerel\n", i, j, k); // output combination
                        counter++; // add one to possible ways
                    }
                }
            }
        }
        System.out.printf("Number of ways to catch fish: %d\n", counter); // output possibilities
    }
}
