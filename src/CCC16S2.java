import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/***********************************************************************
 * Project Name: CCC16S1
 *
 * Author: YZmS Lemonsity
 *
 * Date: Unknown
 *
 * Purpose: Solving 2016 CCC S2
 *
 ***********************************************************************
 * Status: Completed
 *
 */
public class CCC16S2 {
    public static int[] dmoj;
    public static int[] peg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine()); // Question type
        int riders = Integer.parseInt(br.readLine()); // Amount of riders
        int speed = 0; // initialize the total speed to 0
        dmoj = new int[riders];
        peg = new int[riders];
        //------------------------Obtain rider speeds-----------------------------------
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < riders; i++){
            dmoj[i] = Integer.parseInt(temp[i]);
        }
        temp = br.readLine().split(" ");
        for (int i = 0; i < riders; i++){
            peg[i] = Integer.parseInt(temp[i]);
        }
        //------------------------------------------------------------------------------
        Arrays.sort(dmoj); // sort speed
        Arrays.sort(peg);
        if (q == 1){ // if want least speed, match the fastest with the fastest
            for (int i = riders - 1; i >= 0; i--){ // Start from fastest
                speed += Math.max(dmoj[i], peg[i]);
            }
        }
        else{ // if want most speed
            for (int i = riders - 1; i >= 0; i--){
                // match i from group A to riders - 1 - i in group B
                // in another word, match the one that are opposite to each other position wise
                speed += Math.max(dmoj[i], peg[riders - 1 - i]);
            }
        }
        System.out.print(speed + "\n");
    }
}
