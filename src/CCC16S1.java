import java.io.*;
/***********************************************************************
 * Project Name: CCC16S1
 *
 * Author: YZmS Lemonsity
 *
 * Date: Unknown
 *
 * Purpose: Solving 2016 CCC S1
 *
 ***********************************************************************
 * Status: Completed
 *
 */
public class CCC16S1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] one = br.readLine().toCharArray();
        char[] two = br.readLine().toCharArray();
        int[] numOne = new int[26];
        int[] numTwo = new int[26];
        for (int i = 0; i < one.length; i++){
            if (one[i] != '*')
                numOne[(int)one[i] - 97]++;
            if (two[i] != '*')
                numTwo[(int)two[i] - 97]++;
        }
        boolean temp = true;
        for (int i = 0; i < 26; i++){
            if (numOne[i] < numTwo[i]){
                temp = false;
                break;
            }
        }
        System.out.println((temp) ? "A" : "N");
    }
}
