import java.io.*;
/**********************************************************************
 * Project Name: CCC14S4
 *
 * Author: YZmS Lemonsity
 *
 * Date: Nov 16, 2018
 *
 * Purpose: Solving 2014 CCC S4
 *
 ***********************************************************************
 *  Status: On hold
 *
 *  -Finished user input
 */
public class CCC14S4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int requireTint = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++){
            String[] temp = br.readLine().split(" ");
            int left = Integer.parseInt(temp[0]);
            int top = Integer.parseInt(temp[1]);
            int right = Integer.parseInt(temp[2]);
            int bot = Integer.parseInt(temp[3]);
            int tint = Integer.parseInt(temp[4]);

        }
    }
}
