import java.io.*;
/***********************************************************************
 * Project Name: CCC07S1
 *
 * Author: YZmS Lemonsity
 *
 * Date: Dec 11, 2018
 *
 * Purpose: Solving 2007 CCC S1
 *
 ***********************************************************************
 *  Status: Completed
 *
 */
public class CCC07S1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] temp = br.readLine().split(" ");
            int year = Integer.parseInt(temp[0]); // Year
            int month = Integer.parseInt(temp[1]); // Month
            int day = Integer.parseInt(temp[2]); // Date
            boolean check = false;
            if (year < 2007 - 19) // If the year is 19 smaller than 2007, the the person is definitely >18
                check = true;
            if (year == 2007 - 18) { // If the year is 18 smaller than 2007, then the person may or may not be old enough, depend on month
                if (month < 2) // If the person is born in Jan, then he/she is >18
                    check = true;
            }
            if (year == 2007 - 18) {
                if (month == 2) // If the person is born in Feb
                    if (day <= 27) // But is born before or on 27, then he/she is still >= 18 years old
                        check = true;
            }
            // Since we have included all the possibility where the person is >= 18, the rest are too young

            // Output
            if (check)
                System.out.print("Yes\n");
            else
                System.out.print("No\n");
        }
    }
}
