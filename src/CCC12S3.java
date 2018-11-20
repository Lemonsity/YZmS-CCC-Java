import java.io.*;
import java.util.*;
/***********************************************************************
 * Project Name: CCC12S3
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 18, 2018
 *
 * Purpose: Solving 2012 CCC S3
 *
 ***********************************************************************
 *  Status: Work in progress
 *
 *  - Took in user's input
 *  - figuring out the logic
 */
public class CCC12S3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());
        int[] sensorCount = new int[1001];
        for (int i = 0; i < amount; i++){
            int input = Integer.parseInt(br.readLine());
            sensorCount[input]++;
        }
        int[] sorted = sensorCount.clone();
        Arrays.sort(sorted);
        int cases; // If there are more than one most frequent, or there are mosre than one second most frequent, or neither
        if (sorted[1000] == sorted[999])
            cases = 1; // more than one most frequent read
        else if (sorted[999] == sorted[998])
            cases = 2; // one most frequent read and 2 or more second most frequent read
        else
            cases = 3; // most frequent read and second most frequent read both only have one
        int most = 0;
        int secondMost = 0;
        if (cases == 1){
            for (int i = 1; i <= 1000; i++){
                if (sensorCount[i] == sorted[1000]){
                    most = i;
                    break;
                }
            }
            for (int i = 1000; i >= 1; i--){
                if (sensorCount[i] == sorted[1000]){
                    secondMost = i;
                    break;
                }
            }
        }
        else if (cases == 2){
            for (int i = 1; i <= 1000; i++){
                if (sensorCount[i] == sorted[1000]){
                    most = i;
                    break;
                }
            }
            for (int i = 1; i <= 1000; i++){
                if (sensorCount[i] == sorted[999]){
                    secondMost = i;
                    break;
                }
            }
            for (int i = 1000; i >= 1; i--){
                if (sensorCount[i] == sorted[999]){
                    if (Math.abs(i - most) > Math.abs(secondMost - most))
                        secondMost = i;
                    break;
                }
            }
        }
        else{
            for (int i = 1; i <= 1000; i++){
                if (sensorCount[i] == sorted[1000]){
                    most = i;
                    break;
                }
            }
            for (int i = 1; i <= 1000; i++){
                if (sensorCount[i] == sorted[999]){
                    secondMost = i;
                    break;
                }
            }
        }
        System.out.print(Math.abs(most - secondMost) + "\n");
    }
}