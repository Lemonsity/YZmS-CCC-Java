import java.io.*;
/**********************************************************************
 * Project Name: CCC06J1
 *
 * Author: YZmS Lemonsity
 *
 * Date: December 5, 2018
 *
 * Purpose: Solving 2006 CCC J1
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC06J1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        // User inputs
        int one = Integer.parseInt(br.readLine());
        int two = Integer.parseInt(br.readLine());
        int three = Integer.parseInt(br.readLine());
        int four = Integer.parseInt(br.readLine());

        int total = 0; // Keep count of calories

        // Add calories depend on choice
        switch(one){
            case 1:
                total += 461;
                break;
            case 2:
                total += 431;
                break;
            case 3:
                total += 420;
                break;
            case 4:
                total = total;
                break;
        }
        switch(three){
            case 1:
                total += 130;
                break;
            case 2:
                total += 160;
                break;
            case 3:
                total += 118;
                break;
            case 4:
                total = total;
                break;
        }
        switch(two){
            case 1:
                total += 100;
                break;
            case 2:
                total += 57;
                break;
            case 3:
                total += 70;
                break;
            case 4:
                total = total;
                break;
        }
        switch(four){
            case 1:
                total += 167;
                break;
            case 2:
                total += 266;
                break;
            case 3:
                total += 75;
                break;
            case 4:
                total = total;
                break;
        }
        System.out.println("Your total Calorie count is " + total + ".");
    }
}