import java.io.*;
/***********************************************************************
 * Project Name: CCC12S1
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 17, 2018
 *
 * Purpose: Solving 2012 CCC S1
 *
 ***********************************************************************
 *  Status: Completed
 *
 ***********************************************************************
 *  Side Note:
 *  I think this question is flawed, just take my thing as it is
 */
public class CCC12S1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int counter = 0;
        for (int goalScorer = num; goalScorer >= 4; goalScorer--){
            for (int assist1 = goalScorer - 1; assist1 >= 3; assist1--){
                for (int assist2 = assist1 - 1; assist2 >= 2; assist2--){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
