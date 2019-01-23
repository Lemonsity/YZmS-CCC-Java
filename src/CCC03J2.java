import java.io.*;
/***********************************************************************
 * Project Name: CCC00S4
 *
 * Author: YZmS Lemonsity
 *
 * Date: Jan 20, 2019
 *
 * Purpose: Solving 2003 CCC J2
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC03J2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        while (input != 0) {
            // the smallest possible parameter is the one closest to a square
            int x = (int)Math.sqrt(input); // find square root of the area, then trunk it
            // if the side is not a factor of the area, decrease it by 1
            while (input % x != 0)
                x--;
            System.out.printf("Minimum perimeter is %d with dimensions %d x %d\n", (x + input / x) * 2, x, input / x); // calculate and output ont he same line
            input = Integer.parseInt(br.readLine()); // get new area
        }
    }
}
