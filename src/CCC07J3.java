import java.io.*;
/***********************************************************************
 * Project Name: CCC07J3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Feb 5, 2019
 *
 * Purpose: Solving 2007 CCC J3
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC07J3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] taken = new boolean[11];
        int amount = Integer.parseInt(br.readLine());
        for (int i = 0; i < amount; i++) {
            taken[Integer.parseInt(br.readLine())] = true; // mark case of taken
        }
        int total = 0;
        int counter = 0;
        for (int i = 1; i <= 10; i++) {
            if (!taken[i]) { // if a case isn't taken
                total += translate(i); // add value into total
                counter++;
            }
        }
        double average = (1.0 * total) / (1.0 * counter); // calculate average
        int offer = Integer.parseInt(br.readLine());
        if (offer > average) // if offer is better than average
            System.out.print("deal\n");
        else // if average better than offer
            System.out.print("no deal\n");
    }
    public static int translate(int index) { // case value
        switch (index) {
            case 1:
                return 100;
            case 2:
                return 500;
            case 3:
                return 1000;
            case 4:
                return 5000;
            case 5:
                return 10000;
            case 6:
                return 25000;
            case 7:
                return 50000;
            case 8:
                return 100000;
            case 9:
                return 500000;
        }
        return 1000000;
    }
}
