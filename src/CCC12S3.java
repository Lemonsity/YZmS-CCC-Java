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
 *  Status: Completed
 *
 * tmep
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

        // This array will store the frequency of reads from least frequent to most frequent
        // We only focus on index 998, 999, and 1000
        int[] sorted = sensorCount.clone();
        Arrays.sort(sorted);

        int cases; // If there are more than one most frequent, or there are mosre than one second most frequent, or neither
        if (sorted[1000] == sorted[999])
            cases = 1; // more than one most frequent read
        else if (sorted[999] == sorted[998])
            cases = 2; // one most frequent read and 2 or more second most frequent read
        else
            cases = 3; // most frequent read and second most frequent read both only have one
        int most = 0; // The most frequent
        int secondMost = 0; // The second most frequent
        if (cases == 1){
            for (int i = 1; i <= 1000; i++){ // Start at the front of the array that contain the frequency of read
                if (sensorCount[i] == sorted[1000]){
                    most = i; // First occurrence of the most frequent read
                    break;
                }
            }
            for (int i = 1000; i >= 1; i--){ // Start at the back of array that contain the frequency of read
                if (sensorCount[i] == sorted[1000]){
                    secondMost = i; // Last occurrence of the most frequent read
                    break;
                }
            }
            // Because we start at back and front separately, thus we know the difference is the highest there can be
            // [] [] [] [] [] [] [] [] ...................... [] [] [] [] [] [] [] []
            // ------->        The difference is for sure largest          <---------
        }
        else if (cases == 2){
            for (int i = 1; i <= 1000; i++){ // Find the most frequent read
                if (sensorCount[i] == sorted[1000]){
                    most = i;
                    break;
                }
            }
            for (int i = 1; i <= 1000; i++){ // Go from the front of array, find first occurrence of the second most frequent read
                if (sensorCount[i] == sorted[999]){
                    secondMost = i;
                    break;
                }
            }
            for (int i = 1000; i >= 1; i--){ // Go from back of the array, find the first occurrence of the second most frequent read
                if (sensorCount[i] == sorted[999]){
                    /*
                     *  Because we went from the front and back and always find the first occurrence,
                     *  thus we went on the extreme side of the spectrum
                     *  and which ever one is the furthest away from the most frequent will also have the largest difference
                     */
                    if (Math.abs(i - most) > Math.abs(secondMost - most))
                        secondMost = i;
                    break;
                }
            }
        }
        else { // Just find the first and second most frequent reads
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
        System.out.print(Math.abs(most - secondMost) + "\n"); // Print out the absolute difference of the most and second most frequent
    }
}